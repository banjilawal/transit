package com.lawal.transit.block.model;

import com.lawal.transit.address.model.Address;

import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.curb.CurbOrientationException;

import com.lawal.transit.global.StationBlock;
import com.lawal.transit.station.model.Station;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "blocks")
public class Block {

    @Id
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
        this.addresses = new ArrayList<>();
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Block block)
            return id.equals(block.getId());
        return false;
    }

//    @Override
//    public String toString () {
//        return getClass().getSimpleName()
//            + " id:" + id + " name:" + name + " " + curb.getRoad().getName() + " " + curb.getOrientation().print();
//    }
}