package org.daydevjv.coursebookgui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;

public class MainLayoutController {

    @FXML
    public ChoiceBox<String> choiceDisk;
    @FXML
    public Label lblSelectedDisk;
    @FXML
    public TabPane centerTabPane;

    @FXML
    void initialize() {
        /* Top HBox children */
        final String firstDisk = "First Disk";
        lblSelectedDisk.setText("Selected disk: " + firstDisk);
        choiceDisk.setItems(FXCollections.observableArrayList(firstDisk, "Second Disk"));
        choiceDisk.getSelectionModel().selectFirst();
        choiceDisk.setOnAction(event -> lblSelectedDisk.setText("Selected disk: " + choiceDisk.getValue()));

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
