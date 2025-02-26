package com.lawal.transit.graph.contract;

import com.lawal.transit.graph.EdgeCategory;
import com.lawal.transit.road.RoadLabel;

import java.util.ArrayList;

public interface Edgeable {

    int id ();
    Vertex head ();
    Vertex tail ();
    Weightable weight ();
    ArrayList<EdgeCategory> categories ();
}