package com.lawal.transit.global;

import java.time.*;

public interface Trackable {

    public Address address ();
    public LocalDateTime time ();
}