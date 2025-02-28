package com.lawal.transit.junction.service;

import com.lawal.transit.junction.JunctionCornerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JunctionCornerService {

    private final JunctionCornerRepo junctionCornerRepo;

    @Autowired
    public JunctionCornerService (JunctionCornerRepo junctionCornerRepo) { this.junctionCornerRepo = junctionCornerRepo;}
}