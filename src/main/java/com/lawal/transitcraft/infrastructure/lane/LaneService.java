package com.lawal.transitcraft.infrastructure.lane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaneService {

    private final LaneRepo laneRepo;

    @Autowired
    public LaneService(LaneRepo laneRepo) { this.laneRepo = laneRepo; }
}