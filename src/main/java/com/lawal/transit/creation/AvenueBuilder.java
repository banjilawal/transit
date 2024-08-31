//package com.lawal.transit.creation;
//
//import com.lawal.transit.globals.*;
//import com.lawal.transit.roads.*;
//import com.lawal.transit.roads.interfaces.*;
//
//public final class AvenueBuilder {
//
//    public static final int INCREMENT = 2;
//    public static final int MULTIPLICATION_FACTOR = 1000;
//    public static final int LEFT_FRONTAGE_STARTING_INDEX = 1;
//    public static final int RIGHT_FRONTAGE_STARTING_INDEX = 0;
//
//    private int numberOfBlocks;
//    private int stationInterval;
//    private int buildingsPerBlock;
//    private RoadIdentifier roadLabel;
//    private RoadSectional leftFrontage;
//    private RoadSectional rightFrontage;
//
//    public AvenueBuilder roadLabel (RoadIdentifier roadLabel) {
//        this.roadLabel = roadLabel;
//        return this;
//    }
//
//    public AvenueBuilder buildingsPerBlock (int buildingsPerBlock) {
//        this.buildingsPerBlock = buildingsPerBlock;
//        return this;
//    }
//
//    public AvenueBuilder stationInterval (int stationInterval) {
//        this.stationInterval = stationInterval;
//        return this;
//    }
//
//    public AvenueBuilder numberOfBlocks (int numberOfBlocks) {
//        this.numberOfBlocks = numberOfBlocks;
//        return this;
//    }
//
//    public AvenueBuilder leftFrontage () throws Exception {
//        this.leftFrontage = frontage(Avenue.LEFTWARD_TRAFFIC_DIRECTION, LEFT_FRONTAGE_STARTING_INDEX);
//        return this;
//    }
//
//    public AvenueBuilder rightFrontage () throws Exception {
//        this.rightFrontage = frontage(Avenue.RIGHTWARD_TRAFFIC_DIRECTION, RIGHT_FRONTAGE_STARTING_INDEX);
//        return this;
//    }
//
//    public RoadSectional frontage (Orientation trafficDirection, int startingIndex) throws Exception {
//        return new FrontageBuilder()
//            .roadLabel(roadLabel)
//            .buildingsPerBlock(buildingsPerBlock)
//            .numberOfBlocks(numberOfBlocks)
//            .stationInterval(stationInterval)
//            .trafficDirection(trafficDirection)
//            .startingIndex(startingIndex)
//            .build();
//    }
//
//    public Avenue build () {
//        return new Avenue(roadLabel,  leftFrontage, rightFrontage);
//    }

//    private Frontage frontage (Avenue avenue, Laterality laterality) {
//        int startingnumber = 0;
//        if (laterality.equals(Laterality.LEFT));
//
//
//    }
//
//    public AvenueBuilder () {
//        this.avenueId = 0;
//        this.avenueName = "";
//        this.startingStationId = 0;
//        this.startingBuildingId = 0;
//        this.leftBuildings = 0;
//        this.rightBuildings = 0;
//    }
//
//    public AvenueBuilder (
//        String avenueName,
//        int avenueId,
//        int startingBuildingId,
//        int startingStationId
//    ) {
//        this(
//            avenueName,
//            avenueId,
//            startingBuildingId,
//            startingStationId,
//            3,
//            12,
//            4,
//            20
//        );
//    }
//
//    public AvenueBuilder (
//        String avenueName,
//        int avenueId,
//        int startingBuildingId,
//        int startingStationId,
//        int leftStations,
//        int leftBuildings,
//        int rightStations,
//        int rightBuildings
//    ) {
//        this.startingBuildingId = startingBuildingId;
//        this.startingStationId = startingStationId;
//        this.leftStations = leftStations;
//        this.leftBuildings = leftBuildings;
//        this.rightStations = rightStations;
//        this.rightBuildings = rightBuildings;
//    }
//
//    public void setAvenueId (int avenueId) {
//        this.avenueId = avenueId;
//    }
//
//    public void setAvenueName (String avenueName) {
//        this.avenueName = avenueName;
//    }
//
//    public void buildingsPerFrontage (int number) {
//        this.leftBuildings = number;
//        this.rightBuildings = number;
//    }
//
//    public void stationsPerFrontage (int number) {
//        this.leftStations = number;
//        this.rightStations = number;
//    }
//
//    public void setStartingBuildingId (int startingBuildingId) {
//        this.startingBuildingId = startingBuildingId;
//    }
//
//    public void setStartingStationId (int startingStationId) {
//        this.startingStationId = startingStationId;
//
//    }
//
//    public void setLeftStations (int number) {
//        this.leftStations = number;
//    }
//
//    public void setLeftBuildings (int number) {
//        this.leftBuildings = number;
//    }
//
//    private void addBuildings (Avenue avenue, Laterality laterality) throws Exception {
//        int startingArrayIndex = 1;
//        Addressables buildings = avenue.getLeftFrontage().buildings();
//        int numberOfBuildings = leftBuildings;
//        if (laterality.equals(Laterality.RIGHT)) {
//            startingArrayIndex = 0;
//            buildings = avenue.getRightFrontage().buildings();;
//            numberOfBuildings = rightBuildings;
//        }
//        for (int index = startingArrayIndex; index < numberOfBuildings; index += INCREMENT) {
//            String buildingName = avenue.getLabel().id()  * MULTIPLICATION_FACTOR + index + "";
//            FormattedAddress address = new Address(startingBuildingId, buildingName, avenue, laterality);
//            buildings.add(new Place(address));
////            System.out.println(address.toString() + " " + buildings.size());
//            startingBuildingId++;
//        }
//    }
//
//    private void addStations (Avenue avenue, Laterality laterality) throws Exception {
//        int startingArrayIndex = 1;
//        int numberOfStations = leftStations;
//        Stationables stations = avenue.getLeftFrontage().stations();
//        if (laterality.equals(Laterality.RIGHT)) {
//            startingArrayIndex = 0;
//            numberOfStations = rightStations;
//            stations = avenue.getRightFrontage().stations();
//        }
//        for (int index = startingArrayIndex; index < numberOfStations; index += INCREMENT) {
//            String stationName = "MT" + avenue.getLabel().id() * 100 + index; //MULTIPLICATION_FACTOR + index;
//            FormattedAddress address = new Address(startingStationId, stationName, avenue, laterality);
//            stations.add(new Station(address));
//            startingStationId++;
//        }
//    }
//
//    private void addEdges (Avenue avenue, Laterality laterality) throws Exception {
//        int startingArrayIndex = 1;
//        Stationables stations = avenue.getLeftFrontage().stations();
//        if (laterality.equals(Laterality.RIGHT)) {
//            startingArrayIndex = 0;
//            stations = avenue.getRightFrontage().stations();
//        }
//        for (int index = 1; index < stations.size(); index++) {
//            OldStationable previous = stations.getByIndex(index - 1);
//            OldStationable current = stations.getByIndex(index);
//            Edge edge = new Edge(previous, current, avenue.getLabel(), new Weight(1));
//            previous.getOutgoingEdges().add(edge);
//            current.getIncomingEdges().add(edge);
////            System.out.println("previous:" + previous.toString());
////            System.out.println("current:" + previous.toString());
//        }
//    }
//
//    public void processStations (Avenue avenue, Laterality laterality) throws Exception {
//        addStations(avenue, laterality);
//        addEdges(avenue, laterality);
//    }
//
//    public int nextBuildingId () {
//        return startingBuildingId;
//    }
//
//    public int nextStationId () {
//        return startingStationId;
//    }
//
//    public Avenue build () throws Exception {
//        if (avenueId == 0 && avenueName.isEmpty())
//            throw new Exception("The name and id must be set before an avenue can be created");
//        Avenue avenue = new Avenue(avenueId, avenueName);
//        addBuildings(avenue, Laterality.LEFT);
//        addBuildings(avenue, Laterality.RIGHT);
//        processStations(avenue, Laterality.LEFT);
//        processStations(avenue, Laterality.RIGHT);
//        System.out.println(" number of stattions:" + avenue.getRightFrontage().stations().getOrder()
//           + " number + of buildings: " + avenue.getRightFrontage().buildings().size());
//        return avenue;
//    }
//}
