package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.Arrival;
import com.lawal.transit.core.concretes.Departure;

import java.util.Objects;

public abstract class Traveler extends NamedEntity {

    public enum State {
        STOPPED, CRUISING, ARRIVED, EMBARKING, DISEMBARKING, ACCELERATING, DECELERATING,
        OPENING_DOORS, DOORS_OPEN, CLOSING_DOORS, DOORS_CLOSED, WAITING, RIDING;

        public String print () {
            return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
        }
    } // end enum VertexColor

    private AbstractLocation currentAbstractLocation;
    private Departure departure;
    private Arrival arrival;
    private State state;

    public Traveler(int id, String name, AbstractLocation currentAbstractLocation) {
        this(id, name, currentAbstractLocation, new Departure(id, currentAbstractLocation), null);
    }

    public Traveler(int id, String name, AbstractLocation currentAbstractLocation, Departure departure) {
        this(id, name, currentAbstractLocation, departure, null);
    }

    public Traveler(int id, String name, AbstractLocation currentAbstractLocation, Departure departure, Arrival arrival) {
        super(id, name);
        this.currentAbstractLocation = currentAbstractLocation;
        this.departure = departure;
        this.arrival = arrival;
        this.state = State.STOPPED;
    }

    public AbstractLocation getCurrentLocation () { return currentAbstractLocation; };
    public Departure getDeparture() {
        return departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public State getState () { return state; }

    public void setCurrentLocation (AbstractLocation currentAbstractLocation) { this.currentAbstractLocation = currentAbstractLocation; }

    public void setDeparture (Departure departure) {
        this.departure = departure;
    }

    public void setArrival (Arrival arrival) {
        this.arrival = arrival;
    }

    public void setState (State state) { this.state = state; }

    public abstract void arriving ();
    public abstract void departing ();

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
