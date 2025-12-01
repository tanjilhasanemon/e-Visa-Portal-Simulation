package com.project.visa_management_portal.initial.signUp;


import com.project.visa_management_portal.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ExternalSignUpController
{

    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField nameTextField;

    @FXML
    private Label statusLabel;
    @FXML
    private TextField agentLicenseNoTextField;


    private ArrayList <User> applicantList = new ArrayList<>();
    private ArrayList<User> agentList = new ArrayList<>();


    public void initialize() {
        userTypeComboBox.getItems().addAll("Applicant", "Registered Agent");
    }


    @FXML
    public void signUpOnAction(ActionEvent actionEvent) {
        String userType = userTypeComboBox.getValue();
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String pass = passwordTextField.getText();
        String agentLicenseNO = agentLicenseNoTextField.getText();

        //Validation
        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation error", "Name, email and password are required.");
            return;
        }
        if (Objects.equals(userTypeComboBox.getValue(), "Registered Agent") && agentLicenseNO.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation error", "Agent license number is required for Registered Agent.");
            return;
        }
        if (isEmailRegistered(email)) {
            showAlert(Alert.AlertType.ERROR, "Validation error", "This email is already registered. Try logging in.");
            return;
        }


        if (Objects.equals(userTypeComboBox.getValue(), "Applicant")){
            User newApplicants = new
            newApplicants.signUpExternal(name,email,pass);
            applicantList.add(newApplicants);


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


    private void showAlert(Alert.AlertType type, String title, String message) {
        // update messageLabel too (small status line)
        statusLabel.setText(message);

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void clearForm() {
        if (nameTextField != null) nameTextField.clear();
        if (emailTextField != null) emailTextField.clear();
        if (passwordTextField != null) passwordTextField.clear();
        if (agentLicenseNoTextField != null) agentLicenseNoTextField.clear();
        if (userTypeComboBox != null) userTypeComboBox.getSelectionModel().selectFirst();
        assert userTypeComboBox != null;
        if (statusLabel != null) statusLabel.setText("");
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

}