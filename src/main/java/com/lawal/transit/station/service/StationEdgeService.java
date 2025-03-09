package com.lawal.transit.station.service;

import com.lawal.transit.station.repo.StationEdgeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationEdgeService {

    private final StationEdgeRepo stationEdgeRepo;

    @Autowired
    public StationEdgeService (StationEdgeRepo stationEdgeRepo) { this.stationEdgeRepo = stationEdgeRepo; }
}