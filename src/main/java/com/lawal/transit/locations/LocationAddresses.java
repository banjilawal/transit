package com.lawal.transit.locations;

import com.lawal.transit.addresses.interfaces.*;

import java.util.*;

public class LocationAddresses<LocatableAddress> implements AddressCollection<LocatableAddress> {
    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";
    private final ArrayList<LocatableAddress> addresses;

    private LocationAddresses () {
        this.addresses = new ArrayList<>();
    }

    @Override
    public int size () {
        return addresses.size();
    }

    @Override
    public Iterator<LocatableAddress> iterator () {
        return addresses.iterator();
    }

    @Override
    public void add (LocatableAddress address) throws Exception {
        if (addresses.contains(address)) {
            throw new Exception(ADDITION_ERROR);
        }
        addresses.add(addresses.size(), address);
    }

    @Override
    public void remove (LocatableAddress address) throws Exception {
        int index = addresses.indexOf(address);
        if (index < 0) {
            throw new Exception(REMOVAL_ERROR);
        }
        addresses.remove(index);

    }

    @Override
    public boolean found (LocatableAddress address) {
        return addresses.contains(address);
    }
}
