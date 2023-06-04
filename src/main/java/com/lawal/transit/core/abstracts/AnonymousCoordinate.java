package com.lawal.transit.core.abstracts;

/*
public abstract class AnonymousCoordinate extends Entity {
    private SimplexPath xCoordinate;
    private SimplexPath yCoordinate;

    //------------------ Constructors ------------------//
    public AnonymousCoordinate(SimplexPath xCoordinate, SimplexPath yCoordinate) {
            this.xCoordinate = validatePath(xCoordinate,yCoordinate);
            this.yCoordinate = yCoordinate;
    } // close constructor

    //------------------ Getters ------------------//
    public SimplexPath getXCoordinate () {
        return xCoordinate;
    }

    public SimplexPath getYCoordinate () {
        return yCoordinate;
    }

    //------------------ Setters ------------------//
    public void setXCoordinate (SimplexPath xCoordinate) {
        this.xCoordinate = validatePath(xCoordinate, this.yCoordinate) ;
    } //

    public void setYCoordinate (SimplexPath yCoordinate) {
        this.yCoordinate = validatePath(yCoordinate, this.xCoordinate);
    } //

    //------------------ Overrides ------------------//
    @Override
    public boolean equals (Object object) {
        boolean isEqual = false;
        if (object instanceof AnonymousCoordinate anonymousCoordinate) {
            if (this.sameXCoordinate(anonymousCoordinate) && this.sameYCoordinate(anonymousCoordinate)) {
                isEqual = true;
            }
        }
        return isEqual;
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

    //------------------ Helpers ------------------//
    public String fullString () {
        String string = super.toString()
                + " xCoordinate:" + xCoordinate.fullString()
                + " yCoordinate:" + yCoordinate.fullString();
        return string;
    } // close fullString
    public boolean sameXCoordinate (AnonymousCoordinate anonymousCoordinate) {
        return xCoordinate.equals(anonymousCoordinate.getXCoordinate());
    } // close sameXCoordinate

    public boolean sameYCoordinate (AnonymousCoordinate anonymousCoordinate) {
        return yCoordinate.equals(anonymousCoordinate.getYCoordinate());
    } // close sameYCoordinate
    private SimplexPath validatePath (SimplexPath path, SimplexPath crossPath) {
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
    //------------------ Helpers ------------------//
    //------------------ Statics ------------------//
} // end class AnonymousCoordinate
*/