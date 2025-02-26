package com.lawal.transit.block;

import com.lawal.transit.address.Addresses;
import com.lawal.transit.road.Curb;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Block {

    private final int id;
    @Setter
    private String name;
    private final Curb curb;
    private final Addresses addresses;

    public Block (int id, String name, Curb curb) {
        this.id = id;
        this.name = name;
        this.curb = curb;
        this.addresses = new Addresses();
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Block block)
            return id == block.getId();
        return false;
    }

    @Override
    public String toString () {
        return getClass().getSimpleName()
            + " id:" + id + " name:" + name + " " + curb.getRoad().getName() + " " + curb.getOrientation().print();
    }
}