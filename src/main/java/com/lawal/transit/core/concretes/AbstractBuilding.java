package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.AbstractLocation;
import com.lawal.transit.Orientation;

public class AbstractBuilding extends AbstractLocation {

    public AbstractBuilding (int id, String name, OldConcreteBlock concreteBlock, Orientation orientation) {
        super(id, name, concreteBlock, orientation);
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof AbstractBuilding abstractBuilding)
            return super.equals(abstractBuilding);
        return false;
    }
} // end class AbstractBuilding