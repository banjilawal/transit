package com.lawal.transit.globals;

import com.lawal.transit.globals.*;

import java.util.*;

public interface AddressableCollection {

    public int size ();
    public Iterator<Addressable> iterator ();
    public void add (Addressable addressGetter) throws Exception;
    public void remove (Addressable addressGetter) throws Exception;
    public Addressable search (FormattedAddress addressable);
}
