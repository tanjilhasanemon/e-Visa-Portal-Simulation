package com.project.visa_management_portal.initial.signUp;


import com.project.visa_management_portal.User;
import com.project.visa_management_portal.tanjil.applicant.modelClass.Applicant;
import com.project.visa_management_portal.tanjil.registeredAgent.modelClass.RegisteredAgent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ExternalSignUpController
{

    @FXML
    private TextField licenseField;
    @FXML
    private Label licenseLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField nameTextField;

    private static final ArrayList<User> userList = new ArrayList<>();

    public void initialize() {
        userTypeComboBox.getItems().clear();
        userTypeComboBox.getItems().addAll("Applicant", "Registered Agent");
        userTypeComboBox.getSelectionModel().selectFirst();
        updateLicenseVisibility(userTypeComboBox.getValue());
        userTypeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> updateLicenseVisibility(newVal));
    }
    private void updateLicenseVisibility(String userType) {
        boolean isAgent = "Registered Agent".equalsIgnoreCase(userType);
        licenseLabel.setVisible(isAgent);
        licenseLabel.setManaged(isAgent);
        licenseField.setVisible(isAgent);
        licenseField.setManaged(isAgent);
        if (!isAgent) {
            licenseField.clear();
        }
    }


    @FXML
    public void signUpOnAction(ActionEvent actionEvent) {
        String userType = userTypeComboBox.getValue();
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String pass = passwordTextField.getText();
        String licenseNO = licenseField.getText();

        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation error", "Name, email and password are required.");
            return;
        }

        if ("Registered Agent".equalsIgnoreCase(userType) && licenseNO.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation error", "Agent license number is required for Registered Agent.");
            return;
        }

        if (isEmailRegistered(email)) {
            showAlert(Alert.AlertType.ERROR, "Validation error", "This email is already registered. Try logging in.");
            return;
        }


        User newUser;
        if ("Registered Agent".equalsIgnoreCase(userType)) {
            RegisteredAgent agent = new RegisteredAgent();
            agent.signUpExternal(name, email, pass); // sets userId,name,email,password
            agent.setLicenseNumber(licenseNO);
            newUser = agent;
        } else {
            Applicant applicant = new Applicant();
            applicant.signUpExternal(name, email, pass);
            String passportNo = "";
            applicant.setPassportNumber(passportNo);
            newUser = applicant;
        }

        userList.add(newUser);

        showAlert(Alert.AlertType.INFORMATION, "Sign up successful", "Account created for " + name + ".");

        clearForm();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/externalLogin/ExternalLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("External User Login");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Scene error", "Unable to open External Login scene.");
        }




    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        // update messageLabel too (small status line)
        messageLabel.setText(message);

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Scene error", "Unable to open Main Dashboard.");
        }
    }


    private boolean isEmailRegistered(String email) {
        for (User u : userList) {
            if (u.getEmail() != null && u.getEmail().equalsIgnoreCase(email)) return true;
        }
        return false;
    }


    private void clearForm() {
        if (nameTextField != null) nameTextField.clear();
        if (emailTextField != null) emailTextField.clear();
        if (passwordTextField != null) passwordTextField.clear();
        if (licenseField != null) licenseField.clear();
        if (userTypeComboBox != null) userTypeComboBox.getSelectionModel().selectFirst();
        assert userTypeComboBox != null;
        updateLicenseVisibility(userTypeComboBox.getValue());
        if (messageLabel != null) messageLabel.setText("");
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

}