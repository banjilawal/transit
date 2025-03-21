package com.lawal.transit.infrastructure.junction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JunctionService {

    private final JunctionRepo junctionRepo;

    @Autowired
    public JunctionService (JunctionRepo junctionRepo) { this.junctionRepo = junctionRepo;}
}