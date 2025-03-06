package com.lawal.transit.junction.model;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.avenue.model.exception.AvenueNameNullException;
import com.lawal.transit.block.model.Block;

import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Direction;

import com.lawal.transit.junction.model.exception.NullJunctionException;

import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
public class JunctionCorner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = AvenueNameNullException.MESSAGE)
    private String name;

    @Column(nullable = false)
    @NotBlank(message = AvenueNameNullException.MESSAGE)
    private Direction orientation;

    @ManyToOne
    @JoinColumn(name = "junction_id")
    private Junction junction;

    @ManyToOne
    @JoinColumn(name = "avenue_leg_id", nullable = false)
    private Block avenueLeg;

    @ManyToOne
    @JoinColumn(name = "street_leg_id", nullable = false)
    private Block streetLeg;

    public JunctionCorner(Long id, String name, Junction junction, Direction orientation, Block avenueLeg, Block streetLeg) {
        if (junction == null)
            throw new NullJunctionException(NullJunctionException.MESSAGE);

        if (!isValidOrientation(orientation))
            throw new IllegalArgumentException("Invalid junction corner orientation: " + orientation);
        this.orientation = orientation;

        if (avenueLeg  != null && avenueLeg.getAvenue() != null && !avenueLeg.getAvenue().equals(junction.getAvenue()))
            throw new IllegalArgumentException("junction.avenue != avenueLeg.avenue");

        if (streetLeg  != null && streetLeg.getStreet() != null && !streetLeg.getStreet().equals(junction.getStreet()))
            throw new IllegalArgumentException("junction.street != streetLeg.street");

        this.id = id;
        this.name = name;
        this.avenueLeg = avenueLeg;
        this.streetLeg = streetLeg;

        this.junction = junction;
        if (!junction.getCorners().contains(this)) junction.getCorners().add(this);
    }

//    public Block getStreetLeg() {
//        if (this.streetLeg == null) {
//            System.out.println("Corner getStreetLeg() is returning null " + this.streetLeg);
//            return null;
//        }
//        System.out.println("Corner getStreetLeg() is returning " + this.streetLeg);
//        return this.streetLeg;
//    }
//
//    public Block getAvenueLeg() {
//        if (this.avenueLeg == null) {
//            System.out.println("Corner getAvenueLeg() is returning null " + this.avenueLeg);
//            return null;
//        }
//        System.out.println("Corner getAvenueLeg() is returning " + this.avenueLeg);
//        return this.avenueLeg;
//    }

    public boolean containsBlock(Block block) {
        if (block == null) return false;
        return block.equals(avenueLeg) || block.equals(streetLeg);
    }

    public Block getLegByAvenueOrientation(Avenue avenue, Direction curbOrientation) {
        if (avenue == null || curbOrientation == null) return null;
        if (curbOrientation.equals(avenueLeg.getCurb().getOrientation()) && avenue.equals(avenueLeg.getCurb().getAvenue()))
            return avenueLeg;
        return null;
    }

    public Block getLegByStreetOrientation(Street street, Direction curbOrientation) {
        if (street == null ||curbOrientation == null) return null;
        if (curbOrientation.equals(streetLeg.getCurb().getOrientation()) && street.equals(streetLeg.getCurb().getStreet()))
            return streetLeg;
        return null;
    }

    public Block getLegByStation (Station station) {
        if (station == null) return null;
        if (avenueLeg.getStation() != null && avenueLeg.getStation().equals(station)) return avenueLeg;
        if (streetLeg.getStation() != null && streetLeg.getStation().equals(station)) return streetLeg;
        return null;
    }

    public Curb findCurbByBlock (Block block) {
        if (block == null) return null;

        if (avenueLeg.equals(block)) return avenueLeg.getCurb();
        if (streetLeg.equals(block)) return streetLeg.getCurb();
        return null;
    }

    public Block findLegByBlockId(Long blockId) {
        if (blockId == null) return null;

        if (avenueLeg.getId().equals(blockId)) return avenueLeg;
        if (streetLeg.getId().equals(blockId)) return streetLeg;
        return null;
    }

    public Block getLegByCurbOrientation (Direction curbOrientation) {
        if (curbOrientation == null) return null;
        if (curbOrientation.equals(Direction.NORTH) || curbOrientation.equals(Direction.EAST)) return avenueLeg;
        else return streetLeg;
    }

    public Block getOppositeLeg(Block block) {
        if (block == null) return null;
        if (block.equals(avenueLeg)) return streetLeg;
        if (block.equals(streetLeg)) return avenueLeg;
        return null;
    }

    public Map<Direction, Block> getLegMap() {
        Map<Direction, Block> map = new HashMap<>();

        map.put(avenueLeg.getCurb().getOrientation(), avenueLeg);
        map.put(streetLeg.getCurb().getOrientation(), streetLeg);

        return map;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id:" + id
            + " " + avenueLeg.getCurb().getRoadName()
            + " and " + streetLeg.getCurb().getRoadName()
            + " " + orientation.abbreviation()
            + " corner]";
    }
//
//    private void setAvenueLeg() {
//        Curb avenueCurb = getAvenueCurb();
//        int streetId = (int) junction.getStreet().getId().intValue();
//        int avenueLength = avenueCurb.getBlocks().size();
//
//        this.avenueLeg = avenueCurb.getBlockByArrayIndex(streetId - 1);
////        this.avenueLeg = avenueCurb.getBlocks().get(streetId - 1);
//        if (cornerOrientation != Direction.NORTHWEST && cornerOrientation == Direction.SOUTHWEST && streetId < avenueLength) {
//            this.avenueLeg = avenueCurb.getBlockByArrayIndex(streetId); //avenueCurb.getBlocks().get(streetId);
//        }
//    }
//
//    private void setStreetLeg() {
//        Curb streetCurb = getStreetCurb();
//        int avenueId = (int) junction.getAvenue().getId().intValue();
//        int streetLength = streetCurb.getBlocks().size();
//
//        this.streetLeg = streetCurb.getBlockByArrayIndex(avenueId - 1);
////        this.streetLeg = streetCurb.getBlocks().get(avenueId - 1);
//        if (cornerOrientation != Direction.NORTHWEST && cornerOrientation == Direction.SOUTHWEST && avenueId < streetLength) {
//            this.streetLeg = streetCurb.getBlockByArrayIndex(avenueId); //streetCurb.getBlocks().get(avenueId);
//        }
//    }
//
//    public Curb getAvenueCurb() {
//        Direction curbOrientation = Direction.NORTH;
//
//        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation != Direction.NORTHWEST)
//            curbOrientation = Direction.SOUTH;
//        return junction.getAvenue().getCurbByOrientation(curbOrientation);
//    }
//
//    private Curb getStreetCurb() {
//        Direction curbOrientation = Direction.EAST;
//
//        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation == Direction.SOUTHEAST)
//            curbOrientation = Direction.WEST;
//        return junction.getStreet().getCurbByOrientation(curbOrientation);
//    }
//
//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + "[id:" + id + " name:" + name
//            + " avenueLeg:" + avenueLeg.toString() + " streetLeg:" + streetLeg.toString() + "]";
//    }
//
    private boolean isValidOrientation(Direction cornerOrientation) {
        return EnumSet.of(Direction.NORTHEAST, Direction.NORTHWEST, Direction.SOUTHEAST, Direction.SOUTHWEST)
            .contains(cornerOrientation);
    }

}