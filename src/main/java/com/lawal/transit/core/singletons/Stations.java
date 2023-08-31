package com.lawal.transit.core.singletons;

import com.lawal.transit.core.containers.Bag;
import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;

public enum Stations implements BagWrapper<Station> {
    INSTANCE;
    private final Bag<Station> stations = new Bag<Station>();

    @Override
    public int size() {
        return stations.size();
    }

    @Override
    public void add(Station station) {
        stations.add(station);
    }

    @Override
    public void remove(Station station) {
        stations.remove(station);
    }

    @Override
    public Bag<Station> getBag() {
        return stations;
    }

    @Override
    public Iterator<Station> iterator() {
        return stations.iterator();
    }

    @Override
    public ArrayList<Station> getBagContents() {
        return stations.getContents();
    }


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
