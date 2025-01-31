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
//    public boolean positionExists (FormattedAddress address);
//    public ArrayList<Trackable> selectByAddress (FormattedAddress address);
//    public ArrayList<Trackable> selectByTime (LocalDateTime time, long minuteRange);
//}