package com.lawal.transit.fx;

import com.lawal.transit.fx.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public final class  FrontagePaneBuilder implements CurbsideFXPaneWrapper {


    private final RoadSectional curbside;
    private final ButtonBar buildingsButtonBar;
    private final ButtonBar stationsButtonBar;

    public FrontagePaneBuilder (RoadSectional curbside) {
        this.curbside = curbside;
        this.buildingsButtonBar = new ButtonBarBuilder().build(curbside.buildings());
        this.stationsButtonBar = new ButtonBarBuilder().build(curbside().stations());
    }

    @Override
    public RoadSectional curbside () {
        return curbside;
    }

    @Override
    public HBox getHBox () {
        HBox hbox = new HBox();
        hbox.getChildren().addAll(buildingsButtonBar, stationsButtonBar);
        hbox.setStyle(Styling.FRONTAGE_PANE_CSS);
        return hbox;
    }

    @Override
    public VBox getVBox () {
        VBox vbox = new VBox();
        vbox.getChildren().addAll(buildingsButtonBar, stationsButtonBar);
        vbox.setStyle(Styling.FRONTAGE_PANE_CSS);
        return vbox;
    }
}
