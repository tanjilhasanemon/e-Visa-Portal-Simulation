package com.project.visa_management_portal.galib.visaOfficer;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.galib.model.ApplicantPassport;
import com.project.visa_management_portal.galib.model.GovtPassport;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class fileGeneratorControlller {
    ArrayList<GovtPassport> GovtPassportList;
    @javafx.fxml.FXML
    private Label notificationLabel;

    ArrayList<ApplicantPassport> ApplicantPassportList;
    @javafx.fxml.FXML
    public void initialize() {
        GovtPassportList = new ArrayList<>();

        GovtPassport gP2= new GovtPassport("P100002", "BD", "Rakib",      LocalDate.of(1995, 06, 19), "M", LocalDate.of(2030, 11, 01));
        GovtPassport gP3= new GovtPassport ("P100003", "IN", "Sonia",     LocalDate.of(1988,11,02),   "F", LocalDate.of(2030, 11, 01));
        GovtPassport gP4= new GovtPassport("P100005", "BD", "Mim",       LocalDate.of(1999, 07, 22),  "F", LocalDate.of(2026, 07, 21));
        GovtPassport gP5= new GovtPassport("P100006", "NP", "Arjun",     LocalDate.of(1991, 02, 02),  "M", LocalDate.of(2028, 02, 01));
        GovtPassport gP6= new GovtPassport("P100007", "LK", "Nimali",   LocalDate.of(1987, 11, 05),   "F", LocalDate.of(2027, 11, 04));
        GovtPassport gP7= new GovtPassport("P100008", "BD", "Karim",    LocalDate.of(1985, 12, 30),   "M", LocalDate.of(2030, 12, 29));
        GovtPassport gP8= new GovtPassport("P100009", "CN", "Wei",       LocalDate.of(1993, 06, 18),  "M", LocalDate.of(2029, 06, 17));
        GovtPassport gP9= new GovtPassport("P100010", "US", "Emily",     LocalDate.of(1997, 04, 23),  "F", LocalDate.of(2032, 12, 04));
        GovtPassport gP10= new GovtPassport("P100004", "PK", "Zahid",    LocalDate.of(1992, 01, 15),  "M", LocalDate.of(2029, 01, 14));
        GovtPassport gP11= new GovtPassport("P100001", "BD", "Alice",   LocalDate.of(1995, 03, 12),   "F", LocalDate.of(2028, 03, 11));

        GovtPassportList.add(gP2);
        GovtPassportList.add(gP3);
        GovtPassportList.add(gP4);
        GovtPassportList.add(gP5);
        GovtPassportList.add(gP6);
        GovtPassportList.add(gP7);
        GovtPassportList.add(gP8);
        GovtPassportList.add(gP9);
        GovtPassportList.add(gP10);
        GovtPassportList.add(gP11);





        ApplicantPassportList = new ArrayList<>();

        ApplicantPassport aP2= new ApplicantPassport("P222222", "BD", "Rakib",      LocalDate.of(1995, 06, 19), "M", LocalDate.of(2030, 11, 01));
        ApplicantPassport aP3= new ApplicantPassport ("P333333", "IN", "Sonia",     LocalDate.of(1988,11,02),   "F", LocalDate.of(2030, 11, 01));
        ApplicantPassport aP4= new ApplicantPassport("P555555", "BD", "Mim",       LocalDate.of(1999, 07, 22),  "F", LocalDate.of(2026, 07, 21));
        ApplicantPassport aP5= new ApplicantPassport("P666666", "NP", "Arjun",     LocalDate.of(1991, 02, 02),  "M", LocalDate.of(2028, 02, 01));
        ApplicantPassport aP6= new ApplicantPassport("P777777", "LK", "Nimali",   LocalDate.of(1987, 11, 05),   "F", LocalDate.of(2027, 11, 04));
        ApplicantPassport aP7= new ApplicantPassport("P100008", "BD", "Karim",    LocalDate.of(1985, 12, 30),   "M", LocalDate.of(2030, 12, 29));
        ApplicantPassport aP8= new ApplicantPassport("P100009", "CN", "Wei",       LocalDate.of(1993, 06, 18),  "M", LocalDate.of(2029, 06, 17));
        ApplicantPassport aP9= new ApplicantPassport("P100010", "US", "Emily",     LocalDate.of(1997, 04, 23),  "F", LocalDate.of(2032, 12, 04));
        ApplicantPassport aP10= new ApplicantPassport("P444444", "PK", "Zahid",    LocalDate.of(1992, 01, 15),  "M", LocalDate.of(2029, 01, 14));
        ApplicantPassport aP11= new ApplicantPassport("P111111", "BD", "Alice",   LocalDate.of(1995, 03, 12),   "F", LocalDate.of(2028, 03, 11));

        ApplicantPassportList.add(aP2);
        ApplicantPassportList.add(aP3);
        ApplicantPassportList.add(aP4);
        ApplicantPassportList.add(aP5);
        ApplicantPassportList.add(aP6);
        ApplicantPassportList.add(aP7);
        ApplicantPassportList.add(aP8);
        ApplicantPassportList.add(aP9);
        ApplicantPassportList.add(aP10);
        ApplicantPassportList.add(aP11);
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
            for (GovtPassport c: GovtPassportList){
                oos.writeObject(c);
            }
            oos.close();
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void savePendingApplicationListToBINOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveVerifiedApplicationListToBINOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveRejectedListToBINOnAction(ActionEvent actionEvent) {
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
            for (GovtPassport c: GovtPassportList){
                oosu.writeObject(c);
            }
            oosu.close();
        } catch (Exception e) {
            //
        }

    }

    @javafx.fxml.FXML
    public void saveApplicationGListToBINOnAction(ActionEvent actionEvent) {
    }

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
}