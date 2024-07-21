package com.lawal.transit.buildings;

import com.lawal.transit.globals.*;

import java.util.*;

public class Building implements Addressable {

    private final FormattedAddress address;

    public Building (FormattedAddress address) {
         this.address = address;
    }

    @Override
    public FormattedAddress getAddress () {
        return address;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Building building = (Building) object;
        return Objects.equals(address, building.getAddress());
    }

    @Override
    public int hashCode () {
        return Objects.hash(address);
    }

    @Override
    public String toString () {
        return address.toString();
    }

}
