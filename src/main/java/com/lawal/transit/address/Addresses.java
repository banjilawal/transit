package com.lawal.transit.address;

import com.lawal.transit.block.Block;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.contract.Road;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Addresses {

    private Set<Address> addresses;

    public Addresses () { this.addresses = new HashSet<>(); }

    public int size () { return this.addresses.size(); }

    public boolean isEmpty () { return this.addresses.isEmpty(); }

    public Iterator<Address> iterator () { return this.addresses.iterator(); }

    public Set<Address> getAddresses () { return this.addresses; }

    public void add (Address address) { if (address != null) this.addresses.add(address); }

    public void remove (int id) {
        Address address = findById(id);
        if (address != null) { this.addresses.remove(address); }
    }

    public Address findById (int id) {
        for (Address address : this.addresses) {
            if (address.id() == id) return address;
        }
        return null;
    }

    Addresses filterByBlock (Block block) {
        if (block == null) return null;
        Addresses matches = new Addresses();
        for (Address address : this.addresses) {
            if (address.blockTag().equals(block.getTag())) matches.add(address);
        }
        return matches;
    }

    Addresses filterByRoad (Road road) {
        if (road == null) return null;
        Addresses matches = new Addresses();
        for (Address address : this.addresses) {
            if (address.blockTag().curbMarker().roadLabel().equals(road.label())) matches.add(address);
        }
        return matches;
    }

    Addresses filterByOrientation(Road road, Direction travelDirection) {
        if (road == null || travelDirection == null) return null;
        Addresses matches = new Addresses();
        for (Address address : this.addresses) {
            if (address.blockTag().curbMarker().roadLabel().equals(road.label())
                && address.blockTag().curbMarker().travelDirection().equals(travelDirection)
            )
                matches.add(address);
        }
        return matches;
    }

    @Override
    public String toString () {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(Address address : addresses) {
            stringBuilder.append(count + 1).append(" ").append(address.toString()).append("\n");
            count++;
        }
        return stringBuilder.toString().trim();
    }

}