package com.lawal.transit.core.singletons;

import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.collections.GraphableBag;
import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.enums.Direction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Stations {
    INSTANCE;
    public final GraphableBag<Station> stations; // = new GraphableBag<Station>();

    Stations () {
        ArrayList<Direction> neighborDirections = getNeighborDirections();
        this.stations = new GraphableBag<Station>(neighborDirections);
    }

    private ArrayList<Direction> getNeighborDirections () {
        ArrayList<Direction> neighborDirections = new ArrayList<Direction>();
        neighborDirections.add(neighborDirections.size(), Direction.NORTH);
        neighborDirections.add(neighborDirections.size(), Direction.EAST);
        neighborDirections.add(neighborDirections.size(), Direction.SOUTH);
        neighborDirections.add(neighborDirections.size(), Direction.WEST);
        return neighborDirections;
    } //

    public Bag<Station> getStations () {
        return stations;
    } // close getBag

//    public Iterator<Station> search (Predicate<Station> predicate) {
//        ArrayList<Station> stations = new ArrayList<Station>();
//        for (Station station : this.stations.getContents()) {
//            if (predicate.test(station)) {
//                stations.add(stations.size(), station);
//            }
//        }
//        return stations.iterator();
//    } // close search
} // end class Stations
