package com.lawal.transit.road;

import com.lawal.transit.addresses.*;
import com.lawal.transit.addresses.RoadName;


public class Street extends CityRoad {

    public Street (RoadLabel label, TrafficLanes lanes) {
        super(label, lanes);
    }

    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Street street) {
            return super.equals(street);
        }
        return false;
    }

}
