package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.entities.Block;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Blocks implements BagWrapper<Block> {
    INSTANCE;
    private final Bag<Block> bag = new Bag<Block>();

    public int size () { return bag.size(); }

    public Bag<Block> getBag() {
        return bag;
    }

    public boolean add (Block block) {
        return bag.add(block);
    }

    public boolean remove (Block block) {
        return bag.remove(block.getId());
    }

    public Iterator<Block> iterator () {
        return bag.iterator();
    }

    public String toString () {
        return "Block" + " " + bag.toString();
    }

    public String fullString () {
        return bag.fullString();
    }


     public  <Block> Iterator<Block> filterBlocks (Predicate<Block> predicate) {
        return new FilteredIterator<>(getBag().iterator(), predicate);
    } // close filter

    private class FilteredIterator<Block> implements Iterator<Block> {
        private Iterator<Block> iterator;
        private Predicate<Block> predicate;
        private Block nextBlock;

        public FilteredIterator (Iterator<Block> iterator, Predicate<Block> predicate) {
            System.out.println("line 147");
            this.iterator = iterator;
            this.predicate = predicate;
        } // close constructor

        @Override
        public boolean hasNext () {
            while (iterator.hasNext()) {
                Block element = (Block) iterator.next();
                if (predicate.test(element)) {
                    nextBlock = element;
                    return true;
                }
            }
            return false;
        } // close hasNext

        @Override
        public Block next () {
            if (nextBlock == null && !hasNext()) {
                return null;
            }
            Block element = nextBlock;
            nextBlock = null;
            return element;
        } // close next
    } // end class FilteredIterator

} // end class BLocks
