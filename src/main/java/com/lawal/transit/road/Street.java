package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.road.interfaces.*;


public final class Street implements Road {

    public static final Orientation RIGHT_LANE_TRAFFIC_DIRECTION = Orientation.SOUTH;
    public static final Orientation LEFT_LANE_TRAFFIC_DIRECTION = Orientation.NORTH;
    private final RoadIdentifiable identifier;
    private final LaneCollection rightLanes;
    private final LaneCollection leftLanes;

    public Street (String name, int id) throws Exception {
        this(name, id, 0, 0);
    }

    public Street (String name, int id, int numberOfRightLanes, int numberOfLeftLanes) throws Exception {
        this.identifier = new RoadIdentifier(RoadCategory.AVENUE, name, id);
        this.rightLanes = new TrafficLanes(RIGHT_LANE_TRAFFIC_DIRECTION);
        this.leftLanes = new TrafficLanes(LEFT_LANE_TRAFFIC_DIRECTION);

        rightLanes.addLanes(numberOfRightLanes);
        leftLanes.addLanes(numberOfLeftLanes);
    }

    @Override
    public RoadIdentifiable getIdentifier () {
        return identifier;
    }

    @Override
    public LaneCollection getRightLanes () {
        return rightLanes;
    }

    @Override
    public LaneCollection getLeftLanes () { return leftLanes; }

    @Override
    public Orientation getRightLaneTrafficeDirection () {
        return RIGHT_LANE_TRAFFIC_DIRECTION;
    }

    @Override
    public Orientation getLeftLaneTrafficDirection () {
        return LEFT_LANE_TRAFFIC_DIRECTION;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Street street) {
            return identifier.equals(street.getIdentifier())
                && rightLanes.numberOfLanes() == street.getRightLanes().numberOfLanes()
                && leftLanes.numberOfLanes() == street.getLeftLanes().numberOfLanes();
        }
        return false;
    }

    @Override
    public String toString () {
        return identifier.toString();
    }

//    @Override
//    public void render (GraphicsContext gc) {
//
//    }
//
//    public void addLabel () {
//        // Calculate label position
//        double labelX = (getStartX() + getEndX()) / 2;
//        double labelY = (getStartY() + getEndY()) / 2;
//
//        // Create label
//        Label nameLabel = new Label(identifier.toString());
//        nameLabel.setLayoutX(labelX);
//        nameLabel.setLayoutY(labelY);
//        nameLabel.setTextFill(Color.BLACK); // Set text color
//        nameLabel.setStyle("-fx-font-size: 12px;"); // Set font size
//
//        // Add label to parent
//        ((javafx.scene.Group) getParent()).getChildren().add(nameLabel);
//    }

}
