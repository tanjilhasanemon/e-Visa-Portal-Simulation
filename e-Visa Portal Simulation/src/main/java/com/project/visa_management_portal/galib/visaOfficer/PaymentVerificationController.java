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
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class PaymentVerificationController {

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

    @FXML
    public void initialize() {}
////        NewVerifiedPassportList = new ArrayList<>();
////        NewPendingPassportList = new ArrayList<>();
//
//        GovtPassportList = new ArrayList<>();
//        //Document(String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate) {
//
//        PendingApplicationList = new ArrayList<>();
//        //    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified, String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate, boolean isVerified) {
//
//        VerifiedApplicationList = new ArrayList<>();
//        //    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified, String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate, boolean isVerified) {
//
//
//        ApplicantPassportList = new ArrayList<>();
//        //    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified) {
//
//
//        // Applicant Passport columns
//        applicantIdCol.setCellValueFactory(new PropertyValueFactory<Document, String>("ApplicantId"));
//        passportNoCol.setCellValueFactory(new PropertyValueFactory<Document, String>("passportNo"));
//        issuingCountryCol.setCellValueFactory(new PropertyValueFactory<Document, String>("issuingCountry"));
//        firstNameCol.setCellValueFactory(new PropertyValueFactory<Document, String>("firstName"));
//        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<Document, String>("dateOfBirth"));
//        genderCol.setCellValueFactory(new PropertyValueFactory<Document, String>("gender"));
//        expireDateCol.setCellValueFactory(new PropertyValueFactory<Document, String>("expireDate"));
//        paymentStatusCol.setCellValueFactory(new PropertyValueFactory<Document, String>("paymentStatus"));
//        passportVerifiedCol.setCellValueFactory(new PropertyValueFactory<Document, String>("passportVerified"));
//
//
//
//
//        Document gp1 = new Document("APP001", "P111111", "BD", "Alice", LocalDate.of(1995, 3, 12), "F", LocalDate.of(2028, 3, 11), true);
//        Document gp2 = new Document("APP002", "P222222", "BD", "Rakib", LocalDate.of(1995, 6, 19), "M", LocalDate.of(2030, 11, 1), true);
//        Document gp3 = new Document("APP003", "P333333", "IN", "Sonia", LocalDate.of(1988, 11, 2), "F", LocalDate.of(2030, 11, 1), true);
//        Document gp4 = new Document("APP004", "P444444", "PK", "Zahid", LocalDate.of(1992, 1, 15), "M", LocalDate.of(2029, 1, 14), true);
//        Document gp5 = new Document("APP005", "P555555", "BD", "Mim",   LocalDate.of(1999, 7, 22), "F", LocalDate.of(2026, 7, 21), true);
//        Document gp6 = new Document("APP006", "P100006", "NP", "Arjun", LocalDate.of(1991, 2, 2), "M", LocalDate.of(2028, 2, 1), true);
//        Document gp7 = new Document("APP007", "P100007", "LK", "Nimali", LocalDate.of(1987, 11, 5), "F", LocalDate.of(2027, 11, 4), true);
//        Document gp8 = new Document("APP008", "P100008", "CN", "Wei", LocalDate.of(1993, 6, 18), "M", LocalDate.of(2029, 6, 17), true);
//        Document gp9 = new Document("APP009", "P100009", "US", "Emily", LocalDate.of(1997, 4, 23), "F", LocalDate.of(2032, 12, 4), true);
//        Document gp10 = new Document("APP010", "P100010", "BD", "Karim", LocalDate.of(1985, 12, 30), "M", LocalDate.of(2030, 12, 29), true);
//        GovtPassportList.add(gp1);
//        GovtPassportList.add(gp2);
//        GovtPassportList.add(gp3);
//        GovtPassportList.add(gp4);
//        GovtPassportList.add(gp5);
//        GovtPassportList.add(gp6);
//        GovtPassportList.add(gp7);
//        GovtPassportList.add(gp8);
//        GovtPassportList.add(gp9);
//        GovtPassportList.add(gp10);
//
//
//
//
//        //Applicant Passport List
//        Document aP1 = new Document("APP001", "P111111", "BD", "Alice",   LocalDate.of(1995, 3, 12), "F", LocalDate.of(2028, 3, 11), true, false);
//        Document aP2 = new Document("APP002", "P222222", "BD", "Rakib",   LocalDate.of(1995, 6, 19), "M", LocalDate.of(2030, 11, 1), true, true);
//        Document aP3 = new Document("APP003", "P333333", "IN", "Sonia",   LocalDate.of(1988, 11, 2), "F", LocalDate.of(2030, 11, 1), true, true);
//        Document aP4 = new Document("APP004", "P444444", "PK", "Zahid",   LocalDate.of(1992, 01, 15), "M", LocalDate.of(2029, 1, 14), true, true);
//        Document aP5 = new Document("APP005", "P555555", "BD", "Mim",     LocalDate.of(1999, 07, 22), "F", LocalDate.of(2026, 7, 21), false, false);
//        Document aP6 = new Document("APP006", "P666666", "NP", "Arjun",   LocalDate.of(1991, 02, 2), "M", LocalDate.of(2028, 2, 1), true, true);
//        Document aP7 = new Document("APP007", "P777777", "LK", "Nimali",  LocalDate.of(1987, 11, 5), "F", LocalDate.of(2027, 11, 4), true, true);
//        Document aP8 = new Document("APP008", "P888888", "CN", "Wei",     LocalDate.of(1993, 06, 18), "M", LocalDate.of(2029, 6, 17), false, false);
//        Document aP9 = new Document("APP009", "P999999", "US", "Emily",   LocalDate.of(1997, 04, 23), "F", LocalDate.of(2032, 12, 4), true, true);
//        Document aP10 = new Document("APP010", "P101010", "BD", "Karim",  LocalDate.of(1985, 12, 30), "M", LocalDate.of(2030, 12, 29), false, false);
//
//        ApplicantPassportList.add(aP1);
//        ApplicantPassportList.add(aP2);
//        ApplicantPassportList.add(aP3);
//        ApplicantPassportList.add(aP4);
//        ApplicantPassportList.add(aP5);
//        ApplicantPassportList.add(aP6);
//        ApplicantPassportList.add(aP7);
//        ApplicantPassportList.add(aP8);
//        ApplicantPassportList.add(aP9);
//        ApplicantPassportList.add(aP10);
//
//        //Pending Application List
//        Document pA1 = new Document("APP001", "P111111", "BD", "Alice", LocalDate.of(1995, 03, 12), "F", LocalDate.of(2028, 03, 11), true, false, "P100001", "BD", "Alice", LocalDate.of(1995, 03, 12), "F", LocalDate.of(2028, 03, 11), false);
//        Document pA2 = new Document("APP002", "P222222", "BD", "Rakib", LocalDate.of(1995, 06, 19), "M", LocalDate.of(2030, 11, 01), true, true, "P100002", "BD", "Rakib", LocalDate.of(1995, 06, 19), "M", LocalDate.of(2030, 11, 01), false);
//
//        PendingApplicationList.add(pA1);
//        PendingApplicationList.add(pA2);
//
//        //Verified Application List
//        Document vA1 = new Document(true, "Rakib", "P222222", "V001", "VN123456", LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 1), LocalDate.of(2025, 2, 1), "Officer1");
//        Document vA2 = new Document(true, "Sonia", "P333333", "V002", "VN234567", LocalDate.of(2024, 2, 10), LocalDate.of(2024, 3, 1), LocalDate.of(2025, 3, 1), "Officer2");
//
//        VerifiedApplicationList.add(vA1);
//        VerifiedApplicationList.add(vA2);
//    }
//
//    @FXML
//    public void refreshListOnAction(ActionEvent actionEvent) {
//        documentTableView.getItems().clear();
//        inputAppIdForVerifyTextField.setText("");
//
//    }
//
//    @FXML
//    public void backToMainDashboardOnAction(ActionEvent actionEvent) {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/galib/visaOfficer/VisaOfficerDashboard.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            stage.setTitle("Visa Officer Dashboard");
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            //throw new RuntimeException(e);
//        }
//    }
//
//    @FXML
//    public void verifySelectedPassportOnAction(ActionEvent actionEvent) { // verify passport from GovtPassportList.bin against input passport no
//        //documentTableView.getItems().clear();
//
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try{
//            File f = new File("ApplicantPassportList.bin");
//            if(f.exists()){
//                fis = new FileInputStream(f);
//                ois = new ObjectInputStream(fis);
//
//                while(true){
//                    Document doc = (Document) ois.readObject();
//                    newApplicantPassportList.add(doc);
//                }
//            }
//            else{
//                showAlert("File not found", "ApplicantList.bin does not exist.");
//            }
//        } catch (EOFException e) {
//            // End of file - expected
//        } catch (Exception e) {
//            //
//        } finally { // close streams
//            try {
//                if (ois != null) ois.close();
//                if (fis != null) fis.close();
//            } catch (IOException ex) {
//                // ignore
//            }
//        }
//
//        ArrayList<Document> newPaymenttList = new ArrayList<>();
//
//        FileInputStream fis1 = null;
//        ObjectInputStream ois1 = null;
//        try{
//            File passport = new File("GovtPassportList.bin");
//            if(passport.exists()){
//                fis1 = new FileInputStream(passport);
//                ois1 = new ObjectInputStream(fis1);
//
//                while(true){
//                    Document doc = (Document) ois1.readObject();
//                    newPaymenttList.add(doc);
//                }
//            }
//            else{
//                showAlert("File not found", "ApplicantList.bin does not exist.");
//            }
//        } catch (EOFException e) {
//            // End of file - expected
//        } catch (Exception e) {
//            //
//        } finally { // close streams
//            try {
//                if (ois1 != null) ois1.close();
//                if (fis1 != null) fis1.close();
//            } catch (IOException ex) {
//                // ignore
//            }
//        }
//
//
//        try {
////            ArrayList<Document> NewVerifiedPassportList = new ArrayList<>();
////            ArrayList<Document> NewPendingPassportList = new ArrayList<>();
//            String inputPassportNo = inputAppIdForVerifyTextField.getText().trim();
//
//            if (inputPassportNo.isEmpty()) {
//                showAlert("Input Required", "Please enter a Passport Number to Verify Payment!!");
//            }
//            else {
//                inputAppIdForVerifyTextField.clear();
//                for (Document doc : newPaymenttList) {
//                    if (doc.getPassportNo().equals(inputPassportNo)) {
//                        for (Document applicantDoc : newApplicantPassportList) {
//                            if (applicantDoc.isPaymentStatus()) {                                applicantDoc.setPassportVerified(true);
//                                documentTableView.getItems().add(applicantDoc);
//                                // Clear input field after successful verification
//                                showAlert1("Success", "Payment verified successfully!");
//                                return;
//
//                            }
////                            if (documentTableView.getItems().equals(applicantDoc) || applicantDoc.getPassportNo().equals(inputPassportNo)){
//////                                newApplicantPassportList.remove(applicantDoc);
//////                                Document newGovtPassportList = null;
//////                                documentTableView.getItems().addAll(newGovtPassportList);
////                                showAlert2("Already Verified", "This passport has already been verified.");
////                                return;
////
////                            }
//                            //documentTableView.getItems().clear();
////                            else {
////                                showAlert("Not Found", "No matching applicant found for the provided Passport Number.");
////                            }
//                        }
//                    }
////                    else {
////                        //showAlert2("Not Found", "No matching applicant found for the provided Passport Number.");
////                    }
//                }
//            }
//        }
//        catch (Exception e) {
//            showAlert("Error", "An error occurred during verification.");
//        }
//    }
//
//    public void showAlert(String title, String message) {
//        Alert a = new Alert(Alert.AlertType.ERROR);
//        a.setTitle(title);
//        a.setHeaderText(null);
//        a.setContentText(message);
//        a.showAndWait();
//    }
//
//    public void showAlert1(String title, String message) {
//        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//        a.setTitle(title);
//        a.setHeaderText(null);
//        a.setContentText(message);
//        a.showAndWait();
//    }
//    public void showAlert2(String title, String message) {
//        Alert a = new Alert(Alert.AlertType.WARNING);
//        a.setTitle(title);
//        a.setHeaderText(null);
//        a.setContentText(message);
//        a.showAndWait();
//    }
//
//    @FXML
//    public void exportPendingListOnAction(ActionEvent actionEvent) {
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try{
//            File f = new File("VerifiedPaymentList.bin");
//            if(f.exists()){
//                fos = new FileOutputStream(f, true);
//                oos = new AppendableObjectOutputStream(fos);
//            }
//            else{
//                fos = new FileOutputStream(f);
//                oos = new ObjectOutputStream(fos);
//            }
//            for (Document c: newApplicantPassportList){
//                oos.writeObject(c);
//                documentTableView.getItems().addAll(newApplicantPassportList);
//                //newApplicantPassportList.clear();
//            }
//            oos.close();
//        } catch (Exception e) {
//            //
//        }
//    }
//
//    @FXML
//    public void clearListOnAction(ActionEvent actionEvent) {
//        newApplicantPassportList.clear();
//        showAlert1("Cleared", "The applicant list has been cleared.");
//    }
}