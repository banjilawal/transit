package com.lawal.transit.dispatch;

import com.lawal.transit.search.*;

public interface TransitRequest extends SystemRequest {

    public Address getSource ();
    public Address getDestination ();
}
