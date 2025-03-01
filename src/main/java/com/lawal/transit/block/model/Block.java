package com.lawal.transit.block.model;

import com.lawal.transit.address.model.Address;

import com.lawal.transit.address.model.exception.NullAddressListException;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.curb.CurbOrientationException;

import com.lawal.transit.curb.model.exception.NullCurbException;
import com.lawal.transit.station.model.Station;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "blocks")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Block {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = CurbOrientationException.MESSAGE)
    String name;

    @ManyToOne
    @JoinColumn(name = "curb_id")
    private Curb curb;

    @OneToOne(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private Station station;

    @OneToMany(mappedBy = "block", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public Block (Long id, String name, Curb curb) {
        this.id = id;
        this.name = name;
        this.curb = curb;
        this.curb.getBlocks().add(this);
        this.addresses = new ArrayList<>();
    }

    public void setAddresses(List<Address> addresses) {
        if (addresses == null) throw new NullAddressListException(NullAddressListException.MESSAGE);
        if (this.addresses == null) this.addresses = new ArrayList<>();
        for (Address address : addresses) addAddress(address);
    }

    public void addAddress(Address address) {
        if (address == null) throw new NullPointerException(BlockMessage.ADDRESS_PARAMETER_NULL_EXCEPTION);

        if (addresses.contains(address) && address.getBlock() == this) return;

        address.setBlock(this);

        if (!addresses.contains(address)) {
            addresses.add(address);
        }
    }

    public void removeAddress(Address address) {
        if (address == null) throw new NullPointerException(BlockMessage.ADDRESS_PARAMETER_NULL_EXCEPTION);

        if (addresses.contains(address) && address.getBlock() == this) {
            addresses.remove(address);
            address.setBlock(null);
        }
    }

    public void setStation(Station station) {
        if (this.station == station) return;

        if (this.station != null) {
            this.station.setBlock(null);
            this.station = null;
        }

        if (station != null) {
            station.setBlock(this);
            this.station = station;
        }
    }

    public void setCurb(Curb curb) {
        if (curb == null) throw new NullCurbException(BlockMessage.CURB_PARAMETER_NULL_EXCEPTION);

        if (this.curb == curb) return;
        if (this.curb != null) { this.curb.removeBlock(this); }

        this.curb = curb;
        if (this.curb.getBlocks().contains(this)) { curb.addBlock(this); }
    }

//    @Override
//    public String toString () {
//        return getClass().getSimpleName()
//            + " id:" + id + " name:" + name + " " + curb.getRoad().getName() + " " + curb.getOrientation().print();
//    }
}