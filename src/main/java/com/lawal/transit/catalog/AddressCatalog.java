package com.lawal.transit.catalog;

import com.lawal.transit.global.Addresses;
import com.lawal.transit.station.Stations;
import lombok.Getter;

@Getter
public enum AddressCatalog {
    INSTANCE;

    private final Addresses catalog;

    AddressCatalog () { catalog = new Addresses(); }
}