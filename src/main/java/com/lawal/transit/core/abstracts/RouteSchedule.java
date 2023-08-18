package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.singletons.Stations;

import java.time.LocalTime;
import java.util.HashMap;

public abstract class RouteSchedule extends NamedEntity {

    private HashMap<LocalTime, String> schedule;

    public RouteSchedule(int id, TransitRoute transitRoute) {
        super(id, transitRoute.getName());
        this.schedule = new HashMap<LocalTime, String>();
    }

    public abstract TransitRoute getRoute ();

    public HashMap<LocalTime, String> getMap() { return schedule; }

    public String getStationName (LocalTime departureTime) { return schedule.get(departureTime); }

    public Station getStation (LocalTime departureTime) { return getStation(getStationName(departureTime)); }

    public Station getStation (String stationName) {
        return Stations.INSTANCE.getBag().search(stationName);
    }

    public void addStation(Station station, LocalTime departure) {
        schedule.put(departure, station.getName());
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof  RouteSchedule routeSchedule) {
            return super.equals(routeSchedule);
        }
        return false;
    }

    public boolean sameSchedules (RouteSchedule target) {
        if (schedule.size() != target.getMap().size()) return false;
        HashMap<LocalTime, String> otherSchedule = target.getMap();
//
//        schedule.forEach((key, value) -> {
//            key.equals(otherSchedule.)
//            if (!value.equalsIgnoreCase(otherSchedule.getMap().get(key))) {
//                return false;
//            }
//        });

        return false;
    }

    @Override
    public String toString () {
        return super.toString() + "\n" + printSchedule();
    }

    public String printSchedule () {
        StringBuilder builder = new StringBuilder("[");
        schedule.forEach(((departureTime, stationName) -> builder.append(departureTime.toString()).append(" ").append(stationName).append("\n")));
//        builder.deleteCharAt(builder.length() - 1);
        return builder.deleteCharAt(builder.length() - 1).toString();
    } //

} // end class RegularSchedule
