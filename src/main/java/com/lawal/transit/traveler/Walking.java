package com.lawal.transit.traveler;

import com.lawal.transit.places.*;
import com.lawal.transit.stations.interfaces.*;

public interface Walking {

   public void walkTo (Stationable station);
   public void walkTo (Addressable addressable);
}
