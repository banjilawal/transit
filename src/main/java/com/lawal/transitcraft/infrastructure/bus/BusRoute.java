package com.lawal.transitcraft.infrastructure.bus;

import com.lawal.transitcraft.infrastructure.road.Road;
import com.lawal.transitcraft.infrastructure.bus.exception.NullDepartureException;
import com.lawal.transitcraft.infrastructure.station.Station;
import com.lawal.transitcraft.infrastructure.station.exception.StationNameNullException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transit_routes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BusRoute {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = StationNameNullException.MESSAGE)
    String name;

    @Column(nullable = false)
    private LocalTime openingTime;

    @Column(nullable = false)
    private LocalTime closingTime;

    @Column(nullable = false)
    Integer interval;

    @OneToMany(mappedBy = "transit_route", cascade = CascadeType.ALL)
    private List<Departure> departures = new ArrayList<>();

    public BusRoute (Long id, String name, LocalTime openingTime, LocalTime closingTime, Integer interval) {
        this.id = id;
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.interval = interval;

        this.departures = new ArrayList<>();
    }

    public void setDepartures (List<Departure> departures) {
        if (departures == null) throw new IllegalArgumentException("Cannot set null stops");
        if (this.departures == null) this.departures = new ArrayList<>();
        this.departures.clear();

        for (Departure stop : departures) { addDeparture(stop); }
    }

    public void addDeparture(Departure departure) {
        if (departure == null) throw new NullDepartureException(NullDepartureException.MESSAGE);
        if (departures == null) departures = new ArrayList<>();

        if (departures.contains(departure)) {
            System.out.println("BusRoute.addDeparture(): " + departure + " is already in the list");
            return;
        }

        departures.add(departure);
        if (!departure.getBusRoute().equals(this)) { departure.setBusRoute(this); }
    }

    public void removeDeparture(Departure departure) {
        if (departure == null) throw new NullDepartureException(NullDepartureException.MESSAGE);
        if (departures == null) {
            departures = new ArrayList<>();
            return;
        }
        if (departures.isEmpty()) return;

        if (departures.contains(departure)) {
            departures.remove(departure);
            if (departure.getBusRoute() != null && this.equals(departure.getBusRoute())) { departure.setBusRoute(null); }
        }
    }

    public List<Departure> filterByRoad(Road road) {
        List<Departure> matches = new ArrayList<>();

        if (road == null) return matches;
        for (Departure departure : departures) {
            Road departureRoad = departure.getStation().getBlock().getCurb().getRoad();
            if (departureRoad.equals(road)) matches.add(departure);
        }
        return List.copyOf(matches);
    }

    public Departure getFirstDeparture() {
        if (departures == null || departures.isEmpty()) return null;
        return departures.get(0);
    }

    public Departure getLastDeparture() {
        if (departures == null || departures.isEmpty()) return null;
        return departures.get(departures.size() - 1);
    }

    public String getDepartureTimeString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (departures.isEmpty()) return stringBuilder.toString();
        for (Departure departure : departures) {
            stringBuilder.append("\t").append(departure.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public Set<Departure> filterBYStation(Station station) {
        Set<Departure> matches = new HashSet<>();

        if (station == null) return matches;
        for (Departure departure : departures) {
            if (departure.getStation().equals(station)) matches.add(departure);
        }
        return Set.copyOf(matches);
    }

    public Set<Station> getStations() {
        Set<Station> stations = new HashSet<>();

        for (Departure departure : departures) {
            stations.add(departure.getStation());
        }
        return Set.copyOf(stations);
    }

    public Set<Road> getRoads() {
        Set<Road> roads = new HashSet<>();
        for (Departure departure : departures) {
            Road road = departure.getStation().getBlock().getCurb().getRoad();
            roads.add(road);
        }
        return Set.copyOf(roads);
    }

    public boolean isGhostBusRoute() {
        return departures.isEmpty();
    }

    public String getRoadInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Road road : getRoads()) {
            stringBuilder.append(road.getName()).append(", ");
        }
        return stringBuilder.toString().endsWith(", ") ? stringBuilder.substring(0, stringBuilder.length() - 2) : stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
            + "[id:" + id
            + " name:" + name
            + " interArrivalTime:" + interval
            + " totalStops:" + getStations().size()
            + " roads:" + getRoadInfo();
//            +
//            + "\n\tfirst departure:" + getFirstDeparture()
//            + "\n\tlast departure:" + getLastDeparture();
////            + "\nSchedule:\n" + getDepartureTimeString() ;
    }
}