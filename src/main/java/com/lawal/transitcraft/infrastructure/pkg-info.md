# Infrastructure Package
TransitCraft has static infrastructure that defines and creates the world. A mass transit system 
is overlaid on city grid.

## Purpose

### 1 The City Grid layer
Consists of roads, intersections, blocks and houses.

### BlockGraph
Blocks have:
- Line-of-sight neighbors.
- Neighbors at 90 degrees.

### IntersectionGraph
Vertices are where roads meet. Edges of the IntersectionGraph are avenues and streets.
Each intersection has a number of corners.

## The Mass Transit Overlay
The layers here have sub-graphs.
- StationGraph
- TransitRouteGraph
- TransitVehicleGraph

### StationGraph
The transit stops located on blocks. Edges between stations are blocks on roads. The 
transit.

### TransitRouteGraph
A set of sub-graphs that defined a scheduled transit route. Vertices are stations. Edges
are legs of the route. All the sub-graphs are cycles.

# Infrastructure Package


TransitCraft's infrastructure package defines and manages the static infrastructure that creates the world, consisting of a city grid with an overlaid mass transit system.

## Key Components

### City Grid Components
- **BlockGraph** - Manages blocks with line-of-sight and 90-degree neighbor relationships
- **IntersectionGraph** - Handles road intersections and their connecting avenues/streets

### Mass Transit Components
- **StationGraph** - Manages transit stops and their block connections
- **TransitRouteGraph** - Defines scheduled transit routes as cycles between stations
- **TransitVehicleGraph** - Handles the transit vehicle movement and scheduling

## Package Structure
The package is organized into two main conceptual layers:

### 1. City Grid Layer
Fundamental static infrastructure including:
- Roads
- Intersections
- Blocks
- Houses

### 2. Mass Transit Layer
Dynamic transit system overlay including:
- Station network
- Route definitions
- Vehicle management

## Technical Notes
- Blocks implement neighbor relationships in both line-of-sight and 90-degree orientations
- Intersection vertices represent road meeting points
- Transit routes are implemented as cyclic sub-graphs
- All transit graphs are specialized implementations optimized for their specific use cases

## Related Components
- City generation system
- Traffic management system
- Route planning components