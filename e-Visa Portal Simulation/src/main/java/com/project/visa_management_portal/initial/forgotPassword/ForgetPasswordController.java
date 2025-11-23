package com.project.visa_management_portal.initial.forgotPassword;

import com.project.visa_management_portal.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ForgetPasswordController
{
    @javafx.fxml.FXML
    private TextField emailTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitch.switchTo("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void sendResetLinkOnAction(ActionEvent actionEvent) {
    }
}