package com.lawal.transitcraft.infrastructure.avenue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvenueService {

    private final AvenueRepo repo;

    @Autowired
    public AvenueService(AvenueRepo repo) {
        this.repo = repo;
    }
}