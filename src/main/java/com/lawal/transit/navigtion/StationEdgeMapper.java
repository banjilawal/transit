//package com.lawal.transit.navigtion;
//
//import com.lawal.transit.block.model.Block;
//import com.lawal.transit.catalog.BlockCatalog;
//import com.lawal.transit.catalog.CurbCatalog;
//import com.lawal.transit.catalog.StationCatalog;
//import com.lawal.transit.curb.model.Curb;
//import com.lawal.transit.edge.model.Edge;
//import com.lawal.transit.station.model.Station;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
//public class StationEdgeMapper {
//
//    private static AtomicLong edgeId = new AtomicLong(0);
//
//    public static Station getFirstStation(Curb curb) {
//        if (curb == null) return null;
//        if (curb.getStations().isEmpty()) return null;
//        return curb.getStations().get(0);
//    }
//
//    public static Station getLastStation(Curb curb) {
//        if (curb == null) return null;
//        if (curb.getStations().isEmpty()) return null;
//        return curb.getStations().get(curb.getStations().size() - 1);
//    }
//
//    public List<Edge> getCurbEdges(Curb curb) {
//        if (curb == null) return null;
//        if (curb.getStations().isEmpty()) return null;
//
//        Station previousStation = getFirstStation(curb);
//        if (previousStation == null) return null;
//
//        List<Edge> edges = new ArrayList<>();
//        for (Station station : curb.getStations()) {
//            Block block = station.getBlock();
//            int distance = curb.getBlockArrayIndex(station.getBlock().getId())
//                - curb.getBlockArrayIndex(previousStation.getBlock().getId());
//
//            if (distance < 0) {
//                Edge edge = new Edge(edgeId.incrementAndGet(), previousStation, station, distance,0, 0);
//                edges.add(edge);
//            }
//            previousStation = station;
//        }
//        return edges;
//    }
//
//    public static void processCurbs() {
//        for (Curb curb : CurbCatalog.INSTANCE.getCatalog()) {
//            int distance = 0;
//
//            Station previousStation = curb.getStations().getFirst();
//            Block previousBlock = previousStation.getBlock();
//
//            for (Station station : curb.getStations()) {
//                Block block = station.getBlock();
//                distance = curb.getBlockArrayIndex(block.getId()) - curb.getBlockArrayIndex(previousBlock.getId());
//
//                if (distance < 0) {
//                    Edge edge = new Edge(edgeId.incrementAndGet(), previousStation, station, distance,0, 0);
//                    System.out.println(edge.toString());
//                }
//                previousBlock = block;
//                previousStation = station;
//            }
//        }
//    }
//
//    public static void processStationBlocks() {
//        for (Block block : BlockCatalog.INSTANCE.getStationBlocks()) {
//            System.out.println("blockId:" + block.getId()
//                + " blockArrayIndex:" + block.getCurb().getBlockArrayIndex(block.getId())
//                + " stationId:" + block.getStation().getId()
//                + " stationCatalogArrayIndex:" + StationCatalog.INSTANCE.getCatalog().indexOf(block.getStation())
//                + " " + block.getCurb().getAvenueString()
//                + block.getCurb().getStreetString()
//                + " " + block.getCurb().getOrientation().print()
//            );
//        }
//    }
//
//}