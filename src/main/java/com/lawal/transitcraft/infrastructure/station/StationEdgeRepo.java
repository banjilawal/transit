package com.lawal.transitcraft.infrastructure.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationEdgeRepo extends JpaRepository<StationEdge, Long> {

    // Find edges based on the source and destination stations
    List<StationEdge> findByHeadAndTail(Station head, Station tail);

    // Optional: Find all edges connected to a given station (for path exploration)
    List<StationEdge> findByHead(Station head);

    List<StationEdge> findByTail(Station tail);
}