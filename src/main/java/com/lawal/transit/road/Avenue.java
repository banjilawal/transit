package com.lawal.transit.road;

import com.lawal.transit.addresses.*;
import com.lawal.transit.addresses.RoadName;
import com.lawal.transit.road.interfaces.*;


public class Avenue extends CityRoad {

    public Avenue (RoadLabel label, TrafficLanes lanes) {
        super(label, lanes);
    }

    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Avenue avenue) {
            return super.equals(avenue);
        }
        return false;
    }

}
