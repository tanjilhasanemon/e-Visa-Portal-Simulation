package com.project.visa_management_portal.initial.internalLogIn;

import com.project.visa_management_portal.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InternalLoginController
{
    @javafx.fxml.FXML
    private Button backBtn;
    @javafx.fxml.FXML
    private TextField userNameTextField;
    @javafx.fxml.FXML
    private ComboBox userTypeComboBox;
    @javafx.fxml.FXML
    private PasswordField internalUserPasswordField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitch.switchTo("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void logInOnAction(ActionEvent actionEvent) {
    }
}