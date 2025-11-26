package com.project.visa_management_portal.initial.externalLogIn;
import com.project.visa_management_portal.User;
import com.project.visa_management_portal.initial.signUp.ExternalSignUpController;
import com.project.visa_management_portal.tanjil.applicant.modelClass.Applicant;
import com.project.visa_management_portal.tanjil.registeredAgent.modelClass.RegisteredAgent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ExternalLoginController {

    @javafx.fxml.FXML
    private ComboBox <String> userTypeComboBox;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordField;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().clear();
        userTypeComboBox.getItems().addAll("Applicant", "Registered Agent");
        userTypeComboBox.getSelectionModel().selectFirst();
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Main Dashboard.");
        }
    }

    @FXML
    public void logInOnAction(ActionEvent actionEvent) {
        String role = userTypeComboBox.getValue();
        String email = (emailTextField.getText());
        String password = passwordField.getText();



        if (role == null || role.isEmpty()) {
            showAlert("Validation", "Please select a user type.");
            return;
        }
        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Validation", "Please enter both email and password.");
            return;
        }

        ArrayList<User> users = ExternalSignUpController.getUserList(); // in-memory list
        User matched = null;

        for (User u : users) {
            if (u.getEmail() == null) continue;
            if (!u.getEmail().equalsIgnoreCase(email)) continue;

            // check role and password (assumes User.getPassword() is public)
            boolean roleOk = (role.equals("Applicant") && u instanceof Applicant)
                    || (role.equals("Registered Agent") && u instanceof RegisteredAgent);
            if (!roleOk) continue;

            // simple password compare
            if (u.getPassword() != null && u.getPassword().equals(password)) {
                matched = u;
                break;
            }
    }
        if (matched == null) {
            showAlert("Login failed", "Invalid credentials or wrong user type.");
            return;
        }
        try {
            if (matched instanceof Applicant) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setTitle("Applicant Dashboard");
                stage.setScene(scene);
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setTitle("Registered Agent Dashboard");
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {

            showAlert("Scene error", "Unable to open Dashboard.");
        }
    }

    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}

