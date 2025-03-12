//package com.lawal.transit.traveler;
//
//import com.lawal.transit.house.model.House;
//import com.lawal.transit.global.*;
//
//import java.time.*;
//
//public record Position(House house, LocalDateTime time) implements Trackable{
//
////    @Override
//    public boolean equals (Object object) {
//        if (object == this) return true;
//        if (object == null) return false;
//        if (object instanceof Trackable positionable) {
//            return house.equals(positionable.house()) && time.equals(positionable.time());
//        }
//        return false;
//    }
//
//    @Override
//    public String toString () {
//        return getClass().getSimpleName() + ":" + house.toString() + " time:" + time.toString();
//    }
//}