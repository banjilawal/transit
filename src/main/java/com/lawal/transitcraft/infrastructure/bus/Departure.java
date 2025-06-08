package com.lawal.transitcraft.infrastructure.bus;

import com.lawal.transitcraft.infrastructure.station.Station;
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
    private BusRoute busRoute;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    public Departure (Long id, LocalTime departureTime, BusRoute busRoute, Station station) {
        this.id = id;
        this.departureTime = departureTime;

        this.busRoute = busRoute;
        if (this.busRoute != null && !this.busRoute.getDepartures().contains(this)) {
            this.busRoute.addDeparture(this);
        }

        this.station = station;
        if (this.station != null && !this.station.getDepartures().contains(this)) {
            this.station.addDeparture(this);
        }
    }

    public void setBusRoute (BusRoute busRoute) {
        if (this.busRoute != null && this.busRoute.equals(busRoute)) return;
        if (this.busRoute != null) this.busRoute.removeDeparture(this);

        this.busRoute = busRoute;
        if (this.busRoute != null) busRoute.addDeparture(this);
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
            + " busRoute:" + busRoute.getName()
            + " station:" + station.getName() + "_" + station.getBlock().getCurb().getOrientation().abbreviation()
            + " time:" + departureTime
            + " stopId:" + id + "]";
    }
}