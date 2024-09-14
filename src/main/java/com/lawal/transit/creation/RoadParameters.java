package com.lawal.transit.creation;

import com.lawal.transit.addressing.properties.AddressParameters;
import com.lawal.transit.addressing.properties.NamingRuleSet;
import com.lawal.transit.globals.Laterality;
import com.lawal.transit.roads.RoadCategory;

import java.util.HashMap;

public record RoadParameters (
    int roadId,
    String roadName,
    RoadCategory roadCategory,
    int blocksPerCurbside,
    int placesPerBlock,
    int stationRatio,
    NamingRuleSet rulesSet
) {}