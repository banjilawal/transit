package com.lawal.transit.edge.model;

import com.lawal.transit.station.model.Station;
import com.lawal.transit.station.model.exception.NullStationException;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "edges")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "head_station_id", nullable = false)
    private Station headStation;

    @ManyToOne
    @JoinColumn(name = "tail_station_id", nullable = false)
    private Station tailStation;

    @Column(name = "distance", nullable = false, columnDefinition = "int default 0")
    private int distance;

    @Column(name = "actual_time", nullable = false, columnDefinition = "int default 0")
    private int actual_time;

    @Column(name = "heuristic", nullable = false, columnDefinition = "int default 0")
    private int heuristic;

    public Edge (Long id, Station headStation, Station tailStation, int distance, int actual_time, int heuristic) {

        if (headStation == null || tailStation == null) {
            throw new NullStationException(NullStationException.MESSAGE);
        }

        if (headStation.getOutgoingEdges() == null || tailStation.getIncomingEdges() == null) {
            throw new IllegalArgumentException("Neither head nor tail stations can have null outgoing or incoming edge lists");
        }

        if (distance < 0 || actual_time < 0 || heuristic < 0) {
            throw new IllegalArgumentException("Edge distance, actual_time, nor heuristic can be negative");
        }

        this.headStation = headStation;
        if (!this.headStation.getOutgoingEdges().contains(this)) this.headStation.getOutgoingEdges().add(this);

        this.tailStation = tailStation;
        if (!this.tailStation.getIncomingEdges().contains(this)) this.tailStation.getIncomingEdges().add(this);

        this.id = id;
        this.distance = distance;
        this.heuristic = heuristic;
        this.actual_time = actual_time;
    }

    public int getWeight () { return distance + actual_time; }

    public void setHeadsStation (Station station) {
        if (station == null) throw new NullStationException(NullStationException.MESSAGE);

        if (this.headStation != null && this.headStation.equals(station)) return;

        if (this.headStation != null) {
            this.headStation.getOutgoingEdges().remove(this);
            this.headStation = null;
        }

        this.headStation = station;
        this.headStation.getOutgoingEdges().add(this);
    }

    public void setTailsStation (Station station) {
        if (station == null) throw new NullStationException(NullStationException.MESSAGE);

        if (this.tailStation != null && this.tailStation.equals(station)) return;

        if (this.tailStation != null) {
            this.tailStation.getIncomingEdges().remove(this);
            this.tailStation = null;
        }

        this.tailStation = station;
        this.tailStation.getOutgoingEdges().add(this);
    }
}