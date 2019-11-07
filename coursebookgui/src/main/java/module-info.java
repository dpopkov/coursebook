module org.daydevjv.coursebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires coursebookmodel;

    opens org.daydevjv.coursebookgui to javafx.fxml;
    exports org.daydevjv.coursebookgui;
}