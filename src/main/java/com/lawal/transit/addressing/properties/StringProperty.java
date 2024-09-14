package com.lawal.transit.addressing.properties;

import com.lawal.transit.globals.StringPropertyType;

import java.util.HashMap;

public record StringProperty(HashMap<StringPropertyType, String> map) {
}