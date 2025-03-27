package com.lawal.transit.infrastructure.block;

import com.lawal.transit.graph.VertexColor;
import com.lawal.transit.infrastructure.house.House;

import com.lawal.transit.infrastructure.house.exception.NullHouseListException;
import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.curb.Curb;
import com.lawal.transit.infrastructure.curb.exception.CurbOrientationException;

import com.lawal.transit.infrastructure.station.Station;
import com.lawal.transit.infrastructure.street.Street;
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

    @Column(nullable = true)
    private VertexColor color;

    @Column(nullable = true)
    private int hopCount;

    @Column(nullable = true)
    private Long predecessorId;

    @ManyToOne
    @JoinColumn(name = "curb_id")
    private Curb curb;

    @OneToOne(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private Station station;

    @OneToMany(mappedBy = "block", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<House> houses = new ArrayList<>();

    @OneToMany(mappedBy = "headBlock", cascade = CascadeType.ALL)
    private List<BlockEdge> outgoingEdges = new ArrayList<>();

    @OneToMany(mappedBy = "tailBlock", cascade = CascadeType.ALL)
    private List<BlockEdge> incomingEdges = new ArrayList<>();

    public Block (Long id, String name, Curb curb) {
        this.id = id;
        this.name = name;
        this.curb = curb;

        this.color = VertexColor.WHITE;
        this.hopCount = 0;
        this.predecessorId = null;

        if (this.curb != null && curb.getBlocks() != null) { this.curb.getBlocks().add(this); }
        this.houses = new ArrayList<>();

        this.incomingEdges = new ArrayList<>();
        this.outgoingEdges = new ArrayList<>();
    }

    public Avenue getAvenue() { return curb.getAvenue(); }

    public Street getStreet() { return curb.getStreet(); }

    public void setHouses (List<House> houses) {
        if (houses == null) throw new NullHouseListException(NullHouseListException.MESSAGE);
        if (this.houses == null) this.houses = new ArrayList<>();
        for (House house : houses) addHouse(house);
    }

    public void addHouse(House house) {
        if (house == null) throw new NullPointerException(BlockMessage.ADDRESS_PARAMETER_NULL_EXCEPTION);

        if (houses.contains(house) && house.getBlock() == this) return;

        house.setBlock(this);

        if (!houses.contains(house)) {
            houses.add(house);
        }
    }

    public void removeHouse(House house) {
        if (house == null) throw new NullPointerException(BlockMessage.ADDRESS_PARAMETER_NULL_EXCEPTION);

        if (houses.contains(house) && house.getBlock() == this) {
            houses.remove(house);
            house.setBlock(null);
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

    public House getFirstHouse() { return houses.get(0); }
    public House getLastHouse() { return houses.get(houses.size() - 1); }


    @Override
    public String toString () {
        return getClass().getSimpleName()
            + " id:" + id + " name:" + name + " " + curb.getRoad().getName() + " " + curb.getOrientation().abbreviation();
    }
}