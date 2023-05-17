package com.lawal.transit.middleware.collections;

import com.lawal.transit.middleware.abstracts.Entity;

import java.util.*;

public class AnonymousBag {
    private static final int serialNumber = 1;
    private final ArrayList<Entity> bag;

    public AnonymousBag () {
        bag = new ArrayList<Entity>();
    }

    public Entity get(int index) {
        return bag.get(index);
    }

    public boolean contains (Entity entity) {
        return (bag.contains(entity));
    }

    public Entity search (Entity target) {
        for (Entity entity : bag) {
            if (entity.equals(target)) {
                return entity;
            }
        }
        return null;
    } // close search

    public boolean add (Entity entity) {
        if (bag.contains(entity)) {
            return false;
        }
        return bag.add(entity);
    } // close

    public boolean remove (Entity entity) {
        return bag.remove (entity);
    } // close remove

    public Iterator iterator () {
        return bag.iterator();
    }

    public int size () {
        return bag.size();
    } // close size

    @Override
    public String toString () {
        String string = this.getClass().getSimpleName() + "\n---------------";
        for (Entity entity : bag) {
            string += "\n" + entity.toString();
        }
        return string;
    } // close to String

    private class AnonymousBagIterator implements Iterator<Entity> {
        int index;
        private AnonymousBagIterator () {
            this.index = 0;
        } // close constructor

        @Override
        public boolean hasNext () {
            return index != bag.size() - 1;
        } // close hasNext

        @Override
        public Entity next () {
            if (!hasNext()) {
                return null;
            }
            Entity entity = bag.get(index);
            index++;
            return entity;
        } // close next
    } // end class AnonymousBagIterator
} // end class AnonymousBag
