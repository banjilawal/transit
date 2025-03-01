package com.lawal.transit.catalog;

import com.lawal.transit.address.model.Address;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum AddressCatalog {
    INSTANCE;

    private final List<Address> catalog;

    AddressCatalog () { catalog = new ArrayList<>(); }
}