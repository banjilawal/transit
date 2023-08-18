package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.enums.Direction;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.*;

public abstract class TransitRoute extends NamedEntity implements Serializable {
    private LocalTime startTime;
    private LocalTime endTime;
    private int interArrivalTime;
    private Direction outboundDirection;
    private final ArrayList<Station> stations;



    public TransitRoute (int id, String name, LocalTime startTime, LocalTime endTime, int interArrivalTime, Direction outboundDirection) {
        super(id, name);
        this.startTime = startTime;
        this.endTime = endTime;
        this.interArrivalTime = interArrivalTime;
        this.outboundDirection = outboundDirection;
        this.stations = new ArrayList<Station>();
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

    public Direction getInboundDirection () { return outboundDirection.oppositeDirection(); }

    public Direction getOutboundDirection() { return outboundDirection; }

    public Iterator<Station> getStations () { return stations.iterator(); }

    public ArrayList<Station> getStationList () { return stations; }

    public void setStartTime (LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime (LocalTime endTime) { this.endTime = endTime; }

    public void setInterArrivalTime (int interArrivalTime) {
        this.interArrivalTime = interArrivalTime;
    }

    public void setOutboundDirection(Direction outboundDirection) { this.outboundDirection = outboundDirection; }

    public void addStations (ArrayList<Station> stations) {
        for (Station station : stations) {
            addStation(station);
        }
    } // close addStations

    public void addStation (Station station) {
        if (station != null && !stations.contains(station)) {
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

    @Override
    public boolean equals(Object object) {
        if (object instanceof TransitRoute transitRoute) {
            return super.equals(transitRoute) && (interArrivalTime == transitRoute.interArrivalTime
                && sameStartEnd(transitRoute)) && outboundDirection.equals(transitRoute.getOutboundDirection());
        }
        return false;
    } // close equals

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), startTime, endTime, interArrivalTime, outboundDirection, stations);
    }

    @Override
    public String toString () {
        return  preamble() + " " + printStops();
    }


    public String printStops () {
        StringBuilder string = new StringBuilder("[Stops:");
        for (Station station : stations) {
            string.append(station.getName()).append(station.getOrientation().abbreviation()).append(" ");
        }
        string = new StringBuilder(string.toString().trim() + "]");
        return string.toString();
    } // close printStops

    private String preamble () {
        return super.toString(); // + " startTime:" + startTime + " endTime:" + endTime + " interArrivalTime:" + interArrivalTime;
    } // close preamble

    private boolean sameStartEnd (TransitRoute transitRoute) {
        int startTimeDifference = startTime.compareTo(transitRoute.getStartTime());
        int endTimeDifference = endTime.compareTo(transitRoute.getEndTime());
        return (startTimeDifference == 0 && endTimeDifference == 0);
    } // close sameStartEnd

    public void sortStations () { Collections.sort(stations, new StationComparator()); }
    private class StationComparator implements Comparator<Station> {
        @Override
        public int compare(Station a, Station b) {
            return a.getId() - b.getId();
        }
    } // end class StationComparator
} // end class TransitRoute