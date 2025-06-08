package com.lawal.transitcraft.infrastructure.curb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurbService {

    private CurbRepo curbRepo;

    @Autowired
    public CurbService(CurbRepo curbRepo) {
        this.curbRepo = curbRepo;
    }
}