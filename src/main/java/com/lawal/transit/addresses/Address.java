package com.lawal.transit.addresses;

import com.lawal.transit.addresses.interfaces.*;

import java.util.*;

public class Address implements Addressable {

    private final int id;
    private final String name;

    public Address (int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId () {
        return id;
    }

    @Override
    public String getName () {
        return name;
    }

    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof com.lawal.transit.addresses.interfaces.Addressable addressable)
            return id == addressable.getId() && name.equalsIgnoreCase(addressable.getName());
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, name);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + " name:" + name;
    }
}
