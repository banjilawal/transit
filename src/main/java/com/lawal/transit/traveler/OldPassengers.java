package com.lawal.transit.traveler;

//import com.lawal.transit.transport.*;
//
//import java.util.*;
//import java.util.function.*;

//public final class Passengers {
//
//    private final ArrayList<Journey> travelers;
//
//    public Passengers () {
//        this.travelers = new ArrayList<>();
//    }
//
//    public int size () {
//        return travelers.size();
//    }
//
//    @Override
//    public Iterator<Embarkation> iterator () {
//        return new PassengerIterator();
//    }
//
//    @Override
//    public void enqueue (Journey traveler){
//        travelers.add(travelers.size(), traveler);
//    }
//
//    public Journey dequeue () {
//        if (!travelers.isEmpty())
//            return travelers.get(0);
//        return null;
//    }
//
//    @Override
//    public void remove (int id){
//        embarkers.remove(id);
//    }
//
//    private class PassengerIterator implements Iterator<Embarkation> {
//
//        int currentIndex = 0;
//
//        @Override
//        public boolean hasNext () {
//            return currentIndex < embarkers.size();
//        }
//
//        @Override
//        public Embarkation next () {
//            Embarkation embarker = embarkers.get(currentIndex);
//            currentIndex++;
//            return embarker;
//        }
//
//        @Override
//        public void remove () {
//            throw new UnsupportedOperationException();
//        }
//
//        @Override
//        public void forEachRemaining (Consumer<? super Embarkation> action) {
//            while (hasNext()) {
//                action.accept(next());
//            }
//        }
//    }
//}