package com.lawal.transitcraft.infrastructure.road;

import com.lawal.transitcraft.common.exception.TransitCraftIdNullException;
import com.lawal.transitcraft.common.exception.TransitCraftNegativeIdException;
import com.lawal.transitcraft.infrastructure.avenue.Avenue;
import com.lawal.transitcraft.infrastructure.road.exception.ImmutableStreetModificationException;
import com.lawal.transitcraft.infrastructure.road.exception.StreetAssignmentConflictsWithExistingAvenueException;
import com.lawal.transitcraft.infrastructure.road.exception.StreetHasConflictingRoadReferenceException;
import com.lawal.transitcraft.infrastructure.street.Street;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RoadTest {

    @Test
    @DisplayName("💰 Should throw TransitCraftNegativeIdException when road ID is negative")
    void negativeRoadIdThrowsException () {
        assertThrows(TransitCraftNegativeIdException.class, () -> new Road(-1L));
    }

    @Test
    @DisplayName("💰 Should throw TransitCraftIdNullException when road ID is null")
    void nullRoadIdThrowsException () {
        assertThrows(TransitCraftIdNullException.class, () -> new Road(null));
    }

    @Test
    void idMustBePositive() {
        Road road = new Road(1L);
        assertTrue(road.getId() >= 1L);
    }

    @Test
    @DisplayName("💰 Constructing a street should establish a bidirectional relationship between" +
        " the street and the road it's built on")
    void constructingStreetEstablishedBidirectionalRelationShipWithRoad () {
        Road road = new Road(1L);
        Street street = new Street(1L, "1st Street", road);

        assertSame(road.getStreet(), street);
        assertSame(street, road.getStreet());
    }

    @Test
    @DisplayName("💰Should throw StreetHasConflictingRoadReferenceException")
    void exchangingStreetHasConflictingRoadReferenceThrowsException() {
        Road roadA = new Road(1L);
        Road roadB = new Road(2L);

        Street streetA = new Street(1L, "1st Street", roadA);

        assertThrows(StreetHasConflictingRoadReferenceException.class, () ->
            roadB.setStreet(streetA)
        );
    }

    @Test
    @DisplayName("Should throw ImmutableStreetModificationException when " +
        "road tries changing its' relationship with a street")
    void roadAttemptingToChangeCurrentRelationshipWithStreetThrowsException() {
        Road road = new Road(1L);
        Street street = new Street(1L, "1st Street", road);

        assertThrows(ImmutableStreetModificationException.class, () ->
            new Street(1L, "2nd Street", road)
        );
    }

    @Test
    @DisplayName("Should throw StreetAssignmentConflictsWithExistingAvenueException")
    void addingStreetWhenAvenueAlreadyExistsThrowsException() {
        Road road = new Road(1L);
        Avenue avenue = new Avenue(1L, "1st Avenue", road);

        assertThrows(StreetAssignmentConflictsWithExistingAvenueException.class,
            () -> new Street(1L, "1st Streete", road));
    }
}