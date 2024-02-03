package com.lawal.transit.core.interfaces;

import com.lawal.transit.core.enums.Direction;

import java.util.HashMap;

public interface DiGraphable<T> {
    public HashMap<Direction, T> getIncomingNeighbors ();
    public HashMap<Direction, T> getOutgoingNeighbors ();

    public void setOutgoingNeighbors ();
    public void setIncomingNeighbors ();
    public void addOutGoingNeighbor (T t);
    public void addIncomigNeighbor (T t);
} // end interface DiGraphable
