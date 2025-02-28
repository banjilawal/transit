package com.lawal.transit.global;

import com.lawal.transit.address.model.Address;

import java.time.*;

public interface Trackable {

    public Address address ();
    public LocalDateTime time ();
}