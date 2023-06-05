package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Station;

import java.time.LocalTime;
import java.util.Objects;

public abstract class DestinationName extends IdentifiableEntity {
    private String stationName;

    public DestinationName (int id, Station station) {
        super(id);
        this.stationName = station.getName();
    } // close constructor

    public String getStationName () {
        return stationName;
    }

    public void setStationName (Station station) {
        this.stationName = station.getName();
    }

    public abstract LocalTime getTime ();
    public abstract void setTime(LocalTime time);

    @Override
    public boolean equals (Object object) {
        if (object instanceof DestinationName) {
            DestinationName ai = (DestinationName) object;
            if (super.equals(ai)) {
                if (stationName.equalsIgnoreCase(ai.getStationName())) {
                    return true;
                }
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), stationName);
    } // close hashCode

    @Override
    public String toString () {
        return super.toString() + " Station:" + stationName;
    } // close toString
} // end class TransitArrivalItem
