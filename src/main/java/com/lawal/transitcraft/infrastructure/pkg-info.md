# Infrastructure Package

## Purpose
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