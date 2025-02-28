package com.lawal.transit.edge;

import com.lawal.transit.edge.model.Edge;
import com.lawal.transit.station.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdgeRepo extends JpaRepository<Edge, Long> {

    // Find edges based on the source and destination stations
    List<Edge> findByHeadStationAndTailStation(Station headStation, Station tailStation);

    // Optional: Find all edges connected to a given station (for path exploration)
    List<Edge> findByHeadStation(Station headStation);

    List<Edge> findByTailStation(Station tailStation);
}