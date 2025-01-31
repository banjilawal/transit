package com.lawal.transit.traveler;

import com.lawal.transit.global.*;

import java.time.*;

public record Position(Address address, LocalDateTime time) implements Trackable{

//    @Override
//    public boolean equals (Object object) {
//        if (object == this) return true;
//        if (object == null) return false;
//        if (object instanceof Trackable positionable) {
//            return address.equals(positionable.address()) && time.equals(positionable.time());
//        }
//        return false;
//    }
//
//    @Override
//    public String toString () {
//        return getClass().getSimpleName() + ":" + address.toString() + " time:" + time.toString();
//    }
}