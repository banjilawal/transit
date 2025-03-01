package com.lawal.transit.catalog;


import com.lawal.transit.curb.model.Curb;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum CurbCatalog {
    INSTANCE;

    private final List<Curb> catalog;

    CurbCatalog () {
        catalog = new ArrayList<>();
    }
}