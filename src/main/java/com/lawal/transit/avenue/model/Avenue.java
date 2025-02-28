package com.lawal.transit.avenue.model;

import com.lawal.transit.avenue.model.exception.AvenueNameNullException;

import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.*;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.lane.model.Lane;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.roadEntity.OldCurb;
import com.lawal.transit.roadEntity.Lanes;
import com.lawal.transit.roadEntity.RoadCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "avenues")
public final class Avenue {

    public static final RoadCategory ROAD_CATEGORY = RoadCategory.AVENUE;
    public static final Direction RIGHTWARD_TRAFFIC_DIRECTION = Direction.WEST;
    public static final Direction LEFTWARD_TRAFFIC_DIRECTION = Direction.EAST;

    public static final Direction LEFT_CURB_ORIENTATION = Direction.SOUTH;
    public static final Direction RIGHT_CURB_ORIENTATION = Direction.NORTH;

    public static final int RIGHTWARD_STATION_BASE_NAME = 2000;
    public static final int LEFTWARD_STATION_BASE_NAME = 4000;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = AvenueNameNullException.MESSAGE)
    private String name;

    /* Bidirectional fields */

    @OneToOne
    @JoinColumn(name = "road_id", nullable = false)
    private Road road;

    @OneToMany(mappedBy = "avenue", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Junction> junctions = new ArrayList<>();

    public Avenue (Long id, String name, Road road) {
        this.id = id;
        this.name = name;
        this.road = road;
        this.road.setAvenue(this);
//        this.lanes = new ArrayList<>();
//        this.curbs = new ArrayList<>();
        this.junctions = new ArrayList<>();
//        this.leftLanes = new Lanes(LEFTWARD_TRAFFIC_DIRECTION);
//        this.rightLanes = new Lanes(RIGHTWARD_TRAFFIC_DIRECTION);
//        this.leftCurb = new OldCurb(leftCurbId, this, Avenue.LEFT_CURB_ORIENTATION);
//        this.rightCurb = new OldCurb(rightCurbId, this, Avenue.RIGHT_CURB_ORIENTATION);
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

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Avenue avenue) {
            return id.equals(avenue.getId()) && name.equalsIgnoreCase(avenue.getName());
        }
        return false;
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "[id:" + id + " name:" + name + "]";
    }
}