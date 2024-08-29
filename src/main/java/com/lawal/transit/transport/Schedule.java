package com.lawal.transit.transport;

import com.lawal.transit.globals.*;
import com.lawal.transit.transport.interfaces.*;
import com.lawal.transit.traveler.*;

public final class Schedule implements TimeTable {

    private final int id;
    private final String name;
    private final Trajectory entries;

    private Schedule (Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.entries = builder.entries;
    }

    @Override
    public int getId () { return id; }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public Trajectory getEntries () {
        return entries;
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof TimeTable timeTable)
            return id == timeTable.getId() && name.equalsIgnoreCase(timeTable.getName());
        return false;
    }

    @Override
    public String toString () {
        return name + " "  + getClass().getSimpleName() + "\n" + entries.toString();
    }

    public static Builder builder () { return new Builder(); }

    public static class Builder {
        private int id;
        private String name;
        private Trajectory entries;

        public Builder id (int id ) {
            this.id = id;
            return this;
        }

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder entries (Trajectory entries) {
            this.entries = entries;
            return this;
        }

        public TimeTable build () {
            return new Schedule(this);
        }

    }
}
