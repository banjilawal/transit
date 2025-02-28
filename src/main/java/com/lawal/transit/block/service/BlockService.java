package com.lawal.transit.block.service;

import com.lawal.transit.block.BlockRepo;
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