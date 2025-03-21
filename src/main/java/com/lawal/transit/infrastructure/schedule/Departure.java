package com.lawal.transit.infrastructure.schedule;

import com.lawal.transit.infrastructure.station.Station;
import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "departures")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Departure {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    LocalTime departureTime;

    @ManyToOne
    @JoinColumn(name = "transit_route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    public Departure (Long id, LocalTime departureTime, Route route, Station station) {
        this.id = id;
        this.departureTime = departureTime;

        this.route = route;
        if (this.route != null && !this.route.getDepartures().contains(this)) {
            this.route.addDeparture(this);
        }

        this.station = station;
        if (this.station != null && !this.station.getDepartures().contains(this)) {
            this.station.addDeparture(this);
        }
    }

    public void setRoute(Route route) {
        if (this.route != null && this.route.equals(route)) return;
        if (this.route != null) this.route.removeDeparture(this);

        this.route = route;
        if (this.route != null) route.addDeparture(this);
    }

    public void setStation(Station station) {

        if (this.station != null && this.station.equals(station)) return;
        if (this.station != null) this.station.removeDeparture(this);

        this.station = station;
        if (this.station != null) station.addDeparture(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
            + "[id:" + id
            + " route:" + route.getName()
            + " station:" + station.getName() + "_" + station.getBlock().getCurb().getOrientation().abbreviation()
            + " time:" + departureTime
            + " stopId:" + id + "]";
    }
}