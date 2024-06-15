package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.OldConcreteBlock;
import com.lawal.transit.Orientation;

import java.util.Objects;

public abstract class AbstractLocation extends NamedEntity {

    private enum Mark { KEEP, PURGE; }
    private OldConcreteBlock concreteBlock;
    private AbstractRoad abstractRoad;
    private Mark mark;
    private Orientation orientation;

    public AbstractLocation (int id, String name, OldConcreteBlock concreteBlock, Orientation orientation) {
        super(id, name);
        this.mark = Mark.KEEP;
        this.concreteBlock = concreteBlock;
        this.orientation = orientation;
        this.abstractRoad = concreteBlock.getBorderRoad(orientation);
    }

    public Mark getMark () {
        return mark;
    }

    public OldConcreteBlock getBlock () {
        return concreteBlock;
    }

    public AbstractRoad getRoad () {
        return concreteBlock.getBorderRoad(orientation);
    }

    public Orientation getOrientation () {
        return orientation;
    }

    public void setMark (Mark mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof AbstractLocation abstractLocation)
            return super.equals(abstractLocation) && concreteBlock.equals(abstractLocation.getBlock())
                && mark.equals(abstractLocation.getMark()) && orientation.equals(abstractLocation.getOrientation());
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), concreteBlock, abstractRoad, orientation);
    }

    @Override
    public String toString () {
        return super.toString()
            + " " + abstractRoad.toString()
            + " " + orientation.abbreviation()
            + " blockId:" + concreteBlock.getId();
    } // close toString
} // end class AbstractLocation
