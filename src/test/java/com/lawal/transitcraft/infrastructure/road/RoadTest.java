package com.lawal.transitcraft.infrastructure.road;

import com.lawal.transitcraft.common.exception.TransitCraftIdNullException;
import com.lawal.transitcraft.common.exception.TransitCraftNegativeIdException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoadTest {
    @Test
    void NegativeRoadIdThrowsException () {
        assertThrows(TransitCraftNegativeIdException.class, () -> new Road(-1L));
    }

    @Test
    void NullRoadIdThrowsException () {
        assertThrows(TransitCraftIdNullException.class, () -> new Road(null));
    }

    @Test
    void idMustBePositive() {
        Road road = new Road(1L);
        assertTrue(road.getId() >= 1L);
    }
}