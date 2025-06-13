package com.lawal.transitcraft.infrastructure.road;

import com.lawal.transitcraft.common.exception.TransitCraftIdNullException;
import com.lawal.transitcraft.common.exception.TransitCraftNegativeIdException;
import com.lawal.transitcraft.infrastructure.street.Street;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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

    @Test
    void settingStreetEstablishedBidirectionalRelationShip() {
        Road road = new Road(1L);
        Street street = new Street(1L, "1st Street", road);

        assertSame(road.getStreet(), street);
        assertSame(street, road.getStreet());
    }
}