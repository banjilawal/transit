package com.lawal.transitcraft.report;

import com.lawal.transitcraft.common.Direction;
import com.lawal.transitcraft.infrastructure.bus.BusRoute;
import com.lawal.transitcraft.infrastructure.bus.Departure;
import com.lawal.transitcraft.infrastructure.station.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusRouteReport implements Report {

    private BusRoute busRoute;

    public String getReport() {
        if (busRoute == null) return "";
        return getHeader() + "\n" + getSchedule();
    }

    private String getHeader() {
        return "----------------------------- BusRoute -----------------------------\n"
            + "route id:" + busRoute.getId()
            + " route name:" + busRoute.getName()
            + "\nstarting time:" + busRoute.getOpeningTime()
            + " closing time:" + busRoute.getClosingTime()
            + " interarrival time:" + busRoute.getInterval() + " minutes"
            + "\nroads:" + busRoute.getRoadInfo()
            + "\n--------------------------------------------------------------------";
    }

    private String getFooter() {
        return "\n-------------------------------------------\n";
    }



//    public static Set<Station> getStations(BusRoute busRoute) {
//        Set<Station> stations = new HashSet<>();
//        if (busRoute == null) return stations;
//
//        for (Departure departure : busRoute.getDepartures()) {
//            Station station = departure.getStation();
//            if (station != null) stations.add(station);
//        }
//        return stations;
//    }

    private String getSchedule() {
        StringBuilder stringBuilder = new StringBuilder("Schedule").append("\n");
        if (busRoute == null) return stringBuilder.append("Empty Schedule").toString();

        int counter = 0;
        for (Departure departure : busRoute.getDepartures()) {
            Station station = departure.getStation();
            Direction stationOrientation = station.getBlock().getCurb().getOrientation();
            String stationInfo = "Station:" + station.getName() + " " + station.getLocationName();
//                + " " + station.getBlock().getCurb().getRoad().getName() + " " + stationOrientation.print();
            stringBuilder.append(counter).append(" ")
                .append(departure.getDepartureTime())
                .append(" ")
                .append(stationInfo)
                .append("\n");
            counter++;
        }
        return stringBuilder.toString();
    }
}