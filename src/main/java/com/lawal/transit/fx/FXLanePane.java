package com.lawal.transit.fx;

import com.lawal.transit.road.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

public interface FXLanePane {

    public Lane getLane ();
    public Pane getPane ();
    public Rectangle getRectangle ();
    public Stylerizerable getStylerizer ();
}
