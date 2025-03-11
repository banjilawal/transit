package com.lawal.transit.global;

import com.lawal.transit.house.model.House;

import java.time.*;

public interface Trackable {

    public House address ();
    public LocalDateTime time ();
}