package com.lawal.transit.middleware.datatransfer;

import com.lawal.transit.middleware.enums.TransitRouteCategory;

public record TransitRouteScheduleRecord(TransitRouteCategory routeCategory, int routeId, String routeName, int stationId ) {
}
