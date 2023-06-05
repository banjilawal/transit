package com.lawal.transit.core.singletons;

import com.lawal.transit.core.abstracts.TransitRoute;
import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.RouteSchedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public enum RouteSchedules {
    INSTANCE;
    public Bag<RouteSchedule> schedules = new Bag<RouteSchedule>();

    public Bag<RouteSchedule> getSchedules () {
        return schedules;
    } // close getSchedules

    public void sort () {
        Collections.sort(schedules.getContents(), new ScheduleComparator());
    } // close sort

    public Iterator<RouteSchedule> filter (TransitRoute target) {
        ArrayList<RouteSchedule> results = new ArrayList<RouteSchedule>();
        Predicate<RouteSchedule> predicate = (routeSchedule)
                -> routeSchedule.getRouteName().equalsIgnoreCase(target.getName());
        return schedules.search(predicate);
    } // close filter

   private class ScheduleComparator implements Comparator<RouteSchedule> {

       @Override
       public int compare (RouteSchedule a, RouteSchedule b) {
           int nameResult = compareRouteNames(a.getRouteName(), b.getRouteName());
           int idResult = compareIds(a.getId(), b.getId());

           if (nameResult == 0) {
               return idResult;
           }
           return nameResult;
       } //

       private int compareRouteNames (String a, String b) {
           if (a.compareTo(b) > 0) return 1;
           else if (a.compareTo(b) < 0) return -1;
           else return 0;
       } //

       private int compareIds (int a, int b) {
           return a - b;
       } // close compareIds
   } // close ScheduleItemCompartor
} // end enum TransitRouteSchedules
