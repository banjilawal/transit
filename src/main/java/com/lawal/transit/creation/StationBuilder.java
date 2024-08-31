//package com.lawal.transit.creation;
//public final class StationBuilder {
//
//private
//
//    public StationBuilder id (int id) {
//        this.id = id;
//        return this;
//    }
//
//    public StationBuilder blockId (int blockId) {
//        this.blockId = blockId;
//        return this;
//    }
//
//    public StationBuilder orientation ()
//
//
//
//
//
//}

//public final class StationBuilder implements VertexBuildable {
//
//    private final FormattedAddress address;
//    private final Edgeables incomingEdges;
//    private final Edgeables outgoingEdges;
//
//    public StationBuilder (
//        Edgeables incomingEdges,
//        Edgeables outgoingEdges,
//        RoadIdentifier roadLabel,
//        Orientation orientation,
//        String name,
//        int id
//    ) throws Exception {
//        this.address = new Address(id, name, roadLabel, orientation);
//        this.incomingEdges = setEdges(incomingEdges);
//        this.outgoingEdges = setEdges(outgoingEdges);
//    }
//
//    @Override
//    public FormattedAddress getAddress () {
//        return address;
//    }
//
//    @Override
//    public Edgeables getIncomingEdges () {
//        return incomingEdges;
//    }
//
//    @Override
//    public Edgeables getOutgoingEdges () {
//        return outgoingEdges;
//    }
//
//    @Override
//    public OldStationable build () {
//        return new Station(address, incomingEdges , outgoingEdges);
//    }
//
//    private Edgeables setEdges (Edgeables collection) throws Exception {
//        Edgeables edges  = new Edges();
//        Iterator<Edgeable> iterator = collection.iterator();
//        while(iterator.hasNext()) {
//            edges.add(iterator.next());
//        }
//        return edges;
//    }
//
//}
