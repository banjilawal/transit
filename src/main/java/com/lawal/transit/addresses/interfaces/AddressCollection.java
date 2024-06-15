package com.lawal.transit.addresses.interfaces;

import java.util.*;

public interface AddressCollection<Addressable> extends GenericCollection<Addressable> {
    public int size ();
    public Iterator<Addressable> iterator ();
    public void add (Addressable addressable) throws Exception;
    public void remove (Addressable addressable) throws Exception;
    public boolean found  (Addressable addressable);
}
