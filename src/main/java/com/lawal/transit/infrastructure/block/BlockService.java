package com.lawal.transit.infrastructure.block;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    private final BlockRepo blockRepo;

    @Autowired
    public BlockService(BlockRepo blockRepo) {
        this.blockRepo = blockRepo;
    }
}