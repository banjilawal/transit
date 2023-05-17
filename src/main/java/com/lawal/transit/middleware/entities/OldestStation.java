package com.lawal.transit.middleware.entities;
/*
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.abstracts.Item;
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.collections.BusRouteBag;
import com.lawal.transit.middleware.enums.Direction;

import java.util.Iterator;
import java.util.Objects;

public class OldestStation extends Item implements Comparable<OldestStation> {
    private static final long serialVersionUID = 1L;
    private Road crossRoad;
    private Road road;
    private Direction direction;
    private BusRouteBag buses;

    public OldestStation (int id, String name, Road crossRoad, Road road, Direction direction) {
        super(id, name);
        this.crossRoad = crossRoad;
        this.direction = direction;
        this.road = road;

        this.buses = new BusRouteBag();
    } // close constructor

    public Road getArtery () {
        return road;
    }
    public Road getCrossRoad () {
        return crossRoad;
    }
    public Direction getDirection() {
        return direction;
    }
    public BusRouteBag getBuses () { return buses; }

    public void setArtery (Road road) {
        this.road = road;
    }
    public void setCrossRoad (Road crossRoad) {
        this.crossRoad = crossRoad;
    }
    public void setDirection (Direction direction) {
        this.direction = direction;
    }

    public void setBuses (BusRouteBag buses) {
        this.buses = buses;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.crossRoad, this.road, this.direction);
    } // close hashCode

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof OldestStation) {
            OldestStation station = (OldestStation) object;

            if (this.getId() == station.getId() && this.getName().equalsIgnoreCase(station.getName())) {
                if (this.crossRoad == station.getCrossRoad() && this.road == station.getArtery() ) {
                    if (this.direction == station.getDirection()) {
                        isEqual = true;
                    }
                }
            }
        }
        return isEqual;
    } // close equals

    @Override
    public String toString () {
        String string = super.toString()
                + " " + this.direction.print()
                + " [Location: " + this.road.print()
                + " & " + this.crossRoad.print()
                + "]"
                + " (Buses:" + printBusRoutes()
                + ")";
        return string;
    } // close toString

    public String printBusRoutes () {
        String string = "";
        for (Iterator<TransitRoute> iterator = this.buses.iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            string += transitRoute.print(); //transitRoute.getName() + " " + transitRoute.getCategory().print() + " ";
        }
        string = string.trim();
        return string;
    } // close printRoads

    @Override
    public int compareTo (OldestStation station) {
        return this.getId() - station.getId();
    }
} // end class Station

 */