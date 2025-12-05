package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ApplicantGenerateReceiptController
{
    @javafx.fxml.FXML
    private TextArea receiptTextArea;


    @javafx.fxml.FXML
    private TextField applicationIdTextField;

    ArrayList<VisaApplication> visaApplications;

    @javafx.fxml.FXML
    public void initialize() {
        visaApplications = new ArrayList<>();


    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        // Validation
        if (applicationIdTextField.getText().isEmpty()) {
            showAlert( Alert.AlertType.WARNING, "Input Error","Please enter a valid Application ID.");
            return;
        }


        String applicationId = (applicationIdTextField.getText());

        ArrayList <VisaApplication> filteredApplications = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = new File("ApplicantVisaApplications.bin");

        try {

            if (file.exists()) {
                fis = new FileInputStream(file);
            }else {
                showAlert( Alert.AlertType.ERROR, "File Not Found","Client applications file does not exist.");
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                visaApplications.add((VisaApplication) ois.readObject());
            }

        } catch (Exception e) {
            try {
                if(ois!=null)
                    ois.close();
            }catch (Exception _) {
                showAlert( Alert.AlertType.ERROR,"File Error", "Error closing the file.");
            }
        }

        for (VisaApplication application : visaApplications) {
            if (application.getApplicationId().equals(applicationId)) {
                filteredApplications.add(application);
            }
        }

        if (filteredApplications.isEmpty()) {
            showAlert( Alert.AlertType.WARNING, "No Matches","No applications found for the given client ID.");
        }else{
            for (VisaApplication application : filteredApplications) {
                String receipt = "═══════════════════════════════════════════════════\n" +
                        "           VISA APPLICATION RECEIPT\n" +
                        "═══════════════════════════════════════════════════\n\n" +
                        "Receipt Date: " + LocalDate.now() + "\n" +
                        "Application ID: " + application.getApplicationId() + "\n\n" +
                        "───────────────── APPLICANT DETAILS ─────────────────\n" +
                        "Full Name: " + application.getFullName() + "\n" +
                        "Gender: " + application.getGender() + "\n" +
                        "Passport No: " + application.getPassportNo() + "\n" +
                        "Nationality: " + application.getNationality() + "\n" +
                        "Mother Language: " + application.getMotherLanguage() + "\n" +
                        "Contact Email: " + application.getApplicantEmail() + "\n\n" +
                        "─────────────── VISA APPLICATION DETAILS ──────────────\n" +
                        "Visa Type: " + application.getVisaType() + "\n" +
                        "Purpose of Visit: " + application.getPurposeOfVisit() + "\n\n" +
                        "═══════════════════════════════════════════════════\n" +
                        "          Thank you for your application!\n" +
                        "═══════════════════════════════════════════════════";;

                receiptTextArea.setText(receipt);
            }
        }
    }

    @javafx.fxml.FXML
    public void backToDashBoardOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Applicant Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
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

    public void clear(){
        applicationIdTextField.clear();
    }
}