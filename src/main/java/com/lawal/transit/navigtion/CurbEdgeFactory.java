package com.lawal.transit.navigtion;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.*;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.edge.model.Edge;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CurbEdgeFactory {

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

    public static List<Edge> getCurbEdges(Curb curb) {
//        System.out.println("getCurbEdges");
        List<Edge> edges = new ArrayList<>();

        if (curb == null || curb.getStations().isEmpty()) return edges;

        Station previousStation = getFirstStation(curb);
        if (previousStation == null) return edges;

        for (Station station : curb.getStations()) {
            Block block = station.getBlock();
//            System.out.println(block.toString());
            int distance = curb.getBlocks().indexOf(block) - curb.getBlocks().indexOf(previousStation.getBlock());
            if (distance > 0) {
                Edge edge = new Edge(edgeId.incrementAndGet(), previousStation, station, distance,0, 0);
                edges.add(edge);
//                System.out.println(edge.toString());
            }
            previousStation = station;
        }
        return edges;
    }

    public static Edge createCycleEdge(Curb startingCurb, Curb endingCurb) {
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

        Edge cycleEdge = new Edge(edgeId.incrementAndGet(), startingStation, endingStation, distance,0, 0);
//        System.out.println("Cycle Edge"  + cycleEdge.toString());
        return cycleEdge;
    }

    public static void processCurbs() {

//        System.out.println("processCurbs");
        for (Road road : RoadCatalog.INSTANCE.getCatalog()) {
            List<Edge> leftEdges = getCurbEdges(road.getLeftCurb());
            List<Edge> rightEdges = getCurbEdges(road.getRightCurb());

            if (leftEdges.isEmpty() && rightEdges.isEmpty()) continue;
//            System.out.println("pre cycle edge addition: # leftedges = " + leftEdges.size() + " # rightedges = " + rightEdges.size());
            Edge cycleEdgeA = createCycleEdge(road.getLeftCurb(), road.getRightCurb());
            Edge cycleEdgeB = createCycleEdge(road.getRightCurb(), road.getLeftCurb());

            if (cycleEdgeA != null) leftEdges.add(cycleEdgeA);
            if (cycleEdgeB != null) rightEdges.add(cycleEdgeB);

    //        System.out.println("post cycle edge addition: # leftedges = " + leftEdges.size() + " # rightedges = " + rightEdges.size());
            List<Edge> roadEdges = new ArrayList<>(leftEdges);
            roadEdges.addAll(rightEdges);
            EdgeCatalog.INSTANCE.getCatalog().addAll(roadEdges);
//            for (Edge edge : roadEdges) {
//                System.out.println(
//                    "roadId:" + road.getId()
//                    + " edgeId:" + edge.getId()
//                    + " headStation(id:"
//                        + edge.getHeadStation().getId()
//                        + " inDegree:" + edge.getHeadStation().getIncomingEdges().size()
//                        + " outDegree:" + edge.getHeadStation().getOutgoingEdges().size() + ")"
//                    + " headBlockId:" + edge.getHeadStation().getBlock().getId()
//                    + " headCurbId:" + edge.getHeadStation().getBlock().getCurb().getId()
//                    + " " + edge.getHeadStation().getBlock().getCurb().getOrientation().abbreviation()
//                    + " tailStation(id:"
//                        + edge.getTailStation().getId()
//                        + " inDegree:" + edge.getTailStation().getIncomingEdges().size()
//                        + " outDegree:" + edge.getTailStation().getOutgoingEdges().size() + ")"
//                    + " tailBlockId:" + edge.getTailStation().getBlock().getId()
//                    + " tailCurbId:" + edge.getTailStation().getBlock().getCurb().getId()
//                    + " " + edge.getTailStation().getBlock().getCurb().getOrientation().abbreviation()
//                    + " distance:" + edge.getDistance()
//                );
//            }
        }
    }
}