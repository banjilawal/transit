package com.lawal.transit.blocks;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.places.interfaces.*;

import java.util.*;

public final class Blocks implements RoadSectionals,  Iterable<RoadSectional> { //}, Iterable<RoadSectional> {
    public static final String ADDITION_ERROR = "The blockId is already in use.";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private final ArrayList<RoadSectional> blocks;

    public Blocks () {
        this.blocks = new ArrayList<>();
    }

    @Override
    public int size () {
        return blocks.size();
    }

    @Override
    public ArrayList<RoadSectional> getList () {
        return blocks;
    }

    @Override
    public Iterator<RoadSectional> iterator () {
        return new RoadSectionalIterator();
    }

    @Override
    public void addBlock (RoadSectional block) throws Exception {
        if (blocks.contains(block))
            throw new Exception(ADDITION_ERROR);
        blocks.add(blocks.size(), block);
    }

    @Override
    public RoadSectional findBlock (int blockId) {
        for (RoadSectional block: blocks) {
            if (block.tag().id() == blockId)
                return block;
        }
        return null;
    }

    @Override
    public RoadSectional nextBlock (int currentBlockId) {
        int currentIndex = blocks.indexOf(findBlock(currentBlockId));
        if (currentIndex >= 0 || currentIndex < blocks.size() - 1)
            return blocks.get(currentIndex + 1);
        return null;
    }

    @Override
    public RoadSectional previousBlock (int currentBlockId) {
        int currentIndex = blocks.indexOf(findBlock(currentBlockId));
        if (currentIndex > 1 || currentIndex < blocks.size())
            return blocks.get(currentIndex - 1);
        return null;
    }

    @Override
    public Placeable findPlace (int placeId) {
        for (RoadSectional block: blocks) {
            Placeable place = block.places().search(placeId);
            if (place != null)
                return place;
        }
        return null;
    }

    @Override
    public Placeable findPlace (String placeName) {
        for (RoadSectional block: blocks) {
            Placeable place = block.places().search(placeName);
            if (place != null)
                return place;
        }
        return null;
    }

    @Override
    public void addPlace (Placeable placeable) throws Exception {
        RoadSectional block = findBlock(placeable.address().blockTag().id());
        if (block == null)
            throw new Exception("There is no block with that id. To add the place to.");
        block.places().add(placeable);
    }

    public void removePlace (int placeId) throws Exception {
        RoadSectional target = null;
        for (RoadSectional block: blocks) {
            if (block.places().search(placeId) == null)
                target = block;
        }
        if (target == null)
            throw new Exception("There is no place with that id to remove");
        blocks.remove(placeId);
    }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        for (RoadSectional block: blocks) {
            stringBuilder.append(block.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    private class RoadSectionalIterator implements Iterator<RoadSectional> {
        private final Iterator<RoadSectional> iterator = blocks.iterator();
        private int cursor = 0;

        @Override
        public boolean hasNext () {
            return iterator.hasNext();
        }

        @Override
        public RoadSectional next () {
            return iterator().next();
        }


//        @Override
//        public boolean hasNext () {
//            return cursor < blocks.size();
//        }
//
//        @Override
//        public RoadSectional next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            return blocks.get(cursor++);
//        }
//
//        public RoadSectional previous () {
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
//        private ArrayList<RoadSectional> blocks;
//        private Direction trafficDirection;
//
//        public Builder () {}
//
//        public Builder roadLabel (RoadIdentifier roadLabel) {
//            this.roadLabel = roadLabel;
//            return this;
//        }
//
//        public Builder blocks (ArrayList<RoadSectional> blocks) {
//            this.blocks = blocks;
//            return this;
//        }
//
//        public Builder trafficDirection (Direction trafficDirection) {
//            this.trafficDirection = trafficDirection;
//            return this;
//        }
//
//        public RoadSectionals build () {
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
//    public void addBlock (RoadSectional roadSectional) throws Exception {
//        if (blocks.contains(roadSectional))
//            throw new Exception("Attempting to add a block which already exists in the collection");
//        blocks.add(blocks.size(), roadSectional);
//    }
//
//    @Override
//    public Iterator<RoadSectional> iterator () {
//        return blocks.iterator();
//    }
//
//    @Override
//    public RoadSectional findBlockById (int id) {
//        if (id < blocks.size())
//            return blocks.get(id);
//        return null;
//    }
//
//    @Override
//    public RoadSectional findBlockByAddress (FormattedAddress address) {
//        for (RoadSectional block : blocks) {
//            if (block.search(address) != null)
//                return block;
//        }
//        return null;
//    }
//
//    @Override
//    public void addBuilding (Addressable building) throws Exception {
//        if (building.address().blockLabel().id() >= blocks.size()) {
//            addBlock();
//        }
//        blocks.get(building.address().blockLabel().id()).add(building);
//    }
//
//    @Override
//    public void removeBuilding (FormattedAddress address) throws Exception {
//        RoadSectional block = findBlockById(address.blockLabel().id());
//        if (block == null)
//            throw new Exception(REMOVAL_ERROR);
//        block.remove(address);
//    }
//
//    @Override
//    public Addressable findBuildingById (int id) {
//        for (RoadSectional block : blocks) {
//            Addressable building = block.search(id);
//            if (building != null)
//                return building;
//        }
//        return null;
//    }
//
//    @Override
//    public Addressable findBuildingByAddress (FormattedAddress address) {
//        for (RoadSectional block : blocks) {
//            Addressable building = block.search(address);
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
//        for(RoadSectional block : blocks) {
//            string.append("Block ").append(index).append("\n").append(block.toString()).append("\n");
//        }
//        return string.toString();
//    }
//
//   private class PrivateIterator implements Iterator<RoadSectional> {
//        private int currentIndex = 0;
//
//        @Override
//        public boolean hasNext () {
//            return currentIndex < blocks.size();
//        }
//
//        @Override
//        public RoadSectional next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            return blocks.get(currentIndex++);
//        }
//   }
}