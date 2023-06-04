package com.lawal.transit.core.facade;
/*
import com.lawal.transit.middleware.entities.Address;
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.entities.Station;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.enums.TransitRouteCategory;
import com.lawal.transit.middleware.enums.Direction;

import java.time.LocalTime;

public abstract class DataTransfer {
    private int arteryId;
    private String arteryName;
    private RoadCategory roadCategory;
    private Direction rightLaneOrientation;
    private Direction leftLaneOrientation;
    private int addressId;
    private String addressName;
    private Road addressRoad;
    private Direction addressOrientation;
    private int stationId;
    private String stationName;
    private Road stationRoad;
    private Road stationCrossRoad;
    private Direction stationDirection;

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

    public Direction getLeftLaneOrientation () {
        return leftLaneOrientation;
    } // close getLeftLaneOrientation

    public Direction geRightLaneOrientation () {
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

    public void setLeftLaneOrientation (Direction leftLaneOrientation) {
        this.leftLaneOrientation = leftLaneOrientation;
    } // close setLeftLaneOrientation

    public void setRightLaneOrientation (Direction rightLaneOrientation) {
        this.rightLaneOrientation = rightLaneOrientation;
    } // close setRightLaneOrientation


    public void setArteryFields (Road road) {
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

   public Road getAddressRoad () {
       return addressRoad;
   }
   public Direction getAddressOrientation () {
       return addressOrientation;
   }

   public void setAddressId (int addressId) {
       this.addressId = addressId;
   }
   public void setAddressNAme (String addressName) {
       this.addressName = addressName;
   }

    public void setAddressRoad (Road addressRoad) {
        this.addressRoad = addressRoad;
    } // close setAddressRoad

    public void setAddressOrientation (Direction addressOrientation) {
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

    public Road getStationArtery () {
        return stationRoad;
    }
    public Road getStationCrossRoad () {
        return stationCrossRoad;
    }
    public Direction getStationDirection () {
        return stationDirection;
    }

    public void setStationId (int stationId) {
        this.stationId = stationId;
    }

    public void setStationName (String stationName) {
        this.stationName = stationName;
    }
    public void setStationArtery (Road stationRoad) {
        this.stationRoad = stationRoad;
    }
    public void setStationCrossRoad (Road stationCrossRoad) {
        this.stationCrossRoad = stationCrossRoad;
    }
    public void setStationDirection (Direction stationDirection) {
        this.stationDirection = stationDirection;
    }

    public void setStationFields (Station station) {
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
        leftLaneOrientation = Direction.NONE;
        rightLaneOrientation = Direction.NONE;

        addressId = Integer.MIN_VALUE;
        addressName = "None";
        addressRoad = null;
        addressOrientation = Direction.NONE;

        stationId = Integer.MIN_VALUE;
        stationName = "None";
        stationCrossRoad = null;
        stationRoad = null;
        stationDirection = Direction.NONE;

        busRouteId = Integer.MIN_VALUE;
        busRouteName = "None";
        busRouteStartTime = null;
        busRouteEndTime = null;
        busRouteInterArrivalTime = Integer.MIN_VALUE;
        busRouteCategory = TransitRouteCategory.NONE;
    } // close reset
} // end class RoadDataTransfer
*/