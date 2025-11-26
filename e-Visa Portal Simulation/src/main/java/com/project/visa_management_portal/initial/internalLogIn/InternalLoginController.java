package com.project.visa_management_portal.initial.internalLogIn;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InternalLoginController
{
    @javafx.fxml.FXML
    private Button backBtn;
    @javafx.fxml.FXML
    private TextField userNameTextField;

    @javafx.fxml.FXML
    private PasswordField internalUserPasswordField;
    @javafx.fxml.FXML
    private ComboBox <String> internalUserTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        internalUserTypeComboBox.getItems().addAll("Visa Officer", "Issuer", "Operation Manager", "Policy Manager", "Finance Clerk", "Support Agent");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Main Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        if (Objects.equals(internalUserTypeComboBox.getValue(), "Issuer")){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/galib/issuer/issuer-Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Visa Officer Dashboard");
            stage.setScene(scene);
            stage.show();

        }
        if
        (Objects.equals(internalUserTypeComboBox.getValue(), "Visa Officer")){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/galib/visaOfficer/VisaOfficerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Issuer Dashboard");
            stage.setScene(scene);
            stage.show();
        }



        //Rifat's Scene switch

        if (Objects.equals(internalUserTypeComboBox.getValue(), "Operation Manager")){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/OperationManager_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Operation Manager Dashboard");
            stage.setScene(scene);
            stage.show();

        }

        if (Objects.equals(internalUserTypeComboBox.getValue(), "Policy Manager")){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/policyManagerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Policy Manager Dashboard");
            stage.setScene(scene);
            stage.show();

        }
    }
}