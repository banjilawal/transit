package com.lawal.transit.road;

import com.lawal.transit.global.*;

public record Lane(int id, Direction trafficDirection) {

    @Override
    public String toString () {
        return "Laneable:" + id + trafficDirection.abbreviation();
    }
}