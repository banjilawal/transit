package com.lawal.transit.core.facade;
/*
import com.lawal.transit.middleware.concretes.Address;
import com.lawal.transit.middleware.abstracts.TwoWayRoad;
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.concretes.OldAbstractStation;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.enums.TransitRouteCategory;
import com.lawal.transit.middleware.enums.Orientation;

import java.time.LocalTime;

public abstract class DataTransfer {
    private int arteryId;
    private String arteryName;
    private RoadCategory roadCategory;
    private Orientation rightLaneOrientation;
    private Orientation leftLaneOrientation;
    private int addressId;
    private String addressName;
    private TwoWayRoad addressRoad;
    private Orientation addressOrientation;
    private int stationId;
    private String stationName;
    private TwoWayRoad stationRoad;
    private TwoWayRoad stationCrossRoad;
    private Orientation stationDirection;

    private int busRouteId;
    private String busRouteName;
    private LocalTime busRouteStartTime;
    private LocalTime busRouteEndTime;
    private int busRouteInterArrivalTime;
    private TransitRouteCategory busRouteCategory;


    public DataTransfer () {
        reset();
    } // close reset

    public int getRoadId () {
        return arteryId;
    } // close getRoadId

    public String getRoadName () {
        return arteryName;
    } // close getRoadId

    public RoadCategory getRoadCategory () {
        return roadCategory;
    } // close getRoadCategory

    public Orientation getLeftLaneOrientation () {
        return leftLaneOrientation;
    } // close getLeftLaneOrientation

    public Orientation geRightLaneOrientation () {
        return rightLaneOrientation;
    } // close getRightLaneOrientation



    public void setArteryId (int roadId) {
       this.arteryId = roadId;
    } // close setRoadId

    public void setArteryName (String roadName) {
        this.arteryName = roadName;
    } // close setRoadId

    public void setArteryCategory (RoadCategory roadCategory) {
       this.roadCategory = roadCategory;
    } // close setRoadCategory

    public void setLeftLaneOrientation (Orientation leftLaneOrientation) {
        this.leftLaneOrientation = leftLaneOrientation;
    } // close setLeftLaneOrientation

    public void setRightLaneOrientation (Orientation rightLaneOrientation) {
        this.rightLaneOrientation = rightLaneOrientation;
    } // close setRightLaneOrientation


    public void setArteryFields (TwoWayRoad road) {
        arteryId = road.getId();
        arteryName = road.getName();
        roadCategory = road.getCategory();
        leftLaneOrientation = road.getLeftLane();
        rightLaneOrientation = road.getRightLane();
    } // close setRoadFields

   public int getAddressId () {
        return addressId;
   }
   public  String getAddressName () {
       return addressName;
   }

   public TwoWayRoad getAddressRoad () {
       return addressRoad;
   }
   public Orientation getAddressOrientation () {
       return addressOrientation;
   }

   public void setAddressId (int addressId) {
       this.addressId = addressId;
   }
   public void setAddressNAme (String addressName) {
       this.addressName = addressName;
   }

    public void setAddressRoad (TwoWayRoad addressRoad) {
        this.addressRoad = addressRoad;
    } // close setAddressRoad

    public void setAddressOrientation (Orientation addressOrientation) {
        this.addressOrientation = addressOrientation;
    } // close setAddressOrientation

    public void setAddressFields (Address address) {
        addressId = address.getId();
        addressName = address.getName();
        addressRoad = address.getArtery();
        addressOrientation = address.getOrientation();
    } // close setAddressFields

    public int getStationID () {
        return stationId;
    }

    public String getStationName () {
        return stationName;
    }

    public TwoWayRoad getStationArtery () {
        return stationRoad;
    }
    public TwoWayRoad getStationCrossRoad () {
        return stationCrossRoad;
    }
    public Orientation getStationDirection () {
        return stationDirection;
    }

    public void setStationId (int stationId) {
        this.stationId = stationId;
    }

    public void setStationName (String stationName) {
        this.stationName = stationName;
    }
    public void setStationArtery (TwoWayRoad stationRoad) {
        this.stationRoad = stationRoad;
    }
    public void setStationCrossRoad (TwoWayRoad stationCrossRoad) {
        this.stationCrossRoad = stationCrossRoad;
    }
    public void setStationDirection (Orientation stationDirection) {
        this.stationDirection = stationDirection;
    }

    public void setStationFields (OldAbstractStation station) {
        stationId = station.getId();
        stationName = station.getName();
        stationCrossRoad =  station.getCrossRoad();
        stationRoad = station.getArtery();
        stationDirection = station.getOrientation();
    } // close setStationFields

    public int getBusRouteId () {
        return this.busRouteId;
    } // close getRoadId

    public String getBusRouteName () {
        return this.busRouteName;
    } // close getRoadId

    public LocalTime getBusRouteStartTime () {
        return this.busRouteStartTime;
    }  // close getBusLineStartTime

    public LocalTime getBusRouteEndTime () {
        return this.busRouteEndTime;
    } // close getBusLineStartTime

    public int getBusRouteInterArrivalTime () {
        return this.busRouteInterArrivalTime;
    } // close getBusLineStartTime

    public TransitRouteCategory getBusRouteCategory () {
        return this.busRouteCategory;
    } // getBusLineCategory

    public void setBusRouteId (int busRouteId) {
        this.busRouteId = busRouteId;
    } // close setRoadId

    public void setBusRouteName (String busRouteName) {
        this.busRouteName = busRouteName;
    } // close setRoadId

    public void setBusRouteStartTime (LocalTime busRouteStartTime) {
        this.busRouteStartTime = busRouteStartTime;
    }  // close setBusLineStartTime

    public void  setBusRouteEndTime (LocalTime busRouteEndTime) {
        this.busRouteEndTime = busRouteEndTime;
    } // close setBusLineStartTime

    public void setBusRouteInterArrivalTime (int busRouteInterArrivalTime) {
        this.busRouteInterArrivalTime = busRouteInterArrivalTime;
    } // close setBusLineStartTime

    public void setBusRouteCategory (TransitRouteCategory busRouteCategory) {
        this.busRouteCategory = busRouteCategory;
    } // setBusLineCategory

   public void setBusRouteFields (TransitRoute transitRoute) {
       busRouteId = transitRoute.getId();
       busRouteName = transitRoute.getName();
       busRouteStartTime = transitRoute.getStartTime();
       busRouteEndTime = transitRoute.getEndTime();
       busRouteInterArrivalTime = transitRoute.getInterArrivalTime();
       busRouteCategory = transitRoute.getCategory();
   }  // close setBusLineFields

    public void reset () {
        arteryId = Integer.MIN_VALUE;
        arteryName = "None";
        roadCategory = RoadCategory.NONE;
        leftLaneOrientation = Orientation.NONE;
        rightLaneOrientation = Orientation.NONE;

        addressId = Integer.MIN_VALUE;
        addressName = "None";
        addressRoad = null;
        addressOrientation = Orientation.NONE;

        stationId = Integer.MIN_VALUE;
        stationName = "None";
        stationCrossRoad = null;
        stationRoad = null;
        stationDirection = Orientation.NONE;

        busRouteId = Integer.MIN_VALUE;
        busRouteName = "None";
        busRouteStartTime = null;
        busRouteEndTime = null;
        busRouteInterArrivalTime = Integer.MIN_VALUE;
        busRouteCategory = TransitRouteCategory.NONE;
    } // close reset
} // end class RoadDataTransfer
*/