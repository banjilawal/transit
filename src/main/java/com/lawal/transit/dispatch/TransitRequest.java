package com.lawal.transit.dispatch;

import com.lawal.transit.addressing.*;

public interface TransitRequest extends SystemRequest {

    public Address getSource ();
    public Address getDestination ();
}