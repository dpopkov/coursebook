module org.daydevjv.coursebook {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.daydevjv.coursebookgui to javafx.fxml;
    exports org.daydevjv.coursebookgui;
}