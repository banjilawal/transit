package com.lawal.transit.infrastructure.catalog;

import com.lawal.transit.infrastructure.house.House;
import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.street.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum HouseCatalog {
    INSTANCE;

    private final List<House> catalog;

    HouseCatalog () { catalog = new ArrayList<>(); }
//
//    public List<House> getCatalog() { return List.copyOf(catalog); }

    public void addHouse(House house) {
        if (house == null) return;
        if (catalog.contains(house)) return;
        catalog.add(house);
    }

    public House findById(Long id) {
        if (id == null) return null;
        for (House house : catalog) {
            if (house.getId().equals(id)) return house;
        }
        return null;
    }

    public List<House> filterByAvenue(Avenue avenue) {
        List<House> matches = new ArrayList<>();
        if (avenue == null) return matches;

        for (House house : catalog) {
            Avenue addressAvenue = house.getBlock().getAvenue();
            if (addressAvenue != null && addressAvenue.equals(avenue) && !matches.contains(house)) matches.add(house);
        }
        return matches;
    }

    public List<House> filterByStreet(Street street) {
        List<House> matches = new ArrayList<>();
        if (street == null) return matches;

        for (House house : catalog) {
            Street addressStreet = house.getBlock().getStreet();
            if (addressStreet != null && addressStreet.equals(street) && !matches.contains(house)) matches.add(house);
        }
        return matches;
    }

    public House randomHouse() {
        return catalog.get((int) (Math.random() * catalog.size()));
    }

}