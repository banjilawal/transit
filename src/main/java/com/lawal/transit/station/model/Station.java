package com.lawal.transit.station.model;

import com.lawal.transit.block.model.Block;

import com.lawal.transit.edge.model.Edge;


import com.lawal.transit.edge.model.exception.NullEdgeException;
import com.lawal.transit.route.model.Departure;
import com.lawal.transit.route.model.exception.NullTransitStopException;
import com.lawal.transit.station.model.exception.IncompatibleEdgeDirection;
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

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
    private List<Departure> departures = new ArrayList<>();

    public Station (Long id, String name, Block block) {
        this.id = id;
        this.name = name;

        if (block != null) { if (!this.equals(block.getStation())) block.setStation(this); }
        this.block = block;

        this.incomingEdges = new ArrayList<>();
        this.outgoingEdges = new ArrayList<>();
        this.departures = new ArrayList<>();
    }

    public void setBlock(Block block) {
        if (this.block != null && this.block.equals(block)) return;

        if (this.block != null) {
            Block oldBlock = this.block;
            this.block = null;
            oldBlock.setStation(null);
        }

        if (block != null) {
            this.block = block;

            if (!this.equals(block.getStation()))
                block.setStation(this);
        }
    }

    public void setDepartures(List<Departure> departures) {
        if (departures == null) throw new IllegalArgumentException("Cannot add null stops");

        if (this.departures == null) departures = new ArrayList<>();
        if (this.departures != null) this.departures.clear();

        for (Departure departure : departures) { addDeparture(departure); }
    }

    public void addDeparture(Departure departure) {
        if (departure == null) throw new NullTransitStopException(NullTransitStopException.MESSAGE);

        if (departures == null) departures = new ArrayList<>();
        if (departures.contains(departure)) return;

        departures.add(departure);
        if (!departure.getStation().equals(this)) { departure.setStation(this); }
    }

    public void removeDeparture (Departure departure) {
        if (departure == null) throw new NullTransitStopException(NullTransitStopException.MESSAGE);

        if (departures.contains(departure)) {
            departures.remove(departure);
            if (departure.getStation() != null && this.equals(departure.getStation())) { departure.setRoute(null); }
        }
    }

    public void setOutgoingEdges(List<Edge> edges) {
        if (edges == null) throw new IllegalArgumentException("Cannot add null edges");

        if(this.outgoingEdges == null) outgoingEdges = new ArrayList<>();
        this.outgoingEdges.clear();

        for (Edge edge : edges) { addOutgoingEdge(edge); }
    }

    public void setIncomingEdges(List<Edge> edges) {
        if (edges == null) throw new IllegalArgumentException("Cannot add null edges");

        if (this.incomingEdges == null) incomingEdges = new ArrayList<>();
        this.incomingEdges.clear();

        for (Edge edge : edges) { addIncomingEdge(edge); }
    }

    public void addOutgoingEdge(Edge edge) {
        if (edge == null) throw new NullEdgeException(NullEdgeException.MESSAGE);
        if(!this.equals(edge.getHeadStation())) throw new IncompatibleEdgeDirection(IncompatibleEdgeDirection.MESSAGE);

        if (outgoingEdges == null) this.outgoingEdges = new ArrayList<>();
        if (outgoingEdges.contains(edge)) return;

        outgoingEdges.add(edge);
//        if (edge.getHeadStation() != null && !this.equals(edge.getHeadStation())) {
//            edge.setHeadStation(this);
//        }
    }

    public void addIncomingEdge(Edge edge) {
        if (edge == null) throw new NullEdgeException(NullEdgeException.MESSAGE);
        if (!this.equals(edge.getTailStation())) throw new IncompatibleEdgeDirection(IncompatibleEdgeDirection.MESSAGE);

        if (incomingEdges == null) this.incomingEdges = new ArrayList<>();
        if (incomingEdges.contains(edge)) return;

        incomingEdges.add(edge);
//        if (edge.getTailStation() != null && !this.equals(edge.getTailStation())) {
//            edge.setTailStation(this);
//        }
    }

    public void removeOutgoingEdge(Edge edge) {
        if (edge == null) throw new NullEdgeException(NullEdgeException.MESSAGE);

        if (outgoingEdges.contains(edge)) {
            outgoingEdges.remove(edge);
            if (edge.getHeadStation() != null && this.equals(edge.getHeadStation())) { edge.setHeadsStation(null); }
        }
    }

    public void removeIncoming(Edge edge) {
        if (edge == null) throw new NullEdgeException(NullEdgeException.MESSAGE);

        if (incomingEdges.contains(edge)) {
            incomingEdges.remove(edge);
            if (edge.getTailStation() != null && this.equals(edge.getTailStation())) { edge.setTailStation(null); }
        }
    }


    @Override
    public String toString () {
        return getClass().getSimpleName()
            + "[id:" + id
            + " name:" + name
            + "-" + block.getCurb().getOrientation().abbreviation()
            + " inDegree:" + incomingEdges.size()
            + " outDegree:" + outgoingEdges.size()
            + "]";
//            + " (" + block.getName()
//            + " blockId:" + block.getId()
//            + ") curbId:" + block.getCurb().getId()
//            + " " + block.getCurb().getRoad().toString()
//            + " " + block.getCurb().getOrientation().print() + "]"
//            + " in degree:" + incomingEdges.size() + " out degree:" + outgoingEdges.size();
    }
}