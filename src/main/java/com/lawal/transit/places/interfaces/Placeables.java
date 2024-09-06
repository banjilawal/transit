package com.lawal.transit.places.interfaces;

import java.util.*;

public interface Placeables {

    int size ();
    Iterator<Placeable> iterator ();
    void add (Placeable placeable)  throws Exception;
    void remove (int placeId) throws Exception;
    Placeable search (int placeId);
    Placeable search (String placeName);
}