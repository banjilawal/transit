package com.lawal.transit.core.datatransfer;

import com.lawal.transit.core.enums.TransitRouteCategory;

public record TransitRouteScheduleRecord(TransitRouteCategory routeCategory, int routeId, String routeName, int stationId ) {
}
