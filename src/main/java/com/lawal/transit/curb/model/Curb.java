package com.lawal.transit.curb.model;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.block.model.exception.NullBlockException;
import com.lawal.transit.block.model.exception.NullBlockListException;
import com.lawal.transit.curb.CurbOrientationException;
import com.lawal.transit.global.Direction;

import com.lawal.transit.road.model.Road;

import com.lawal.transit.station.model.Station;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public final class Curb {

    @Id
    @EqualsAndHashCode.Include
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

    @OneToMany(mappedBy = "curb", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks = new ArrayList<>();

    public Curb (Long id, Direction orientation, Road leftRoadSide, Road rightRoadSide) {//Avenue avenue, Street street, Direction orientation, Road leftRoadSide, Road rightRoadSide) {
        if (leftRoadSide == null && rightRoadSide == null)
            throw new IllegalArgumentException("Curb cannot have both leftRoadSide and rightRoadSide null");

        if (leftRoadSide == null && rightRoadSide == null || leftRoadSide != null && rightRoadSide != null)
            throw new IllegalArgumentException("Curb cannot be on both the left and right sides of the road");

        this.id = id;
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

    public List<Station> getStations() {
        List<Station> stations = new ArrayList<>();
        for (Block block: blocks) {
            Station station = block.getStation();
            if (station != null && !stations.contains(station)) stations.add(station);
        }
        return stations;
    }

    public void setBlocks (List<Block> blocks) {
        if (blocks == null) throw new NullBlockListException(NullBlockListException.MESSAGE);
        if (this.blocks == null) this.blocks = new ArrayList<>();

        for (Block block: blocks) {
            addBlock(block);
        }
    }

    public void addBlock(Block block) {
        if (block == null) throw new NullBlockException(NullBlockException.MESSAGE);
        if (blocks.contains(block)) return;

        blocks.add(block);
        if (block.getCurb() != this) {
            block.setCurb(this);
        }
    }

    public void removeBlock(Block block) {
        if (block == null) throw new NullBlockException(NullBlockException.MESSAGE);

        if (blocks.contains(block)) {
            blocks.remove(block);
            if (block.getCurb() == this) { block.setCurb(null); }
        }
    }

    @Override
    public String toString () {
        String avenueString = getAvenue() == null ? "" : getAvenue().toString();
        String streetString = getStreet() == null ? "" : getStreet().toString();
        return getClass().getSimpleName() + "[" + id + " " + orientation.print() + " "  + avenueString + " " + streetString +"]";
    }
}