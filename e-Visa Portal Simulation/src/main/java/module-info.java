module com.project.visa_management_portal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //requires com.project.visa_management_portal;
    //showing error that's why it's being commmented, commented by Galib


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

    opens com.project.visa_management_portal.tanjil.registeredAgent.controller to javafx.fxml;
    exports com.project.visa_management_portal.tanjil.registeredAgent.controller;


    opens com.project.visa_management_portal.galib.issuer to javafx.fxml;
    exports com.project.visa_management_portal.galib.issuer;

    opens com.project.visa_management_portal.galib.visaOfficer to javafx.fxml;
    exports com.project.visa_management_portal.galib.visaOfficer;




    opens com.project.visa_management_portal.rifat.operationManager.controller to javafx.fxml;
    exports com.project.visa_management_portal.rifat.operationManager.controller;

    opens com.project.visa_management_portal.rifat.policyManager.controller to javafx.fxml;
    exports com.project.visa_management_portal.rifat.policyManager.controller;


}