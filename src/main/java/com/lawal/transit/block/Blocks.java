package com.lawal.transit.block;

import com.lawal.transit.block.interfaces.*;
import com.lawal.transit.places.interfaces.*;

import java.util.*;

public final class Blocks implements RoadSegments,  Iterable<RoadSegment> { //}, Iterable<RoadSegment> {
    public static final String ADDITION_ERROR = "The blockId is already in use.";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private final ArrayList<RoadSegment> blocks;

    public Blocks () {
        this.blocks = new ArrayList<>();
    }

    @Override
    public int size () {
        return blocks.size();
    }

    @Override
    public ArrayList<RoadSegment> getList () {
        return blocks;
    }

    @Override
    public Iterator<RoadSegment> iterator () {
        return new RoadSectionalIterator();
    }

    @Override
    public void addBlock (RoadSegment block) throws Exception {
        if (blocks.contains(block))
            throw new Exception(ADDITION_ERROR);
        blocks.add(blocks.size(), block);
    }

    @Override
    public RoadSegment findBlock (int blockId) {
        for (RoadSegment block: blocks) {
            if (block.getTag().id() == blockId)
                return block;
        }
        return null;
    }

    @Override
    public RoadSegment nextBlock (int currentBlockId) {
        int currentIndex = blocks.indexOf(findBlock(currentBlockId));
        if (currentIndex >= 0 || currentIndex < blocks.size() - 1)
            return blocks.get(currentIndex + 1);
        return null;
    }

    @Override
    public RoadSegment previousBlock (int currentBlockId) {
        int currentIndex = blocks.indexOf(findBlock(currentBlockId));
        if (currentIndex > 1 || currentIndex < blocks.size())
            return blocks.get(currentIndex - 1);
        return null;
    }

    @Override
    public Placeable findPlaceById (int placeId) {
        for (RoadSegment block: blocks) {
            Placeable place = block.getPlaces().search(placeId);
            if (place != null)
                return place;
        }
        return null;
    }

    @Override
    public Placeable findPlaceByName (String placeName) {
        for (RoadSegment block: blocks) {
            Placeable place = block.getPlaces().search(placeName);
            if (place != null)
                return place;
        }
        return null;
    }

    @Override
    public void addPlace (Placeable placeable) throws Exception {
        RoadSegment block = findBlock(placeable.address().blockTag().id());
        if (block == null)
            throw new Exception("There is no block with that id. To add the place to.");
        block.getPlaces().add(placeable);
    }

    public void removePlace (int placeId) throws Exception {
        RoadSegment target = null;
        for (RoadSegment block: blocks) {
            if (block.getPlaces().search(placeId) == null)
                target = block;
        }
        if (target == null)
            throw new Exception("There is no place with that id to remove");
        blocks.remove(placeId);
    }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        for (RoadSegment block: blocks) {
            stringBuilder.append(block.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    private class RoadSectionalIterator implements Iterator<RoadSegment> {
        private final Iterator<RoadSegment> iterator = blocks.iterator();
        private int cursor = 0;

        @Override
        public boolean hasNext () {
            return iterator.hasNext();
        }

        @Override
        public RoadSegment next () {
            return iterator().next();
        }


//        @Override
//        public boolean hasNext () {
//            return cursor < blocks.size();
//        }
//
//        @Override
//        public RoadSegment next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            return blocks.get(cursor++);
//        }
//
//        public RoadSegment previous () {
//            if (!hasPrevious())
//                throw new NoSuchElementException();
//            return blocks.get(cursor--);
//        }
//
//        @Override
//        public void remove () {
//            throw new UnsupportedOperationException();
//        }
    }
//
//    public static Builder builder () { return new Builder(); }
//    public static class Builder {
//        private RoadIdentifier roadLabel;
//        private ArrayList<RoadSegment> blocks;
//        private Direction trafficDirection;
//
//        public Builder () {}
//
//        public Builder roadLabel (RoadIdentifier roadLabel) {
//            this.roadLabel = roadLabel;
//            return this;
//        }
//
//        public Builder blocks (ArrayList<RoadSegment> blocks) {
//            this.blocks = blocks;
//            return this;
//        }
//
//        public Builder trafficDirection (Direction trafficDirection) {
//            this.trafficDirection = trafficDirection;
//            return this;
//        }
//
//        public RoadSegments build () {
//            return new Blocks(roadLabel, trafficDirection);
//        }
//    }
//
//    @Override
//    public int size () {
//        return blocks.size();
//    }
//
//    @Override
//    public void addBlock (RoadSegment roadSectional) throws Exception {
//        if (blocks.contains(roadSectional))
//            throw new Exception("Attempting to add a block which already exists in the collection");
//        blocks.add(blocks.size(), roadSectional);
//    }
//
//    @Override
//    public Iterator<RoadSegment> iterator () {
//        return blocks.iterator();
//    }
//
//    @Override
//    public RoadSegment findBlockById (int id) {
//        if (id < blocks.size())
//            return blocks.get(id);
//        return null;
//    }
//
//    @Override
//    public RoadSegment findBlockByAddress (FormattedAddress address) {
//        for (RoadSegment block : blocks) {
//            if (block.search(address) != null)
//                return block;
//        }
//        return null;
//    }
//
//    @Override
//    public void addBuilding (AddressEntity building) throws Exception {
//        if (building.address().blockLabel().id() >= blocks.size()) {
//            addBlock();
//        }
//        blocks.get(building.address().blockLabel().id()).add(building);
//    }
//
//    @Override
//    public void removeBuilding (FormattedAddress address) throws Exception {
//        RoadSegment block = findBlockById(address.blockLabel().id());
//        if (block == null)
//            throw new Exception(REMOVAL_ERROR);
//        block.remove(address);
//    }
//
//    @Override
//    public AddressEntity findBuildingById (int id) {
//        for (RoadSegment block : blocks) {
//            AddressEntity building = block.search(id);
//            if (building != null)
//                return building;
//        }
//        return null;
//    }
//
//    @Override
//    public AddressEntity findBuildingByAddress (FormattedAddress address) {
//        for (RoadSegment block : blocks) {
//            AddressEntity building = block.search(address);
//            if (building != null)
//                return building;
//        }
//        return null;
//    }
//
//    @Override
//    public String toString () {
//        StringBuilder string = new StringBuilder();
//        int index = 0;
//        for(RoadSegment block : blocks) {
//            string.append("Block ").append(index).append("\n").append(block.toString()).append("\n");
//        }
//        return string.toString();
//    }
//
//   private class PrivateIterator implements Iterator<RoadSegment> {
//        private int currentIndex = 0;
//
//        @Override
//        public boolean hasNext () {
//            return currentIndex < blocks.size();
//        }
//
//        @Override
//        public RoadSegment next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            return blocks.get(currentIndex++);
//        }
//   }
}