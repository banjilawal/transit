package com.lawal.transit.address;

import com.lawal.transit.address.model.Address;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.roadEntity.contract.RoadEntity;

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

    public void remove (Long id) {
        Address address = findById(id);
        if (address != null) { this.addresses.remove(address); }
    }

    public Address findById(Long id) {
        for (Address address : this.addresses) {
            if (address.getId().equals(id)) return address;
        }
        return null;
    }

    public Addresses filterByBlock (Block block) {
        if (block == null) return null;
        Addresses matches = new Addresses();
        for (Address address : this.addresses) {
            if (address.getBlock().equals(block)) matches.add(address);
        }
        return matches;
    }

    public Addresses filterByRoad (Long roadId) {
        if (roadId == null) return null;
        Addresses matches = new Addresses();
        for (Address address : this.addresses) {
            if (address.getBlock().getCurb().getRoad().getId().equals(roadId)) matches.add(address);
        }
        return matches;
    }

//    Addresses filterByOrientation(RoadEntity road, Direction travelDirection) {
//        if (road == null || travelDirection == null) return null;
//        Addresses matches = new Addresses();
//        for (Address address : this.addresses) {
//            if (address.blockTag().curbMarker().roadLabel().equals(road.label())
//                && address.blockTag().curbMarker().travelDirection().equals(travelDirection)
//            )
//                matches.add(address);
//        }
//        return matches;
//    }

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