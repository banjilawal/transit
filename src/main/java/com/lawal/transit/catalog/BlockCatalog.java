package com.lawal.transit.catalog;


import com.lawal.transit.block.Blocks;
import com.lawal.transit.block.interfaces.RoadSegments;
import lombok.Getter;

@Getter
public enum BlockCatalog {
    INSTANCE;

    private final RoadSegments catalog;

    BlockCatalog () {
        catalog = new Blocks();
    }
}