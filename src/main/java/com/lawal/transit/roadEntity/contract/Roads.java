package com.lawal.transit.roadEntity.contract;

import java.util.*;

public interface Roads {

    public int size ();
    public Iterator<RoadEntity> iterator();
    public void add (RoadEntity roadEntity) throws Exception;
    public RoadEntity search (int roadId);
    public RoadEntity search (String roadName);
    public void remove (int roadId) throws Exception;
}