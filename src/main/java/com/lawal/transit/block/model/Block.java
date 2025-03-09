package com.lawal.transit.block.model;

import com.lawal.transit.address.model.Address;

import com.lawal.transit.address.model.exception.NullAddressListException;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.curb.CurbOrientationException;


import com.lawal.transit.station.model.Station;
import com.lawal.transit.station.model.exception.IncompatibleEdgeDirection;
import com.lawal.transit.station.model.exception.NullEdgeException;
import com.lawal.transit.street.model.Street;
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

    @OneToMany(mappedBy = "headBlock", cascade = CascadeType.ALL)
    private List<BlockEdge> outgoingEdges = new ArrayList<>();

    @OneToMany(mappedBy = "tailBlock", cascade = CascadeType.ALL)
    private List<BlockEdge> incomingEdges = new ArrayList<>();

    public Block (Long id, String name, Curb curb) {
        this.id = id;
        this.name = name;
        this.curb = curb;
        this.curb.getBlocks().add(this);
        this.addresses = new ArrayList<>();
    }

    public Avenue getAvenue() { return curb.getAvenue(); }

    public Street getStreet() { return curb.getStreet(); }

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
        if (this.station != null && this.station.equals(station)) return;

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
        if (curb == null || this.curb != null && this.curb.equals(curb)) return;
        if (this.curb != null) { this.curb.removeBlock(this); }

        this.curb = curb;
        if (!this.curb.getBlocks().contains(this)) { curb.addBlock(this); }
    }

    public void setOutgoingEdges (List<BlockEdge> edges) {
        if (edges == null) throw new IllegalArgumentException("Cannot add null blockEdges");

        if(this.outgoingEdges == null) outgoingEdges = new ArrayList<>();
        this.outgoingEdges.clear();

        for (BlockEdge edge : edges) { addOutgoingEdge(edge); }
    }

    public void setIncomingEdges (List<BlockEdge> edges) {
        if (edges == null) throw new IllegalArgumentException("Cannot add null blockEdges");

        if (this.incomingEdges == null) incomingEdges = new ArrayList<>();
        this.incomingEdges.clear();

        for (BlockEdge edge : edges) { addIncomingEdge(edge); }
    }

    public void addOutgoingEdge(BlockEdge edge) {
        if (edge == null) {
            throw new IllegalArgumentException("Cannot add null edge to outgoingEdges");
        }
        if (!this.equals(edge.getHead())) {
            throw new IllegalStateException("Outgoing edge head does not match this block: " + this);
        }
        if (!outgoingEdges.contains(edge)) {
            outgoingEdges.add(edge);
        }
    }

    public void addIncomingEdge(BlockEdge edge) {
        if (edge == null) {
            throw new IllegalArgumentException("Cannot add null edge to incomingEdges");
        }
        if (!this.equals(edge.getTail())) {
            throw new IllegalStateException("Incoming edge tail does not match this block: " + this);
        }
        if (!incomingEdges.contains(edge)) {
            incomingEdges.add(edge);
        }
    }

    public void removeOutgoingEdge(BlockEdge edge) {
        if (edge == null) {
            throw new NullPointerException("Cannot remove null edge");
        }

        if (outgoingEdges.contains(edge)) {
            outgoingEdges.remove(edge);
            if (edge.getHead() != null && this.equals(edge.getHead())) {
                edge.setHead(null);
            }
        }
    }

    public void removeIncoming(BlockEdge edge) {
        if (edge == null) {
            throw new NullPointerException("Cannot remove null edge");
        }

        if (incomingEdges.contains(edge)) {
            incomingEdges.remove(edge);
            if (edge.getTail() != null && this.equals(edge.getTail())) {
                edge.setTail(null);
            }
        }
    }


    @Override
    public String toString () {
        return getClass().getSimpleName()
            + " id:" + id + " name:" + name + " " + curb.getRoad().getName() + " " + curb.getOrientation().abbreviation();
    }
}