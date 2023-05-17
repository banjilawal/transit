package com.lawal.transit.middleware.entities;
    /*
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.abstracts.Location;
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.singletons.RegularBusRoutes;

import java.util.ArrayList;
import java.util.Objects;

public class OlderStation extends Location {

    private static final long serialVersionUID = 1L;
    private Road crossRoad;
    private Road road;
    private Direction orientation;
    private ArrayList<Integer> busNumbers;

    public OlderStation (int id, String name, Direction orientation, Road road, Road crossRoad) {
        super(id, name, orientation, road);
        this.crossRoad = crossRoad;

        this.busNumbers = new ArrayList<Integer>();
    } // close constructor


    public Road getCrossRoad () {
        return crossRoad;
    }

    public boolean addBusRoute (TransitRoute transitRoute) {
        if (this.busNumbers.contains(transitRoute.getId())) {
            return false;
        }
        return this.busNumbers.add(transitRoute.getId());
    } // close addBusRoute

    public boolean removeBusRoute (TransitRoute transitRoute) {
        if (!this.busNumbers.contains(transitRoute.getId())) {
            return true;
        }
        return this.busNumbers.remove(Integer.valueOf(transitRoute.getId()));
    } // close addBusRoute

    public void setCrossRoad (Road crossRoad) {
        this.crossRoad = crossRoad;
    }

    public TransitRoute search (int busRouteId) {
        for (Integer id : busNumbers) {
            if (id.equals(busRouteId))
                return (RegularBusRoutes.getInstance().search(id));
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.crossRoad);
    } // close hashCode

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof OlderStation) {
            OlderStation station = (OlderStation) object;

            if (super.equals(station)) {
                if (this.crossRoad.equals(station.getCrossRoad())) {
                    isEqual = true;
                }
            }
        }
        return isEqual;
    } // close equals

    @Override
    public String toString () {
        String string = super.toString()
                + " & " + this.crossRoad.print()
                + "]"
                + " (Buses:" + printBusRoutes()
                + ")";
        return string;
    } // close toString

    public String printBusRoutes () {
        String string = "";
        for (Integer busNumber : busNumbers) {
            TransitRoute transitRoute = RegularBusRoutes.getInstance().search(busNumber);
            if (transitRoute == null) {
                string += "\n" + busNumber.toString() + " mismatch";
            }
            else {
                string += transitRoute.print();
            }
        }
        string = string.trim();
        return string;
    } // close printRoads
} // end class Station

     */