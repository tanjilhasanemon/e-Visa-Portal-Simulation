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

public class InternalLoginController
{
    @javafx.fxml.FXML
    private Button backBtn;
    @javafx.fxml.FXML
    private TextField userNameTextField;

    @javafx.fxml.FXML
    private PasswordField internalUserPasswordField;
    @javafx.fxml.FXML
    private ComboBox <String> userTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Visa Officer", "Issuer", "Operation Manager", "Policy Manager", "Finance Clerk", "Support Agent");
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
    public void logInOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void userTypeComboBox(ActionEvent actionEvent) {
    }
}