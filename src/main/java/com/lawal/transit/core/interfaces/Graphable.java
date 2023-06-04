package com.lawal.transit.core.interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public interface Graphable<T> {
    public Iterator<T> getNeighbors ();
    public void addNeighbors (ArrayList<T> neighbors);
    public void addNeighbor (T neighbor);
    public void removeNeighbors (ArrayList<T> neighbors);
    public void removeNeighbor (T neighbor);
} // end interface Graphable
