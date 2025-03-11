package com.lawal.transit.navigtion;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.station.model.StationEdge;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CurbStationEdgeFactory {

    private static final AtomicLong edgeId = new AtomicLong(0);

    public static Station getFirstStation(Curb curb) {
        if (curb == null) return null;
        if (curb.getStations().isEmpty()) return null;
        return curb.getStations().get(0);
    }

    public static Station getLastStation(Curb curb) {
        if (curb == null) return null;
        if (curb.getStations().isEmpty()) return null;
        return curb.getStations().get(curb.getStations().size() - 1);
    }

    public static List<StationEdge> getCurbEdges(Curb curb) {
//        System.out.println("getCurbEdges");
        List<StationEdge> stationEdges = new ArrayList<>();

        if (curb == null || curb.getStations().isEmpty()) return stationEdges;

        Station previousStation = getFirstStation(curb);
        if (previousStation == null) return stationEdges;

        for (Station station : curb.getStations()) {
            Block block = station.getBlock();
//            System.out.println(block.toString());
            int distance = curb.getBlocks().indexOf(block) - curb.getBlocks().indexOf(previousStation.getBlock());
            if (distance > 0) {
                StationEdge stationEdge = new StationEdge(edgeId.incrementAndGet(), previousStation, station, distance,0, 0);
                StationEdgeCatalog.INSTANCE.getCatalog().add(stationEdge);
                stationEdges.add(stationEdge);
//                System.out.println(stationEdge.toString());
            }
            previousStation = station;
        }
        return stationEdges;
    }

    public static StationEdge createCycleEdge(Curb startingCurb, Curb endingCurb) {
//        System.out.println("createCycleEdge");
        if (startingCurb == null || endingCurb == null) return null;
        if (startingCurb.equals(endingCurb)) return null;
        if (startingCurb.getRoad() == null || endingCurb.getRoad() == null) return null;
        if (startingCurb.getStations().isEmpty() || endingCurb.getStations().isEmpty()) return null;

        Station startingStation = getFirstStation(startingCurb);
        Station endingStation = getLastStation(endingCurb);

//        System.out.println("number of starting blocks: " + startingCurb.getBlocks().size());
//        System.out.println("number of ending blocks: " + endingCurb.getBlocks().size());

        int startingBlockArrayIndex = startingCurb.getBlocks().indexOf(startingStation.getBlock());
        int endingBlockArrayIndex = endingCurb.getBlocks().indexOf(endingStation.getBlock());
//        System.out.println("startingBlockArrayIndex: " + startingBlockArrayIndex);
//        System.out.println("endingBlockArrayIndex: " + endingBlockArrayIndex);

        int startingIndex = startingCurb.getBlocks().size() - startingCurb.getBlocks().indexOf(startingStation.getBlock()) - 1;
        int endingIndex = endingCurb.getBlocks().size() - endingCurb.getBlocks().indexOf(endingStation.getBlock()) - 1;

        int roadDistance = Math.abs(endingCurb.getRoad().getId().intValue() - startingCurb.getRoad().getId().intValue());
        int curbDistance = Math.abs(endingCurb.getId().intValue() - startingCurb.getId().intValue());
        int blocKDistance = Math.abs(endingIndex - startingIndex);

        int distance = roadDistance + blocKDistance + curbDistance;

//        System.out.println("startingIndex: " + startingIndex);
//        System.out.println("endingIndex: " + endingIndex);
//        System.out.println("roadDistance: " + roadDistance);
//        System.out.println("curbDistance: " + curbDistance);
//        System.out.println("blocKDistance: " + blocKDistance);
//        System.out.println("distance: " + distance);

        StationEdge cycleStationEdge = new StationEdge(edgeId.incrementAndGet(), startingStation, endingStation, distance,0, 0);
        StationEdgeCatalog.INSTANCE.getCatalog().add(cycleStationEdge);
//        System.out.println("Cycle StationEdge"  + cycleStationEdge.toString());
        return cycleStationEdge;
    }

    public static void processCurbs() {

//        System.out.println("processCurbs");
        for (Road road : RoadCatalog.INSTANCE.getCatalog()) {
            List<StationEdge> leftStationEdges = getCurbEdges(road.getLeftCurb());
            List<StationEdge> rightStationEdges = getCurbEdges(road.getRightCurb());

            if (leftStationEdges.isEmpty() && rightStationEdges.isEmpty()) continue;
//            System.out.println("pre cycle edge addition: # leftedges = " + leftStationEdges.size() + " # rightedges = " + rightStationEdges.size());
            StationEdge cycleStationEdgeA = createCycleEdge(road.getLeftCurb(), road.getRightCurb());
            StationEdge cycleStationEdgeB = createCycleEdge(road.getRightCurb(), road.getLeftCurb());

            if (cycleStationEdgeA != null && !leftStationEdges.contains(cycleStationEdgeA)) leftStationEdges.add(cycleStationEdgeA);
            if (cycleStationEdgeB != null && !rightStationEdges.contains(cycleStationEdgeB)) rightStationEdges.add(cycleStationEdgeB);

    //        System.out.println("post cycle edge addition: # leftedges = " + leftStationEdges.size() + " # rightedges = " + rightStationEdges.size());
//            List<StationEdge> roadEdges = new ArrayList<>(leftStationEdges);
//            roadEdges.addAll(rightStationEdges);
//            for (StationEdge edge : roadEdges) {
//                System.out.println("curb factory:" + edge);
//                StationEdgeCatalog.INSTANCE.getCatalog().add(edge);
//            }
//            for (StationEdge edge : roadEdges) {
//                System.out.println(
//                    "roadId:" + road.getId()
//                    + " edgeId:" + edge.getId()
//                    + " headStation(id:"
//                        + edge.getHeadStation().getId()
//                        + " inDegree:" + edge.getHeadStation().getIncomingStationEdges().size()
//                        + " outDegree:" + edge.getHeadStation().getOutgoingStationEdges().size() + ")"
//                    + " headBlockId:" + edge.getHeadStation().getBlock().getId()
//                    + " headCurbId:" + edge.getHeadStation().getBlock().getCurb().getId()
//                    + " " + edge.getHeadStation().getBlock().getCurb().getOrientation().abbreviation()
//                    + " tailStation(id:"
//                        + edge.getTailStation().getId()
//                        + " inDegree:" + edge.getTailStation().getIncomingStationEdges().size()
//                        + " outDegree:" + edge.getTailStation().getOutgoingStationEdges().size() + ")"
//                    + " tailBlockId:" + edge.getTailStation().getBlock().getId()
//                    + " tailCurbId:" + edge.getTailStation().getBlock().getCurb().getId()
//                    + " " + edge.getTailStation().getBlock().getCurb().getOrientation().abbreviation()
//                    + " distance:" + edge.getDistance()
//                );
//            }
        }
    }
}