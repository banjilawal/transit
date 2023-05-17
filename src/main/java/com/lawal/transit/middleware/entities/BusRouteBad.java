package com.lawal.transit.middleware.entities;
/*
import com.lawal.transit.middleware.abstracts.Item;
import com.lawal.transit.middleware.enums.TransitRouteCategory;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class BusRouteBad extends Item {
    private int id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private int interArrivalTime;
    private ArrayList<Station> stops;
    private TransitRouteCategory category;

    public BusRouteBad (int id, String name) {
        this(id, name, LocalTime.of(6,0), LocalTime.of(2,30), 12);
    } // close constructor
    public BusRouteBad (int id, String name, LocalTime startTime, LocalTime endTime, int interArrivalTime) {
        this(TransitRouteCategory.REGULAR, id, name, startTime, endTime, interArrivalTime);
    } // close constructor

    public BusRouteBad (TransitRouteCategory category, int id, String name, LocalTime startTime, LocalTime endTime, int interArrivalTime) {
        super(id, name);
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
        this.interArrivalTime = interArrivalTime;

        if (this.category == TransitRouteCategory.EXPRESS) {
            this.interArrivalTime = 8;
        }

        this.stops = new ArrayList<Station>();
    } // close constructor

    public int getId () {
        return this.id;
    }
    public String getName () {
        return this.name;
    }  // close getName

    public LocalTime getStartTime () {
        return this.startTime;
    }  // close getStartTime

    public LocalTime getEndTime () {
        return this.endTime;
    } // close getEndTime

    public int getInterArrivalTime () {
        return this.interArrivalTime;
    } // close getInterArrivalTime

    public TransitRouteCategory getCategory () {
        return this.category;
    }

    public ArrayList<Station> getStops () {
        return this.stops;
    }

    public void setId (int id) {
        this.id = id;
    } //close setId

    public void setName (String name) {
        this.name = name;
    } //close setName

    public void setStartTime (LocalTime startTime) {
        this.startTime = startTime;
    } //close setStartTime

    public void setEndTime (LocalTime endTime) {
        this.endTime = endTime;
    } //close setEndTime

    public void setInterArrivalTime (int interArrivalTime) {
        this.interArrivalTime = interArrivalTime;

        if (this.category == TransitRouteCategory.EXPRESS && interArrivalTime > 10) {
            this.interArrivalTime = 8;
        }
    } //close setInterArrivalTime

    public void setStops (ArrayList<Station> stops) {
        this.stops = stops;
    } // close setStops

    public void setCategory (TransitRouteCategory category) {
        this.category = category;

        if (category == TransitRouteCategory.EXPRESS) {
            this.interArrivalTime = 8;
        }
    } // close setCategory

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startTime, endTime, interArrivalTime);
    } // close hashCode

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof BusRouteBad) {
            BusRouteBad busRoute = (BusRouteBad) object;

            if (this.id == busRoute.getId() && this.name.equalsIgnoreCase(busRoute.getName())){
                if (this.startTime == busRoute.getStartTime() && this.endTime == busRoute.getEndTime()) {
                    if (this.interArrivalTime == busRoute.getInterArrivalTime()) {
                        if ( this.category.compareTo(busRoute.getCategory()) == 0) {
                            isEqual = true;
                        }
                    }
                }
            }
        }
        return isEqual;
    } // close equals

    @Override
    public String toString () {
        String string = "Name:" + this.name
                + this.category.print()
                + " startTime:" + this.startTime
                + " endTime:" + this.endTime
                + " interArrivalTime:" + this.interArrivalTime
                + "\n-----------------------------------------------------------\nStops";

        for (Station stop : this.stops) {
            string += "\n\t" + stop.toString();
        }
        return string;
    } // close toString

    private String printStops () {
        String string = "Stops:";

        for (Station stop : this.stops) {
            string += "\n\t" + stop.toString();
        }
        return string;
    } //

} // end class TransitRoute
*/
