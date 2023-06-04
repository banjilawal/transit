package com.lawal.transit.core.abstracts;

import static java.util.Objects.hash;

public abstract class Coordinate extends NamedEntity {
    private DuplexPath xCoordinate;
    private DuplexPath yCoordinate;

    public Coordinate(int id, String name, DuplexPath xCoordinate, DuplexPath yCoordinate) {
        super(id, name);
        this.xCoordinate = xCoordinate; //validatePath(xCoordinate, yCoordinate);
        this.yCoordinate = yCoordinate;
    } // close constructor

    public DuplexPath getXCoordinate () {
        return xCoordinate;
    }

    public DuplexPath getYCoordinate () {
        return yCoordinate;
    }

    public void setXCoordinate (DuplexPath xCoordinate) {
        this.xCoordinate = xCoordinate; //validatePath(xCoordinate, this.yCoordinate) ;
    } //

    public void setYCoordinate (DuplexPath yCoordinate) {
        this.yCoordinate = yCoordinate; //validatePath(yCoordinate, this.xCoordinate);
    } //

    @Override
    public boolean equals (Object object) {
        if (object instanceof Coordinate coordinate) {
            if (this.sameXCoordinate(coordinate) && this.sameYCoordinate(coordinate)) {
                return true;
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return hash(xCoordinate, yCoordinate);
    } // close hashCode

    @Override
    public String toString () {
        String string = super.toString() + " (" + xCoordinate.toString() + ", " + yCoordinate.toString() + ")";
        return string;
    } // close toString

    public boolean sameXCoordinate (Coordinate coordinate) {
        return xCoordinate.equals(coordinate.getXCoordinate());
    } // close sameXCoordinate

    public boolean sameYCoordinate (Coordinate coordinate) {
        return yCoordinate.equals(coordinate.getYCoordinate());
    } // close sameYCoordinate
    /*
    private DuplexPath validatePath (DuplexPath path, DuplexPath crossPath) {
        try {
            if (path.equals(crossPath)) {
                String errorMessage = generateErrorMessage("validatePath", "path-crossPath conflict",79, CoordinateException.PREFIX);
                throw new CoordinateException(errorMessage);
            }
        } catch (CoordinateException e) {
            System.err.println(e.getMessage());
        }
        return path;
    } // close validatePath
    */
} // end class AnonymousCoordinate
