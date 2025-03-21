package com.lawal.transit.infrastructure.junction;

import com.lawal.transit.common.exception.NullDirectionException;
import com.lawal.transit.common.exception.NullNameException;
import com.lawal.transit.infrastructure.avenue.Avenue;

import com.lawal.transit.infrastructure.block.Block;

import com.lawal.transit.infrastructure.curb.Curb;
import com.lawal.transit.common.Direction;

import com.lawal.transit.infrastructure.junction.exception.NullJunctionException;

import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.station.Station;
import com.lawal.transit.infrastructure.street.Street;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
@Table(name = "junction_corners")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JunctionCorner {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = NullNameException.MESSAGE)
    private String name;

    @Column(nullable = false)
    @NotBlank(message = NullDirectionException.MESSAGE)
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

    public JunctionCorner (Long id, String name, Junction junction, Direction orientation, Block avenueLeg, Block streetLeg) {
        if (junction == null)
            throw new NullJunctionException(NullJunctionException.MESSAGE);

        if (!isValidOrientation(orientation))
            throw new IllegalArgumentException("Invalid junction corner orientation: " + orientation);
        this.orientation = orientation;

        if (avenueLeg != null && avenueLeg.getAvenue() != null && !avenueLeg.getAvenue().equals(junction.getAvenue()))
            throw new IllegalArgumentException("junction.avenue != avenueLeg.avenue");

        if (streetLeg != null && streetLeg.getStreet() != null && !streetLeg.getStreet().equals(junction.getStreet()))
            throw new IllegalArgumentException("junction.street != streetLeg.street");

        this.id = id;
        this.name = name;
        this.avenueLeg = avenueLeg;
        this.streetLeg = streetLeg;

        this.junction = junction;
        if (!junction.getCorners().contains(this)) junction.getCorners().add(this);
    }

    public boolean containsBlock (Block block) {
        if (block == null) return false;
        return block.equals(avenueLeg) || block.equals(streetLeg);
    }

    public Block getLegByAvenueOrientation (Avenue avenue, Direction curbOrientation) {
        if (avenue == null || curbOrientation == null) return null;
        if (curbOrientation.equals(avenueLeg.getCurb().getOrientation()) && avenue.equals(avenueLeg.getCurb().getAvenue()))
            return avenueLeg;
        return null;
    }

    public Block getLegByStreetOrientation (Street street, Direction curbOrientation) {
        if (street == null || curbOrientation == null) return null;
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

    public Block findLegByBlockId (Long blockId) {
        if (blockId == null) return null;

        if (avenueLeg.getId().equals(blockId)) return avenueLeg;
        if (streetLeg.getId().equals(blockId)) return streetLeg;
        return null;
    }

    public Block getLegByRoad(Road road) {
        if (road == null) return null;

        if (road.getAvenue() != null && avenueLeg.getCurb().getRoad().equals(road)) return avenueLeg;
        if (road.getStreet() != null && streetLeg.getCurb().getRoad().equals(road)) return streetLeg;
        return null;
    }

    public Block getLegByCurbOrientation (Direction curbOrientation) {
        if (curbOrientation == null) return null;
        if (curbOrientation.equals(Direction.NORTH) || curbOrientation.equals(Direction.EAST)) return avenueLeg;
        else return streetLeg;
    }

    public Block getOppositeLeg (Block block) {
        if (block == null) return null;
        if (block.equals(avenueLeg)) return streetLeg;
        if (block.equals(streetLeg)) return avenueLeg;
        return null;
    }

    public Map<Direction, Block> getLegMap () {
        Map<Direction, Block> map = new HashMap<>();

        map.put(avenueLeg.getCurb().getOrientation(), avenueLeg);
        map.put(streetLeg.getCurb().getOrientation(), streetLeg);

        return map;
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "[id:" + id
            + " " + avenueLeg.getCurb().getRoadName()
            + " and " + streetLeg.getCurb().getRoadName()
            + " " + orientation.abbreviation()
            + " corner]";
    }

    private boolean isValidOrientation (Direction cornerOrientation) {
        return EnumSet.of(Direction.NORTHEAST, Direction.NORTHWEST, Direction.SOUTHEAST, Direction.SOUTHWEST)
            .contains(cornerOrientation);
    }
}