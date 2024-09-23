package com.lawal.transit.dispatch;

import com.lawal.transit.addressing.*;

public interface TransitRequest extends SystemRequest {

    public RetiredAddressOld getSource ();
    public RetiredAddressOld getDestination ();
}