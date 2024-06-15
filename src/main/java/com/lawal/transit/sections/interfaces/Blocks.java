package com.lawal.transit.sections.interfaces;

import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.graph.interfaces.*;
import com.lawal.transit.sections.*;

import java.util.*;

public class Blocks implements VertexCollection<Block> {

    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";

    private final ArrayList<Block> blocks;

    public Blocks () {
        this.blocks = new ArrayList<>();
    }
    @Override
    public int getOrder () {
        return blocks.size();
    }

    @Override
    public Iterator<Block> iterator () {
        return blocks.iterator();
    }

    @Override
    public Block search (Addressable addressable) {
        for (Block block : blocks) {
            if (block.getAddress().equals(addressable))
                return block;
        }
        return null;
    }

    @Override
    public void add (Block block) throws Exception {
        if (blocks.contains(block))
            throw new Exception(ADDITION_ERROR);
        blocks.add(blocks.size(), block);;
    }

    @Override
    public void remove (Block block) throws Exception {
        int index = blocks.indexOf(block);
        if (index < 0)
            throw new Exception(REMOVAL_ERROR);
        blocks.remove(index);
    }
}
