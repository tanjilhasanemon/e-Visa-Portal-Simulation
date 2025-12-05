package com.project.visa_management_portal.galib.visaOfficer;

import com.project.visa_management_portal.galib.model.ApplicantPassport;
import com.project.visa_management_portal.galib.model.ApplicationG;
import com.project.visa_management_portal.galib.model.GovtPassport;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


public class documentVerificationController
{
    @javafx.fxml.FXML
    private TextField inputAppIdForVerifyTextField;
    @javafx.fxml.FXML
    private TableColumn <ApplicationG, String>verifiedPassportNoCol;
    @javafx.fxml.FXML
    private TableColumn <ApplicationG, String>verifiedPassportVerifiedCol;
    @javafx.fxml.FXML
    private TableView <String>verifiedDocumentTableView;
    @javafx.fxml.FXML
    private TableColumn  <ApplicationG, String>verifiedPassportNoteCol;
    @javafx.fxml.FXML
    private TableColumn  <ApplicationG, String>verifiedAppplicationNameCol;
    @javafx.fxml.FXML
    private TableColumn  <ApplicationG, String>verifiedAppIdCol;
    @javafx.fxml.FXML
    private RadioButton govtPassportradioButton;
    @javafx.fxml.FXML
    private RadioButton applicantPassportradioButton1;
    @javafx.fxml.FXML
    private TableColumn <GovtPassport,String>govtFirstNameCol;
    @javafx.fxml.FXML
    private TableColumn<GovtPassport,String> govtPassportNoCol;
    @javafx.fxml.FXML
    private TableColumn<ApplicantPassport,String> applicantPassportCol1;
    @javafx.fxml.FXML
    private TableView<GovtPassport> govtPassportTableView;
    @javafx.fxml.FXML
    private TableView<ApplicantPassport> applicantPassportTableView;
    @javafx.fxml.FXML
    private TableColumn<ApplicantPassport,String> applucantNameCol;

    @javafx.fxml.FXML
    public void initialize() {
        ToggleGroup tg = new ToggleGroup();
        govtPassportradioButton.setToggleGroup(tg);
        applicantPassportradioButton1.setToggleGroup(tg);

        govtPassportNoCol.setCellValueFactory(new PropertyValueFactory<GovtPassport,String>("PassportNO"));
        govtFirstNameCol.setCellValueFactory(new PropertyValueFactory<GovtPassport, String>("FirstName"));


        applicantPassportCol1.setCellValueFactory(new PropertyValueFactory<ApplicantPassport,String>("passportNo"));
        applucantNameCol.setCellValueFactory(new PropertyValueFactory<ApplicantPassport,String>("firstName"));

    }


    @javafx.fxml.FXML
    public void verifySelectedPassportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshListOnAction(ActionEvent actionEvent) {
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
    public void saveVerifiedApplication(ActionEvent actionEvent) {
    }

//    @Deprecated
//    public void loadPassportOnAction(ActionEvent actionEvent) {
    //    notificationLabel.setText("");
    //
    //        if (!applicantPassportradioButton1.isSelected() && !govtPassportradioButton.isSelected()) {
    //    notificationLabel.setText("Error!Passport list isn't loaded!!");
    //}
    //
    //        else if (govtPassportradioButton.isSelected())
    //    {
    //        FileInputStream fis = null;
    //        ObjectInputStream ois = null;
    //        try {
    //            File f = new File("GovtPassportList.bin");
    //            if (f.exists()) {
    //                fis = new FileInputStream(f);
    //            } else {
    //                //Alert: file does not exist
    //            }
    //            if (fis != null) ois = new ObjectInputStream(fis);
    //
    //            while (true) {
    //                //System.out.println((GovtPassport) ois.readObject());
    //                govtPassportTableView.getItems().add((GovtPassport) ois.readObject());
    //            }
    //        } catch (Exception e) {
    //            try {
    //                ois.close();
    //
    //            } catch (IOException ex) {
    //                //
    //            }
    //            notificationLabel.setText("Govt Passport list Loaded SuccessFully!");
    //        }
    //    }
//
//
//
//
//        //dummyPassportTableView.getItems().clear();
//          //System.out.println(dummyPassportTableView.getItems());
//        if (applicantPassportradioButton1.isSelected()) {
//
//
//            FileInputStream fis = null;
//            ObjectInputStream ois = null;
//            try {
//                File f = new File("ApplicantPassportList.bin");
//                if (f.exists()) {
//                    fis = new FileInputStream(f);
//                } else {
//                    //Alert: file does not exist
//                }
//                if (fis != null) ois = new ObjectInputStream(fis);
//
//                while (true) {
//                    //System.out.println((GovtPassport) ois.readObject());
//                    applicantPassportTableView.getItems().add((ApplicantPassport) ois.readObject());
//                }
//            } catch (Exception e) {
//                try {
//                    ois.close();
//
//                } catch (IOException ex) {
//                    //
//                }
//                notificationLabel.setText("Applicant Passport list Loaded SuccessFully!");
//            }
//        }
//    }

    @javafx.fxml.FXML
    public void loadApplicantPassportOnAction(ActionEvent actionEvent) {
        FileInputStream fisr = null;
        ObjectInputStream oisr = null;
        try {
            File gpp = new File("ApplicantPassportList.bin");
            if (gpp.exists()) {
                fisr = new FileInputStream(gpp);
            } else {
                //Alert: file does not exist
            }
            if (fisr != null) oisr = new ObjectInputStream(fisr);

            while (true) {
                //System.out.println((GovtPassport) ois.readObject());
                applicantPassportTableView.getItems().add((ApplicantPassport) oisr.readObject());
            }
        } catch (Exception e) {
            try {
                oisr.close();

            } catch (IOException ex) {
                //
            }
            //notificationLabel.setText("Applicant Passport list Loaded SuccessFully!");
        }
    }

    @javafx.fxml.FXML
    public void loadGovtPassportOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File gp = new File("GovtPassportList.bin");
            if (gp.exists()) {
                fis = new FileInputStream(gp);
            } else {
                //Alert: file does not exist
            }
            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                //System.out.println((GovtPassport) ois.readObject());
                govtPassportTableView.getItems().add((GovtPassport) ois.readObject());
            }
        } catch (Exception e) {
            try {
                ois.close();

            } catch (IOException ex) {
                //
            }
            //notificationLabel.setText("Applicant Passport list Loaded SuccessFully!");
        }

    }
}