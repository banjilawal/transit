package com.lawal.transit.core.singletons;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.containers.Bag;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;

public enum Roads implements BagWrapper<Road> {
    INSTANCE;
    private Bag<Road> roads = new Bag<Road>();

    @Override
    public int size () { return roads.size(); }

    @Override
    public Bag<Road> getBag () {
        return roads;
    }

    @Override
    public ArrayList<Road> getBagContents() { return roads.getContents(); }

    @Override
    public void add (Road road) { roads.add(road); }

    @Override
    public void remove (Road road) { roads.remove(road); }

    @Override
    public Iterator<Road> iterator () { return roads.getContents().iterator(); }

    public Road search (String roadName) {
        Road road = Avenues.INSTANCE.getBag().search(roadName);
        if (road == null) {
            road = Streets.INSTANCE.getBag().search(roadName);
        }
        return road;
    } // close search


    public String toString () {
        return "\t\t\tRoads\n\t\t--------------" //\n"
                + Avenues.INSTANCE.getBag().toString()
                + "\n" + Streets.INSTANCE.getBag().toString();
    } //close toString
} // end class Roads
