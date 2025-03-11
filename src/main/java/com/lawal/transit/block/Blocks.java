package com.lawal.transit.block;

import com.lawal.transit.block.model.Block;

import java.util.*;

public final class Blocks implements Iterable<Block> { //}, Iterable<Block> {
    public static final String ADDITION_ERROR = "The blockId is already in use.";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private final List<Block> blocks;

    public Blocks () {
        this.blocks = new ArrayList<>();
    }

    public int size () { return blocks.size(); }

    public List<Block> getList () {
        return blocks;
    }

    public Iterator<Block> iterator () {
        return blocks.iterator();
    }

    public void add (Block block) {
        if (!blocks.contains(block)) { blocks.add(block); }
    }

    public Block findById (int id) {
        for (Block block: blocks) {
            if (block.getId() == id) return block;
        }
        return null;
    }

    public Block nextBlock (int currentBlockId) {
        int currentIndex = blocks.indexOf(findById(currentBlockId));
        if (currentIndex >= 0 || currentIndex < blocks.size() - 1)
            return blocks.get(currentIndex + 1);
        return null;
    }

    public Block previousBlock (int currentBlockId) {
        int currentIndex = blocks.indexOf(findById(currentBlockId));
        if (currentIndex > 1 || currentIndex < blocks.size())
            return blocks.get(currentIndex - 1);
        return null;
    }

//    public House findAddressById (Long addressId) {
//        for (Block block: blocks) {
//            House house = block.getHouses();
//            if (house != null) return house;
//        }
//        return null;
//    }

//    public House findAddressByName(String name) {
//        for (Block block: blocks) {
//            House house = block.getHouses().searchByNa(placeName);
//            if (house != null) return house;
//        }
//        return null;
//    }
//

    boolean isEmpty () { return blocks.isEmpty(); }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        for (Block block: blocks) {
            stringBuilder.append(block.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    private class BlockIterator implements Iterator<Block> {
        private final Iterator<Block> iterator = blocks.iterator();
        private int cursor = 0;

        @Override
        public boolean hasNext () {
            return iterator.hasNext();
        }

        @Override
        public Block next () {
            return iterator.next();
        }


//        @Override
//        public boolean hasNext () {
//            return cursor < blocks.size();
//        }
//
//        @Override
//        public Block next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            return blocks.get(cursor++);
//        }
//
//        public Block previous () {
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
//        private ArrayList<Block> blocks;
//        private Direction trafficDirection;
//
//        public Builder () {}
//
//        public Builder roadLabel (RoadIdentifier roadLabel) {
//            this.roadLabel = roadLabel;
//            return this;
//        }
//
//        public Builder blocks (ArrayList<Block> blocks) {
//            this.blocks = blocks;
//            return this;
//        }
//
//        public Builder trafficDirection (Direction trafficDirection) {
//            this.trafficDirection = trafficDirection;
//            return this;
//        }
//
//        public Blocks build () {
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
//    public void addBlock (Block roadSectional) throws Exception {
//        if (blocks.contains(roadSectional))
//            throw new Exception("Attempting to add a block which already exists in the collection");
//        blocks.add(blocks.size(), roadSectional);
//    }
//
//    @Override
//    public Iterator<Block> iterator () {
//        return blocks.iterator();
//    }
//
//    @Override
//    public Block findBlockById (int id) {
//        if (id < blocks.size())
//            return blocks.get(id);
//        return null;
//    }
//
//    @Override
//    public Block findBlockByAddress (FormattedAddress house) {
//        for (Block block : blocks) {
//            if (block.search(house) != null)
//                return block;
//        }
//        return null;
//    }
//
//    @Override
//    public void addBuilding (AddressEntity building) throws Exception {
//        if (building.house().blockLabel().id() >= blocks.size()) {
//            addBlock();
//        }
//        blocks.get(building.house().blockLabel().id()).add(building);
//    }
//
//    @Override
//    public void removeBuilding (FormattedAddress house) throws Exception {
//        Block block = findBlockById(house.blockLabel().id());
//        if (block == null)
//            throw new Exception(REMOVAL_ERROR);
//        block.remove(house);
//    }
//
//    @Override
//    public AddressEntity findBuildingById (int id) {
//        for (Block block : blocks) {
//            AddressEntity building = block.search(id);
//            if (building != null)
//                return building;
//        }
//        return null;
//    }
//
//    @Override
//    public AddressEntity findBuildingByAddress (FormattedAddress house) {
//        for (Block block : blocks) {
//            AddressEntity building = block.search(house);
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
//        for(Block block : blocks) {
//            string.append("Block ").append(index).append("\n").append(block.toString()).append("\n");
//        }
//        return string.toString();
//    }
//
//   private class PrivateIterator implements Iterator<Block> {
//        private int currentIndex = 0;
//
//        @Override
//        public boolean hasNext () {
//            return currentIndex < blocks.size();
//        }
//
//        @Override
//        public Block next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            return blocks.get(currentIndex++);
//        }
//   }
}