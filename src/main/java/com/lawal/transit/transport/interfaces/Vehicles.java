package com.lawal.transit.transport.interfaces;

import java.util.*;

public interface Vehicles {

    public void add (int id, int capacity) throws Exception;
    public void remove (int id) throws Exception;
    public Iterator<Vehicle> iterator ();
}
