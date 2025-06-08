package com.lawal.transitcraft.infrastructure.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusRouteService {

    private final BusRouteRepo busRouteRepo;
    private final DepartureRepo departureRepo;

    @Autowired
    public BusRouteService (BusRouteRepo busRouteRepo, DepartureRepo departureRepo) {
        this.busRouteRepo = busRouteRepo;
        this.departureRepo = departureRepo;
    }
}