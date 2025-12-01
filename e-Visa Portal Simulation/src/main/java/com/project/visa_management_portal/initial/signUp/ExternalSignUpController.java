package com.project.visa_management_portal.initial.signUp;


import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.ExternalUser;
import com.project.visa_management_portal.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
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


   public ArrayList<ExternalUser> applicantList = new ArrayList<>();
   public ArrayList<ExternalUser> agentList = new ArrayList<>();


    public void initialize() {
        userTypeComboBox.getItems().addAll("Applicant", "Registered Agent");

        // enable/disable license input depending on selection from GPT
        userTypeComboBox.setOnAction(e -> {
            boolean isAgent = "Registered Agent".equals(userTypeComboBox.getValue());
            agentLicenseNoTextField.setDisable(!isAgent);
            if (!isAgent) agentLicenseNoTextField.clear();
        });
    }


    @FXML
    public void signUpOnAction(ActionEvent actionEvent) {
        String userType = userTypeComboBox.getValue();
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String pass = passwordTextField.getText();
        String agentLicenseNO = agentLicenseNoTextField.getText();
        String userId = String.valueOf(1000 + (int)(Math.random() * 9000));

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
            ExternalUser newApplicant = new ExternalUser(userType, name, email, pass, null);
            newApplicant.signUpExternal(name, email, pass); // generates userId inside User class
            applicantList.add(newApplicant);


            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try{
                File file = new File("Applicants.bin");
                if(file.exists()){
                    fos = new FileOutputStream(file, true);
                    oos = new AppendableObjectOutputStream(fos);

                }
                else{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    for (ExternalUser a:applicantList){
                        oos.writeObject(a);
                    }
                }
                oos.close();
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Sign up error", "An unexpected error occurred while signing up.");
            }

        }




        else if (Objects.equals(userTypeComboBox.getValue(), "Registered Agent") ) {
            ExternalUser newAgent = new ExternalUser(userType, name, email, pass, agentLicenseNO);
            newAgent.signUpExternal(name, email, pass);


            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                File file = new File("Agents.bin");
                if (file.exists()) {
                    fos = new FileOutputStream(file, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                }
                for (ExternalUser r: agentList) {
                    oos.writeObject(r);
                }
                oos.close();
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Sign up error", "An unexpected error occurred while signing up.");
            }

        }




        showAlert(Alert.AlertType.INFORMATION, "Sign up successful", "Account created for " + name + ".");

        clearForm();


        //Scene Switch to the External User Login Scene

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



    private boolean isEmailRegistered(String email) {
        if (email == null) return false;
        for (ExternalUser u : applicantList) {
            if (email.equals(u.getEmail())) return true;
        }
        for (ExternalUser u : agentList) {
            if (email.equals(u.getEmail())) return true;
        }
        return false;
    }
}