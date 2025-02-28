package com.lawal.transit.edge.service;

import com.lawal.transit.edge.EdgeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdgeService {

    private final EdgeRepo edgeRepo;

    @Autowired
    public EdgeService(EdgeRepo edgeRepo) { this.edgeRepo = edgeRepo; }
}