package com.lawal.transit.route.model;

import com.lawal.transit.station.model.Station;
import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transit_stops")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TransitStop  {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    LocalTime departureTime;

    @ManyToOne
    @JoinColumn(name = "transit_route_id", nullable = false)
    private TransitRoute route;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    public TransitStop(Long id, LocalTime departureTime, TransitRoute route, Station station) {
        this.id = id;
        this.departureTime = departureTime;

        this.route = route;
        this.route.addStop(this);

        this.station = station;
        this.station.addDeparture(this);
    }

    public void setRoute(TransitRoute route) {
        if (this.route != null && this.route.equals(route)) return;
        if (this.route != null) this.route.removeStop(this);

        this.route = route;
        if (this.route != null) route.addStop(this);
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
            + "[route:" + route.getName()
            + " station:" + station.getName()
            + " departure:" + departureTime
            + " stopId:" + id + "]";
    }
}