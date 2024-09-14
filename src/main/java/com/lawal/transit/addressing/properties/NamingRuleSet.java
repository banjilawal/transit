package com.lawal.transit.addressing.properties;

import com.lawal.transit.globals.Laterality;

import java.util.HashMap;

public record NamingRuleSet(HashMap<Laterality, PlaceParameters> rules) {
}