package com.lawal.transit.route.sevice;

import com.lawal.transit.route.repo.TransitRouteRepo;
import com.lawal.transit.route.repo.TransitStopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransitRouteService {

    private final TransitRouteRepo transitRouteRepo;
    private final TransitStopRepo transitStopRepo;

    @Autowired
    public TransitRouteService(TransitRouteRepo transitRouteRepo, TransitStopRepo transitStopRepo) {
        this.transitRouteRepo = transitRouteRepo;
        this.transitStopRepo = transitStopRepo;
    }
}