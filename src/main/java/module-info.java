module com.example.assignment_i {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment_i to javafx.fxml;
    exports com.example.assignment_i;
    exports Controllers;
    opens Controllers to javafx.fxml;
}