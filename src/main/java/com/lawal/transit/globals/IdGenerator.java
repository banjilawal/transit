package com.lawal.transit.globals;

public enum IdGenerator {
    INSTANCE;

    private int scheduleId = 1;
    private int avenueId = 1;
    private int streetId = 1;
    private int stationId = 1;
    private int busId = 1;
    private int placeId =1;
    private int edgeId = 1;
    private int junctionId = 1;
    private int stationCounter = 1;

    public int nextScheduleId () {
        return scheduleId++;
    }

    public int nextAvenueId () {
        return avenueId++;
    }

    public int nextStreetId () {
 //       System.out.println("streetId: " + streetId);
        return streetId++;
    }

    public int nextStationID () {
        return stationId++;
    }

    public int nextBusId () {
        return busId++;
    }

    public int nextPlaceId () { return placeId++; }

    public int nextEdgeId () {
        return edgeId++;
    }

    public int nextJunctionId () { return junctionId++; }

    public int stationCount () { return stationCounter++; }
}