package com.lawal.transit.addresses.interfaces;

import java.util.*;

public interface LocationAddressCollection <LocationAddressable> extends GenericCollection<LocationAddressable> {

    public int size ();
    public Iterator<LocationAddressable> iterator ();

    public void add (LocationAddressable locationAddressable) throws Exception;
    public void remove (LocationAddressable locationAddressable) throws Exception;

    public boolean found (LocationAddressable locationAddressable);


}
