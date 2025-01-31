//package com.lawal.transit.transport.interfaces;
//
//import com.lawal.transit.globals.*;
//import com.lawal.transit.addressing.*;
//import com.lawal.transit.traveler.*;
//
//public interface Vehicle {
//
//    public  int getId ();
//    public int getCapacity ();
//    public Trackable getLocation ();
//    public TimeTable getSchedule ();
//    public FormattedAddress getNextStop ();
//    public Passengers getPassengers ();
//    public void setLocation (Trackable positionable);
//    public void setNextStop (FormattedAddress stop);
//    public void setSchedule (TimeTable timeTable);
//
//    public void embarkPassenger (Embarkation embarkation, Journey traveler) throws Exception;
//    public void disembarkPassenger (Disembarkation disembarkation, Journey traveler);
//
//}