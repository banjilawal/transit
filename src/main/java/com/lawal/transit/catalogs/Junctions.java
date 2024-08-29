package com.lawal.transit.catalogs;

import com.lawal.transit.junctions.*;

import java.util.*;

public enum Junctions implements Intersectionals, Iterable<Intersectional>  {
    INSTANCE;
    private final ArrayList<Intersectional> junctions;

    private Junctions () {
        junctions = new ArrayList<>();
    }

    @Override
    public int size () {
        return junctions.size();
    }

    @Override
    public Iterator<Intersectional> iterator () {
        return new JunctionIterator();
    }

    @Override
    public void add (Intersectional intersectional) throws Exception {
        if (search(intersectional.id()) != null)
            throw new Exception("Cannot add an duplicate intersection");
        junctions.add(junctions.size(), intersectional);
    }

    @Override
    public void remove (int intersectionId) throws Exception {
        int index = junctions.indexOf(search(intersectionId));
        if (index < 0)
            throw new Exception("Cannot remove an intersection that does not exist");
        junctions.remove(index);
    }

    @Override
    public Intersectional search (int intersectionId) {
        for (Intersectional junction : junctions) {
            if (junction.id() == intersectionId)
                return junction;
        }
        return null;
    }

    @Override
    public Intersectional next (int currentBranchId) {
        int currentIndex = junctions.indexOf(search(currentBranchId));
        if (currentIndex >= 0 && currentIndex < junctions.size() - 1)
            return junctions.get(currentIndex + 1);
        return null;
    }

    @Override
    public Intersectional previous (int currentBranchId) {
        int currentIndex = junctions.indexOf(search(currentBranchId));
        if (currentIndex > 0 && currentIndex < junctions.size())
            return junctions.get(currentIndex - 1);
        return null;
    }

    private class JunctionIterator implements Iterator<Intersectional> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext () {
            return currentIndex < junctions.size();
        }

        @Override
        public Intersectional next () {
            if (!hasNext())
                throw new NoSuchElementException();
            return junctions.get(currentIndex++);
        }
    }
}
