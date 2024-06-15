package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.concretes.OldAbstractStation;
import com.lawal.transit.core.enums.*;
import com.lawal.transit.core.global.Constant;

import java.util.Objects;

public abstract class Vehicle extends Traveler {
    VehicleState state;
    private int capacity;
    private OldAbstractStation nextOldAbstractStation;

    public Vehicle (int id, String name, OldAbstractStation currentOldAbstractStation) {
        this(id, name, currentOldAbstractStation, new Departure(id, currentOldAbstractStation), Constant.STANDARD_BUS_CAPACITY);
        this.state = VehicleState.ENGINE_RUNNING;
    }

    public Vehicle (int id, String name, AbstractLocation currentAbstractLocation, Departure departure, int capacity) {
        super(id, name, currentAbstractLocation, departure);
        this.capacity = capacity;
        this.nextOldAbstractStation = null;
        this.setState(State.DOORS_CLOSED);
    }

    public int getCapacity () {
        return capacity;
    }

    public OldAbstractStation getNextStation () {
        return nextOldAbstractStation;
    }

    public void setCapacity (int capacity) {
        this.capacity = capacity;
    }

    public void setNextStation (OldAbstractStation nextOldAbstractStation) throws InterruptedException {
        this.nextOldAbstractStation = nextOldAbstractStation;
        accelerating();
    }

    public void stopped () throws InterruptedException {
        setState(State.STOPPED);
        openingDoors();
    }

    public void openingDoors () throws InterruptedException {
        setState(State.OPENING_DOORS);
        Thread.sleep(Constant.DOOR_OPENING_SECONDS * 1000);
        doorsOpen();
    }

    public void doorsOpen () throws InterruptedException {
        setState(State.DOORS_OPEN);
        Thread.sleep(Constant.DOOR_OPEN_SECONDS * 1000);
        closingDoors();
    }

    public void closingDoors () throws InterruptedException {
        setState(State.CLOSING_DOORS);
        Thread.sleep(Constant.DOOR_CLOSING_SECONDS * 1000);
    }

    public void doorsClosed () throws InterruptedException {
        setState(State.DOORS_CLOSED);
        Thread.sleep(Constant.DOOR_CLOSED_SECONDS * 1000);
        accelerating();
    }

    public void accelerating () throws InterruptedException {
        setState(State.ACCELERATING);
        Thread.sleep(Constant.ACCELERATION_SECONDS * 1000);
        cruising();
    }

    public void cruising () throws InterruptedException {
        setState(State.CRUISING);
        Thread.sleep(Constant.REGULAR_MAXIMUM_INTERARRIVAL_TIME * 1000);
        decelerating();
    }


    public void decelerating () throws InterruptedException {
        setState(State.DECELERATING);
        Thread.sleep(Constant.DECELERATION_SECONDS * 1000);
        stopped();
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Vehicle vehicle) {
            return super.equals(vehicle) && getCurrentLocation().equals(vehicle.getCurrentLocation())
                    && nextOldAbstractStation.equals(vehicle.getNextStation()) && capacity == vehicle.getCapacity();
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
} // end class Vehicle
