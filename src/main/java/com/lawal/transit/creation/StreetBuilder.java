package com.lawal.transit.creation;

import com.lawal.transit.buildings.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.road.*;
import com.lawal.transit.stations.*;

public final class StreetBuilder {

    public static final int INCREMENT = 2;
    public static final int MULTIPLICATION_FACTOR = 1000;

    private final int buildingsPerRoadside;
    private final int stationsPerRoadside;
    private int currentBuildingId;
    private int currentStationId;
    private final Street street;

    public StreetBuilder (int roadId, int stationsPerRoadSide, int buildingsPerRoadSide, int currentBuildingId, int currentStationId) throws Exception {
        this.buildingsPerRoadside = buildingsPerRoadSide;
        this.stationsPerRoadside = stationsPerRoadSide;
        this.currentBuildingId = currentBuildingId;
        this.currentStationId = currentStationId;
        this.street = new Street(roadId, roadId + "");
    }

    private void addBuildings (RoadLateral roadLateral) throws Exception {
        int startingArrayIndex = 1;
        AddressableCollection buildings = street.getLeftSideBuildings();
        if (roadLateral.equals(RoadLateral.RIGHT)) {
            startingArrayIndex = 0;
            buildings = street.getRightSideBuildings();
        }
        for (int index = startingArrayIndex; index < buildingsPerRoadside; index += INCREMENT) {
            String buildingName = street.getIdentifier().getId()  * MULTIPLICATION_FACTOR + index + "";
            FormattedAddress address = new Address(currentBuildingId, buildingName, street, roadLateral);
            buildings.add(new Building(address));
            currentBuildingId++;
        }
    }

    private void addStations (RoadLateral roadLateral) throws Exception {
        int startingArrayIndex = 1;
        VertexCollection stations = street.getLeftSideStations();
        if (roadLateral.equals(RoadLateral.RIGHT)) {
            startingArrayIndex = 0;
            stations = street.getRightSideStations();
        }
        for (int index = startingArrayIndex; index < stationsPerRoadside; index += INCREMENT) {
            String stationName = "MT-" + street.getIdentifier().getId() * MULTIPLICATION_FACTOR + index;
            FormattedAddress address = new Address(currentStationId, stationName, street, roadLateral);
            stations.add(new Station(address));
            currentStationId++;
        }
    }

    public int getCurrentBuildingId () {
        return currentBuildingId;
    }

    public int getCurrentStationId () {
        return currentStationId;
    }

    public Street build () throws Exception {
        addBuildings(RoadLateral.LEFT);
        addBuildings(RoadLateral.RIGHT);
        addStations(RoadLateral.LEFT);
        addStations(RoadLateral.RIGHT);
        return street;
    }
}
