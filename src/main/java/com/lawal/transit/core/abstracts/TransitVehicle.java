package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Departure;
import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.enums.GlobalConstant;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class TransitVehicle extends Traveler {
    private int capacity;
    private Station nextStation;

    public TransitVehicle(int id, String name, Station currentStation) {
        this(id, name, currentStation, new Departure(id, currentStation), GlobalConstant.STANDARD_BUS_CAPACITY);
    }

    public TransitVehicle(int id, String name, Location currentLocation, Departure departure, int capacity) {
        super(id, name, currentLocation, departure);
        this.capacity = capacity;
        this.nextStation = null;
        this.setState(State.DOORS_CLOSED);
    }

    public int getCapacity () {
        return capacity;
    }

    public Station getNextStation () {
        return nextStation;
    }

    public void setCapacity (int capacity) {
        this.capacity = capacity;
    }

    public void setNextStation (Station nextStation) throws InterruptedException {
        this.nextStation = nextStation;
        accelerating();
    }

    public void stopped () throws InterruptedException {
        setState(State.STOPPED);
        openingDoors();
    }

    public void openingDoors () throws InterruptedException {
        setState(State.OPENING_DOORS);
        Thread.sleep(GlobalConstant.DOOR_OPENING_SECONDS * 1000);
        doorsOpen();
    }

    public void doorsOpen () throws InterruptedException {
        setState(State.DOORS_OPEN);
        Thread.sleep(GlobalConstant.DOOR_OPEN_SECONDS * 1000);
        closingDoors();
    }

    public void closingDoors () throws InterruptedException {
        setState(State.CLOSING_DOORS);
        Thread.sleep(GlobalConstant.DOOR_CLOSING_SECONDS * 1000);
    }

    public void doorsClosed () throws InterruptedException {
        setState(State.DOORS_CLOSED);
        Thread.sleep(GlobalConstant.DOOR_CLOSED_SECONDS * 1000);
        accelerating();
    }

    public void accelerating () throws InterruptedException {
        setState(State.ACCELERATING);
        Thread.sleep(GlobalConstant.ACCELERATION_SECONDS * 1000);
        cruising();
    }

    public void cruising () throws InterruptedException {
        setState(State.CRUISING);
        Thread.sleep(GlobalConstant.REGULAR_MAXIMUM_INTERARRIVAL_TIME * 1000);
        decelerating();
    }


    public void decelerating () throws InterruptedException {
        setState(State.DECELERATING);
        Thread.sleep(GlobalConstant.DECELERATION_SECONDS * 1000);
        stopped();
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof TransitVehicle vehicle) {
            return super.equals(vehicle) && getCurrentLocation().equals(vehicle.getCurrentLocation())
                    && nextStation.equals(vehicle.getNextStation()) && capacity == vehicle.getCapacity();
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), capacity);
    }

    @Override
    public String toString () {
        return super.toString() + " capacity:" + capacity;
    }
} // end class TransitVehicle
