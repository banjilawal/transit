package com.lawal.transit.addressing.properties;

import com.lawal.transit.globals.PlaceCategory;

import java.util.HashMap;

public record PlaceParameters(HashMap<PlaceCategory, AddressParameters> params) {
}