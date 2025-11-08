module com.project.visa_management_portal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.visa_management_portal to javafx.fxml;
    exports com.project.visa_management_portal;
}