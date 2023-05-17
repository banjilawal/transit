package com.lawal.transit.middleware.abstracts;


import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Building;
import com.lawal.transit.middleware.enums.Direction;;

public abstract class AvenueBuilding extends Building {

    public AvenueBuilding (int id, String name, int blockId, Avenue avenue, Direction blockSide) {
        super(id, name, blockId, avenue, blockSide);
    }
}

/*
public abstract class AvenueBuilding extends Building {
    public AvenueBuilding (int id, String name, int blockId, Avenue blockAvenue) {
        super(id, name, blockId, blockAvenue);
    }

    public Avenue getAvenue () {
        return (Avenue) getBlockRoad();
    }

    public void setAvenue (Avenue avenue) {
        setBlockRoad(avenue);
    }

    @Override
    public String toString () {
        String string = getName()
                + " " + getAvenue().getName()
                + " " + getAvenue().getClass().getSimpleName();
        return string;
    } // close toString

    @Override
    public String fullString () {
        String string = "id:" + Integer.toString(getId())
                +  " " + getName()
                + " " + getAvenue().getName()
                + " " + getAvenue().getClass().getSimpleName();
        return string;
    } // close toString
} // end class AvenueBuilding

 */