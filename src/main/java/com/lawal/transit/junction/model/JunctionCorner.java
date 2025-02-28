package com.lawal.transit.junction.model;

import com.lawal.transit.avenue.model.exception.AvenueNameNullException;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Direction;

import com.lawal.transit.station.model.Station;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Direction cornerOrientation;

    @ManyToOne
    @JoinColumn(name = "junction_id")
    private Junction junction;

    @ManyToOne
    @JoinColumn(name = "avenue_leg_id", nullable = false)
    private Block avenueLeg;

    @ManyToOne
    @JoinColumn(name = "street_leg_id", nullable = false)
    private Block streetLeg;

    public JunctionCorner(Long id, Junction junction, Direction cornerOrientation) {
        this.id = id;
        this.junction = junction;
        if (!isValidOrientation(cornerOrientation))
            throw new IllegalArgumentException("Invalid junction corner orientation: " + cornerOrientation);

        this.cornerOrientation = cornerOrientation;
        this.name = this.cornerOrientation.name() + " Corner";
        setAvenueLeg();
        setStreetLeg();
    }

    private void setAvenueLeg() {
        Curb avenueCurb = getAvenueCurb();
        int streetId = (int) junction.getStreet().getId().intValue();
        int avenueLength = avenueCurb.getBlocks().size();

        this.avenueLeg = avenueCurb.getBlocks().get(streetId - 1);
        if (cornerOrientation != Direction.NORTHWEST && cornerOrientation == Direction.SOUTHWEST && streetId < avenueLength) {
            this.avenueLeg = avenueCurb.getBlocks().get(streetId);
        }
    }

    private void setStreetLeg() {
        Curb streetOldCurb = getStreetCurb();
        int avenueId = (int) junction.getAvenue().getId().intValue();
        int streetLength = streetOldCurb.getBlocks().size();

        this.streetLeg = streetOldCurb.getBlocks().get(avenueId - 1);
        if (cornerOrientation != Direction.NORTHWEST && cornerOrientation == Direction.SOUTHWEST && avenueId < streetLength) {
            this.streetLeg = streetOldCurb.getBlocks().get(avenueId);
        }
    }

    private boolean isValidOrientation(Direction cornerOrientation) {
        return cornerOrientation == Direction.NORTHEAST ||
            cornerOrientation == Direction.SOUTHEAST ||
            cornerOrientation == Direction.SOUTHWEST ||
            cornerOrientation == Direction.NORTHWEST;
    }

    public Curb getAvenueCurb() {
        Direction curbOrientation = Direction.NORTH;

        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation != Direction.NORTHWEST)
            curbOrientation = Direction.SOUTH;
        return junction.getAvenue().getCurbByOrientation(curbOrientation);
    }

    private Curb getStreetCurb() {
        Direction curbOrientation = Direction.EAST;

        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation == Direction.SOUTHEAST)
            curbOrientation = Direction.WEST;
        return junction.getStreet().getCurbByOrientation(curbOrientation);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id:" + id + " name:" + name
            + " avenueLeg:" + avenueLeg.toString() + " streetLeg:" + streetLeg.toString() + "]";
    }
}