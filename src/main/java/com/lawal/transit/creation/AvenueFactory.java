package com.lawal.transit.creation;

import com.lawal.transit.road.*;

public class AvenueFactory {
    private int buildingId;
    private int stationId;
    private final int blocksPerRoadSide;

    public AvenueFactory (int buildingId, int stationId, int blocksPerRoadside) {
        this.buildingId = buildingId;
        this.stationId = stationId;
        this.blocksPerRoadSide = blocksPerRoadside;
    }

    private int randNumber (int floor, int ceiling) {
        return (int) (Math.random() * (ceiling - floor)) + floor;
    }

    public Avenues make (String[] names) throws Exception {
        Avenues avenues = new Avenues();
        for (int index = 0; index < names.length; index++) {
//            Avenue avenue = new Avenue((index + 1), names[index]);
            int numberofBuildings = randNumber(1, 4);
            int numberofStations = randNumber(1, (blocksPerRoadSide / 4));
            AvenueBuilder builder = new AvenueBuilder(buildingId, stationId, blocksPerRoadSide, numberofBuildings, 4);
//            builder.setBuildingsPerBlock();
//            builder.setStationsPerSide(numberofStations);
//            builder.setBuildingsPerSide(numberofBuildings);
            builder.setAvenueId(index + 1);
            builder.setAvenueName(names[index]);
            Avenue avenue = builder.build();
            avenues.add(avenue);
            buildingId = builder.getCurrentBuildingId();
            stationId = builder.getCurrentStationId();
//            int totalBuildings = avenue.getLeftSideBuildings().size() + avenue.getRightSideBuildings().size();
//            int totalStations = avenue.getLeftSideStations().getOrder() + avenue.getRightSideStations().getOrder();
//            AvenueBuilder builder = new AvenueBuilder(names[index], (index + 1), numberofStations, numberofBuildings, buildingId, stationId);
//
//            System.out.println(avenue.toString() + " total buildings:" + totalBuildings + " total stations:" + totalStations);
//            avenues.add(new Avenue(index+1), names[index]));
//            System.out.println(names.length + " " + index + " " + names[index]);
        }
        System.out.println(avenues.numberOfRoads());
        return avenues;
    }
}
