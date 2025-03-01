package com.lawal.transit.edge.model;

import com.lawal.transit.station.model.Station;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "edges")
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
        this.id = id;
        this.headStation = headStation;
        this.headStation.getOutgoingEdges().add(this);

        this.tailStation = tailStation;
        this.tailStation.getIncomingEdges().add(this);

        this.distance = distance;
        this.actual_time = actual_time;
        this.heuristic = heuristic;
    }

    public int getWeight () { return distance + actual_time; }

}