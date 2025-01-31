package com.lawal.transit.places;

import com.lawal.transit.global.Address;
import com.lawal.transit.global.*;
import com.lawal.transit.places.interfaces.*;

public record Place (Address address) implements Placeable, Visitee {

    @Override
    public void accept (Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName()
            + " id:" + address.id()
            + " name:" + address.name()
            +  " " + address.blockTag().curbsideMarker().roadLabel().name()
            + " " + address.blockTag().curbsideMarker().roadLabel().category().abbreviation()
            + " " + address.blockTag().curbsideMarker().travelDirection().print();
    }
}