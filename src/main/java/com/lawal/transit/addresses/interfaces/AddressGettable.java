package com.lawal.transit.addresses.interfaces;

import com.lawal.transit.addresses.*;

public interface AddressGettable<T> extends GenericGettable<T> {
    public T getAddress ();
}
