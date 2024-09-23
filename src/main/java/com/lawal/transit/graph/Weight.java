package com.lawal.transit.graph;

import com.lawal.transit.graph.interfaces.Weightable;
import lombok.Data;
import lombok.Setter;

import java.util.*;
@Data
public class Weight implements Weightable {

    public static final String SET_WEIGHT_VALUE_ERROR = "Value to a negative number";
    private int distance;
    private int travelTime;
    private int waitingTime;
    private int heuristic;

//    private Weight (Builder builder) {
//        this.distance = builder.distance;
//        this.travelTime = builder.travelTime;
//        this.waitingTime = builder.waitingTime;
//        this.heuristic = builder.heuristic;
//    }
//
//    @Override
//    public int getDistance () {
//        return distance;
//    }
//
//    @Override
//    public int getTravelTime () {
//        return travelTime;
//    }
//
//    @Override
//    public int getWaitingTime () {
//        return waitingTime;
//    }
//
//    @Override
//    public void setDistance ( int distance){
//        this.distance = distance;
//    }
//
//    @Override
//    public void setTravelTime ( int travelTime){
//        this.travelTime = travelTime;
//    }
//
//    @Override
//    public void setWaitingTime ( int waitingTime){
//        this.waitingTime = waitingTime;
//    }
//
//    @Setter
//    public void setHeuristic (int heuristic){
//        this.heuristic = heuristic;
//    }
//
//    @Override
//    public int getHeuristic () {
//        return heuristic;
//    }
//
//    @Override
//    public boolean equals (Object object){
//        if (this == object) return true;
//        if (object == null) return false;
//        if (object instanceof Weightable weightable)
//            return distance == weightable.getDistance() && travelTime == weightable.getTravelTime()
//                && waitingTime == weightable.getWaitingTime();
//        return false;
//    }
//
//    @Override
//    public int hashCode () {
//        return Objects.hash(distance, waitingTime, travelTime);
//    }
//
//    @Override
//    public String toString () {
//        return getClass().getSimpleName() + " distance:" + distance + " travelTime:" + travelTime + " waitingTime:" + waitingTime;
//    }
//
//
//    public static Builder builder () {
//        return new Builder();
//    }
//
//    public static class Builder {
//        private int distance;
//        private int travelTime;
//        private int waitingTime;
//        private int heuristic;
//
//
//        public Builder distance (int distance) {
//            this.distance = distance;
//            return this;
//        }
//
//        public Builder travelTime (int travelTime) {
//            this.travelTime = travelTime;
//            return this;
//        }
//
//        public Builder waitingTime (int waitingTime) {
//            this.waitingTime = waitingTime;
//            return this;
//        }
//
//        public Weight build () {
//            heuristic = distance + waitingTime + travelTime;
//            return new Weight(this);
//        }
//    }
}