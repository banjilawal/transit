package com.lawal.transit.dispatch;

import java.time.*;

public abstract class Request implements SystemRequest {

    private int id;
    private LocalDateTime arrivalTime;

    public Request (int id) {
        this.id = id;
        this.arrivalTime = LocalDateTime.now();
    }

    @Override
    public int getId () {
        return id;
    }

    @Override
    public LocalDateTime getArrivalTime () {
        return arrivalTime;
    }

    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Request) {

        }
        return false;
    }
}
