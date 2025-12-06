package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FindsApplicationIDController
{

    @javafx.fxml.FXML
    private TextField passportNoTextField;
    @javafx.fxml.FXML
    private TextArea showDataTextArea;

    ArrayList<VisaApplication> visaApplications;

    @javafx.fxml.FXML
    public void initialize() {
        visaApplications = new ArrayList<>();
    }


    @javafx.fxml.FXML
    public void findApplicationIdOnAction(ActionEvent actionEvent) {
        //Validation
        if (passportNoTextField.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please enter your passport number.");
            return;
        }
        String passportNo = passportNoTextField.getText().trim();

        File file = new File("ApplicantVisaApplications.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showAlert( Alert.AlertType.ERROR, "File Not Found","Client applications file does not exist.");
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
                showAlert( Alert.AlertType.ERROR,"File Error", "Error closing the file.");
            }
        }


        ArrayList<VisaApplication> matchedApplications = new ArrayList<>();
        boolean found = false;


        for (VisaApplication va : visaApplications) {
            if (va.getPassportNo().equalsIgnoreCase(passportNo)) {
                matchedApplications.add(va);
                found = true;
            }
        }

        String outputString = "";

        if (!found) {
            showAlert( Alert.AlertType.WARNING,"No Applications Found", "No visa applications found for the provided passport number.");


        }else {

            for (VisaApplication va : matchedApplications) {
                        outputString =("Application ID: " + va.getApplicationId() + "\n" +
                        "Full Name: " + va.getFullName() + "\n" +
                        "Passport No: " + va.getPassportNo() + "\n" +
                        "Visa Type: " + va.getVisaType() + "\n" +
                        "Application Status: " + va.getStatus() + "\n" +
                        "----------------------------------------\n");
            }
            showAlert( Alert.AlertType.INFORMATION,"Applications Found", "Visa applications found for the provided passport number. Check the text area for details.");
            showDataTextArea.setText(outputString);
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
        }catch (Exception e){
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Unable to load the dashboard.");
        }

    }


    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}