package com.lawal.transitcraft.common;

import com.lawal.transitcraft.infrastructure.house.House;

import java.time.*;

public interface Trackable {

    public House address ();
    public LocalDateTime time ();
}