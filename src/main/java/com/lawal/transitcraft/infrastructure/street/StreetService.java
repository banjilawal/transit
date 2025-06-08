package com.lawal.transitcraft.infrastructure.street;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetService {

    private final StreetRepo streetRepo;

    @Autowired
    public StreetService( StreetRepo streetRepo) { this.streetRepo = streetRepo; }
}