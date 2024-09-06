//package com.lawal.transit.catalogs;
//
//import com.lawal.transit.globals.*;
//import com.lawal.transit.addressing.*;
//import com.lawal.transit.stations.interfaces.*;
//import com.lawal.transit.transport.*;
//import com.lawal.transit.transport.interfaces.*;
//
//import java.time.*;
//import java.util.*;
//import java.util.function.*;
//
//public enum Schedules implements Iterable<TimeTable> {
//    INSTANCE;
//
//    private final List<TimeTable> list;
//
//    Schedules () {
//        list = new ArrayList<>();
//    }
//
//    public void add (String name) throws Exception {
//        for (TimeTable schedule : list) {
//            if (schedule.getName().equalsIgnoreCase(name))
//                throw new Exception("A schedule named" + name + " already exists");
//        }
//        list.add(list.size(), new Schedule(IdGenerator.INSTANCE.nextScheduleId(), name));
//    }
//
//    public void remove (String name) throws Exception {
//        TimeTable timeTable = search(name);
//        if (timeTable == null)
//            throw new Exception("No schedule named " + name + "exists. Deletion not possible");
//        int index = list.indexOf(timeTable);
//        list.remove(index);
//    }
//
//    public TimeTable searchById (int id) {
//        for (TimeTable timeTable : list) {
//            if (timeTable.getId() == id)
//                return timeTable;
//        }
//        return null;
//    }
//
//    public TimeTable search (String name) {
//        for (TimeTable timeTable : list) {
//            if (timeTable.getName().equalsIgnoreCase(name))
//                return timeTable;
//        }
//        return null;
//    }
//
//    public Iterator<TimeTable> iterator () {
//        return list.iterator();
//    }
//
//
//    public ArrayList<TimeTable> selectByAddress (FormattedAddress address) {
//        ArrayList<TimeTable> results = new ArrayList<>();
//        for (TimeTable timeTable : list) {
//            if (timeTable.getEntries().positionExists(address))
//                results.add(results.size(), timeTable);
//        }
//        return results;
//    }
//
//    public HashMap<String, ArrayList<Positionable>> selectByTime (FormattedAddress address,  LocalDateTime time, long minuteRange) {
//        HashMap<String, ArrayList<Positionable>> results = new HashMap<>();
//        for (TimeTable timeTable : list) {
//            if (timeTable.getEntries().positionExists(address)) {
//                ArrayList<Positionable> entries = timeTable.getEntries().selectByTime(time, minuteRange);
//                results.put(timeTable.getName(),entries);
//            }
//        }
//        return results;
//    }
//
//    public Iterator<TimeTable> filterByStation (Stationable stationable) {
//        List<TimeTable> results = new ArrayList<>();
//        for (TimeTable timeTable : list) {
//            if (timeTable.getEntries().positionExists(stationable.getAddress()) && !results.contains(timeTable))
//                results.add(results.size(), timeTable);
//        }
//        return results.iterator();
//    }
//
//    private class TimeTableIterator implements  Iterator<TimeTable> {
//        int currentIndex = 0;
//
//        @Override
//        public boolean hasNext () {
//            return currentIndex < list.size();
//        }
//
//        @Override
//        public TimeTable next () {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            return list.get(currentIndex++);
//        }
//
//        @Override
//        public void forEachRemaining (Consumer<? super TimeTable> action) {
//            while (hasNext()) {
//                action.accept((next()));
//            }
//        }
//
//        @Override
//        public void remove () {
//            throw new UnsupportedOperationException();
//        }
//    }
//}