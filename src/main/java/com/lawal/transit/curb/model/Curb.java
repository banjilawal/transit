package com.lawal.transit.curb.model;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.block.model.exception.NullBlockException;
import com.lawal.transit.block.model.exception.NullBlockListException;
import com.lawal.transit.curb.CurbOrientationException;
import com.lawal.transit.curb.model.exception.CurbAvenueMismatchException;
import com.lawal.transit.curb.model.exception.CurbStreetMismatchException;
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
    private Road leftRoadside;

    @ManyToOne
    @JoinColumn(name = "right_road_id", nullable = true)
    private Road rightRoadside;

    @OneToMany(mappedBy = "curb", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks = new ArrayList<>();

    public Curb (Long id, Direction orientation, Road leftRoadside, Road rightRoadside) {//Avenue avenue, Street street, Direction orientation, Road leftRoadSide, Road rightRoadSide) {
        if (leftRoadside == null && rightRoadside == null)
            throw new IllegalArgumentException("Curb cannot have both leftRoadSide and rightRoadSide null");

        if (leftRoadside != null && rightRoadside != null)
            throw new IllegalArgumentException("Curb cannot be on both the left and right sides of the road");

        this.id = id;
        this.orientation = orientation;

        this.leftRoadside = leftRoadside;
        this.rightRoadside = rightRoadside;

        if (leftRoadside != null) {
            if (!this.equals(leftRoadside.getLeftCurb())) leftRoadside.setLeftCurb(this);
        }
        if (rightRoadside != null) {
            if (!this.equals(rightRoadside.getRightCurb())) rightRoadside.setRightCurb(this);
        }

        this.blocks = new ArrayList<>();
    }

    public Avenue getAvenue() {
        if (leftRoadside != null) return leftRoadside.getAvenue();
        else if (rightRoadside != null) return rightRoadside.getAvenue();
        else return null;
    }

    public Street getStreet() {
        if (leftRoadside != null) return leftRoadside.getStreet();
        else if (rightRoadside != null) return rightRoadside.getStreet();
        return null;
    }

    public Block getBlockByArrayIndex(int index) {
        if (index < 0 || index >= blocks.size()) throw new IllegalArgumentException("BlockArrayIndex out of bounds");
        return blocks.get(index);
    }

    public Block getNextBlockByArrayIndex(int index) {
        if (index < 0 || index >= blocks.size()) throw new IllegalArgumentException("BlockArrayIndex out of bounds");
        return blocks.get(index + 1);
    }

    public Block getPreviousBlockByArrayIndex(int index) {
        if (index <= 0 || index >= blocks.size()) throw new IllegalArgumentException("BlockArrayIndex out of bounds");
        return blocks.get(index - 1);
    }

    public Road getRoad() {
        if (rightRoadside != null) return rightRoadside;
        else if (leftRoadside != null) return leftRoadside;
        else return null;
    }

    public void setLeftRoad(Road road) {
        if (road != null && road.getStreet() == null && orientation == Street.LEFT_CURB_ORIENTATION) {
            throw new CurbStreetMismatchException(CurbStreetMismatchException.MESSAGE);
        }

        if (road != null && road.getAvenue() == null && orientation == Avenue.LEFT_CURB_ORIENTATION) {
            throw new CurbAvenueMismatchException(CurbAvenueMismatchException.MESSAGE);
        }

        if (this.leftRoadside != null) {
            this.leftRoadside.setLeftCurb(null);
        }

        if (road != null && road.getLeftCurb() != null && !this.equals(road.getLeftCurb())) {
            road.setLeftCurb(this);
        }
        this.leftRoadside = road;
    }

    public void setRightRoad(Road road) {
        if (road != null && road.getStreet() == null && orientation == Street.RIGHT_CURB_ORIENTATION) {
            throw new CurbStreetMismatchException(CurbStreetMismatchException.MESSAGE);
        }

        if (road != null && road.getAvenue() == null && orientation == Avenue.RIGHT_CURB_ORIENTATION) {
            throw new CurbAvenueMismatchException(CurbAvenueMismatchException.MESSAGE);
        }

        if (this.rightRoadside != null) {
            this.rightRoadside.setRightCurb(null);
        }

        if (road != null && road.getRightCurb() != null && !this.equals(road.getRightCurb())) {
            road.setRightCurb(this);
        }
        this.leftRoadside = road;
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
            if (block.getCurb() != null && this.equals(block.getCurb())) { block.setCurb(null); }
        }
    }

    public String getAvenueString() {
        if (getRoad() == null || getRoad().getAvenue() == null) return "";
        return " " + getRoad().getAvenue().toString();
    }

    public String getStreetString() {
        if (getRoad() == null || getRoad().getStreet() == null) return "";
        return " " + getRoad().getStreet().toString();
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "[curbId:" + id + " " + orientation.print()
            + getAvenueString() + getStreetString() +"]";
    }
}