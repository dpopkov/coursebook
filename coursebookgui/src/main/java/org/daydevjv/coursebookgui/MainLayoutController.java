package org.daydevjv.coursebookgui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainLayoutController {
    private Parent primaryPane;
    private Parent secondaryPane;

    @FXML
    public ChoiceBox<String> choiceDisk;
    @FXML
    public Label lblSelectedDisk;
    @FXML
    public StackPane centerStackPane;
    @FXML
    public ChoiceBox<Integer> choiceLayout;

    @FXML
    void initialize() {
        /* Top HBox children */
        final String firstDisk = "First Disk";
        lblSelectedDisk.setText("Selected disk: " + firstDisk);
        choiceDisk.setItems(FXCollections.observableArrayList(firstDisk, "Second Disk"));
        choiceDisk.getSelectionModel().selectFirst();
        choiceDisk.setOnAction(event -> lblSelectedDisk.setText("Selected disk: " + choiceDisk.getValue()));

        choiceLayout.setItems(FXCollections.observableArrayList(1, 2));
        choiceLayout.getSelectionModel().selectFirst();
        choiceLayout.setOnAction(event -> {
            if (choiceLayout.getValue().equals(1)) {
                primaryPane.setVisible(true);
                secondaryPane.setVisible(false);
            } else {
                secondaryPane.setVisible(true);
                primaryPane.setVisible(false);
            }
        });

        /* Center StackPane children */
        try {
            primaryPane = App.loadFXML("primary");
            secondaryPane = App.loadFXML("secondary");
            centerStackPane.getChildren().addAll(primaryPane, secondaryPane);
            secondaryPane.setVisible(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
