package com.lawal.transit.common;

import com.lawal.transit.infrastructure.house.House;

import java.time.*;

public interface Trackable {

    public House address ();
    public LocalDateTime time ();
}