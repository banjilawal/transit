package com.lawal.transit.core.entities;

public class ArrivalSet {
    /*
    private int busRouteId;
    private int stationId;
    private ArrayList<LocalTime> arrivalTimes;

    public ArrivalSet (int busRouteId, int stationId) {
        this.busRouteId = busRouteId;
        this.stationId = stationId;
        this.arrivalTimes = new ArrayList<LocalTime>();
    } // close constructor

    //---------- Getters ---------//
    public int getBusRouteId () {
        return busRouteId;
    }

    public int getStationId () {
        return stationId;
    }

    public ArrayList<LocalTime> getArrivalTimes () {
        return this.arrivalTimes;
    }

    //---------- Setters ---------//
    public void setBusRouteId (int busRouteId) {
        this.busRouteId = busRouteId;
    }

    public void setStationId (int stationId) {
        this.stationId = stationId;
    }

    public void setArrivalTimes (ArrayList<LocalTime> arrivalTimes) {
        this.arrivalTimes = arrivalTimes;
    }

    //---------- Overrides ---------//
    @Override
    public boolean equals (Object object) {
        boolean isEqual = false;

        if (object instanceof ArrivalSet) {
           ArrivalSet arrivalSet = (ArrivalSet) object;

           if (this.busRouteId == arrivalSet.getBusRouteId() && this.stationId == arrivalSet.getStationId()) {
               if (this.sameArrivalTimes(arrivalSet) && arrivalSet.sameArrivalTimes(this) {
                   isEqual = true;
               }
           }
        }
        return isEqual;
    } // close equals

    public boolean addArrivalTime (LocalTime arrivalTime) {
        if (this.arrivalTimes.contains(arrivalTime)) {
            return false;
        }
        return arrivalTimes.add(arrivalTime);
    } // close addArrivalTime

    @Override
    public int hashCode () {
        return Objects.hash(busRouteId, stationId, arrivalTimes);
    } // close hashCode

    //---------- Helpers ---------//
    public boolean sameArrivalTimes (ArrivalSet arrivalSet) {
        for (LocalTime arrival : this.arrivalTimes) {
            if (!arrivalSet.getArrivalTimes().contains(arrival)) {
                return false;
            }
        }
        return true;
    } // close target

     */
} // end class ExpectedStationArrival
