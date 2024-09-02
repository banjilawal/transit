package com.lawal.transit.catalogs;

import com.lawal.transit.roads.interfaces.RoadSystem;

import javax.xml.catalog.Catalog;

public class CityGrid implements RoadSystem {
    @Override
    public Avenues getAvenues() {
        return Avenues.INSTANCE;
    }

    @Override
    public Streets getStreets() {
        return Streets.INSTANCE;
    }

    @Override
    public Junctions getJunctions() {
        return Junctions.INSTANCE;
    }
}
