package com.lawal.transit.sections.interfaces;

import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.sections.interfaces.*;

import java.util.*;

public interface BorderCollection {

    public int numberOfBorders ();
    public Iterator<Borderable> iterator ();

    public Borderable seacrh (RoadLabeler roadLabeler);

    public Borderable search (Orientation orientation);
    public void add (Borderable borderable) throws Exception;
    public void remove (Borderable borderable) throws Exception;
    public Borderable find (Orientation orientation);
}
