package com.lawal.transitcraft.infrastructure.road;

import com.lawal.transitcraft.common.exception.TransitCraftIdNullException;
import com.lawal.transitcraft.common.exception.TransitCraftNegativeIdException;
import com.lawal.transitcraft.infrastructure.avenue.Avenue;
import com.lawal.transitcraft.infrastructure.curb.Curb;
import com.lawal.transitcraft.infrastructure.curb.exception.CurbAvenueMismatchException;
import com.lawal.transitcraft.infrastructure.curb.exception.CurbStreetMismatchException;
import com.lawal.transitcraft.infrastructure.lane.Lane;
import com.lawal.transitcraft.infrastructure.road.exception.ImmutableStreetModificationException;
import com.lawal.transitcraft.infrastructure.road.exception.StreetAssignmentConflictsWithExistingAvenueException;
import com.lawal.transitcraft.infrastructure.road.exception.StreetHasConflictingRoadReferenceException;
import com.lawal.transitcraft.infrastructure.street.Street;
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
        if (id == null) throw new TransitCraftIdNullException(TransitCraftIdNullException.MESSAGE);
        if (id < 1) throw new TransitCraftNegativeIdException(TransitCraftNegativeIdException.MESSAGE);

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

        // Check immutability - if street is already set, it can't be changed (even to null)
        if (this.street != null) {
            throw new ImmutableStreetModificationException("Street reference cannot be modified once set");
        }

        // Check mutual exclusivity with avenue
        if (this.avenue != null) {
            throw new StreetAssignmentConflictsWithExistingAvenueException(
                StreetAssignmentConflictsWithExistingAvenueException.MESSAGE
            );
        }

        // Check bidirectional reference consistency
        if (street != null && street.getRoad() != null && !street.getRoad().equals(this)) {
            throw new StreetHasConflictingRoadReferenceException(
                StreetHasConflictingRoadReferenceException.MESSAGE
            );
        }

        // Set new relationship
        this.street = street;
        if (street != null) {
            street.setRoad(this);
        }
    }


    public void setAvenue(Avenue avenue) {
        if (this.avenue != null && this.avenue.equals(avenue)) return;

        this.avenue = avenue;
        if (avenue.getRoad() != this) { this.avenue.setRoad(this); }
    }

    public String avenueString() {
        if (avenue == null) return "";
        return avenue.getName() + " " + Avenue.ABBREVIATION;
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
        return street.getName() + " " + Street.ABBREVIATION;
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