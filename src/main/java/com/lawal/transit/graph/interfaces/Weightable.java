package com.lawal.transit.graph.interfaces;

public interface Weightable {
    
    int getTravelTime ();
    int getWaitingTime ();
    int getDistance ();
    int getHeuristic();

    void setTravelTime (int travelTime);
    void setWaitingTime (int waitingTime);
    void setDistance (int distance);


}