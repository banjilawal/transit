package com.lawal.transitcraft.report;

import com.lawal.transitcraft.infrastructure.bus.BusRoute;
import com.lawal.transitcraft.infrastructure.bus.Departure;
import com.lawal.transitcraft.infrastructure.station.Station;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class StationReport implements Report {

    private Station station;

    public String getReport() {
        return getHeader()
            + "\n" + incomingNeighborListing()
            + "\n" + outgoingNeighborListing()
            + "\n" + getBusRouteNames()
            + "\n" + getDepartureListing();
    }

    private String getHeader() {
        return "----------------------------- Station -----------------------------\n"
            + "station_id:" + station.getId()
            + " station_name:" + station.getName()
            + " location:" + station.getLocationName()
            + "\n-------------------------------------------------------------------";
    }

    private String getFooter() {
        return "\n-------------------------------------------";
    }

    private String incomingNeighborListing(){
        return "Incoming Neighbors:" + getNeighborListing(station.getIncomingNeighbors());
    }

    private String outgoingNeighborListing(){
        return "Outgoing Neighbors:" + getNeighborListing(station.getOutgoingNeighbors());
    }

    private String getNeighborListing(Set<Station> neighbors) {
        StringBuilder stringBuilder = new StringBuilder();
        if (neighbors.isEmpty()) return "none";

        int counter = 1;
        for (Station neighbor : neighbors) {
            stringBuilder
                .append(counter)
                .append(":")
                .append(station.getName())
                .append(" ").append(station.getRoadName())
                .append("\n");
            counter++;
        }
        return stringBuilder.toString();
    }

    public String getBusRouteNames() {
        StringBuilder stringBuilder = new StringBuilder("Bus Route Names:");
        Set<BusRoute> busRoutes = station.getBusRoutes();

        if (busRoutes.isEmpty())  return stringBuilder.append("No buses at this stations").toString();
        for (BusRoute busRoute : busRoutes) {
            stringBuilder.append(busRoute.getName()).append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    public String getDepartureListing() {
        StringBuilder stringBuilder = new StringBuilder().append("departures:");
        if (station.getBusRoutes().isEmpty()) return stringBuilder.append("No buses at this stations").toString();

        int counter = 1;
        for (Departure departure : station.getDepartures()) {
            stringBuilder.append("\n").append(counter)
                .append(" time:").append(departure.getDepartureTime().toString())
                .append(" route:").append(departure.getBusRoute().getName());
            counter++;
        }
        return stringBuilder.toString();
    }
}