package com.lawal.transit.street.model;

import com.lawal.transit.avenue.model.AvenueMessage;
import com.lawal.transit.avenue.model.exception.AvenueNameNullException;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.*;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.exception.NullJunctionException;
import com.lawal.transit.junction.model.exception.NullJunctionListException;
import com.lawal.transit.lane.model.Lane;

import com.lawal.transit.road.model.Road;

import com.lawal.transit.road.model.exception.NullRoadException;
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
@Table(name = "streets")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public final class Street {

    public static final Direction RIGHTWARD_TRAFFIC_DIRECTION = Direction.SOUTH;
    public static final Direction LEFTWARD_TRAFFIC_DIRECTION = Direction.NORTH;

    public static final Direction LEFT_CURB_ORIENTATION = Direction.WEST;
    public static final Direction RIGHT_CURB_ORIENTATION = Direction.EAST;

    public static final int RIGHTWARD_STATION_BASE_NAME = 1000;
    public static final int LEFTWARD_STATION_BASE_NAME = 3000;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = AvenueNameNullException.MESSAGE)
    private String name;

    @OneToOne
    @JoinColumn(name = "road_id", nullable = false)
    private Road road;

    @OneToMany(mappedBy = "avenue", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Junction> junctions = new ArrayList<>();


    public Street (Long id, String name, Road road) {
        this.id = id;
        this.name = name;
        this.road = road;
        this.road.setStreet(this);
        this.junctions = new ArrayList<>();
    }

    public Lane getLaneByDirection (Direction direction) {
        if (road.getLeftLane().getDtrafficDirection() == direction) return road.getLeftLane();
        else if (road.getRightLane().getDtrafficDirection() == direction) return road.getRightLane();
        else return null;
    }

    public Curb getCurbByOrientation (Direction orientation) {
        if (road.getLeftCurb().getOrientation() == orientation) return road.getLeftCurb();
        else if (road.getRightCurb().getOrientation() == orientation) return road.getRightCurb();
        else return null;
    }


    public void setRoad(Road road) {
        if (road == null) throw new NullRoadException("Street cannot exist without a Road");
        if (this.road != null) { this.road.setStreet(null); }

        this.road = road;
        if (road.getStreet() != this) { road.setStreet(this); }
    }

    public void setJunctions (List<Junction> junctions) {
        if (junctions == null) throw new NullJunctionListException(NullJunctionListException.MESSAGE);
        if (this.junctions == null) this.junctions = new ArrayList<>();

        for (Junction junction : junctions) { addJunction(junction); }
    }

    public void addJunction(Junction junction) {
        if (junction == null) throw new NullJunctionException(AvenueMessage.JUNCTION_PARAMETER_NULL_EXCEPTION);
        if (junctions.contains(junction)) { return; }

        if (!this.equals(junction.getStreet())) { junction.setStreet(this); }
        junctions.add(junction);
    }

    public void removeJunction(Junction junction) {
        if (junction == null) throw new NullJunctionException(StreetMessage.JUNCTION_PARAMETER_NULL_EXCEPTION);
        if (!junctions.contains(junction)) { return; }

        if (junction.getStreet() != null && !this.equals(junction.getStreet())) { junction.setAvenue(null); }
        junctions.remove(junction);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "[id:"  + id + " name:" + name  + "]";
    }
}