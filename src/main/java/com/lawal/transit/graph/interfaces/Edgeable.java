package com.lawal.transit.graph.interfaces;

import com.lawal.transit.graph.EdgeCategory;
import com.lawal.transit.road.interfaces.RoadIdentifier;

import java.util.ArrayList;

public interface Edgeable {

    int id ();
    Vertex head ();
    Vertex tail ();
    Weightable weight ();
    ArrayList<EdgeCategory> categories ();
    RoadIdentifier roadLabel ();
}