package com.lawal.transit.junction;

import java.util.*;

public interface JunctionEntities {

    int size ();
    Iterator<JunctionEntity> iterator ();
    void add (JunctionEntity junctionEntity) throws Exception;
    void remove (int intersectionId) throws Exception;
    JunctionEntity search (int junctionId);
    JunctionEntity next (int junctionId);
    JunctionEntity previous (int junctionId);
}