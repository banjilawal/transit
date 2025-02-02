package com.lawal.transit.catalog;


import com.lawal.transit.block.Blocks;
import lombok.Getter;

@Getter
public enum BlockCatalog {
    INSTANCE;

    private final Blocks catalog;

    BlockCatalog () {
        catalog = new Blocks();
    }
}