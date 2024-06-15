package com.lawal.transit.dispatch;

import com.lawal.transit.addresses.*;

public interface TransitRequest extends SystemRequest {

    public LocationAddress getSource ();
    public LocationAddress getDestination ();
}
