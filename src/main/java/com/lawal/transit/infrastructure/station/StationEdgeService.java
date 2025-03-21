package com.lawal.transit.infrastructure.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationEdgeService {

    private final StationEdgeRepo stationEdgeRepo;

    @Autowired
    public StationEdgeService (StationEdgeRepo stationEdgeRepo) { this.stationEdgeRepo = stationEdgeRepo; }
}