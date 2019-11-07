package org.daydevjv.coursebookgui;

import java.io.IOException;
import javafx.fxml.FXML;

public class OutputLayoutController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
