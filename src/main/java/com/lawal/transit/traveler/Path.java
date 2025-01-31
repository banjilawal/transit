//package com.lawal.transit.traveler;
//
//import com.lawal.transit.globals.*;
//import com.lawal.transit.addressing.*;
//
//import java.time.*;
//import java.util.*;
//import java.util.function.*;
//
//public class Path implements Trajectory, Iterable<Trackable> {
//
//    private ArrayList<Trackable> path;
//
//    public Path () {
//        this.path = new ArrayList<>();
//    }
//
//    @Override
//    public Iterator<Trackable> iterator () {
//        return new PositionableIterator();
//    }
//
//    @Override
//    public void add (Trackable positionable) throws Exception {
//        if (path.contains(positionable))
//            throw new Exception("Cannot add a point which already exists in the collection.");
//        path.add(path.size(), positionable);
//
//    }
//
//    @Override
//    public void remove (Trackable positionable) throws Exception {
//        int index = path.indexOf(positionable);
//        if (index < 0)
//            throw new NoSuchElementException("No such element to remove");
//        path.remove(index);
//    }
//
//    @Override
//    public boolean positionExists (FormattedAddress address) {
//        for (Trackable positionable : path) {
//            if (positionable.address().equals(address))
//                return true;
//        }
//        return false;
//    }
//
//    @Override
//    public ArrayList<Trackable> selectByAddress (FormattedAddress address) {
//        ArrayList<Trackable> results = new ArrayList<>();
//        for (Trackable positionable : path) {
//            if (positionable.address().equals(address) && !results.contains(positionable))
//                results.add(results.size(), positionable);
//        }
//        return results;
//    }
//
//    @Override
//    public ArrayList<Trackable> selectByTime (LocalDateTime time, long minuteRange) {
//        ArrayList<Trackable> results = new ArrayList<>();
//        for (Trackable positionable : path) {
//            if (positionable.time().isEqual(time) && positionable.time().isBefore(time.plusMinutes(minuteRange)))
//                results.add(results.size(), positionable);
//        }
//        return results;
//    }
//
//    @Override
//    public String toString () {
//        StringBuilder stringBuilder = new StringBuilder("\n");
//        for(Trackable positionable : path) {
//           stringBuilder.append(positionable.toString()).append("\n");
//        }
//        return stringBuilder.toString();
//    }
//
//    private class PositionableIterator implements  Iterator<Trackable> {
//        int currentIndex = 0;
//
//        @Override
//        public boolean hasNext () {
//            return currentIndex < path.size();
//        }
//
//        @Override
//        public Trackable next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            Trackable positionable = path.get(currentIndex);
//            currentIndex++;
//            return positionable;
//        }
//
//        @Override
//        public void forEachRemaining (Consumer<? super Trackable> action) {
//            while (hasNext()) {
//                action.accept(next());
//            }
//        }
//
//        @Override
//        public void remove () {
//            throw new UnsupportedOperationException();
//        }
//    }
//}