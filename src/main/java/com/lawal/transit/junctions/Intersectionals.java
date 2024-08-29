package com.lawal.transit.junctions;

import java.util.*;

public interface Intersectionals {
    int size ();
    Iterator<Intersectional> iterator ();
    void add (Intersectional intersectional) throws Exception;
    void remove (int intersectionId) throws Exception;
    Intersectional search (int intersectionId);
    Intersectional next (int currentIntersectionId);
    Intersectional previous (int currentIntersectionId);
}
