module com.project.visa_management_portal {
    requires javafx.controls;
    requires javafx.fxml;




    opens com.project.visa_management_portal to javafx.fxml;
    exports com.project.visa_management_portal;

    opens com.project.visa_management_portal.initial.mainDashboard to javafx.fxml;
    exports com.project.visa_management_portal.initial.mainDashboard;

    opens com.project.visa_management_portal.initial.signUp to javafx.fxml;
    exports com.project.visa_management_portal.initial.signUp;

    opens com.project.visa_management_portal.initial.internalLogIn to javafx.fxml;
    exports com.project.visa_management_portal.initial.internalLogIn;

    opens com.project.visa_management_portal.initial.externalLogIn to javafx.fxml;
    exports com.project.visa_management_portal.initial.externalLogIn;



    opens com.project.visa_management_portal.initial.forgotPassword to javafx.fxml;
    exports com.project.visa_management_portal.initial.forgotPassword;

    opens com.project.visa_management_portal.tanjil.applicant.controller to javafx.fxml;
    exports com.project.visa_management_portal.tanjil.applicant.controller;








}