package com.project.visa_management_portal.initial.mainDashboard;

import com.project.visa_management_portal.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainDashboardController
{
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signUpOnAction(ActionEvent actionEvent)  {
        try {
            SceneSwitch.switchTo("/com/project/visa_management_portal/initial/signUp/ExternalSignUp.fxml",actionEvent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void forgotPasswordOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitch.switchTo("/com/project/visa_management_portal/initial/forgotPassword/ForgetPassword.fxml",actionEvent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void internalUserLoginOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitch.switchTo("/com/project/visa_management_portal/initial/internalLogin/InternalLogin.fxml",actionEvent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void externalUserLoginOnAction(ActionEvent actionEvent) {
        try {
            SceneSwitch.switchTo("/com/project/visa_management_portal/initial/externalLogin/ExternalLogin.fxml",actionEvent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}