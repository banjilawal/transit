package com.lawal.transitcraft.infrastructure.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    private final StationRepo stationRepo;

    @Autowired
    public StationService(StationRepo stationRepo) { this.stationRepo = stationRepo; }
}