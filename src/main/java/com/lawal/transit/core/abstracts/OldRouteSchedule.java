package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.singletons.Stations;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

public abstract class OldRouteSchedule extends NamedEntity {

    private class ScheduleItem {
        String stationName;
       LocalTime departure;

        public ScheduleItem(int id, String stationName, LocalTime departure) {
            this.stationName = stationName;
            this.departure = departure;
        } //

        public String getStationName () { return stationName; }

        public LocalTime getDeparture () { return departure; }

        public String getStationName (LocalTime departure) {
            return schedule.get(departure).getStationName();
        }

        public Station getStation (LocalTime departure) { return getStation(getStationName(departure)); }

        public Station getStation (String stationName) {
            return Stations.INSTANCE.getBag().search(stationName);
        }

        public void setStationName (String stationName) { this.stationName = stationName; }

        public void setDeparture(LocalTime departure) { this.departure = departure; }

        @Override
        public boolean equals(Object object) {
            if (object instanceof ScheduleItem item)
                return stationName.equalsIgnoreCase(item.getStationName()) && departure == item.getDeparture();
            return false;
        }

        @Override
        public int hashCode() { return Objects.hash(stationName, departure); }

    } // end private class ScheduleItem

    private HashMap<LocalTime, ScheduleItem> schedule;

    public OldRouteSchedule(int id, TransitRoute transitRoute) {
        super(id, transitRoute.getName());
        this.schedule = new HashMap<LocalTime, ScheduleItem>();
    }

    public abstract TransitRoute getRoute ();

    public void addScheduleItem (Station station, LocalTime departure) {
        schedule.put(departure, new ScheduleItem((schedule.size() + 1), station.getName(), departure));
    }


} // end class RegularSchedule
