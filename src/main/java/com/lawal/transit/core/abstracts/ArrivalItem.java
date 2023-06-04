package com.lawal.transit.core.abstracts;

import java.time.LocalTime;
import java.util.Objects;

public abstract class ArrivalItem extends IdentifiableEntity {
    private String transitRouteType;
    private String transitRouteName;
    private String stationName;

    public ArrivalItem (int id, String transitRouteType, String transitRouteName, String stationName) {
        super(id);
        this.transitRouteType = transitRouteType;
        this.transitRouteName = transitRouteName;
        this.stationName = stationName;
    } // close constructor

    public String getTransitRouteType () {
        return transitRouteType;
    }

    public String getTransitRouteName () {
        return transitRouteName;
    }

    public String getStationName () {
        return stationName;
    }

    public void setTransitRouteType (String transitRouteType) {
        this.transitRouteType = transitRouteType;
    }

    public void setTransitRouteName (String transitRouteName) {
        this.transitRouteName = transitRouteName;
    }

    public void setStationName (String stationName) {
        this.stationName = stationName;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof ArrivalItem) {
            ArrivalItem ai = (ArrivalItem) object;
            if (super.equals(ai)) {
                if (transitRouteType.equalsIgnoreCase(ai.getTransitRouteType())) {
                    if (transitRouteName.equalsIgnoreCase(ai.getTransitRouteName())) {
                        if (stationName.equalsIgnoreCase(ai.getStationName())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), transitRouteType, transitRouteName, stationName);
    } // close hashCode

    @Override
    public String toString () {
        String string = super.toString()
                + " " + transitRouteType
                + " Route:" + transitRouteName
                + " Station:" + stationName;
        return string;
    } // close toString
} // end class TransitArrivalItem
