package com.lawal.transit.catalog;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.Blocks;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum BlockCatalog {
    INSTANCE;

    private final List<Block> catalog;

    BlockCatalog () {
        catalog = new ArrayList<>();
    }

    public Block findById(Long id) {
        if (id == null) return null;

        for (Block block : catalog) {
            if (block.getId().equals(id)) return block;
        }
        return null;
    }

    public List<Block> getStationBlocks(){
        List<Block> matches = new ArrayList<>();
        for (Block block : catalog) {
            if (block.getStation() != null && !matches.contains(block)) matches.add(block);
        }
        return matches;
    }

    public List<Block> filterByRoad(Road road) {
        if (road == null) return null;

        List<Block> matches = new ArrayList<>();
        for (Block block : catalog) {
            if (block.getCurb().getRoad().equals(road) && !matches.contains(block)) matches.add(block);
        }
        return matches;
    }

    public List<Block> filterByAvenue(Avenue avenue) {
        List<Block> matches = new ArrayList<>();
        if (avenue == null) return matches;
        for (Block block : catalog) {
            Avenue blockAvenue = block.getCurb().getAvenue();
            if (blockAvenue != null && blockAvenue.equals(avenue) && !matches.contains(block)) matches.add(block);
        }
        return matches;
    }

    public List<Block> filterByStreet(Street street) {
        if (street == null) return null;

        List<Block> matches = new ArrayList<>();
        for (Block block : catalog) {
            if (block.getCurb().getStreet().equals(street) && !matches.contains(block)) matches.add(block);
        }
        return matches;
    }

    public List<Block> filterByCurbOrientation(Direction curbOrientation) {
        if (curbOrientation == null) return null;

        List<Block> matches = new ArrayList<>();
        for (Block block : catalog) {
            if (block.getCurb().getOrientation().equals(curbOrientation) && !matches.contains(block)) matches.add(block);
        }
        return matches;
    }
}