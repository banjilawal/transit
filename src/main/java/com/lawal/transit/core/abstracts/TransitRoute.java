package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Station;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class TransitRoute extends NamedEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalTime startTime;
    private LocalTime endTime;
    private int interArrivalTime;
    private ArrayList<Station> stations;

    private ArrayList<Road> roads;
    public static int MINIMUM_INTERARRIVAL_TIME = 15;
    public static int MAXIMUM_INTERARRIVAL_TIME = 30;
    public static LocalTime DEFAULT_START_TIME = LocalTime.of(6,0);
    public static LocalTime DEFAULT_END_TIME = LocalTime.of(2,30);
//    private TransitRouteCategory routeCategory;

    public TransitRoute (int id, String name, LocalTime startTime, LocalTime endTime, int interArrivalTime) { //}, TransitRouteCategory routeCategory) {
        super(id, name);
        this.startTime = startTime;
        this.endTime = endTime;
        this.interArrivalTime = interArrivalTime;
        this.stations = new ArrayList<Station>();
        this.roads = new ArrayList<Road>();
//        this.routeCategory = routeCategory;
    } // close constructor

//    public TransitRouteCategory getRouteCategory () {
//        return routeCategory;
//    }

    public LocalTime getStartTime () {
        return startTime;
    }

    public void setStartTime (LocalTime startTime) {
        this.startTime = startTime;
    } //close setStartTime

    public LocalTime getEndTime () {
        return endTime;
    }

    public void setEndTime (LocalTime endTime) {
        this.endTime = endTime;
    } //close setEndTime

    public int getInterArrivalTime () {
        return interArrivalTime;
    }

    public Iterator<Station> getStations () { return stations.iterator(); }

    public void setInterArrivalTime (int interArrivalTime) {
        this.interArrivalTime = interArrivalTime;
    }

    public void setStations (ArrayList<Station> stations) {
        for (Station station : stations) {
            addStation(station);
        }
    } // close addStations

    public void addStation (Station station) {
        String stationName = station.getName();
        if (!stations.contains(station)) {
            stations.add(stations.size(), station);
        }
    } // close addStation

    public void removeStations (ArrayList<Station> stations) {
        for (Station station : stations) {
            removeStation(station);
        }
    } // close removeStations

    public void removeStation (Station station) {
        int index = stations.indexOf(station);
        if (index > -1) {
            stations.remove(index);
        }
    } // close removeStation

    public Iterator<Road> getRoads () { return roads.iterator(); }

    public void addRoads (ArrayList<Road> roads) {
        for (Road road : roads) {
            addRoad(road);
        }
    } // close addRoads

    public void addRoad (Road road) {
        if (!roads.contains(road)) {
            roads.add(roads.size(), road);
        }
    } // close addRoad

    public void removeRoads (ArrayList<Road> roads) {
        for (Road road : roads) {
            removeRoad(road);
        }
    } // close removeRoads

    public void removeRoad (Road road) {
        int index = roads.indexOf(road);
        if (index > -1) {
            roads.remove(index);
        }
    } // close removeRoad

//    public void setRouteCategory (TransitRouteCategory routeCategory) {
//        this.routeCategory = routeCategory;
//    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof TransitRoute) {
            TransitRoute transitRoute = (TransitRoute) object;
            if (super.equals(transitRoute)) {
                if (interArrivalTime == transitRoute.interArrivalTime && sameStartEnd(transitRoute)) {
                    return true;
//                    if (routeCategory.compareTo(transitRoute.getRouteCategory()) == 0) {
//                        return true;
//                    }
                }
            }
        }
        return false;
    } // close equals

    @Override
    public String toString () {
        return  preamble() + "\n" + printRoads() + "\n" + printStops();
    }

    public String fullString () {
        return toString();
//        String string =  preamble();
//
//        for (Iterator<NamedEntity> iterator = stationIds.iterator(); iterator().hasNext();) {
//            Station station = (Station) iterator.next();
//            string += "\n" + station.getName()
//                    + " " + station.getBlockRoad().getName()
//                    + " " + station.getBlockRoad().getRoadCategory().abbreviation()
//                    + " " + station.getBlockSide().abbreviation();
//        }
//        return string;
    } // close fullString

    public String printRoads () {
        String string = "[Roads:";
        for (Road road : roads) {
            string += road.getName() + " ";
        }
        return (string.trim() + "]");
    } // close printRoads

    public String printStops () {
        String string = "[Stops:";
        for (Station station : stations) {
            string += station.getName() + " ";
        }
        string = string.trim() + "]";
        return string;
    } // close printStops

    private String preamble () {
      String string = super.toString() + " startTime:" + startTime + " endTime:"
              + endTime + " interArrivalTime:" + interArrivalTime; // + routeCategory.print();
      return string;
    } // close preamble

    private boolean sameStartEnd (TransitRoute transitRoute) {
        int startTimeDifference = startTime.compareTo(transitRoute.getStartTime());
        int endTimeDifference = endTime.compareTo(transitRoute.getEndTime());
        return (startTimeDifference == 0 && endTimeDifference == 0);
    } // close sameStartEnd
} // end class TransitRoute