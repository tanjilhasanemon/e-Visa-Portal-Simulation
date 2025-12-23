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
import java.util.ArrayList;

public class VisaOfficersMergedGoalController {
    @javafx.fxml.FXML
    private TextField inputAppIdForVerifyTextField;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableView<Document> documentTableView;
    @javafx.fxml.FXML
    private TableColumn<Document, String> dateOfBirthCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> issuingCountryCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> passportVerifiedCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> expireDateCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> applicantIdCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> paymentStatusCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> genderCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> passportNoCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> firstNameCol;
    @javafx.fxml.FXML
    private ComboBox<String> filterComboBox2;


    ArrayList<Document> newApplicantPassportList = new ArrayList<>();
    ArrayList<Document> FinalVerifiedListForIssuing = new ArrayList<>();
    ArrayList<Document> Rejected = new ArrayList<>();
    ArrayList<Document> MergedVerifiedAndRejectedList = new ArrayList<>();
    ArrayList<Document> VerifiedListForTable = new ArrayList<>();
    ArrayList<Document> PendingListForTable = new ArrayList<>();
    @javafx.fxml.FXML
    private TableColumn<Document, String> issuingCountryCol1;
    @javafx.fxml.FXML
    private TableColumn<Document, String> expireDateCol1;
    @javafx.fxml.FXML
    private TableColumn<Document, String> genderCol1;
    @javafx.fxml.FXML
    private TableColumn<Document, String> passportNoCol1;
    @javafx.fxml.FXML
    private TableColumn<Document, String> passportVerifiedCol1;
    @javafx.fxml.FXML
    private TableView<Document> documentTableView1;
    @javafx.fxml.FXML
    private ComboBox<String> filterComboBox21;
    @javafx.fxml.FXML
    private TableColumn<Document, String> applicantIdCol1;
    @javafx.fxml.FXML
    private TableColumn<Document, String> dateOfBirthCol1;
    @javafx.fxml.FXML
    private TableColumn<Document, String> firstNameCol1;
    @javafx.fxml.FXML
    private TableColumn<Document, String> paymentStatusCol1;


    @javafx.fxml.FXML
    public void initialize() {


        filterComboBox2.getItems().addAll("Verified Applications", "Pending Applications", "All Applications", "Pending And Verified Applications", "Final Verified List For Issuing", "Rejected Applications", "Final Verified And Rejected Applications");

        applicantIdCol.setCellValueFactory(new PropertyValueFactory<Document, String>("ApplicantId"));
        passportNoCol.setCellValueFactory(new PropertyValueFactory<Document, String>("passportNo"));
        issuingCountryCol.setCellValueFactory(new PropertyValueFactory<Document, String>("issuingCountry"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Document, String>("firstName"));
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<Document, String>("dateOfBirth"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Document, String>("gender"));
        expireDateCol.setCellValueFactory(new PropertyValueFactory<Document, String>("expireDate"));
        paymentStatusCol.setCellValueFactory(new PropertyValueFactory<Document, String>("paymentStatus"));
        passportVerifiedCol.setCellValueFactory(new PropertyValueFactory<Document, String>("passportVerified"));

        filterComboBox21.getItems().addAll("Final Verified List For Issuing", "Rejected Applications", "Final Verified And Rejected Applications");
        applicantIdCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("ApplicantId"));
        passportNoCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("passportNo"));
        issuingCountryCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("issuingCountry"));
        firstNameCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("firstName"));
        dateOfBirthCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("dateOfBirth"));
        genderCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("gender"));
        expireDateCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("expireDate"));
        paymentStatusCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("paymentStatus"));
        passportVerifiedCol1.setCellValueFactory(new PropertyValueFactory<Document, String>("passportVerified"));
    }

    @javafx.fxml.FXML
    public void verifySelectedPassportOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("ApplicantPassportList.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);

                while (true) {
                    Document doc = (Document) ois.readObject();
                    newApplicantPassportList.add(doc);
                }
            } else {
                showAlert("File not found", "ApplicantPassportList.bin does not exist.");
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
        try {
            File passport = new File("GovtPassportList.bin");
            if (passport.exists()) {
                fis1 = new FileInputStream(passport);
                ois1 = new ObjectInputStream(fis1);

                while (true) {
                    Document doc = (Document) ois1.readObject();
                    newGovtPassportLis.add(doc);
                }
            } else {
                showAlert("File not found", "ApplicantPassportList.bin does not exist.");
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
                showAlert("Input Required", "Please enter a Passport Number.");
            } else {
                inputAppIdForVerifyTextField.clear();
                boolean matchFound = false;
                for (Document doc : newGovtPassportLis) {
                    if (doc.getGovtPassportNO().equals(inputPassportNo)) {
                        // Find matching applicant document
                        for (Document applicantDoc : newApplicantPassportList) { //loop through applicant documents

                            if (applicantDoc.isPaymentStatus() && applicantDoc.getPassportNo().equals(inputPassportNo)) {
                                FileOutputStream fos = null;
                                ObjectOutputStream oos = null;
                                try {
                                    File f = new File("VerifiedList.bin");
                                    if (f.exists()) {
                                        fos = new FileOutputStream(f, true);
                                        oos = new AppendableObjectOutputStream(fos);
                                    } else {
                                        fos = new FileOutputStream(f);
                                        oos = new ObjectOutputStream(fos);
                                    }
                                    for (Document c : newApplicantPassportList) {
                                        oos.writeObject(c);
                                        VerifiedListForTable.add(applicantDoc);

                                    }
                                    oos.close();
                                } catch (Exception e) {
                                    //
                                }
                                documentTableView.getItems().add(applicantDoc);
                                // Clear input field after successful verification
                                showAlert1("Success", "verified successfully!");
                                matchFound = true;
                                return;

                            }
                        }
                    }
                }

                if (!matchFound) { //no govt passport match or payment not done
                    for (Document applicantDoc : newApplicantPassportList) {
                        if (applicantDoc.getPassportNo().equals(inputPassportNo)) {
                            FileOutputStream fos = null;
                            ObjectOutputStream oos = null;
                            try {
                                File f = new File("PendingList.bin");
                                if (f.exists()) {
                                    fos = new FileOutputStream(f, true);
                                    oos = new AppendableObjectOutputStream(fos);
                                } else {
                                    fos = new FileOutputStream(f);
                                    oos = new ObjectOutputStream(fos);
                                }
                                oos.writeObject(applicantDoc);
                                PendingListForTable.add(applicantDoc);
                                oos.close();
                            } catch (Exception e) {
                                //
                            }
                            showAlert2("Pending", "Document added to pending list - verification requirements not met.");
                            return;
                        }
                    }
                    showAlert("Not Found", "No document found with this passport number.");
                }
            }
        } catch (Exception e) {
            showAlert("Error", "An error occurred during verification.");
        }
    }

    @javafx.fxml.FXML
    public void refreshListOnAction(ActionEvent actionEvent) {
        documentTableView.getItems().clear();
        inputAppIdForVerifyTextField.clear();
        showAlert1("Refreshed", "All lists have been cleared.");
    }

    @javafx.fxml.FXML
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


    @javafx.fxml.FXML
    public void exportListOnAction(ActionEvent actionEvent) {
//        documentTableView.getItems().clear();
//        String selectedVisaType = filterComboBox2.getValue();
//        if (selectedVisaType == null) {
//            showAlert("Error", "Please select a List type");
//
//        } else if (selectedVisaType.equals("Verified Applications")) {
//            FileInputStream fis = null;
//            ObjectInputStream ois = null;
//            try{
//                File f = new File("VerifiedList.bin");
//                if(f.exists()){
//                    fis = new FileInputStream(f);
//                    ois = new ObjectInputStream(fis);
//
//                    while(true){
//                        Document doc = (Document) ois.readObject();
//                        VerifiedListForTable.add(doc); // add to DocList
//                    }
//                }
//                else{
//                    showAlert("File not found", "VerifiedtList.bin does not exist.");
//                }
//
//            } catch (EOFException e) {
//                // End of file - expected
//            } catch (Exception e) {
//                //
//            } finally { // close streams
//                try {
//                    if (ois != null) ois.close();
//                    if (fis != null) fis.close();
//                } catch (IOException ex) {
//                    // ignore
//                }
//            }
//
//        } else if (selectedVisaType.equals("Pending Applications")) {
//            FileInputStream fis = null;
//            ObjectInputStream ois = null;
//            try{
//                File f = new File("PendingList.bin");
//                if(f.exists()){
//                    fis = new FileInputStream(f);
//                    ois = new ObjectInputStream(fis);
//
//                    while(true){
//                        Document doc = (Document) ois.readObject();
//                        PendingListForTable.add(doc); // add to DocList
//                    }
//                }
//                else{
//                    showAlert("File not found", "VerifiedtList.bin does not exist.");
//                }
//
//            } catch (EOFException e) {
//                // End of file - expected
//            } catch (Exception e) {
//                //
//            } finally { // close streams
//                try {
//                    if (ois != null) ois.close();
//                    if (fis != null) fis.close();
//                } catch (IOException ex) {
//                    // ignore
//                }
//            }
//
//        }
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

    ArrayList<Document> MergedListForTable = new ArrayList<>();

    @javafx.fxml.FXML
    public void loadListInTableView(ActionEvent actionEvent) {
        documentTableView.getItems().clear();
        String selectedVisaType = filterComboBox2.getValue();
        if (selectedVisaType == null) {
            showAlert("Error", "Please select a List type");
            return;
        } else if (selectedVisaType.equals("Verified Applications")) {
            documentTableView.getItems().addAll(VerifiedListForTable);
        } else if (selectedVisaType.equals("Pending Applications")) {
            documentTableView.getItems().addAll(PendingListForTable);
        } else if (selectedVisaType.equals("Pending And Verified Applications")) {
            MergedListForTable.clear();// clear previous data
            MergedListForTable.addAll(VerifiedListForTable);
            MergedListForTable.addAll(PendingListForTable);
            documentTableView.getItems().addAll(MergedListForTable);
        } else if (selectedVisaType.equals("All Applications")) {
            documentTableView.getItems().addAll(newApplicantPassportList);
        } else if (selectedVisaType.equals("Final Verified List For Issuing")) {
            documentTableView1.getItems().addAll(FinalVerifiedListForIssuing);
        } else if (selectedVisaType.equals("Rejected Applications")) {
            documentTableView1.getItems().addAll(Rejected);
        } else if (selectedVisaType.equals("Final Verified And Rejected Applications")) {
            MergedVerifiedAndRejectedList.clear();// clear previous data
            MergedVerifiedAndRejectedList.addAll(FinalVerifiedListForIssuing);
            MergedVerifiedAndRejectedList.addAll(Rejected);
            documentTableView1.getItems().addAll(MergedVerifiedAndRejectedList);
        }
    }

    @javafx.fxml.FXML
    public void refreshFinalListOnAction(ActionEvent actionEvent) {
        documentTableView1.getItems().clear();
    }

    @javafx.fxml.FXML
    public void loadFinalListInTableViewButtonOnAction(ActionEvent actionEvent) {
        try {
            String inputPassportNo1 = inputAppIdForVerifyTextField.getText().trim();

            if (inputPassportNo1.isEmpty()) {
                showAlert("Input Required", "Please enter a Passport Number.");
            } else {
                inputAppIdForVerifyTextField.clear();
                boolean matchFound = false;
                for (Document doc : MergedListForTable) {
                    if (doc.getPassportNo().equals(inputPassportNo1)) {
                        matchFound = true;

                        // Add your verification logic here (e.g., check if passport is verified and payment is done)
                        if ("true".equals(doc.isPaymentStatus()) && "true".equals(doc.isPassportVerified())) {
                            FileOutputStream fos = null;
                            ObjectOutputStream oos = null;
                            try {
                                File f = new File("FinalVerifiedListForIssuing.bin");
                                if (f.exists()) {
                                    fos = new FileOutputStream(f, true);
                                    oos = new AppendableObjectOutputStream(fos);
                                } else {
                                    fos = new FileOutputStream(f);
                                    oos = new ObjectOutputStream(fos);
                                }
                                oos.writeObject(doc);
                                FinalVerifiedListForIssuing.add(doc);
                                oos.close();
                            } catch (Exception e) {
                                //
                            }
                            documentTableView1.getItems().add(doc);
                            showAlert1("Success", "Verification Applicant for Issuing successfully!");
                        } else {
                            // Rejection logic
                            FileOutputStream fos = null;
                            ObjectOutputStream oos = null;
                            try {
                                File f = new File("RejectedList.bin");
                                if (f.exists()) {
                                    fos = new FileOutputStream(f, true);
                                    oos = new AppendableObjectOutputStream(fos);
                                } else {
                                    fos = new FileOutputStream(f);
                                    oos = new ObjectOutputStream(fos);
                                }
                                oos.writeObject(doc);
                                Rejected.add(doc);
                                oos.close();
                            } catch (Exception e) {
                                //
                            }
                            showAlert2("Rejected", "Document added to Rejected list, Visa Decision not approved!!.");
                        }
                        return;
                    }
                }
            }
        } catch (Exception e) {
            showAlert("Error", "An error occurred during verification.");
        }
    }

}
////
//        try {
//            String inputPassportNo1 = inputAppIdForVerifyTextField.getText().trim();
//
//            if (inputPassportNo1.isEmpty()) {
//                showAlert("Input Required", "Please enter a Passport Number.");
//            }
//            else {
//                inputAppIdForVerifyTextField.clear();
//                boolean matchFound1 = false;
//                for (Document doc : MergedListForTable) {
//                    if (doc.getPassportNo().equals(inputPassportNo1)) {
//                        matchFound1 = true;
//                        if (doc.isPaymentStatus() && "true".equals(doc.getPassportNo())) { //
//                            FileOutputStream fos = null;
//                            ObjectOutputStream oos = null;
//                            try{
//                                File f = new File("FinalVerifiedListForIssuing.bin");
//                                if(f.exists()){
//                                    fos = new FileOutputStream(f, true);
//                                    oos = new AppendableObjectOutputStream(fos);
//                                }
//                                else{
//                                    fos = new FileOutputStream(f);
//                                    oos = new ObjectOutputStream(fos);
//                                }
//                                oos.writeObject(doc);
//                                FinalVerifiedListForIssuing.add(doc);
//                                oos.close();
//                            } catch (Exception e) {
//                                //
//                            }
//                            documentTableView1.getItems().add(doc);
//                            showAlert1("Success", "Verification Applicant for Issuing successfully!");
//                        }
//                    }
//                }
//
//                if (!matchFound1) { //no govt passport match or payment not done
//                    for (Document rejectDoc : MergedListForTable) {
//                        if (rejectDoc.getPassportNo().equals(inputPassportNo1)) {
//                            FileOutputStream fos = null;
//                            ObjectOutputStream oos = null;
//                            try{
//                                File f = new File("RejectedList.bin");
//                                if(f.exists()){
//                                    fos = new FileOutputStream(f, true);
//                                    oos = new AppendableObjectOutputStream(fos);
//                                }
//                                else{
//                                    fos = new FileOutputStream(f);
//                                    oos = new ObjectOutputStream(fos);
//                                }
//                                oos.writeObject(rejectDoc);
//                                Rejected.add(rejectDoc);
//                                oos.close();
//                            } catch (Exception e) {
//                                //
//                            }
//                            showAlert2("Rejected", "Document added to Rejected list, Visa Decision not approved!!.");
//                            return;
//                        }
//                    }
//                }
//            }
//        }
//        catch (Exception e) {
//            showAlert("Error", "An error occurred during verification.");
//        }
//