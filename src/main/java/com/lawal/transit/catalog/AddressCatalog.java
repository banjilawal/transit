package com.lawal.transit.catalog;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum AddressCatalog {
    INSTANCE;

    private final List<Address> catalog;

    AddressCatalog () { catalog = new ArrayList<>(); }

    public List<Address> getCatalog() { return List.copyOf(catalog); }

    public void addAddress(Address address) {
        if (address == null) return;
        if (catalog.contains(address)) return;
        catalog.add(address);
    }

    public Address findById(Long id) {
        if (id == null) return null;
        for (Address address : catalog) {
            if (address.getId().equals(id)) return address;
        }
        return null;
    }

    public List<Address> filterByAvenue(Avenue avenue) {
        if (avenue == null) return null;

        List<Address> matches = new ArrayList<>();
        for (Address address : catalog) {
            Avenue addressAvenue = address.getBlock().getAvenue();
            if (addressAvenue != null && addressAvenue.equals(avenue) && !matches.contains(address)) matches.add(address);
        }
        return matches;
    }

    public List<Address> filterByStreet(Street street) {
        if (street == null) return null;

        List<Address> matches = new ArrayList<>();
        for (Address address : catalog) {
            Street addressStreet = address.getBlock().getStreet();
            if (addressStreet != null && addressStreet.equals(street) && !matches.contains(address)) matches.add(address);
        }
        return matches;
    }

}