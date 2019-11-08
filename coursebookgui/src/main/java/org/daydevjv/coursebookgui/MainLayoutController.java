package org.daydevjv.coursebookgui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;

public class MainLayoutController {

    @FXML
    public TabPane centerTabPane;

    @FXML
    void initialize() {
        /* Center StackPane children */
        try {
            Parent inputPane = App.loadFXML("inputLayout");
            Parent outputPane = App.loadFXML("outputLayout");
            centerTabPane.getTabs().add(new Tab("Input", inputPane));
            centerTabPane.getTabs().add(new Tab("Output", outputPane));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
