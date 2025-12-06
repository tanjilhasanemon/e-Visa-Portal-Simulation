package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class CheckAndUpdateApplicationController
{

    @javafx.fxml.FXML
    private Label oldEmailLabel;
    @javafx.fxml.FXML
    private TextField newNameTextField;
    @javafx.fxml.FXML
    private TextField applicationIdTextField;
    @javafx.fxml.FXML
    private TextField newEmailTextField;
    @javafx.fxml.FXML
    private Label oldPassportNoLabel;
    @javafx.fxml.FXML
    private Label oldNameLabel;
    @javafx.fxml.FXML
    private TextField newPassportNoTextField;

    ArrayList<VisaApplication> visaApplications;

    @javafx.fxml.FXML
    public void initialize() {
        visaApplications = new ArrayList<>();

        File file = new File("ApplicantVisaApplications.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showAlert("File Not Found", Alert.AlertType.ERROR, "Client applications file does not exist.");
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                VisaApplication visaApplication = (VisaApplication) ois.readObject();
                visaApplications.add(visaApplication);
            }
        } catch (IOException | ClassNotFoundException e) {
            try {
                if(ois!=null) ois.close();
            }catch (Exception _) {
                showAlert("File Error",  Alert.AlertType.ERROR,"Error closing the file.");
            }
        }
    }



    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        //Validation
        if (applicationIdTextField.getText().isEmpty()) {
            showAlert("Input Error", Alert.AlertType.WARNING, "Please enter Application ID.");
            return;
        }
        String applicationId = applicationIdTextField.getText().trim();


        ArrayList<VisaApplication> matchedApplications = new ArrayList<>();
        boolean found = false;
        for (VisaApplication va : visaApplications) {
            if (Objects.equals(va.getApplicationId(), applicationId)) {
                matchedApplications.add(va);
                found = true;
            }
        }

        if (!found) {
            showAlert("No Application Found", Alert.AlertType.WARNING, "No application found with the provided Application ID.");
        } else {
            for (VisaApplication va : matchedApplications) {
                oldNameLabel.setText(va.getFullName());
                oldEmailLabel.setText(va.getApplicantEmail());
                oldPassportNoLabel.setText(va.getPassportNo());
            }
        }


    }

    @javafx.fxml.FXML
    public void updateOnAction(ActionEvent actionEvent) {
        //Validation
        if (newNameTextField.getText().isEmpty() && newEmailTextField.getText().isEmpty() && newPassportNoTextField.getText().isEmpty()) {
            showAlert("Input Error", Alert.AlertType.WARNING, "Please enter at least one field to update.");
            return;
        }

        String applicationId = applicationIdTextField.getText().trim();
        boolean updated = false;

        for (VisaApplication va : visaApplications) {
            if (Objects.equals(va.getApplicationId(), applicationId)) {
                if (!newNameTextField.getText().isEmpty()) {
                    va.setFullName(newNameTextField.getText().trim());
                }
                if (!newEmailTextField.getText().isEmpty()) {
                    va.setApplicantEmail(newEmailTextField.getText().trim());
                }
                if (!newPassportNoTextField.getText().isEmpty()) {
                    va.setPassportNo(newPassportNoTextField.getText().trim());
                }
                updated = true;
            }
        }

        if (updated) {
            showAlert("Update Successful", Alert.AlertType.INFORMATION, "Application details updated successfully.");

            // Delete old file and save updated applications
            File f = new File("ApplicantVisaApplications.bin");
            if (f.exists()) {
                f.delete();
            }

            File file = new File("ApplicantVisaApplications.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            try {
                if (file.exists()) {
                    fos = new FileOutputStream(file, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                }

                for (VisaApplication va : visaApplications) {
                    oos.writeObject(va);
                }

                oos.close();
                showAlert("File Saved", Alert.AlertType.INFORMATION, "Updated applications saved to file.");
            } catch (Exception e) {
                showAlert("File Error", Alert.AlertType.ERROR, "Error saving updated applications to file.");
            }
        } else {
            showAlert("Update Failed", Alert.AlertType.ERROR, "Failed to update application details.");
        }

        clear();
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
        }catch (Exception e){
            showAlert("Navigation Error", Alert.AlertType.ERROR, "Unable to load the dashboard.");
        }
    }


    private void showAlert(String title, Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void clear(){
        oldEmailLabel.setText("");
        oldNameLabel.setText("");
        oldPassportNoLabel.setText("");
        newNameTextField.clear();
        newEmailTextField.clear();
        newPassportNoTextField.clear();
        applicationIdTextField.clear();
    }
}