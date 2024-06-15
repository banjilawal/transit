package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.Orientation;
import com.lawal.transit.core.global.*;

import java.time.LocalTime;
import java.util.*;

public abstract class BusRoute extends NamedEntity {
    private Orientation outboundOrientation;
    private int interArrivalTime;
    private HashMap<LocalTime, OldAbstractStation> schedule;
    public BusRoute (int id, String name, Orientation outboundOrientation, int interArrivalTime) {
        super(id, name);
        this.outboundOrientation = outboundOrientation;
        this.interArrivalTime = interArrivalTime;
        schedule = new HashMap<>();
    }

    public Orientation getOutboundDirection() {
        return outboundOrientation;
    }

    public Orientation getInboundDirection () {
        return outboundOrientation.oppositeDirection();
    }

    public void setOutboundDirection(Orientation outboundOrientation) {
        this.outboundOrientation = outboundOrientation;
    }

    public int getInterArrivalTime () {
        return interArrivalTime;
    }


    public HashMap<LocalTime, OldAbstractStation> getSchedule () {
        return schedule;
    }


    public void setInterArrivalTime (int interArrivalTime) {
        this.interArrivalTime = interArrivalTime;
    }

    public void setSchedule (ArrayList<OldAbstractStation> oldAbstractStations) {
        int count = 0;
        int index = 0;
        Collections.sort(oldAbstractStations, new StationComparator());
//        for (OldAbstractStation station : oldAbstractStations) {
//            System.out.println("adding " + station.getName() + " to " + getName() + "'s schedule");
//        }
        LocalTime departureTime = Constant.TRANSIT_START_TIME;
        LocalTime closingTime = Constant.TRANSIT_END_TIME.plusMinutes(1);
//        System.out.println("depart:" + departureTime.toString() + " close:" + closingTime.toString() + " index:" + index);
//        System.out.println(departureTime.isBefore(closingTime));
        while (!departureTime.isBefore(closingTime)){
//            System.out.println("depart:" + departureTime.toString() + " close:" + closingTime.toString() + " index:" + index);
            index = count % oldAbstractStations.size();
            this.schedule.put(departureTime, oldAbstractStations.get(index));
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


    private class StationComparator implements Comparator<OldAbstractStation> {
        @Override
        public int compare(OldAbstractStation a, OldAbstractStation b) {
            return a.getId() - b.getId();
        }
    }
} // end class
