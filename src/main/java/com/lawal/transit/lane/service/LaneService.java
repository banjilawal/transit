package com.lawal.transit.lane.service;

import com.lawal.transit.lane.LaneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaneService {

    private final LaneRepo laneRepo;

    @Autowired
    public LaneService(LaneRepo laneRepo) { this.laneRepo = laneRepo; }
}