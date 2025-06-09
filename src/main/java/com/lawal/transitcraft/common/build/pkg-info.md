# `com.lawal.transitcraft.common.build`

---
## Purpose
Certain packages must be built before others. The package:
- Initializes entities earlier in the dependency chain.
- Injects lower in the hierarchy into constructors, builders, ir factories.
- Maintains system's build-or-dependency.
- Populates repositories with test data

---
## Package Dependencies
Requires:
- `com.lawal.transitcraft.infrastructure`

---
## Class Relationship
```plantuml
@startuml
package build {
    enum BlockEdgeFactory {
        - id: AtomicLong
        + run(): void
        - buildJunctionCornerEdges(Junction junction)
        - buildNorthSouthEdges(Junction junction): void
        - buildEastWestEdges(Junction junction): void
        - cornerEdgeBuildHelper (Junction junction, Direction cornerOrientation): void
    }
    
    enum JunctionCornerBuilder {
        + build(Junction junction, Direction cornerOrientation): JunctionCorner
        - getAvenueLeg(Junction junction, Direction cornerOrientation): Block
        -static getStreetLeg(Junction junction, Direction cornerOrientation): Block
        -static getAvenueCurb(Junction junction, (Direction cornerOrientation): Curb
        -static getStreetCurb(Junction junction, (Direction cornerOrientation): Curb
        -static isValidOrientation(Direction cornerOrientation): boolean
    }
    
    enum BusRouteFactory {
        +static final routeId: AtomicLong
        +static final stopId: AtomicLong
        + run(): void
        + addDepartures(BusRoute busRoute, Road road): void
        - randomName(): String
        - randomInterarrivalTime(): Integer   
    }
    
    enum StationEdgeFactory {
        - id: AtomicLong
        + run():void
        - buildCurbEdges(): void
        - buildCycleEdges()
        - curbEdgeBuildHelper(Curb curb): void
        - cycleEdgeBuildHelper(Curb curb): void
    }
    
    enum TransitSystemBuilder {
        -final roadId: atomicLong
        -final avenueId: atomicLong
        -final streetId: atomicLong
        -final curbId: atomicLong
        -final blockId: atomicLong
        -final stationId: atomicLong
        -final houseId: atomicLong
        -final junctionId: atomicLong
        -final junctionCornerId: atomicLong
        + run(): void
        - buildAvenues(): void
        - buildStreets():void
        - buildBlocks():void
        - buildJunctions(): void
        - blockCreationHelper(Curb curb, int numberOfBlocks): void
        - buildStations(Curb curb, int percentStationDensity): void
        - buildHouses(Curb curb): void
        - putHousesOnBlock(Block block, long address, int addressInterval, int numberOfHouses): void
        - buildJunctionCorners(Junction junction): void
    }
}
@enduml
```