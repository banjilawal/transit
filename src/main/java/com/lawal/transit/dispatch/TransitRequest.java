package com.lawal.transit.dispatch;

import com.lawal.transit.globals.*;

public interface TransitRequest extends SystemRequest {

    public Address getSource ();
    public Address getDestination ();
}
