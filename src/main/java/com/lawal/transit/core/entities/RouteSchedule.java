package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.NamedEntity;
import com.lawal.transit.core.abstracts.TransitRoute;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class RouteSchedule extends NamedEntity {
    private String routeName;
    private ArrayList<ScheduledArrival> arrivals;

    public RouteSchedule (int id, TransitRoute transitRoute) {
        super(id, transitRoute.getName());
        this.arrivals = new ArrayList<ScheduledArrival>();
    } // close constructor

    public String getRouteName () {
        return routeName;
    } // close getRouteName

    public void setRouteName (TransitRoute transitRoute) {
        this.routeName = transitRoute.getName();
    } // close setRouteName

    public Iterator<ScheduledArrival> iterator () {
        return arrivals.iterator();
    } // close iterator

    public ArrayList<ScheduledArrival> getArrivals () {
        return arrivals;
    } // close getItems

    public void addArrivals (ArrayList<ScheduledArrival> arrivals) {
        for (ScheduledArrival arrival : arrivals) {
            addItem(arrival);
        }
    } // close addItems

    public void addItem (ScheduledArrival arrival) {
        if (!arrivals.contains(arrival)) {
            arrivals.add(arrivals.size(), arrival);
        }
    } // close addItem

    public void removeArrivals (ArrayList<ScheduledArrival> arrivals) {
        for (ScheduledArrival arrival : arrivals) {
            removeItem(arrival);
        }
    } // close removeItems

    public void removeItem (ScheduledArrival arrival) {
        int index = arrivals.indexOf(arrival);
        if (index > -1) {
            arrivals.remove(index);
        }
    } // close removeItem

    public void sort () {
        Collections.sort(arrivals, new ArrivalComparator());
    } // close sort

    public Iterator<ScheduledArrival> search (Station targetStation) {
        return search(targetStation, null);
    } // close search

    public Iterator<ScheduledArrival> search (Station targetStation, LocalTime targetTime) {
        Predicate<ScheduledArrival> timeMatch =
                (arrivalItem) ->
                minutesDifference(arrivalItem.getTime(), targetTime) < 5;
        return filter(targetStation, timeMatch);
    } // close search

    public Iterator<ScheduledArrival> filter (Station targetStation, Predicate timeMatch) {
        Predicate<ScheduledArrival> stationMatch =
                (arrivalItem) ->
                arrivalItem.getStationName().equalsIgnoreCase(targetStation.getName());
        if (timeMatch != null) {
            return filter(stationMatch.and(timeMatch));
        }
        return filter(stationMatch);
    } // close filter

    public Iterator<ScheduledArrival> filter (Predicate predicate) {
        ArrayList<ScheduledArrival> results = new ArrayList<ScheduledArrival>();
        for (ScheduledArrival arrival: arrivals) {
            if (predicate.test(arrival)) {
                results.add(results.size(), arrival);
            }
        }
        return results.iterator();
    } // close filter

    private int minutesDifference (LocalTime timeA, LocalTime timeB) {
        return secondsToMinutes(secondsDifference(timeA, timeB));
    } // close minutesDifference

    public String toString () {
        String string =  super.toString()
                + " " + printArrivalItems();
        return string;
    } // close toString

    public String printArrivalItems () {
        sort();
        String string = "Arrivals:\n---------";
        for (ScheduledArrival arrival: arrivals) {
            string += "\n" + arrival.toString();
        }
        return string;
    } // close printArrivalItems

    private int secondsToMinutes (int seconds) {
        return seconds % 60;
    } // cloe secondsToMinutes

    private int secondsDifference (LocalTime timeA, LocalTime timeB) {
        return Math.abs(timeA.toSecondOfDay() - timeB.toSecondOfDay());
    } // close timeDifferenceSeconds

    private class ArrivalComparator implements Comparator<ScheduledArrival> {
        @Override
        public int compare (ScheduledArrival a, ScheduledArrival b) {
            int nameResult = compareNames(a.getStationName(), b.getStationName());
            int arrivalResult = compareArrivals(a.getTime(), b.getTime());
            if (nameResult == 0) {
                return arrivalResult;
            }
            return nameResult;
        } // close compare

        private int compareNames (String a, String b) {
            if (a.compareTo(b) > 0) return 1;
            else if (a.compareTo(b) < 0) return -1;
            else return 0;
        } //

        private int compareArrivals (LocalTime timeA, LocalTime timeB) {
            if (timeA.compareTo(timeB) > 0) return 1;
            else if (timeA.compareTo(timeB) < 0) return -1;
            else return 0;
        } // close compareArrivals
    } // close ArrivalComparator
} // end class Schedule