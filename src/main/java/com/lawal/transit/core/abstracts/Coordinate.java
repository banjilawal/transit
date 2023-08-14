package com.lawal.transit.core.abstracts;

import java.util.Objects;

import static java.util.Objects.hash;

public abstract class Coordinate extends NamedEntity {
    private Path xPath;
    private Path yPath;
    private int xCoordinateIndex;
    private int yCoordinateIndex;

    public Coordinate (int id, String name, Path xPath, Path yPath) {
        this(id, name, xPath, yPath, 0, 0);
    }

    public Coordinate (int id, String name, Path xPath, Path yPath, int xCoordinateIndex, int yCooordinateIndex) {
        super(id, name);
        this.xPath = xPath;
        this.yPath = yPath;
        this.xCoordinateIndex = xCoordinateIndex;
        this.yCoordinateIndex = yCooordinateIndex;
    } // close constructor

    public Path getXPath( ) {
        return xPath;
    }

    public Path getYPath () {
        return yPath;
    }

    public int getXCoordinateIndex () { return xCoordinateIndex; }
    public int getYCoordinateIndex () { return yCoordinateIndex; }

    public void setXPath (Path xPath) {
        this.xPath = xPath;
    }

    public void setYPath (Path yPath) {
        this.yPath = yPath;
    }

    public void setXCoordinateIndex (int xCoordinateIndex) {
        this.xCoordinateIndex = xCoordinateIndex;
    }

    public void setyCoordinateIndex (int yCoordinateIndex) {
        this.yCoordinateIndex = yCoordinateIndex;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Coordinate coordinate) {
            return super.equals(coordinate) && sameXPath(coordinate) && sameYPath(coordinate) && sameIndices(coordinate);
        }
        return false;
    } // close equals

    @Override
    public int hashCode() {
        return hash(super.hashCode(), xPath, yPath, xCoordinateIndex, yCoordinateIndex);
    }

    public boolean sameXPath (Coordinate coordinate) { return xPath.equals(coordinate.getXPath()); } // close sameXCoordinate

    public boolean sameYPath (Coordinate coordinate) { return yPath.equals(coordinate.getYPath()); } // close sameYCoordinate

    public boolean sameIndices (Coordinate coord) { return xCoordinateIndex == coord.getXCoordinateIndex() && yCoordinateIndex == coord.getYCoordinateIndex(); } // close sameXCoordinate

    @Override
    public String toString () { return super.toString() + " xPath:" + xPath.toString() + ", yPath:" + yPath.toString(); } // close toString
} // end class AnonymousCoordinate
