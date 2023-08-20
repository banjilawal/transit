package com.lawal.transit.core.interfaces;

import com.lawal.transit.core.entities.Station;
import com.lawal.transit.core.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public interface DiGraphable<T> {
    public HashMap<Direction, T> getIncomingNeighbors ();
    public HashMap<Direction, T> getOutgoingNeighbors ();

    public void setOutgoingNeighbors ();
    public void setIncomingNeighbors ();
    public void addOutGoingNeighbor (T t);
    public void addIncomigNeighbor (T t);
} // end interface DiGraphable
