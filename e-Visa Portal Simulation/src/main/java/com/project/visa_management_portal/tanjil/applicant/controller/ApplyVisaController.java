package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.AppendableObjectOutputStream;

import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ApplyVisaController
{
    @javafx.fxml.FXML
    private TextArea purposeOfVisitTextArea;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TextField fullNameTextField;
    @javafx.fxml.FXML
    private TextField passportNoTextField;
    @javafx.fxml.FXML
    private ToggleGroup genderGroup;
    @javafx.fxml.FXML
    private ComboBox <String> visaTypeComboBox;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private TextField motherLangTextField;
    @javafx.fxml.FXML
    private TextField nationalityTextField;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextField contactEmailTextField;



    public ArrayList<VisaApplication> applications;


    @javafx.fxml.FXML
    public void initialize() {

        applications = new ArrayList<>();

        visaTypeComboBox.getItems().addAll("Tourist Visa", "Business Visa", "Student Visa", "Work Visa", "Transit Visa");
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
        // Validation
        if (fullNameTextField.getText().isEmpty() || passportNoTextField.getText().isEmpty() ||
            nationalityTextField.getText().isEmpty()|| motherLangTextField.getText().isEmpty() ||
            visaTypeComboBox.getValue() == null || purposeOfVisitTextArea.getText().isEmpty() ||
            contactEmailTextField.getText().isEmpty()) {
            showAlert("Incomplete Form", "Please fill all fields");
            return;
        }

        RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
        if (selectedGender == null) {
            showAlert("Validation Error", "Please select a gender.");
            return;
        }


        String fullName = fullNameTextField.getText();
        String passportNo = passportNoTextField.getText();
        String nationality = nationalityTextField.getText();
        String motherLanguage = motherLangTextField.getText();
        String visaType = visaTypeComboBox.getValue();
        String gender = selectedGender.getText();
        String purposeOfVisit = purposeOfVisitTextArea.getText();
        String applicantEmail = contactEmailTextField.getText();


        VisaApplication application = new VisaApplication(fullName, passportNo, nationality,
                motherLanguage, visaType, gender, purposeOfVisit, applicantEmail);

        applications.add(application);

        File file = new File("VisaApplications.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            if(file.exists()){
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            for (VisaApplication app : applications){
                oos.writeObject(app);
            }
            oos.close();

            showAlert("Success", "Your application has been submitted successfully.");
            statusLabel.setText("Application ID: " + application.getApplicationId() + " | Status: ");
            clearForm();

        } catch (Exception e) {
            showAlert("Error", "An error occurred while submitting your application.");
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Applicant Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            showAlert("Scene error", "Unable to open Applicant Dashboard.");
        }
    }


    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }


    private void clearForm() {
        fullNameTextField.clear();
        passportNoTextField.clear();
        nationalityTextField.clear();
        motherLangTextField.clear();
        purposeOfVisitTextArea.clear();
        contactEmailTextField.clear();
        visaTypeComboBox.setValue(null);
        genderGroup.selectToggle(null);
    }
}