package com.lawal.transit.core.interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public interface DiGraphable<T> {
    public Iterator<T> getIncomingNeighbors ();
    public void addIncomingNeighbors (ArrayList<T> neighbors);
    public void addIncomingNeighbor (T neighbor);
    public void removeIncomingNeighbors (ArrayList<T> neighbors);
    public void removeIncomingNeighbor (T neighbor);

    public Iterator<T> getOutgoingNeighbors ();
    public void addOutgoingNeighbors (ArrayList<T> neighbors);
    public void addOutgoingNeighbor (T neighbor);
    public void removeOutgoingNeighbors (ArrayList<T> neighbors);
    public void removeOutgoingNeighbor (T neighbor);
} // end interface DiGraphable
