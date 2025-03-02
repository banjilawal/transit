package com.lawal.transit.station.model;

import com.lawal.transit.block.model.Block;

import com.lawal.transit.edge.model.Edge;


import com.lawal.transit.station.model.exception.StationNameNullException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "stations")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public final class Station {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = StationNameNullException.MESSAGE)
    String name;

    @OneToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @OneToMany(mappedBy = "headStation", cascade = CascadeType.ALL)
    private List<Edge> outgoingEdges = new ArrayList<>();

    @OneToMany(mappedBy = "tailStation", cascade = CascadeType.ALL)
    private List<Edge> incomingEdges = new ArrayList<>();

    public Station (Long id, String name, Block block) {
        this.id = id;
        this.name = name;

        this.block = block;
        if (block != null) {
            if (!this.equals(block.getStation())) block.setStation(this);
        }
        this.incomingEdges = new ArrayList<>();
        this.outgoingEdges = new ArrayList<>();
    }

    public void setBlock(Block block) {
        if (this.block != null && this.block.equals(block)) return;

        if (this.block != null) {
            this.block.setStation(null);
            this.block = null;
        }

        if (block != null) {
            block.setStation(this);
            this.block = block;
        }
    }



    @Override
    public String toString () {
        return getClass().getSimpleName()
            + "[id:" + id
            + " name:" + name
            + " (" + block.getName()
            + " blockId:" + block.getId()
            + ") curbId:" + block.getCurb().getId()
//            + " " + block.getCurb().getRoad().toString()
            + " " + block.getCurb().getOrientation().print() + "]"
            + " in degree:" + incomingEdges.size() + " out degree:" + outgoingEdges.size();
    }
}