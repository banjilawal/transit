package com.lawal.transit.catalog;

import com.lawal.transit.address.Addresses;
import lombok.Getter;

@Getter
public enum AddressCatalog {
    INSTANCE;

    private final Addresses catalog;

    AddressCatalog () { catalog = new Addresses(); }
}