package com.lawal.transit.infrastructure.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private final HouseRepo houseRepo;

    @Autowired
    public HouseService (HouseRepo houseRepo) { this.houseRepo = houseRepo; }
}