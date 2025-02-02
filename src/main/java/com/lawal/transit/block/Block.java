package com.lawal.transit.block;

import com.lawal.transit.global.Addresses;
import com.lawal.transit.global.Constant;
import com.lawal.transit.road.Curb;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Block {

    private final int id;
    @Setter
    private String name;
    private final Curb curb;
    private final BlockTag tag;
    private final Addresses addresses;

    public Block (int id, String name, Curb curb) {
        this.id = id;
        this.name = name;
        this.curb = curb;
        this.tag = new BlockTag(id, curb.getMarker());
        this.addresses = new Addresses();
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Block block)
            return tag.equals(block.getTag());
        return false;
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + " name:" + name + " " + curb.toString() + "\nAddresses:\n" + addresses.toString() + "\n";
//        String roadName = tag.curbMarker().roadLabel().name() + " "
//            + tag.curbMarker().roadLabel().category().print() + " " + tag.curbMarker().travelDirection().print();
//        return "block:" + tag.id() + " [road:" + roadName + " " + "addresses(" + addresses.toString() + ")]";
    }
}