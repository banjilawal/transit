package com.lawal.transit.infrastructure.catalog;

import com.lawal.transit.infrastructure.bus.BusRoute;
import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.station.Station;
import com.lawal.transit.report.BusRouteReport;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public enum BusRouteCatalog {
    INSTANCE;

    private final Set<BusRoute> catalog;

    BusRouteCatalog () {
        catalog = new HashSet<>();
    }

    public Set<BusRoute> getCatalog() { return Set.copyOf(catalog); }

    public int size() { return catalog.size(); }

    public void addRoute (BusRoute busRoute) {
        if (busRoute == null) return;
        catalog.add(busRoute);
    }

    public BusRoute findById(Long id) {
        if (id == null) return null;

        for (BusRoute busRoute : catalog) {
            if (busRoute.getId().equals(id)) return busRoute;
        }
        return null;
    }

    public BusRoute findByName(String name) {
        if (name == null) return null;

        for (BusRoute busRoute : catalog) {
            if (busRoute.getName().equalsIgnoreCase(name)) return busRoute;
        }
        return null;
    }

    public Set<BusRoute> filterByRoad(Road road){
        Set<BusRoute> matches = new HashSet<>();
        if (road == null) return matches;

        for (BusRoute busRoute : catalog) {
            if (busRoute.getRoads().contains(road)) matches.add(busRoute);
        }
        return matches;
    }

    public Set<BusRoute> filterByStation(Station station) {
        Set<BusRoute> matches = new HashSet<>();
        if (station == null) return matches;

        for (BusRoute busRoute : catalog) {
            if (busRoute.getStations().contains(station)) matches.add(busRoute);
        }
        return matches;
    }

    public Set<BusRoute> getGhostBusRoutes () {
        Set<BusRoute> ghosts = new HashSet<>();
        for (BusRoute busRoute : catalog) {
            if (busRoute.isGhostBusRoute()) ghosts.add(busRoute);
        }
        return ghosts;
    }

    public Set<BusRoute> getActiveBusRoutes () {
        Set<BusRoute> matches = new HashSet<>();
        for (BusRoute busRoute : catalog) {
            if (!busRoute.isGhostBusRoute()) matches.add(busRoute);
        }
        return matches;
    }

    public String ghostBusRoutesReport (){
        StringBuilder report = new StringBuilder()
            .append("----------------- GHOST BUS ROUTES REPORT ----------------\n");
//            .append("------------------------------------------------------\n");

        Set<BusRoute> ghosts = getGhostBusRoutes();
        if (ghosts.isEmpty()) return report.append("No ghost bus routes").toString();

//        report.append("------------------------------------------------------\n");
        for (BusRoute busRoute : ghosts) {
            report.append("\n").append(new BusRouteReport(busRoute).getReport());
        }
        report.append("\n\t\t\t\t").append("total ghost stations:").append(ghosts.size());
        report.append("\n------------------------------------------------------");
        return report.toString();
    }

    public String activeBusRoutesReport (){
        StringBuilder report = new StringBuilder();
        for (BusRoute busRoute : getActiveBusRoutes()) {
            report.append("\n").append(new BusRouteReport(busRoute).getReport());
        }
        return report.toString();
    }

    public String getSummary(){
        StringBuilder summary = new StringBuilder("---------------------- Bus Routes Summary ----------------------\n");
        int counter = 0;

        for (BusRoute busRoute : catalog) {
            summary.append(counter + 1).append(" NAME:").append(busRoute.getName())
                .append(" INTERVAL:").append(busRoute.getInterval()).append(" minutes")
                .append(" TOTAL_STATIONS:").append(busRoute.getStations().size())
                .append(" ROADS:").append(busRoute.getRoadInfo())
                .append("\n");
            counter++;
        }
        return summary.toString();
    }
}