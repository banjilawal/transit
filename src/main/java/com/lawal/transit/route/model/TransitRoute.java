package com.lawal.transit.route.model;

import com.lawal.transit.road.model.Road;
import com.lawal.transit.route.model.exception.NullTransitStopException;
import com.lawal.transit.station.model.exception.StationNameNullException;
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
public class TransitRoute {

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

    public TransitRoute(Long id, String name, LocalTime openingTime, LocalTime closingTime, Integer interArrivalTime) {
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
        if (departure == null) throw new NullTransitStopException(NullTransitStopException.MESSAGE);
        if (departures == null) departures = new ArrayList<>();

        if (departures.contains(departure)) {
            System.out.println("TransitRoute.addDeparture(): " + departure + " is already in the list");
            return;
        }

        departures.add(departure);
        if (!departure.getRoute().equals(this)) { departure.setRoute(this); }
    }

    public void removeDeparture(Departure departure) {
        if (departure == null) throw new NullTransitStopException(NullTransitStopException.MESSAGE);
        if (departures == null) {
            departures = new ArrayList<>();
            return;
        }
        if (departures.isEmpty()) return;

        if (departures.contains(departure)) {
            departures.remove(departure);
            if (departure.getRoute() != null && this.equals(departure.getRoute())) { departure.setRoute(null); }
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
            + "\nSchedule:\n" + getDepartureTimeString() ;
    }
}