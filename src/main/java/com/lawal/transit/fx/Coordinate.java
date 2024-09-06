//package com.lawal.transit.fx;
//
//import java.util.*;
//
//public final class Coordinate {
//    private double x;
//    private double y;
//
//    public Coordinate (double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public double getX () {
//        return x;
//    }
//
//    public double getY () {
//        return y;
//    }
//
//    public void setX (double x) {
//        this.x = x;
//    }
//
//    public void setY (double y) {
//        this.y = y;
//    }
//
//    @Override
//    public boolean equals (Object object) {
//        if (this == object) return true;
//        if (object == null) return false;
//        if (object instanceof Coordinate coordinate)
//            return x == coordinate.getX() && y == coordinate.getY();
//        return false;
//    }
//
//    @Override
//    public int hashCode () {
//        return Objects.hash(x, y);
//    }
//
//    @Override
//    public String toString () {
//        return getClass().getSimpleName() + ":(" + x + ", " + y + ")";
//    }
//}