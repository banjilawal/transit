//package com.lawal.transit.junctions;
//
//import com.lawal.transit.blocks.interfaces.*;
//import com.lawal.transit.catalogs.*;
//import com.lawal.transit.edges.*;
//import com.lawal.transit.edges.interfaces.*;
//import com.lawal.transit.globals.*;
//import com.lawal.transit.roads.*;
//import com.lawal.transit.stations.interfaces.*;
//
//import java.util.*;
//
//public enum JunctionProcessor {
//    INSTANCE;
//
//        public void processStreetLeftFrontage () throws Exception {
//            Iterator<Street> streetIterator = Streets.INSTANCE.iterator();
//            while (streetIterator.hasNext()) {
//                Street street = streetIterator.next();
//                Stationables stations = street.leftCurb().stations();
//                Iterator<Vertex> stationIterator = street.leftCurb().stations().iterator();
//                while (stationIterator.hasNext()) {
//                    Vertex currenStation = stationIterator.next();
//                    Vertex nextStation = stations.next(currenStation.key().id());
//                    if (nextStation != null) {
//                        RoadSectionTag currenTag = currenStation.key().blockTag();
//                        RoadSectionTag nextTag = nextStation.key().blockTag();
//
//                        Weightable weight = new Weight(nextTag.id() - currenTag.id());
//                        Edgeable edge = new Edge.Builder()
//                            .head(currenStation)
//                            .tail(nextStation)
//                            .properties(new EdgeTraits(IdGenerator.INSTANCE.nextEdgeId(), weight,EdgeCategory.ADJACENT))
//                            .build();
//                        Edges.INSTANCE.add(edge);
//                    }
//                }
//            }
//        }
//
//        public Vertex getAvenueCrossStation (Vertex streetStation, Avenue avenue) {
//            for (Vertex avenueStation : avenue.leftCurb().stations().get()) {
//                if (avenueStation.key().blockTag().id() <= streetStation.key().blockTag().id()) {
//                    return avenueStation;
//                }
//            }
//            return null;
//        }

//    public void processFrontage (RoadIdentifier roadLabel, RoadSectional frontage) {
//        Iterator<RoadSectional> iterator = frontage.blocks().iterator();
//        while (iterator.hasNext()) {
//
//        }
//    }
//    public void func (Avenue avenue, Street street) {
//        IntersectionElement aBranches = new JunctionItem.Builder().roadLabel(avenue.label()).blockTags(new ArrayList<RoadSectionTag>()).build();
//        IntersectionElement sBrances = new JunctionItem.Builder().roadLabel(street.label()).blockTags(new ArrayList<RoadSectionTag>()).build();
//        Iterator<RoadSectional> aIter = avenue.leftFrontage().blocks().iterator();
//        while (aIter.hasNext()) {
//            RoadSectional aBlock = aIter.next();
//            Iterator<RoadSectional> sIter = street.leftFrontage().blocks().iterator();
//            while (sIter.hasNext()) {
//                RoadSectional sBlock = sIter.next();
//                if (aBlock.tag().id() == sBlock.tag().id()) {
//                    aBranches.blockTags().add(aBranches.size(), aBlock.tag());
//                }
//            }

//        }
//    }
//}