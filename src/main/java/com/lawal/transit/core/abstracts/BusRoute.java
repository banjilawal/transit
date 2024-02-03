package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.enums.Direction;
import com.lawal.transit.core.global.*;

import java.time.LocalTime;
import java.util.*;

public abstract class BusRoute extends NamedEntity {
    private Direction outboundDirection;
    private int interArrivalTime;
    private HashMap<LocalTime, Station> schedule;
    public BusRoute (int id, String name, Direction outboundDirection, int interArrivalTime) {
        super(id, name);
        this.outboundDirection = outboundDirection;
        this.interArrivalTime = interArrivalTime;
        schedule = new HashMap<>();
    }

    public Direction getOutboundDirection() {
        return outboundDirection;
    }

    public Direction getInboundDirection () {
        return outboundDirection.oppositeDirection();
    }

    public void setOutboundDirection(Direction outboundDirection) {
        this.outboundDirection = outboundDirection;
    }

    public int getInterArrivalTime () {
        return interArrivalTime;
    }


    public HashMap<LocalTime, Station> getSchedule () {
        return schedule;
    }


    public void setInterArrivalTime (int interArrivalTime) {
        this.interArrivalTime = interArrivalTime;
    }

    public void setSchedule (ArrayList<Station> stations) {
        int count = 0;
        int index = 0;
        Collections.sort(stations, new StationComparator());
//        for (Station station : stations) {
//            System.out.println("adding " + station.getName() + " to " + getName() + "'s schedule");
//        }
        LocalTime departureTime = Constant.TRANSIT_START_TIME;
        LocalTime closingTime = Constant.TRANSIT_END_TIME.plusMinutes(1);
//        System.out.println("depart:" + departureTime.toString() + " close:" + closingTime.toString() + " index:" + index);
//        System.out.println(departureTime.isBefore(closingTime));
        while (!departureTime.isBefore(closingTime)){
//            System.out.println("depart:" + departureTime.toString() + " close:" + closingTime.toString() + " index:" + index);
            index = count % stations.size();
            this.schedule.put(departureTime, stations.get(index));
            departureTime = departureTime.plusMinutes(interArrivalTime);
            count++;
        }
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof BusRoute busRoute)
            return super.equals(busRoute) && interArrivalTime == busRoute.getInterArrivalTime();
        return false;
    }

    public String printSchedule () {
        StringBuilder builder = new StringBuilder("[");
        schedule.forEach(((departureTime, station) ->
            builder.append(departureTime.toString()).append(" ").append(station.getName()).append("\n")));
//        builder.deleteCharAt(builder.length() - 1);
        return builder.deleteCharAt(builder.length() - 1).toString();
    }


    @Override
    public String toString () {
        return super.toString() + " interarrival time:" + interArrivalTime + " total stops:" + schedule.size();
    }


    private class StationComparator implements Comparator<Station> {
        @Override
        public int compare(Station a, Station b) {
            return a.getId() - b.getId();
        }
    }
} // end class
