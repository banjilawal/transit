package com.lawal.transit.infrastructure.station;

import com.lawal.transit.infrastructure.block.Block;


import com.lawal.transit.graph.VertexColor;
import com.lawal.transit.infrastructure.bus.BusRoute;
import com.lawal.transit.infrastructure.junction.Junction;
import com.lawal.transit.infrastructure.station.exception.NullEdgeException;
import com.lawal.transit.infrastructure.bus.Departure;
import com.lawal.transit.infrastructure.bus.exception.NullDepartureException;
import com.lawal.transit.infrastructure.station.exception.IncompatibleEdgeDirection;
import com.lawal.transit.infrastructure.station.exception.StationNameNullException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(nullable = true)
    private VertexColor color;

    @Column(nullable = true)
    private int hopCount;

    @Column(nullable = true)
    private Long predecessorId;

    @OneToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @OneToMany(mappedBy = "head", cascade = CascadeType.ALL)
    private List<StationEdge> outgoingEdges = new ArrayList<>();

    @OneToMany(mappedBy = "tail", cascade = CascadeType.ALL)
    private List<StationEdge> incomingEdges = new ArrayList<>();

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
    private List<Departure> departures = new ArrayList<>();

    public Station (Long id, String name, Block block) {
        this.id = id;
        this.name = name;

        this.color = VertexColor.WHITE;
        this.hopCount = 0;
        this.predecessorId = null;

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
        if (departure == null) throw new NullDepartureException(NullDepartureException.MESSAGE);

        if (departures == null) departures = new ArrayList<>();
        if (departures.contains(departure)) return;

        departures.add(departure);
        if (!departure.getStation().equals(this)) { departure.setStation(this); }
    }

    public void removeDeparture (Departure departure) {
        if (departure == null) throw new NullDepartureException(NullDepartureException.MESSAGE);

        if (departures.contains(departure)) {
            departures.remove(departure);
            if (departure.getStation() != null && this.equals(departure.getStation())) { departure.setBusRoute(null); }
        }
    }

    public void setOutgoingEdges (List<StationEdge> stationEdges) {
        if (stationEdges == null) throw new IllegalArgumentException("Cannot add null stationEdges");

        if(this.outgoingEdges == null) outgoingEdges = new ArrayList<>();
        this.outgoingEdges.clear();

        for (StationEdge stationEdge : stationEdges) { addOutgoingEdge(stationEdge); }
    }

    public void setIncomingEdges (List<StationEdge> stationEdges) {
        if (stationEdges == null) throw new IllegalArgumentException("Cannot add null stationEdges");

        if (this.incomingEdges == null) incomingEdges = new ArrayList<>();
        this.incomingEdges.clear();

        for (StationEdge stationEdge : stationEdges) { addIncomingEdge(stationEdge); }
    }

    public void addOutgoingEdge(StationEdge stationEdge) {
        if (stationEdge == null) throw new NullEdgeException(NullEdgeException.MESSAGE);
        if(!this.equals(stationEdge.getHead())) throw new IncompatibleEdgeDirection(IncompatibleEdgeDirection.MESSAGE);

        if (outgoingEdges == null) this.outgoingEdges = new ArrayList<>();
        if (outgoingEdges.contains(stationEdge)) return;

        outgoingEdges.add(stationEdge);
//        if (stationEdge.getHeadStation() != null && !this.equals(stationEdge.getHeadStation())) {
//            stationEdge.setHeadStation(this);
//        }
    }

    public void addIncomingEdge(StationEdge stationEdge) {
        if (stationEdge == null) throw new NullEdgeException(NullEdgeException.MESSAGE);
        if (!this.equals(stationEdge.getTail())) throw new IncompatibleEdgeDirection(IncompatibleEdgeDirection.MESSAGE);

        if (incomingEdges == null) this.incomingEdges = new ArrayList<>();
        if (incomingEdges.contains(stationEdge)) return;

        incomingEdges.add(stationEdge);
//        if (stationEdge.getTailStation() != null && !this.equals(stationEdge.getTailStation())) {
//            stationEdge.setTailStation(this);
//        }
    }

    public void removeOutgoingEdge(StationEdge stationEdge) {
        if (stationEdge == null) throw new NullEdgeException(NullEdgeException.MESSAGE);

        if (outgoingEdges.contains(stationEdge)) {
            outgoingEdges.remove(stationEdge);
            if (stationEdge.getHead() != null && this.equals(stationEdge.getHead())) { stationEdge.setHead(null); }
        }
    }

    public void removeIncoming(StationEdge stationEdge) {
        if (stationEdge == null) throw new NullEdgeException(NullEdgeException.MESSAGE);

        if (incomingEdges.contains(stationEdge)) {
            incomingEdges.remove(stationEdge);
            if (stationEdge.getTail() != null && this.equals(stationEdge.getTail())) { stationEdge.setTail(null); }
        }
    }

    public Set<BusRoute> getBusRoutes () {
        Set<BusRoute> busRoutes = new HashSet<>();

        for (Departure departure : departures) {
            if (departure.getBusRoute() != null) {
                busRoutes.add(departure.getBusRoute());
            } else {
                System.out.println("Departure has no route: " + departure);
            }
        }
        return busRoutes;
    }

    public String getRouteNames() {
        Set<BusRoute> busRoutes = getBusRoutes();
        if (busRoutes.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (BusRoute busRoute : busRoutes) {
            sb.append(busRoute.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public Set<Station> getIncomingNeighbors() {
        Set<Station> neighbors = new HashSet<>();
        for (StationEdge edge : incomingEdges) {
            neighbors.add(edge.getHead());
        }
        return neighbors;
    }

    public Set<Station> getOutgoingNeighbors() {
        Set<Station> neighbors = new HashSet<>();
        for (StationEdge edge : outgoingEdges) {
            neighbors.add(edge.getTail());
        }
        return neighbors;
    }

    public String getRoadName() {
        return block.getCurb().getRoadName() + " " + block.getCurb().getOrientation().print();
    }

    public String getLocationName() {
        Junction junction = block.getJunctions().stream().findAny().orElse(null);
        if (junction == null) return "";
        else return junction.getAvenue().getName() + " and " + junction.getStreet().getName();
    }

    public boolean isGhostStation() {
        return incomingEdges.isEmpty() && outgoingEdges.isEmpty();
    }

    @Override
    public String toString () {
        return getClass().getSimpleName()
            + "[id:" + id
            + " name:" + name
            + " location:" + getLocationName()
            + " total_incoming_neighbors:" + incomingEdges.size()
            + " total_outgoing_neighbors:" + outgoingEdges.size()
            + " bus_routes:" + getRouteNames()
            + "]";
    }
}