package com.lawal.transit.transport;

import com.lawal.transit.globals.*;
import com.lawal.transit.transport.interfaces.*;
import com.lawal.transit.traveler.*;

public class Disembark implements Disembarkation {

    @Override
    public void disembark (Vehicle vehicle, Journey traveler, Positionable disembarkationPoint) {
        traveler.setLocation(disembarkationPoint);
        vehicle.dequeue(traveler);
    }
}
