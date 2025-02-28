package com.lawal.transit.station.model;

import com.lawal.transit.block.model.Block;

import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.curb.CurbOrientationException;
import com.lawal.transit.edge.model.Edge;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "stations")
public final class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = CurbOrientationException.MESSAGE)
    String name;

    @OneToOne
    @JoinColumn(name = "block_id", nullable = false)
    private Block block;

    @OneToMany(mappedBy = "headStation", cascade = CascadeType.ALL)
    private List<Edge> outgoingEdges = new ArrayList<>();

    @OneToMany(mappedBy = "tailStation", cascade = CascadeType.ALL)
    private List<Edge> incomingEdges = new ArrayList<>();

    public Station (Long id, String name, Block block) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.block.setStation(this);
        this.incomingEdges = new ArrayList<>();
        this.outgoingEdges = new ArrayList<>();
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