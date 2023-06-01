package com.lawal.transit.middleware.collections;

import com.lawal.transit.middleware.abstracts.NamedEntity;
import com.lawal.transit.middleware.entities.Block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class OldestBag<E> {
   // private static int serialNumber = 1;
    private final ArrayList<NamedEntity> bag;

    public OldestBag () {
        bag = new ArrayList<>();
    }

    public int size () {
        return bag.size();
    } // close size

    public NamedEntity get(int index) {
        return bag.get(index);
    }

    public boolean contains (NamedEntity entity) {
        return (bag.contains(entity));
    }

    public NamedEntity search (int id) {
        for (NamedEntity namedEntity : bag) {
            if (namedEntity.getId() == id) {
                return namedEntity;
            }
        }
        return null;
    } // close search

    public NamedEntity search (String name) {
        for (NamedEntity namedEntity : bag) {
            if (namedEntity.getName().equalsIgnoreCase(name)) {
                return namedEntity;
            }
        }
        return null;
    } // close search

    public NamedEntity search (NamedEntity target) {
        for (NamedEntity namedEntity : bag) {
            if (namedEntity.equals(target)) {
                return namedEntity;
            }
        }
        return null;
    } // close search


    public boolean add (NamedEntity namedEntity) {
        if (bag.contains(namedEntity)) {
            return false;
        }
        return bag.add(namedEntity);
    } // close

    public boolean remove (int id) {
        NamedEntity namedEntity = search(id);
        if (namedEntity == null) {
            return false;
        }
        return bag.remove(namedEntity);
    } // close remove

    public boolean remove (String name) {
        NamedEntity namedEntity = search(name);
        if (namedEntity == null) {
            return false;
        }
        return bag.remove(namedEntity);
    } // close remove

    public boolean remove (NamedEntity namedEntity) {
        return bag.remove(namedEntity);
    } // close remove

    public Iterator iterator () {
        return bag.iterator();
    }

    //public Iterator iterator (Predicate predicate) {
    //
    //} // close

    //public static int nextSerialNumber () {
    //    return serialNumber++;
   // } // close nextSerialNumber

    @Override
    public String toString () {
        String string = this.getClass().getSimpleName() + "\n---------------------------";
        for (NamedEntity namedEntity : bag) {
            string += "\n" + namedEntity.toString(); //namedEntity.getName() + " " + namedEntity.getId();
        }
        return string;
    } // close to String

    public String fullString () {
        String string = this.getClass().getSimpleName() + "\n---------------------------";
        for (NamedEntity namedEntity : bag) {
            string += "\n[" + namedEntity.fullString() + "]";
        }
        return string;
    } // close to String

    public Iterator<Block> filterBag (Predicate<Block> predicate) {
        ArrayList<Block> results = new ArrayList<>();
        for (NamedEntity ie : this.bag) {
            if (predicate.test((Block) ie)) {
                results.add((Block) ie);
            }
        }
        return results.iterator();
    } // close
//
//    public Iterator<NamedEntity> filter (Predicate<NamedEntity> predicate) {
//        return process(predicate).iterator();
//    } // close filter
//
//    public ArrayList<NamedEntity> process(Predicate<NamedEntity> predicate) {
//        ArrayList<NamedEntity> results = new ArrayList<>();
//        for (NamedEntity ie: bag) {
//            if (predicate.test((NamedEntity) ie)) { //.getWestAvenue().equals(avenue)) {
//                results.add((NamedEntity) ie);
//            }
//        }
//        return results;
//    } // close process

//    public ArrayList<NamedEntity> process(Predicate<NamedEntity> predicate) {
//        ArrayList<NamedEntity> results = (ArrayList<NamedEntity>) new ArrayList<E>();
//        for (NamedEntity ie: bag) {
//            if (predicate.test((NamedEntity) ie)) { //.getWestAvenue().equals(avenue)) {
//                results.add((NamedEntity) ie);
//            }
//        }
//        return results;
//    } // close process

     public  <Block> Iterator<Block> filter (Iterable<Block> iterable, Predicate<Block> predicate) {
        return new FilteredIterator<Block>(iterable.iterator(), predicate);
    } // close filter

    public Stream<NamedEntity> stream () {
        return bag.stream();
    }

    private class FilteredIterator<Block> implements Iterator<Block> {
        private Iterator<Block> iterator;
        private Predicate<Block> predicate;
        private Block nextBlock;

        public FilteredIterator (Iterator<Block> iterator, Predicate<Block> predicate) {
            System.out.println("Bag line 158");
            this.iterator = iterator;
            this.predicate = predicate;
        } // close constructor

        @Override
        public boolean hasNext () {
            while (iterator.hasNext()) {
                Block block = iterator.next();
                if (predicate.test(block)) {
                    nextBlock = block;
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
            Block block = nextBlock;
            nextBlock = null;
            return block;
        } // close next
    } // end class FilteredIterator

    private class BagIterator implements Iterator<NamedEntity> {
        int index;
        private BagIterator () {
            this.index = 0;
        } // close constructor

        @Override
        public boolean hasNext () {
            return index != (bag.size() - 1);
        } // close hasNext

        @Override
        public NamedEntity next () {
            if (!hasNext()) {
                return null;
            }
            NamedEntity namedEntity = bag.get(index);
            index++;
            return namedEntity;
        } // close next
    } // end class BagIterator

    /*
    private class BagPredicateIterator<NamedEntity> implements Iterator<NamedEntity>, Predicate<NamedEntity> {
        int index ;
        Predicate predicate;
        public BagPredicateIterator (Predicate predicate) {
            this.predicate = predicate;
            this.index = 0;
        }

        @Override
        public boolean hasNext () {
            return index != (bag.size() - 1);
        }

        @Override
        public NamedEntity next () {
            return null;
        }

        @Override
        public void forEachRemaining (Consumer<? super NamedEntity> action) {
            Iterator.super.forEachRemaining(action);
        }

        @Override
        public boolean test (NamedEntity identifiableEntity) {
            if (predicate.test(identifiableEntity)) return
        }
    } // end class BagPredicateIterator
    */
} // end class Bag
