package com.lawal.transit.middleware.entities;

/*
public class OlderRoad extends SimplexPath {
    /*
    private static final long serialVersionUID = 1L;
    private RoadCategory category;

    public OlderRoad (int id, String name, Direction direction, RoadCategory category) throws IdentifiableEntityNameException, IdentifiableEntityIdException {
        super(id, name, direction);
        this.category = categoryHandler(direction);
    } // close constructor

    //------------------ Getters ------------------//
    public RoadCategory getCategory() {
        return category;
    }

    //------------------ Setters ------------------//
    public void setCategory (RoadCategory category) {

    } // close setCategory

    //------------------ Overrides ------------------//
    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof OlderRoad) {
            OlderRoad road = (OlderRoad) object;

            if (this.id.equals(road.getId()) && this.getName().equalsIgnoreCase(road.getName())) {
                if (this.rightLane == road.getRightLane() && this.leftLane == road.getLeftLane()) {
                    if (this.category ==  road.getCategory()) {
                        isEqual = true;
                    }
                }
            }
        }
        return isEqual;
    } // close equals

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, rightLane, leftLane);
    } // close hashcode

    @Override
    public String toString () {
        return this.getName() + " "  + this.category.print();
    }

    public String fullString() {
        String string = super.toString()
            + " " + this.getClass().getSimpleName()
            + " id:" + id.toString()
            + " name:" + name
            + category.print();
        return string;
    } // close toString

    //------------------ Helpers ------------------//
    private RoadCategory categoryHandler (Direction direction) {
        RoadCategory roadCategory = RoadCategory.NONE;
        switch (direction) {
            case NORTH, SOUTH:
                roadCategory = RoadCategory.AVENUE;
                break;
            case EAST, WEST:
                roadCategory = RoadCategory.STREET;
                break;
            default:
                System.out.println("Road line 103: category not set");
        }
        return roadCategory;
    } // close categoryHandler

    private void directionHandler (RoadCategory category) {
        switch (category) {
            case AVENUE:
                this.setDirection(Direction.NORTH);
                break;
            case STREET:
                this.setDirection(Direction.EAST);
                break;
            default:
                System.out.println("Road line 103: category not set");
                break;
        }
    } // close categoryHandler
    //------------------ Statics ------------------//

} // end class Road
 */