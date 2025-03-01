package com.lawal.transit.curb.model;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.curb.CurbOrientationException;
import com.lawal.transit.global.Direction;

import com.lawal.transit.road.model.Road;

import com.lawal.transit.street.model.Street;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curbs")
public final class Curb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = CurbOrientationException.MESSAGE)
    Direction orientation;

    @ManyToOne
    @JoinColumn(name = "left_road_id", nullable = true)
    private Road leftRoadSide;

    @ManyToOne
    @JoinColumn(name = "right_road_id", nullable = true)
    private Road rightRoadSide;

//    @ManyToOne
//    @JoinColumn(name = "avenue_id", nullable = true)
//    private Avenue avenue;
//
//    @ManyToOne
//    @JoinColumn(name = "street_id", nullable = true)
//    private Street street;

    @OneToMany(mappedBy = "curb", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks = new ArrayList<>();

    public Curb (Long id, Direction orientation, Road leftRoadSide, Road rightRoadSide) {//Avenue avenue, Street street, Direction orientation, Road leftRoadSide, Road rightRoadSide) {
        this.id = id;
//        this.avenue = avenue;
//        this.street = street;
        this.orientation = orientation;

        this.leftRoadSide = leftRoadSide;
        this.rightRoadSide = rightRoadSide;

        if (leftRoadSide != null) leftRoadSide.setLeftCurb(this);
        if (rightRoadSide != null) rightRoadSide.setRightCurb(this);

        this.blocks = new ArrayList<>();
    }

    public Road getRoad() {
        if (rightRoadSide != null) return rightRoadSide;
        else if (leftRoadSide != null) return leftRoadSide;
        else return null;
    }

    public Avenue getAvenue() {
        if (getRoad() == null) return null;
        if (getRoad().getAvenue() != null) return getRoad().getAvenue();
        return null;
    }

    public Street getStreet() {
        if (getRoad() == null) return null;
        if (getRoad().getStreet() != null) return getRoad().getStreet();
        return null;
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Curb curb) {
            return id.equals(curb.getId()) && orientation == curb.getOrientation();
        }
        return false;
    }

    @Override
    public String toString () {
        String avenueString = getAvenue() == null ? "" : getAvenue().toString();
        String streetString = getStreet() == null ? "" : getStreet().toString();
        return getClass().getSimpleName() + "[" + id + " " + orientation.print() + " "  + avenueString + " " + streetString +"]";
    }
}