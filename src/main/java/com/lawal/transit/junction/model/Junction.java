package com.lawal.transit.junction.model;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.avenue.model.exception.NullAvenueException;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Direction;
import com.lawal.transit.junction.JunctionCornerFactory;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;
import com.lawal.transit.street.model.exception.NullStreetException;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "junctions")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Junction {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name = "avenue_id")
    private Avenue avenue;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToMany(mappedBy = "junction", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JunctionCorner> corners = new ArrayList<>();

    public Junction(Long id, Avenue avenue, Street street) {
        if (avenue == null)
            throw new NullAvenueException(NullAvenueException.MESSAGE);
        if (street == null)
            throw new NullStreetException(NullStreetException.MESSAGE);

        this.id = id;
        this.avenue = avenue;
        if (!avenue.getJunctions().contains(this)) this.avenue.getJunctions().add(this);

        this.street = street;
        if (!street.getJunctions().contains(this)) this.street.getJunctions().add(this);

        this.name = avenue.getName() + " Ave and " + street.getName() + " St";
        this.corners = new ArrayList<>();

        createCorners();
    }

    public JunctionCorner getCornerByBlock(Block block) {
        if (block == null) return null;

        for (JunctionCorner corner : corners) {
            if (corner.containsBlock(block)) return corner;
        }
        return null;
    }

    public JunctionCorner getCornerByOrientation(Direction cornerOrientation) {
        if (cornerOrientation == null) {
            System.out.println("junction.getCornerByOrientation() " + cornerOrientation.print() + " is null");
            return null;
        }
//        System.out.println("junction.getCornerByOrientation() " + cornerOrientation.abbreviation() + " is not null proceeding");
        if (corners == null || corners.isEmpty()) {
            System.out.println("junction.corners is empty or null cannot find any corners by  " + cornerOrientation);
            return null;
        }
        for (JunctionCorner corner : corners) {
//            System.out.println("junctionCorner.getCornerByOrientation() checking " + corner.toString() + " against " + cornerOrientation.abbreviation() + "");
            if (corner.getOrientation() == cornerOrientation) {
//                System.out.println("junction.getCornerByOrientation() found corner matching " + cornerOrientation.abbreviation() + " is " + corner);
//                System.out.println("returning " + corner.toString());
                return corner;
            }
        }
        return null;
    }

    public Map<Direction, JunctionCorner> getCornersAsMap () {
        Map<Direction, JunctionCorner> map = new HashMap<>();

        map.put(Direction.NORTHWEST, getCornerByOrientation(Direction.NORTHWEST));
        map.put(Direction.NORTHEAST, getCornerByOrientation(Direction.NORTHEAST));
        map.put(Direction.SOUTHWEST, getCornerByOrientation(Direction.SOUTHWEST));
        map.put(Direction.SOUTHEAST, getCornerByOrientation(Direction.SOUTHEAST));

        return map;
    }

    public JunctionCorner getCornerByStation(Station station) {
        if (station == null) return null;

        for (JunctionCorner corner : corners) {
            if (corner.getLegByStation(station) != null) return corner;
        }
        return null;
    }

    public Curb findCurbByBlock (Block block) {
        if (block == null) return null;

        for (JunctionCorner corner : corners) {
            if (corner.containsBlock(block)) {
                Curb curb = corner.findCurbByBlock(block);
                if (curb != null) return curb;
            }
        }
        return null;
    }

    public Block findLegByBlockId(Long blockId) {
        if (blockId == null) return null;

        for (JunctionCorner corner : corners) {
            Block block = corner.findLegByBlockId(blockId);
            if (block != null) return block;
        }
        return null;
    }

    public void setAvenue(Avenue avenue) {
        if (this.avenue != null && this.avenue.equals(avenue)) return;

        if (this.avenue != null) {
            this.avenue.getJunctions().remove(this) ;
            this.avenue = null;
        }

        if (avenue != null && !avenue.getJunctions().contains(this)) avenue.getJunctions().add(this);
        this.avenue = avenue;
    }

    public void setStreet(Street street) {
        if (this.street != null && this.street.equals(street)) return;

        if (this.street != null) {
            this.street.getJunctions().remove(this) ;
            this.street = null;
        }

        if (street != null && !street.getJunctions().contains(this)) street.getJunctions().add(this);
        this.street = street;
    }

    private void createCorners() {
        JunctionCorner northWestCorner = JunctionCornerFactory.createJunctionCorner(null, this, Direction.NORTHWEST);
        if (!corners.contains(northWestCorner)) corners.add(northWestCorner);

        JunctionCorner northEastCorner = JunctionCornerFactory.createJunctionCorner(null, this, Direction.NORTHEAST);
        if (!corners.contains(northEastCorner)) corners.add(northEastCorner);

        JunctionCorner southWestCorner = JunctionCornerFactory.createJunctionCorner(null, this, Direction.SOUTHWEST);
        if (!corners.contains(southWestCorner)) corners.add(southWestCorner);

        JunctionCorner southEastCorner = JunctionCornerFactory.createJunctionCorner(null, this, Direction.SOUTHEAST);
        if (!corners.contains(southEastCorner)) corners.add(southEastCorner);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id:" + id + " " + avenue.getName() + " Ave and " + street.getName() + " St]";
    }
}