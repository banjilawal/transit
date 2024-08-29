package com.lawal.transit.transport.interfaces;

import com.lawal.transit.stations.interfaces.*;
import com.lawal.transit.transport.interfaces.*;

public interface PassengerFlowQueue {

    public void setVehicle (Vehicle vehicle);
    public void setStation (Stationable station);
    public void embark ();
    public void disembark ();

}
