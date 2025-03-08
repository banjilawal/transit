package com.lawal.transit.route.model;

import com.lawal.transit.block.model.exception.NullBlockException;
import com.lawal.transit.route.model.exception.NullTransitStopException;
import com.lawal.transit.station.model.exception.StationNameNullException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false)
    Integer interArrivalTime;

    @Column(nullable = false, unique = true)
    @NotBlank(message = StationNameNullException.MESSAGE)
    String name;

    @OneToMany(mappedBy = "transit_route", cascade = CascadeType.ALL)
    private List<TransitStop> stops = new ArrayList<>();

    public TransitRoute(Long id, String name, Integer interArrivalTime) {
        this.id = id;
        this.name = name;
        this.interArrivalTime = interArrivalTime;

        this.stops = new ArrayList<>();
    }

    public void setStops(List<TransitStop> stops) {
        if (stops == null) throw new IllegalArgumentException("Cannot set null stops");
        if (this.stops == null) this.stops = new ArrayList<>();
        this.stops.clear();

        for (TransitStop stop : stops) { addStop(stop); }
    }

    public void addStop(TransitStop stop) {
        if (stop == null) throw new NullTransitStopException(NullTransitStopException.MESSAGE);

        if (stops == null) stops = new ArrayList<>();
        if (stops.contains(stop)) return;

        stops.add(stop);
        if (!stop.getRoute().equals(this)) { stop.setRoute(this); }
    }

    public void removeStop(TransitStop stop) {
        if (stop == null) throw new NullTransitStopException(NullTransitStopException.MESSAGE);

        if (stops.contains(stop)) {
            stops.remove(stop);
            if (stop.getRoute() != null && this.equals(stop.getRoute())) { stop.setRoute(null); }
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id:" + id + " name:" + name + " interArrivalTime:" + interArrivalTime + "]";
    }

}