package com.lawal.transit.core.singletons;

import com.lawal.transit.core.containers.Bag;
import com.lawal.transit.core.entities.RegularSchedule;
import com.lawal.transit.core.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;

public enum RegularSchedules implements BagWrapper<RegularSchedule> {
    INSTANCE;
    private Bag<RegularSchedule> schedules = new Bag<RegularSchedule>();

    @Override
    public int size() { return schedules.size(); }

    @Override
    public void add(RegularSchedule schedule) { schedules.add(schedule); }

    @Override
    public void remove(RegularSchedule schedule) { schedules.remove(schedule); }
    @Override
    public Bag<RegularSchedule> getBag() {
        return schedules;
    }

    @Override
    public Iterator<RegularSchedule> iterator() {
        return schedules.iterator();
    }

    @Override
    public ArrayList<RegularSchedule> getBagContents() {
        return schedules.getContents();
    }

} // end enum RegularBusRoutes