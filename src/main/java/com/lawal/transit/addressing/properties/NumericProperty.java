package com.lawal.transit.addressing.properties;

import com.lawal.transit.globals.NumericPropertyType;

import java.util.HashMap;

public record NumericProperty (HashMap<NumericPropertyType, Integer> map) {
}