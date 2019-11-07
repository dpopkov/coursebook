package org.daydevjv.coursebookgui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.StringConverter;
import org.daydevjv.coursebook.model.FileStoreInfo;
import org.daydevjv.coursebook.service.FileStoreUtils;

import java.io.IOException;
import java.util.List;

public class MainLayoutController {

    @FXML
    public ChoiceBox<FileStoreInfo> choiceDisk;
    @FXML
    public Label lblSelectedDisk;
    @FXML
    public TabPane centerTabPane;

    @FXML
    void initialize() {
        /* Top HBox children */
        List<FileStoreInfo> info = FileStoreUtils.getInfo();
        lblSelectedDisk.setText("Selected disk: " + info.get(0).getName());
        choiceDisk.setConverter(new StringConverter<>() {
            @Override
            public String toString(FileStoreInfo fsInfo) {
                return fsInfo.getName();
            }

            @Override
            public FileStoreInfo fromString(String s) {
                throw new UnsupportedOperationException("Converting from String to FileStoreInfo is not supported");
            }
        });
        choiceDisk.setItems(FXCollections.observableList(info));
        choiceDisk.getSelectionModel().selectFirst();
        choiceDisk.setOnAction(event -> lblSelectedDisk.setText("Selected disk: " + choiceDisk.getValue().getName()));

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
