package com.lawal.transit.path.service;

import com.lawal.transit.path.PathRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathService {

    private final PathRepo pathRepo;

    @Autowired
    public PathService(PathRepo pathRepo) {
        this.pathRepo = pathRepo;
    }
}