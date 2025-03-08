package com.lawal.transit.road.model;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.curb.model.exception.CurbAvenueMismatchException;
import com.lawal.transit.curb.model.exception.CurbStreetMismatchException;
import com.lawal.transit.global.RoadCategory;
import com.lawal.transit.lane.model.Lane;
import com.lawal.transit.street.model.Street;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roads")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Road {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Avenue avenue;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Street street;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Curb leftCurb;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Curb rightCurb;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Lane leftLane;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Lane rightLane;

    @OneToMany(mappedBy = "road", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lane> lanes = new ArrayList<>();

    public Road (Long id) {
        this.id = id;
        this.leftCurb = null;
        this.rightCurb = null;
        this.avenue = null;
        this.street = null;
        this.leftLane = null;
        this.rightLane = null;
        this.lanes = new ArrayList<>();
    }

    public void setLeftCurb(Curb curb) {
        if (curb == null && this.leftCurb == null) return;
        if (curb != null && curb.equals(this.leftCurb)) return;

        if (curb != null && avenue == null && curb.getOrientation() == Avenue.LEFT_CURB_ORIENTATION) {
            throw new CurbAvenueMismatchException(CurbAvenueMismatchException.MESSAGE);
        }

        if (curb != null && street == null && curb.getOrientation() == Street.LEFT_CURB_ORIENTATION) {
            throw new CurbStreetMismatchException(CurbStreetMismatchException.MESSAGE);
        }

        if (curb != null && curb.getLeftRoadside() != null && !this.equals(curb.getLeftRoadside())) {
            curb.setLeftRoadside(this);
        }
        this.leftCurb = curb;
    }

    public void setRightCurb(Curb curb) {
        if (curb == null && this.rightCurb == null) return;
        if (curb != null && curb.equals(this.rightCurb)) return;

        if (curb != null && avenue == null && curb.getOrientation() == Avenue.RIGHT_CURB_ORIENTATION) {
            throw new CurbAvenueMismatchException(CurbAvenueMismatchException.MESSAGE);
        }

        if (curb != null && street == null && curb.getOrientation() == Street.RIGHT_CURB_ORIENTATION) {
            throw new CurbStreetMismatchException(CurbStreetMismatchException.MESSAGE);
        }

        if (curb != null && curb.getRightRoadside() != null && !this.equals(curb.getRightRoadside())) {
            curb.setRightRoadside(this);
        }
        this.rightCurb = curb;
    }

    public void setStreet(Street street) {
        if (this.street != null && this.street.equals(street)) return;

        this.street = street;
        if (street.getRoad() != this) { this.street.setRoad(this); }
    }

    public void setAvenue(Avenue avenue) {
        if (this.avenue != null && this.avenue.equals(avenue)) return;

        this.avenue = avenue;
        if (avenue.getRoad() != this) { this.avenue.setRoad(this); }
    }

    public String avenueString() {
        if (avenue == null) return "";
        return avenue.getName() + " " + RoadCategory.AVENUE.abbreviation();
    }

    public static String leftCurbString(Road road) {
        if (road.getLeftCurb() == null) return "";
        return road.getLeftCurb().toString();
    }

    public static String rightCurbeString(Road road) {
        if (road.getRightCurb() == null) return "";
        return road.getRightCurb().toString();
    }

    public String streetString() {
        if (street == null) return "";
        return street.getName() + " " + RoadCategory.STREET.abbreviation();
    }

    public String getName() {
        if (avenue != null) return avenueString();
        if (street != null) return streetString();
        else return "";
    }

//    public String getRoadName() {
//        if (street != null) return streetString();
//        if (avenue != null) return avenueString();
//        else return "";
//    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[roadId:" + id
            + " " + leftCurbString(this) + " " + getName() + " " + rightCurbeString(this) +"]";
    }
}