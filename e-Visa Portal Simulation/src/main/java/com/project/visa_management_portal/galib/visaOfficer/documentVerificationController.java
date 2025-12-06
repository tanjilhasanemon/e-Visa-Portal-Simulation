package com.project.visa_management_portal.galib.visaOfficer;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.galib.model.Document;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class documentVerificationController {

    @FXML
    private TextField inputAppIdForVerifyTextField;
    @FXML
    private TableColumn <Document,String> dateOfBirthCol;
    @FXML
    private TableColumn <Document,String> issuingCountryCol;
    @FXML
    private TableColumn <Document,String>expireDateCol;
    @FXML
    private TableColumn <Document,String>applicantIdCol;
    @FXML
    private TableColumn <Document,String>paymentStatusCol;
    @FXML
    private TableColumn <Document,String>genderCol;
    @FXML
    private TableColumn <Document,String>passportNoCol;
    @FXML
    private TableColumn <Document,String>firstNameCol;
    @FXML
    private Label notificationLabel;
    @FXML
    private TableView <Document>documentTableView;
    @FXML
    private TableColumn <Document,String>passportVerifiedCol;

//    ArrayList<Document> NewVerifiedPassportList;
//    ArrayList<Document> NewPendingPassportList;

    ArrayList<Document> GovtPassportList;
    ArrayList<Document> PendingApplicationList;
    ArrayList<Document> VerifiedApplicationList;
    ArrayList<Document> ApplicantPassportList;

    ArrayList<Document> newApplicantPassportList = new ArrayList<>();
//    ArrayList<Document> DocList = new ArrayList<>();

    @FXML
    public void initialize() {
//        NewVerifiedPassportList = new ArrayList<>();
//        NewPendingPassportList = new ArrayList<>();

        GovtPassportList = new ArrayList<>();
        //Document(String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate) {

        PendingApplicationList = new ArrayList<>();
        //    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified, String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate, boolean isVerified) {

        VerifiedApplicationList = new ArrayList<>();
        //    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified, String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate, boolean isVerified) {


        ApplicantPassportList = new ArrayList<>();
        //    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified) {


        // Applicant Passport columns
        applicantIdCol.setCellValueFactory(new PropertyValueFactory<Document, String>("ApplicantId"));
        passportNoCol.setCellValueFactory(new PropertyValueFactory<Document, String>("passportNo"));
        issuingCountryCol.setCellValueFactory(new PropertyValueFactory<Document, String>("issuingCountry"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Document, String>("firstName"));
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<Document, String>("dateOfBirth"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Document, String>("gender"));
        expireDateCol.setCellValueFactory(new PropertyValueFactory<Document, String>("expireDate"));
        paymentStatusCol.setCellValueFactory(new PropertyValueFactory<Document, String>("paymentStatus"));
        passportVerifiedCol.setCellValueFactory(new PropertyValueFactory<Document, String>("passportVerified"));
    }

    @FXML
    public void refreshListOnAction(ActionEvent actionEvent) {
        documentTableView.getItems().clear();
        inputAppIdForVerifyTextField.setText("");

    }

    @FXML
    public void backToMainDashboardOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/galib/visaOfficer/VisaOfficerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Visa Officer Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @FXML
    public void verifySelectedPassportOnAction(ActionEvent actionEvent) { // verify passport from GovtPassportList.bin against input passport no
        //documentTableView.getItems().clear();

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("ApplicantPassportList.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);

                while(true){
                    Document doc = (Document) ois.readObject();
                    newApplicantPassportList.add(doc);
                }
            }
            else{
                showAlert("File not found", Alert.AlertType.INFORMATION, "ApplicantPassportList.bin does not exist.");
            }
        } catch (EOFException e) {
            // End of file - expected
        } catch (Exception e) {
            //
        } finally { // close streams
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException ex) {
                // ignore
            }
        }

        ArrayList<Document> newGovtPassportLis = new ArrayList<>();

        FileInputStream fis1 = null;
        ObjectInputStream ois1 = null;
        try{
            File passport = new File("GovtPassportList.bin");
            if(passport.exists()){
                fis1 = new FileInputStream(passport);
                ois1 = new ObjectInputStream(fis1);

                while(true){
                    Document doc = (Document) ois1.readObject();
                    newGovtPassportLis.add(doc);
                }
            }
            else{
                showAlert("File not found", Alert.AlertType.INFORMATION, "ApplicantPassportList.bin does not exist.");
            }
        } catch (EOFException e) {
            // End of file - expected
        } catch (Exception e) {
            //
        } finally { // close streams
            try {
                if (ois1 != null) ois1.close();
                if (fis1 != null) fis1.close();
            } catch (IOException ex) {
                // ignore
            }
        }


        try {
            String inputPassportNo = inputAppIdForVerifyTextField.getText().trim();

            if (inputPassportNo.isEmpty()) {
                showAlert("Input Required", Alert.AlertType.INFORMATION, "Please enter a Passport Number.");
            }
            else {
                inputAppIdForVerifyTextField.clear();
                for (Document doc : newGovtPassportLis) {
                    if (doc.getGovtPassportNO().equals(inputPassportNo)) {
                        // Find matching applicant document
                        for (Document applicantDoc : newApplicantPassportList) {
                            if (applicantDoc.isPaymentStatus() && applicantDoc.getPassportNo().equals(inputPassportNo)) {
                                applicantDoc.setPassportVerified(true);
                                documentTableView.getItems().add(applicantDoc);
                                 // Clear input field after successful verification
                                showAlert1("Success", "verified successfully!");
                                return;

                            }
//                            if (documentTableView.getItems().equals(applicantDoc) || applicantDoc.getPassportNo().equals(inputPassportNo)){
////                                newApplicantPassportList.remove(applicantDoc);
////                                Document newGovtPassportList = null;
////                                documentTableView.getItems().addAll(newGovtPassportList);
//                                showAlert2("Already Verified", "This passport has already been verified.");
//                                return;
//
//                            }
                            //documentTableView.getItems().clear();
//                            else {
//                                showAlert("Not Found", "No matching applicant found for the provided Passport Number.");
//                            }
                        }
                    }
//                    else {
//                        //showAlert2("Not Found", "No matching applicant found for the provided Passport Number.");
//                    }
                }
            }
        }
        catch (Exception e) {
            showAlert("Error", Alert.AlertType.INFORMATION, "An error occurred during verification.");
        }
    }

    public void showAlert(String title, Alert.AlertType information, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

    public void showAlert1(String title, String message) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
    public void showAlert2(String title, String message) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}