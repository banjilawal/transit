package com.lawal.transit.infrastructure.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final RouteRepo routeRepo;
    private final DepartureRepo departureRepo;

    @Autowired
    public RouteService (RouteRepo routeRepo, DepartureRepo departureRepo) {
        this.routeRepo = routeRepo;
        this.departureRepo = departureRepo;
    }
}