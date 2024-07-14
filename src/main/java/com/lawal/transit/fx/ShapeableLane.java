package com.lawal.transit.fx;

import com.lawal.transit.road.interfaces.*;
import javafx.scene.shape.*;

public interface ShapeableLane {

    public Lane getLane ();
    public double getWidth ();
    public double getHeight ();
    public double getStartingX ();
    public double getStartingY ();
    public Shape getShape ();
    public StylerInterface getStyler ();
}
