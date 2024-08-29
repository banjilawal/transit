package com.lawal.transit.stations.interfaces;

import java.util.*;

public interface Stationables {

    int size ();
    ArrayList<Stationable> get ();
    Iterator<Stationable> iterator ();
    Stationable search (int stationId);
    Stationable search (String stationName);
    Stationable next (int currenStationId);
    Stationable previous (int currentStationId);
    void add (Stationable stationable) throws Exception;
    void remove (int stationId) throws Exception;
}
