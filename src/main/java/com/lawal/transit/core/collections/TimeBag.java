package com.lawal.transit.core.collections;



import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

public class TimeBag {
    private final ArrayList<LocalTime> times;
    public TimeBag () {
        this.times = new ArrayList<>();
    } // close constructor

    public LocalTime search (LocalTime target) {
        for (Iterator<LocalTime> iterator = times.iterator(); iterator.hasNext();) {
            LocalTime time = iterator.next();
            if (time.equals(target)) {
                return time;
            }
        }
        return null;
    } // close search
    public boolean remove (LocalTime target) {
        if (!times.contains(target)) {
            return false;
        }
        else return times.remove(target);
    } // close removeTime

    public boolean add (LocalTime time) {
        if (times.contains(time)) {
            return false;
        }
        return times.add(time);
    } // close addTime

    public Iterator<LocalTime> iterator () {
        return times.iterator();
    } // close iterator

    public int size () {
        return times.size();
    } // close getTimeTotal

    @Override
    public String toString () {
        String string = "Times\n-----";
        for (LocalTime time : times) {
            string += "\n" + time.toString();
        }
        return string;
    } // close toString
} // end class TimeBag
