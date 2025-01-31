package com.lawal.transit.junction;

import lombok.Getter;

import java.util.*;

@Getter
public  class Junctions implements JunctionEntities {

    private final ArrayList<JunctionEntity> junctions;

    public Junctions () {
        junctions = new ArrayList<>();
    }

    @Override
    public int size () {
        return junctions.size();
    }

    @Override
    public Iterator<JunctionEntity> iterator () {
        return new JunctionIterator();
    }

    @Override
    public void add (JunctionEntity junctionEntity) throws Exception {
        if (search(junctionEntity.id()) != null)
            throw new Exception("Cannot add an duplicate intersection");
        junctions.add(junctions.size(), junctionEntity);
    }

    @Override
    public void remove (int junctionId) throws Exception {
        int index = junctions.indexOf(search(junctionId));
        if (index < 0)
            throw new Exception("Cannot remove an intersection that does not exist");
        junctions.remove(index);
    }

    @Override
    public JunctionEntity search (int junctionId) {
        for (JunctionEntity junction : junctions) {
            if (junction.id() == junctionId)
                return junction;
        }
        return null;
    }

    @Override
    public JunctionEntity next (int junctionId) {
        int currentIndex = junctions.indexOf(search(junctionId));
        if (currentIndex >= 0 && currentIndex < junctions.size() - 1)
            return junctions.get(currentIndex + 1);
        return null;
    }

    @Override
    public JunctionEntity previous (int junctionId) {
        int currentIndex = junctions.indexOf(search(junctionId));
        if (currentIndex > 0 && currentIndex < junctions.size())
            return junctions.get(currentIndex - 1);
        return null;
    }

    private class JunctionIterator implements Iterator<JunctionEntity> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext () {
            return currentIndex < junctions.size();
        }

        @Override
        public JunctionEntity next () {
            if (!hasNext())
                throw new NoSuchElementException();
            return junctions.get(currentIndex++);
        }
    }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder().append("\n");
        for (JunctionEntity junction : junctions) {
            stringBuilder.append(junction.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}