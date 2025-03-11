//package com.lawal.transit.globals;
//
//import com.lawal.transit.addressing.*;
//
//import java.time.*;
//import java.util.*;
//
//public interface Trajectory {
//
//    public Iterator<Trackable> iterator ();
//    public void add (Trackable positionable) throws Exception;
//    public void remove (Trackable positionable) throws Exception;
//    public boolean positionExists (FormattedAddress house);
//    public ArrayList<Trackable> selectByAddress (FormattedAddress house);
//    public ArrayList<Trackable> selectByTime (LocalDateTime time, long minuteRange);
//}