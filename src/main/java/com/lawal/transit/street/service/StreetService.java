package com.lawal.transit.street.service;

import com.lawal.transit.street.StreetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetService {

    private final StreetRepo streetRepo;

    @Autowired
    public StreetService( StreetRepo streetRepo) { this.streetRepo = streetRepo; }
}