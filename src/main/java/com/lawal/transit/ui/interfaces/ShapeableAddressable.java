package com.lawal.transit.ui.interfaces;

import com.lawal.transit.places.*;
import javafx.beans.property.*;
import javafx.scene.shape.*;

public interface ShapeableAddressable {

    public StringProperty addressProperty ();
    public Addressable getAddressable ();
    public Shape shape ();

}
