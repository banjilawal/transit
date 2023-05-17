package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Path;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.interfaces.Identifiable;

import java.util.Objects;

public class OldestRoad extends Path implements Identifiable<Integer, String> {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private RoadCategory category;
    private Direction rightLane;
    private Direction leftLane;

    public OldestRoad () {
        this(0,"Unnamed", RoadCategory.NONE);
        this.category = RoadCategory.NONE;
    } // constructor

    public OldestRoad (Integer id, String name, RoadCategory category) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        setLanes();
    } // close constructor

    public Integer getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public RoadCategory getCategory() {
        return category;
    }
    public Direction getLeftLane() {
        return leftLane;
    }

    public Direction getRightLane() {
        return rightLane;
    }

    public void setCategory(RoadCategory category) {
        this.category = category;
        setLanes();
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    private void setLanes () {
        switch (category) {
            case AVENUE:
                this.leftLane = Direction.NORTH;
                this.rightLane = Direction.SOUTH;
                break;
            case STREET:
                this.leftLane = Direction.WEST;
                this.rightLane = Direction.EAST;
                break;
        }
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof OldestRoad road) {

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
    public String toString() {
        String string = super.toString()
            + " " + this.getClass().getSimpleName()
            + " id:" + id.toString()
            + " name:" + name
            + category.print();
        return string;
    } // close toString

    public String print () {
        return this.getName() + " "  + this.category.print();
    }
} // end class Road
