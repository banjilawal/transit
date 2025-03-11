package com.lawal.transit.catalog;

import com.lawal.transit.house.model.House;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum AddressCatalog {
    INSTANCE;

    private final List<House> catalog;

    AddressCatalog () { catalog = new ArrayList<>(); }

    public List<House> getCatalog() { return List.copyOf(catalog); }

    public void addAddress(House house) {
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
        if (avenue == null) return null;

        List<House> matches = new ArrayList<>();
        for (House house : catalog) {
            Avenue addressAvenue = house.getBlock().getAvenue();
            if (addressAvenue != null && addressAvenue.equals(avenue) && !matches.contains(house)) matches.add(house);
        }
        return matches;
    }

    public List<House> filterByStreet(Street street) {
        if (street == null) return null;

        List<House> matches = new ArrayList<>();
        for (House house : catalog) {
            Street addressStreet = house.getBlock().getStreet();
            if (addressStreet != null && addressStreet.equals(street) && !matches.contains(house)) matches.add(house);
        }
        return matches;
    }

    public House randomAddress() {
        return catalog.get((int) (Math.random() * catalog.size()));
    }

}