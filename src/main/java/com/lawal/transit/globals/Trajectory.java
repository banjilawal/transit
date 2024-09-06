//package com.lawal.transit.globals;
//
//import com.lawal.transit.addressing.*;
//
//import java.time.*;
//import java.util.*;
//
//public interface Trajectory {
//
//    public Iterator<Positionable> iterator ();
//    public void add (Positionable positionable) throws Exception;
//    public void remove (Positionable positionable) throws Exception;
//    public boolean positionExists (FormattedAddress address);
//    public ArrayList<Positionable> selectByAddress (FormattedAddress address);
//    public ArrayList<Positionable> selectByTime (LocalDateTime time, long minuteRange);
//}