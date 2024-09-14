package com.lawal.transit.traveler;

import com.lawal.transit.graph.Vertex;
import com.lawal.transit.places.*;


public interface Walking {

   public void walkTo (Vertex vertex);
   public void walkTo (Addressable addressable);
}