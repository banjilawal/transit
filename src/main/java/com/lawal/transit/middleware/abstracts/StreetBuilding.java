package com.lawal.transit.middleware.abstracts;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.enums.Direction;

public abstract class StreetBuilding extends Building {

    public StreetBuilding (int id, String name, int blockId, Street street, Direction blockSide) {
        super(id, name, blockId, street, blockSide);
    }
} // end class StreetBuilding


/*
public abstract class StreetBuilding extends Building {
    public StreetBuilding (int id, String name, int blockId, Street blockStreet) {
        super(id, name, blockId, blockStreet);
    }

    public Street getStreet () {
        return (Street) getBlockRoad();
    }

    public void setStreet (Street street) {
        setBlockRoad(street);
    }

    @Override
    public String toString () {
        String string = getName()
                + " " + getStreet().getName()
                + " " + getStreet().getClass().getSimpleName();
        return string;
    } // close toString

    @Override
    public String fullString () {
        String string = "id:" + Integer.toString(getId())
                +  " " + getName()
                + " " + getStreet().getName()
                + " " + getStreet().getClass().getSimpleName();
        return string;
    } // close fullString
} // end class AvenueBuilding

 */