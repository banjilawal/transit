package com.lawal.transit.creation;

import com.lawal.transit.buildings.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.road.*;
import com.lawal.transit.stations.*;

import java.util.*;

public final class AvenueBuilder {

    public static final int INCREMENT = 2;
    public static final int MULTIPLICATION_FACTOR = 1000;


    private int buildingsPerRoadside;
    private int stationsPerRoadside;
    private int currentBuildingId;
    private int currentStationId;
    public int blocksPerRoadSide;
    public int buildingsPerBlock;
    public int blocksPerStation;
    private int avenueId;
    private String avenueName;
    private Avenue avenue;

    public AvenueBuilder (int currentBuildingId, int currentStationId, int blocksPerRoadSide, int buildingsPerBlock, int blocksPerStation) {
        this.currentBuildingId = currentBuildingId;
        this.currentStationId = currentStationId;
        this.blocksPerRoadSide = blocksPerRoadSide;
        this.buildingsPerBlock = buildingsPerBlock;
        this.blocksPerStation = blocksPerStation;
        buildingsPerRoadside = (int) (Math.random() * (10 - 4)) + 4;
        stationsPerRoadside = (int) (Math.random() * (4 - 1)) + 1;
    }

//    public AvenueBuilder (String roadName, int roadId, int stationsPerRoadSide, int buildingsPerRoadSide, int currentBuildingId, int currentStationId) throws Exception {
////        this.buildingsPerRoadside = buildingsPerRoadSide;
//        this.stationsPerRoadside = stationsPerRoadSide;
//        this.currentBuildingId = currentBuildingId;
//    }
    public void setAvenueId (int avenueId) {
        this.avenueId = avenueId;
    }

    public void setAvenueName (String avenueName) {
        this.avenueName = avenueName;
    }

    public void setBuildingsPerBlock (int buildingsPerBlock) {
        this.buildingsPerBlock = buildingsPerBlock;
    }

    public void setBlocksPerStation (int blocksPerStation) {
        this.blocksPerStation = blocksPerStation;
    }

    public void setStationsPerSide (int stationsPerRoadside) {
        this.stationsPerRoadside = stationsPerRoadside;
    }

    public void setBuildingsPerSide (int buildingsPerRoadside) {
        this.buildingsPerRoadside = buildingsPerRoadside;
    }

    private void addBuildings (RoadLateral roadLateral) throws Exception {
        int startingArrayIndex = 1;
        AddressableCollection buildings = avenue.getLeftSideBuildings();
        if (roadLateral.equals(RoadLateral.RIGHT)) {
            startingArrayIndex = 0;
            buildings = avenue.getRightSideBuildings();
        }
        int numberOfBuildings = blocksPerRoadSide * buildingsPerBlock;
        for (int index = startingArrayIndex; index < buildingsPerRoadside; index += INCREMENT) {
            String buildingName = avenue.getIdentifier().getId()  * MULTIPLICATION_FACTOR + index + "";
            FormattedAddress address = new Address(currentBuildingId, buildingName, avenue, roadLateral);
            buildings.add(new Building(address));
            currentBuildingId++;
        }
    }

    private void addStations (RoadLateral roadLateral) throws Exception {
        int startingArrayIndex = 1;
        VertexCollection stations = avenue.getLeftSideStations();
        if (roadLateral.equals(RoadLateral.RIGHT)) {
            startingArrayIndex = 0;
            stations = avenue.getRightSideStations();
        }
        int numberOfStations = blocksPerStation / blocksPerRoadSide;
        for (int index = startingArrayIndex; index < stationsPerRoadside; index += INCREMENT) {
            String stationName = "MT-" + avenue.getIdentifier().getId() * MULTIPLICATION_FACTOR + index;
            FormattedAddress address = new Address(currentStationId, stationName, avenue, roadLateral);
            stations.add(new Station(address));
            currentStationId++;
        }

        for (int index = 1; index < stations.getOrder();index++) {
            stations.get
        }
    }

    public int getCurrentBuildingId () {
        return currentBuildingId;
    }

    public int getCurrentStationId () {
        return currentStationId;
    }

    public Avenue build () throws Exception {
        this.avenue = new Avenue(this.avenueId, this.avenueName);
        addBuildings(RoadLateral.LEFT);
        addBuildings(RoadLateral.RIGHT);
        addStations(RoadLateral.LEFT);
        addStations(RoadLateral.RIGHT);
        return avenue;
    }
}
