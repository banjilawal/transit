package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.enums.TransitRouteCategory;
import com.lawal.transit.middleware.singletons.Stations;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class TransitRoute extends NamedEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalTime startTime;
    private LocalTime endTime;
    private int interArrivalTime;
    private ArrayList<String> stationNames;

    private ArrayList<String> roadNames;
    public static int MINIMUM_INTERARRIVAL_TIME = 15;
    public static int MAXIMUM_INTERARRIVAL_TIME = 30;
    public static LocalTime DEFAULT_START_TIME = LocalTime.of(6,0);
    public static LocalTime DEFAULT_END_TIME = LocalTime.of(2,30);
    private TransitRouteCategory routeCategory;

    public TransitRoute (int id, String name, LocalTime startTime, LocalTime endTime, int interArrivalTime, TransitRouteCategory routeCategory) {
        super(id, name);
        this.startTime = startTime;
        this.endTime = endTime;
        this.interArrivalTime = interArrivalTime;
        this.stationNames = new ArrayList<>();
        this.roadNames = new ArrayList();
        this.routeCategory = routeCategory;
    } // close constructor

    public LocalTime getStartTime () {
        return startTime;
    }

    public LocalTime getEndTime () {
        return endTime;
    }

    public int getInterArrivalTime () {
        return interArrivalTime;
    }
    public TransitRouteCategory getRouteCategory () {
        return routeCategory;
    }

    public ArrayList<String> getStationNames () { return stationNames; }

    public ArrayList<String> getRoadNames () { return roadNames; }

    public void setInterArrivalTime (int interArrivalTime) {
        this.interArrivalTime = interArrivalTime;
    }

    public void setStationNames (ArrayList<String> stationNames) {
        this.stationNames = stationNames;
    }

    public Iterator<String> iterator () {
        return stationNames.iterator();
    }

    public void setRouteCategory (TransitRouteCategory routeCategory) {
        this.routeCategory = routeCategory;
    }

    public void addRoadName (String roadName) {
        if (!roadNames.contains(roadName)) {
           roadNames.add(roadNames.size(), roadName);
        }
    } // close addStop

    public void addRoadNames (ArrayList<String> roadNames) {
        for (String name : roadNames) {
            addRoadName(name);
        }
    } // close addStops

    public boolean addStop (Station station) {
        String stationName = station.getName();
        if (Stations.INSTANCE.search(stationName) == null) {
            boolean outcome = Stations.INSTANCE.add(station);
        }
        return stationNames.add(stationName);
    } // close addStop

    public void addStops (ArrayList<Station> stations) {
        for (Station station : stations) {
            boolean outcome = addStop(station);
        }
    } // close addStops

    public boolean removeStop (Station station) {
        return Stations.INSTANCE.remove(station);
    } // close

    public void setStartTime (LocalTime startTime) {
        this.startTime = startTime;
    } //close setStartTime

    public void setEndTime (LocalTime endTime) {
        this.endTime = endTime;
    } //close setEndTime

    @Override
    public boolean equals(Object object) {
        if (object instanceof TransitRoute) {
            TransitRoute transitRoute = (TransitRoute) object;
            if (super.equals(transitRoute)) {
                if (interArrivalTime == transitRoute.interArrivalTime && sameStartEnd(transitRoute)) {
                    if (routeCategory.compareTo(transitRoute.getRouteCategory()) == 0) {
                        return true;
                    }
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
        for (String roadName : roadNames) {
            string += roadName + " ";
        }
        return (string.trim() + "]");
    } // close printRoads

    public String printStops () {
        String string = "[Stops:";
        for (String name : stationNames) {
            string += name + " ";
        }
        string = string.trim() + "]";
        return string;
//        for (Iterator<NamedEntity> iterator = stationIds.iterator(); iterator().hasNext();) {
//            Station station = (Station) iterator.next();
//            string += station.getName() + " ";
//        }
//        string = string.trim() + "]";
//        return string;
    } // close printStops

    private String preamble () {
      String string = super.toString() + " startTime:" + startTime + " endTime:"
              + endTime + " interArrivalTime:" + interArrivalTime + routeCategory.print();
      return string;
    } // close preamble

    private boolean sameStartEnd (TransitRoute transitRoute) {
        int startTimeDifference = startTime.compareTo(transitRoute.getStartTime());
        int endTimeDifference = endTime.compareTo(transitRoute.getEndTime());
        return (startTimeDifference == 0 && endTimeDifference == 0);
    } // close sameStartEnd
} // end class TransitRoute