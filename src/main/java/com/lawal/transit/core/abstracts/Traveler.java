package com.lawal.transit.core.abstracts;

import java.util.Objects;

public abstract class Traveler extends NamedEntity {

    private enum State {
        STOPPED, MOVING, ARRIVED, DEPARTING, EMBARKING, DISEMBARKING, ACCELERATING, DECELERATING, DOORS_OPEN, DOORS_CLOSED, WAITING, RIDING;

        public String print () {
            return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
        }
    } // end enum State

    private Location currentLocation;
    private Departure departure;
    private Arrival arrival;
    private State state;

    public Traveler(int id, String name, Location currentLocation, Departure departure) {
        this(id, name, currentLocation, departure, null);
    }

    public Traveler(int id, String name, Location currentLocation, Departure departure, Arrival arrival) {
        super(id, name);
        this.currentLocation = currentLocation;
        this.departure = departure;
        this.arrival = arrival;
        this.state = State.STOPPED;
    }

    public Location getCurrentLocation () { return currentLocation; };
    public Departure getDeparture() {
        return departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public State getState () { return state; }

    public abstract void setCurrentLocation (Location currentLocation);

    public void setDeparture (Departure departure) {
        this.departure = departure;
    }

    public void setArrival (Arrival arrival) {
        this.arrival = arrival;
    }

    public void setState (State state) { this.state = state; }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Traveler traveler)
            return super.equals(traveler)
                && departure.equals(traveler.getDeparture())
                && arrival.equals(traveler.getArrival())
                && state.equals(traveler.getState());
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departure, arrival, state);
    }

    @Override
    public String toString () {
        return super.toString() + " " + departure.toString() + state.toString();
    }

} // end class Traveler
