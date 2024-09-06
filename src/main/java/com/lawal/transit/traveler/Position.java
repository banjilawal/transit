package com.lawal.transit.traveler;

import com.lawal.transit.globals.*;
import com.lawal.transit.addressing.*;

import java.time.*;

public record Position(FormattedAddress address, LocalDateTime time) implements Positionable {

//    @Override
//    public boolean equals (Object object) {
//        if (object == this) return true;
//        if (object == null) return false;
//        if (object instanceof Positionable positionable) {
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