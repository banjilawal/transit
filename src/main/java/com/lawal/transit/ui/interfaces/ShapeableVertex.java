package com.lawal.transit.ui.interfaces;

import com.lawal.transit.globals.*;
import javafx.beans.property.*;
import javafx.scene.shape.*;

public interface ShapeableVertex {

    public StringProperty addressProperty ();
    public Addressable getAddressable ();
    public Shape shape ();

}
