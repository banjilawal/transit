package com.lawal.transit.station.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawal.transit.station.repo.StationRepo;

@Service
public class StationService {

    private final StationRepo stationRepo;

    @Autowired
    public StationService(StationRepo stationRepo) { this.stationRepo = stationRepo; }
}