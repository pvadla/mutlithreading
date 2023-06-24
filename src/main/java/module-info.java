module com.example.multithreadingconcepts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.multithreadingconcepts to javafx.fxml;
    exports com.example.multithreadingconcepts;
}