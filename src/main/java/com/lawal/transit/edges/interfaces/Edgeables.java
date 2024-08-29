package com.lawal.transit.edges.interfaces;

import java.util.*;

public interface Edgeables {

    public int getDegree ();
    public Iterator<Edgeable> iterator ();
    public void add (Edgeable edgeable) throws Exception;
    public void remove (Edgeable edgeable) throws Exception;
}
