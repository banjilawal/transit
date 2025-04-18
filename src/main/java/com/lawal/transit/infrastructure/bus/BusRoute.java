package com.lawal.transit.infrastructure.bus;

import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.bus.exception.NullDepartureException;
import com.lawal.transit.infrastructure.station.exception.StationNameNullException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    Integer interArrivalTime;

    @OneToMany(mappedBy = "transit_route", cascade = CascadeType.ALL)
    private List<Departure> departures = new ArrayList<>();

    public BusRoute (Long id, String name, LocalTime openingTime, LocalTime closingTime, Integer interArrivalTime) {
        this.id = id;
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.interArrivalTime = interArrivalTime;

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

    @Override
    public String toString() {
        return getClass().getSimpleName()
            + "[id:" + id
            + " name:" + name
            + " interArrivalTime:" + interArrivalTime
            + " totalStops:" + departures.size() + "]"
            + "\n\tfirst departure:" + getFirstDeparture()
            + "\n\tlast departure:" + getLastDeparture();
//            + "\nSchedule:\n" + getDepartureTimeString() ;
    }
}