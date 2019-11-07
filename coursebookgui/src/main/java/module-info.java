module org.daydevjv.coursebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires coursebookmodel;
    requires coursebookservice;

    opens org.daydevjv.coursebookgui to javafx.fxml;
    exports org.daydevjv.coursebookgui;
}