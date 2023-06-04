package com.lawal.transit.core.singletons;

import com.lawal.transit.core.abstracts.TransitRoute;
import com.lawal.transit.core.collections.Bag;
import com.lawal.transit.core.entities.ScheduledArrivalItem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public enum TransitRouteSchedules {
    INSTANCE;
    public Bag<ScheduledArrivalItem> schedules = new Bag<ScheduledArrivalItem>();

    public Bag<ScheduledArrivalItem> getSchedules () {
        return schedules;
    } // close getSchedules

    public void sort () {
        Collections.sort(schedules.getContents(), new ScheduleItemComparator());
    } // close sort

    public Iterator<ScheduledArrivalItem> routeFilter (TransitRoute target) {
        ArrayList<ScheduledArrivalItem> results = new ArrayList<ScheduledArrivalItem>();
        Predicate<ScheduledArrivalItem> predicate = (scheduledArrivalItem)
                -> scheduledArrivalItem.getTransitRouteName().equalsIgnoreCase(target.getName());
        return schedules.search(predicate);
    } // close routeFilter

   private class ScheduleItemComparator implements Comparator<ScheduledArrivalItem> {

       @Override
       public int compare (ScheduledArrivalItem a, ScheduledArrivalItem b) {
           int idResult = (compareIds(a.getId(), b.getId()));
           int typeResult = compareRouteTypes(a.getTransitRouteType(), b.getTransitRouteType());
           int routeResult = compareRouteNames(a.getTransitRouteName(), b.getTransitRouteName());
           int stationResult = compareStationNames(a.getStationName(), b.getStationName());
           int arrivalResult = compareArrivals(a.getScheduledArrival(), b.getScheduledArrival());
           if (typeResult == 0) {
               if (routeResult == 0) {
                   if (stationResult == 0) {
                       if (arrivalResult == 0) {
                           return idResult;
                       }
                       return arrivalResult;
                   }
                   return stationResult;
               }
               return routeResult;
           }
           return typeResult;
       } //

       private int compareRouteTypes (String routeA, String routeB) {
           return compareStrings(routeA, routeB);
       } //

       private int compareRouteNames (String routeNameA, String routeNameB) {
           return compareStrings(routeNameA, routeNameB);
       } //

       private int compareStationNames (String stationNameA, String stationNameB) {
           return compareStrings(stationNameA, stationNameB);
       } //

       private int compareArrivals (LocalTime arrivalTimeA, LocalTime arrivalTimeB) {
           if (arrivalTimeA.compareTo(arrivalTimeB) > 0) return 1;
           else if (arrivalTimeA.compareTo(arrivalTimeB) < 0) return -1;
           else return 0;
       } // close compareArrivals

       private int compareIds (int a, int b) {
           return a - b;
       } // close compareIds

        private int compareStrings (String a, String b) {
            if (a.compareTo(b) > 0) return 1;
            else if (a.compareTo(b) < 0) return -1;
            else return 0;
        } // close compareRouteTypes


   } // close ScheduleItemCompartor

} // end enum TransitRouteSchedules
