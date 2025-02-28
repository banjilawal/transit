package com.lawal.transit.junction;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.*;

@Getter
public  class Junctions {

    private final List<Junction> junctions;

    public Junctions() {
        junctions = new ArrayList<>();
    }


    public int size() {
        return junctions.size();
    }
    
    public Iterator<Junction> iterator() {
        return junctions.iterator();
    }

    public void add(Junction junction) {
        if (junction != null && !junctions.contains(junction)) { junctions.add(junctions.size(), junction); }
    }

    public void remove(Long junctionId) throws Exception {
        Junction junction = findById(junctionId);
        if (junction != null) { junctions.remove(junction); }
    }

    public Junction findById(Long id) {
        for (Junction junction : junctions) {
            if (junction.getId().equals(id)) return junction;
        }
        return null;
    }

    public List<Junction> filterByAvenue(Avenue avenue) {
        Junctions matches = new Junctions();
        for (Junction junction : junctions) {
            if (junction.getAvenue().equals(avenue)) { matches.junctions.add(junction); }
        }
        return matches.junctions;
    }

    public List<Junction> filterByStreet(Street street) {
        Junctions matches = new Junctions();
        for (Junction junction : junctions) {
            if (junction.getStreet().equals(street)) { matches.junctions.add(junction); }
        }
        return matches.junctions;
    }
//
//    @Override
//    public Junction next (int junctionId) {
//        int currentIndex = junctions.indexOf(search(junctionId));
//        if (currentIndex >= 0 && currentIndex < junctions.size() - 1)
//            return junctions.get(currentIndex + 1);
//        return null;
//    }
//
//    @Override
//    public Junction previous (int junctionId) {
//        int currentIndex = junctions.indexOf(search(junctionId));
//        if (currentIndex > 0 && currentIndex < junctions.size())
//            return junctions.get(currentIndex - 1);
//        return null;
//    }
//
//    private class JunctionIterator implements Iterator<Junction> {
//        private int currentIndex = 0;
//
//        @Override
//        public boolean hasNext () {
//            return currentIndex < junctions.size();
//        }
//
//        @Override
//        public Junction next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            return junctions.get(currentIndex++);
//        }
//    }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder().append("\n");
        for (Junction junction : junctions) {
            stringBuilder.append(junction.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}