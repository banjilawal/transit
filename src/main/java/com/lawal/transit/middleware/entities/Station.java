package com.lawal.transit.middleware.entities;

/*
public class Station extends Location {
    private final ArrayList<Integer> busRouteNumbers;

    public Station (int id, String name, int blockId, Road blockRoad, Direction orientation) {
        super(id, name, blockId, blockRoad, orientation);
        this.busRouteNumbers = new ArrayList<Integer>();
    }
} // end class Location
/*
import com.lawal.transit.middleware.abstracts.*;
import com.lawal.transit.middleware.singletons.RegularBusRoutes;

import java.util.ArrayList;
import java.util.Iterator;

public class Station extends NamedEntity {
    private static final long serialVersionUID = 1L;

    private ArrayList<Integer> busNumbers;
    private Block block;

    public Station (int id, String name, Block block) {
        super(id, name);
        this.block = block;
        this.busNumbers = new ArrayList<Integer>();
    } // close constructor

    public Block getBlock () {
        return block;
    } // close getBlock

    public Iterator iterator () {
        return busNumbers.iterator();
    } // close iterator

    public void setBlock (Block block) {
        this.block = block;
    }

    /*
    public boolean addBusRoute (TransitRoute busRoute) {
        int busId = busRoute.getId();
        if (!busNumbers.contains(busId)) {
            try {
                if (!busNumbers.add(busId)) {
                    String errorMessage = generateErrorMessage("addBusRoute", "", 34, StationException.PREFIX);
                    throw new StationException(errorMessage);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return true;
    } // close addBusRoute

    public void addBusRoutes (ArrayList<TransitRoute> busRoutes) {
        int busNumber = Integer.MAX_VALUE;
        for (TransitRoute busRoute : busRoutes) {
            busNumber = busRoute.getId();
            if (!busNumbers.contains(busNumber)) {
               try {
                   busNumbers.add(busNumber);
               } catch (Exception e) {
                   System.err.println(e.getMessage() + " invoker addBusRoutes line 53");
               }
            }
        }
    } // close addBusRoutes


    public boolean addBusRoute (TransitRoute transitRoute) {
        int busId = transitRoute.getId();
        if (busNumbers.contains(busId)) {
            return false;
        }
        return busNumbers.add(busId);
    } // close addBusRou

    public void addBusRoutes (ArrayList<TransitRoute> transitRoutes) {
        int busNumber = Integer.MAX_VALUE;
        for (TransitRoute transitRoute : transitRoutes) {
            busNumber = transitRoute.getId();

            if (!busNumbers.contains(busNumber)) {
                busNumbers.add(busNumber);
            }
        }
    } // close addBusRoutes

    public boolean removeBusRoute (TransitRoute transitRoute) {
        if (!this.busNumbers.contains(transitRoute.getId())) {
            return true;
        }
        return this.busNumbers.remove(Integer.valueOf(transitRoute.getId()));
    } // close addBusRoute

    public void removeBusRoutes (ArrayList<TransitRoute> transitRoutes) {
        int busNumber = Integer.MAX_VALUE;
        for (TransitRoute transitRoute : transitRoutes) {
            busNumber = transitRoute.getId();
            if (!busNumbers.contains(busNumber)) {
                busNumbers.add(busNumber);
            }
        }
    } // close removeBusRoutes


    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof  Station) {
            Station station = (Station) object;
            if (super.equals(station) && block.equals(station.getBlock())) {
                isEqual = true;
            }
        }
        return isEqual;
    } // close equals

    @Override
    public String toString () {
        String string = super.toString()
                + " block:" + block.toString()
                + " [Buses:" + printBusRoutes() + "]";
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
                string += transitRoute.toString() + " ";
            }
        }
        string = string.trim();
        return string;
    } // close printBusRoutes

    public String printIntersection () {
        String string = "";
        if (block instanceof NorthSouthBlock) {
            NorthSouthBlock northSouthBlock = (NorthSouthBlock) block;
            string += northSouthBlock.getAvenue().toString()
                    + " " + northSouthBlock.getStartStreet().toString();
        } else {
            EastWestBlock eastWestBlock = (EastWestBlock) block;
            string += eastWestBlock.getStreet().toString()
                    + " " + eastWestBlock.getStartAvenue().toString();
        }
        return string;
    } // close printIntersection

} // end class Station

 */