package com.lawal.transit.road.service;

import com.lawal.transit.road.RoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class roadService {

    private final RoadRepo roadRepo;

    @Autowired
    public roadService(RoadRepo roadRepo) {
        this.roadRepo = roadRepo;
    }
}