package com.lawal.transit.transport;

import com.lawal.transit.traveler.*;

import java.util.*;

public class Riders {

    private ArrayList<Traveler> riders;

    public Riders () {
        riders = new ArrayList<>();
    }

    public ArrayList<Traveler> getRiders() {
        return riders;
    }

    public void add (Traveler traveler) throws Exception {
        if (riders.contains(traveler))
            throw new Exception("The rider is already seated");
        riders.add(riders.size(), traveler);
    }

}
