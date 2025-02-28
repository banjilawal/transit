package com.lawal.transit.path.model;

import com.lawal.transit.edge.model.Edge;
import com.lawal.transit.station.model.Station;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "paths")
public class Path {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "start_station_id", nullable = false)
    private Station startStation;

    @OneToOne
    @JoinColumn(name = "end_station_id", nullable = false)
    private Station endStation;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "sequence")
    private List<Edge> edges = new ArrayList<>();

    @Column(nullable = false)
    private int totalWeight; // The total weight (e.g., distance, cost)

    public Path(Station startStation, Station endStation, List<Edge> edges, int totalWeight) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.edges = edges;
        this.totalWeight = totalWeight;
    }
}