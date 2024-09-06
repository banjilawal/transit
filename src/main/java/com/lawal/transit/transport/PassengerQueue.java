//package com.lawal.transit.transport;
//
//import com.lawal.transit.traveler.*;
//
//import java.util.*;
//
//public class PassengerQueue {
//
//    private final ArrayList<Traveler> queue;
//
//    public PassengerQueue () {
//        this.queue = new ArrayList<>();
//    }
//
//    public void enqueue (Traveler traveler) throws Exception {
//        if (queue.contains(traveler))
//            throw new Exception("The traveler is already in the queue");
//        queue.add(queue.size(), traveler);
//    }
//
//    public Traveler dequeue () {
//        if (!queue.isEmpty())
//            return queue.get(0);
//        return null;
//    }
//}