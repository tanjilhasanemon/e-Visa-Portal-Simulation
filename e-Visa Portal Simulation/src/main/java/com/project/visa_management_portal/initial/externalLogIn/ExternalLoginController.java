package com.project.visa_management_portal.initial.externalLogIn;

import com.project.visa_management_portal.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class ExternalLoginController {

    @javafx.fxml.FXML
    private TextField userNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private PasswordField internalUserPasswordField;
    @javafx.fxml.FXML
    private Button backBtn;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Applicant", "Registered Agent");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitch.switchTo("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml", actionEvent);
    }

    @FXML
    public void logInOnAction(ActionEvent actionEvent) throws IOException {


        String comboVal = String.valueOf(userTypeComboBox.getItems());
        if (Objects.equals(comboVal, "Applicant")) {
            SceneSwitch.switchTo("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml", actionEvent);
        }
        if (Objects.equals(comboVal, "Registered Agent")) {
            SceneSwitch.switchTo("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml", actionEvent);
        }
    }
}