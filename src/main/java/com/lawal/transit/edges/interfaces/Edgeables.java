package com.lawal.transit.edges.interfaces;

import java.util.*;

public interface Edgeables {

    int getDegree ();
    Iterator<Edgeable> iterator ();
    void add (Edgeable edgeable) throws Exception;
    void remove (int edgeId) throws Exception;
}