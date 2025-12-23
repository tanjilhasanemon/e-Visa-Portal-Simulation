package com.project.visa_management_portal.galib.visaOfficer;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.galib.model.Document;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ApplicationReviewControlller {

    @javafx.fxml.FXML
    private TableColumn <Document,String> dateOfBirthCol;
    @javafx.fxml.FXML
    private TableColumn <Document,String>issuingCountryCol;
    @javafx.fxml.FXML
    private TableColumn <Document,String>expireDateCol;
    @javafx.fxml.FXML
    private TableColumn<Document,String> applicantIdCol;
    @javafx.fxml.FXML
    private TableColumn <Document,String>paymentStatusCol;
    @javafx.fxml.FXML
    private TableColumn <Document,String>genderCol;
    @javafx.fxml.FXML
    private TableColumn <Document,String>passportNoCol;
    @javafx.fxml.FXML
    private TableColumn <Document,String>firstNameCol;
    @javafx.fxml.FXML
    private TableView <Document>documentTableView;
    @javafx.fxml.FXML
    private TableColumn <Document,String>passportVerifiedCol;

    ArrayList<Document> GovtPassportList;
    ArrayList<Document> PendingApplicationList;
    ArrayList<Document> VerifiedApplicationList;
    ArrayList<Document> issuedVisaList;
    ArrayList<Document> ApplicantPassportList;

    @javafx.fxml.FXML
    private ComboBox<String> filterComboBox;
    @javafx.fxml.FXML
    private TableColumn <Document,String>govtPassportNoCol;

    @javafx.fxml.FXML
    public void initialize() throws IOException {

        GovtPassportList = new ArrayList<>();
        //Document(String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate) {

        PendingApplicationList = new ArrayList<>();
        //    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified, String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate, boolean isVerified) {

        VerifiedApplicationList = new ArrayList<>();
        //    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified, String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate, boolean isVerified) {

        issuedVisaList = new ArrayList<>();
        //    public Document(boolean isVerified, String firstName, String passportNo, String visaId, String visaNumber, LocalDateTime issuedOn, LocalDate validFrom, LocalDate validUntil, String issuedBy) {

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
        govtPassportNoCol.setCellValueFactory(new PropertyValueFactory<Document, String>("GovtPassportNO"));


//        govtIssuingCountryCol.setCellValueFactory(new PropertyValueFactory<Document, String>("GovtIssuingCountry"));
//        govtFirstNameCol.setCellValueFactory(new PropertyValueFactory<Document, String>("GovtFirstName"));
//        govtDateOfBirthCol.setCellValueFactory(new PropertyValueFactory<Document, String>("GovtDateOfBirth"));
//        govtGenderCol.setCellValueFactory(new PropertyValueFactory<Document, String>("GovtGender"));
//        govtExpireDateCol.setCellValueFactory(new PropertyValueFactory<Document, String>("GovtExpireDate"));
//
//        // Verification status column
//        isVerifiedCol.setCellValueFactory(new PropertyValueFactory<Document, String>("isVerified"));


        filterComboBox.getItems().addAll("All Applications", "Pending Applications", "Verified Applications", "Govt Passport List");

        //Govt Passport List
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


        Document gp1 = new Document("APP001", "P111111", "BD", "Alice", LocalDate.of(1995, 3, 12), "F", LocalDate.of(2028, 3, 11));
        Document gp2 = new Document("APP002", "P222222", "BD", "Rakib", LocalDate.of(1995, 6, 19), "M", LocalDate.of(2030, 11, 1));
        Document gp3 = new Document("APP003", "P333333", "IN", "Sonia", LocalDate.of(1988, 11, 2), "F", LocalDate.of(2030, 11, 1));
        Document gp4 = new Document("APP004", "P444444", "PK", "Zahid", LocalDate.of(1992, 1, 15), "M", LocalDate.of(2029, 1, 14));
        Document gp5 = new Document("APP005", "P555000", "BD", "Mim",   LocalDate.of(1999, 7, 22), "F", LocalDate.of(2026, 7, 21));
        Document gp6 = new Document("APP006", "P666000", "NP", "Arjun", LocalDate.of(1991, 2, 2), "M", LocalDate.of(2028, 2, 1));
        Document gp7 = new Document("APP007", "P000777", "LK", "Nimali", LocalDate.of(1987, 11, 5), "F", LocalDate.of(2027, 11, 4));
        Document gp8 = new Document("APP008", "P888888", "CN", "Wei", LocalDate.of(1993, 6, 18), "M", LocalDate.of(2029, 6, 17));
        Document gp9 = new Document("APP009", "P999999", "US", "Emily", LocalDate.of(1997, 4, 23), "F", LocalDate.of(2032, 12, 4));
        Document gp10 = new Document("APP010", "P101010", "BD", "Karim", LocalDate.of(1985, 12, 30), "M", LocalDate.of(2030, 12, 29));

        GovtPassportList.add(gp1);
        GovtPassportList.add(gp2);
        GovtPassportList.add(gp3);
        GovtPassportList.add(gp4);
        GovtPassportList.add(gp5);
        GovtPassportList.add(gp6);
        GovtPassportList.add(gp7);
        GovtPassportList.add(gp8);
        GovtPassportList.add(gp9);
        GovtPassportList.add(gp10);




        //Applicant Passport List
        Document aP1 = new Document("APP001", "P111111", "BD", "Alice",   LocalDate.of(1995, 3, 12), "F", LocalDate.of(2028, 3, 11), true, true);
        Document aP2 = new Document("APP002", "P222222", "BD", "Rakib",   LocalDate.of(1995, 6, 19), "M", LocalDate.of(2030, 11, 1), true, true);
        Document aP3 = new Document("APP003", "P333333", "IN", "Sonia",   LocalDate.of(1988, 11, 2), "F", LocalDate.of(2030, 11, 1), true, true);
        Document aP4 = new Document("APP004", "P444444", "PK", "Zahid",   LocalDate.of(1992, 01, 15), "M", LocalDate.of(2029, 1, 14), false, true);
        Document aP5 = new Document("APP005", "P555555", "BD", "Mim",     LocalDate.of(1999, 07, 22), "F", LocalDate.of(2026, 7, 21), false, false);
        Document aP6 = new Document("APP006", "P666666", "NP", "Arjun",   LocalDate.of(1991, 02, 2), "M", LocalDate.of(2028, 2, 1), true, false);
        Document aP7 = new Document("APP007", "P777777", "LK", "Nimali",  LocalDate.of(1987, 11, 5), "F", LocalDate.of(2027, 11, 4), false, true);
        Document aP8 = new Document("APP008", "P888888", "CN", "Wei",     LocalDate.of(1993, 06, 18), "M", LocalDate.of(2029, 6, 17), false, false);
        Document aP9 = new Document("APP009", "P999999", "US", "Emily",   LocalDate.of(1997, 04, 23), "F", LocalDate.of(2032, 12, 4), true, true);
        Document aP10 = new Document("APP010", "P101010", "BD", "Karim",  LocalDate.of(1985, 12, 30), "M", LocalDate.of(2030, 12, 29), false, false);

        ApplicantPassportList.add(aP1);
        ApplicantPassportList.add(aP2);
        ApplicantPassportList.add(aP3);
        ApplicantPassportList.add(aP4);
        ApplicantPassportList.add(aP5);
        ApplicantPassportList.add(aP6);
        ApplicantPassportList.add(aP7);
        ApplicantPassportList.add(aP8);
        ApplicantPassportList.add(aP9);
        ApplicantPassportList.add(aP10);

        //Pending Application List
        Document PA1 = new Document("APP001", "P111111", "BD", "Alice",   LocalDate.of(1995, 3, 12), "F", LocalDate.of(2028, 3, 11), true, false);
        Document PA2 = new Document("APP002", "P222222", "BD", "Rakib",   LocalDate.of(1995, 6, 19), "M", LocalDate.of(2030, 11, 1), false, true);
        Document PA3 = new Document("APP003", "P333333", "IN", "Sonia",   LocalDate.of(1988, 11, 2), "F", LocalDate.of(2030, 11, 1), true, true);
        Document PA4 = new Document("APP004", "P444444", "PK", "Zahid",   LocalDate.of(1992, 01, 15), "M", LocalDate.of(2029, 1, 14), true, true);
        Document PA5 = new Document("APP005", "P555555", "BD", "Mim",     LocalDate.of(1999, 07, 22), "F", LocalDate.of(2026, 7, 21), false, false);
        PendingApplicationList.add(PA1);
        PendingApplicationList.add(PA2);
        PendingApplicationList.add(PA3);
        PendingApplicationList.add(PA4);
        PendingApplicationList.add(PA5);

       ;

        //Verified Application List
        Document VA1 = new Document("APP004", "P444444", "PK", "Zahid",   LocalDate.of(1992, 01, 15), "M", LocalDate.of(2029, 1, 14), true, true);
        Document VA2 = new Document("APP003", "P333333", "IN", "Sonia",   LocalDate.of(1988, 11, 2), "F", LocalDate.of(2030, 11, 1), true, true);

        VerifiedApplicationList.add(VA1);
        VerifiedApplicationList.add(VA2);

//
//        //Issued Visa List
//        Document iv1 = new Document(true, "Rakib", "P222222", "V001", "VN123456", LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 1), LocalDate.of(2025, 2, 1), "Officer1");
//        Document iv2 = new Document(true, "Sonia", "P333333", "V002", "VN234567", LocalDate.of(2024, 2, 10), LocalDate.of(2024, 3, 1), LocalDate.of(2025, 3, 1), "Officer2");
//
//        issuedVisaList.add(iv1);
//        issuedVisaList.add(iv1);

        documentTableView.getItems().addAll((ApplicantPassportList));

    }


    @javafx.fxml.FXML
    public void saveGOVTPassportListToTXTOnAction(ActionEvent actionEvent) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("GovtPassportList.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            for (Document c: GovtPassportList){
                oos.writeObject(c);
            }
            oos.close();
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void savePendingApplicationListToBINOnAction(ActionEvent actionEvent) {
        FileOutputStream fosu = null;
        ObjectOutputStream oosu = null;
        try{
            File x = new File("PendingApplicationList.bin");
            if(x.exists()){
                fosu = new FileOutputStream(x, true);
                oosu = new AppendableObjectOutputStream(fosu);
            }
            else{
                fosu = new FileOutputStream(x);
                oosu = new ObjectOutputStream(fosu);
            }
            for (Document c: PendingApplicationList){
                oosu.writeObject(c);
            }
            oosu.close();
        } catch (Exception e) {
            //
        }

    }

    @javafx.fxml.FXML
    public void saveVerifiedApplicationListToBINOnAction(ActionEvent actionEvent) {
        FileOutputStream fosu = null;
        ObjectOutputStream oosu = null;
        try{
            File x = new File("VerifiedApplicationList.bin");
            if(x.exists()){
                fosu = new FileOutputStream(x, true);
                oosu = new AppendableObjectOutputStream(fosu);
            }
            else{
                fosu = new FileOutputStream(x);
                oosu = new ObjectOutputStream(fosu);
            }
            for (Document c: VerifiedApplicationList){
                oosu.writeObject(c);
            }
            oosu.close();
        } catch (Exception e) {
            //
        }

    }

    @Deprecated
    public void saveRejectedListToBINOnAction(ActionEvent actionEvent) {
        FileOutputStream fosu = null;
        ObjectOutputStream oosu = null;
        try{
            File x = new File("PendingApplicationList.bin");
            if(x.exists()){
                fosu = new FileOutputStream(x, true);
                oosu = new AppendableObjectOutputStream(fosu);
            }
            else{
                fosu = new FileOutputStream(x);
                oosu = new ObjectOutputStream(fosu);
            }
            for (Document c: PendingApplicationList){
                oosu.writeObject(c);
            }
            oosu.close();
        } catch (Exception e) {
            //
        }
    }

//    @Deprecated
//    public void saveApplicationGListToBINOnAction(ActionEvent actionEvent) {
//        FileOutputStream fosu = null;
//        ObjectOutputStream oosu = null;
//        try{
//            File x = new File("ApplicantPassportList.bin");
//            if(x.exists()){
//                fosu = new FileOutputStream(x, true);
//                oosu = new AppendableObjectOutputStream(fosu);
//            }
//            else{
//                fosu = new FileOutputStream(x);
//                oosu = new ObjectOutputStream(fosu);
//            }
//            for (Document c: ApplicantPassportList){
//                oosu.writeObject(c);
//            }
//            oosu.close();
//        } catch (Exception e) {
//            //
//        }

//    }

    @javafx.fxml.FXML
    public void backToVisaDashBoardOnAction(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void saveApplicantPassportListtToBINOnAction(ActionEvent actionEvent) {
        FileOutputStream fosu = null;
        ObjectOutputStream oosu = null;
        try{
            File x = new File("ApplicantPassportList.bin");
            if(x.exists()){
                fosu = new FileOutputStream(x, true);
                oosu = new AppendableObjectOutputStream(fosu);
            }
            else{
                fosu = new FileOutputStream(x);
                oosu = new ObjectOutputStream(fosu);
            }
            for (Document c: ApplicantPassportList){
                oosu.writeObject(c);
            }
            oosu.close();
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {
        documentTableView.getItems().clear();
        File f = new File("ApplicantPassportList.bin");
        if(f.exists()){
            f.delete();
        }
        File f1 = new File("PendingApplicationList.bin");
        if(f1.exists()){
            f1.delete();
        }
        File f2 = new File("VerifiedApplicationList.bin");
        if(f2.exists()){
            f2.delete();
        }
        File f3 = new File("GovtPassportList.bin");
        if(f3.exists()){
            f3.delete();
        }
    }
//        filterComboBox.getItems().addAll("All Applications", "Pending Applications", "Verified Applications", "Rejected Applications");
    @javafx.fxml.FXML
    public void loadListOnAction(ActionEvent actionEvent) throws IOException {
        documentTableView.getItems().clear();
//        documentTableView.getItems().addAll((ApplicantPassportList));
        documentTableView.getItems().clear();
        String selectedVisaType = filterComboBox.getValue();
        if (selectedVisaType == null) {
            showAlert("Error", "Please select a List type");
            return;
        } else if (selectedVisaType.equals("All Applications")) {
            documentTableView.getItems().addAll((ApplicantPassportList));
            showAlert1("Success", "All Applications Loaded Successfully");
        } else if (selectedVisaType.equals("Pending Applications")) {
            documentTableView.getItems().addAll((PendingApplicationList));
            showAlert1("Success", "Pending Applications Loaded Successfully");
        } else if (selectedVisaType.equals("Verified Applications")) {
            documentTableView.getItems().addAll((VerifiedApplicationList));
            showAlert1("Success", "Verified Applications Loaded Successfully");
        } else if (selectedVisaType.equals("Govt Passport List")) {
            documentTableView.getItems().addAll((GovtPassportList));
            showAlert1("Success", "Govt Passport List Loaded Successfully");
        } else {
            showAlert2("Error", "Invalid List type selected");
        }

    }
    public void showAlert(String title, String message) {
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