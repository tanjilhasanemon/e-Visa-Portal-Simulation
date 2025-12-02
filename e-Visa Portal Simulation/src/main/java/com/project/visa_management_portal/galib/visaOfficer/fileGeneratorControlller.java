package com.project.visa_management_portal.galib.visaOfficer;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.galib.model.GovtPassport;
import javafx.event.ActionEvent;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class fileGeneratorControlller {
    ArrayList<GovtPassport> GovtPassportList;

    @javafx.fxml.FXML
    public void initialize() {
        GovtPassportList = new ArrayList<GovtPassport>();

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
    }




    @javafx.fxml.FXML
    public void addGovtPassportToListOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveGOVTPassportListToTXTOnAction(ActionEvent actionEvent) {
        FileWriter fw = null;
        try{
            File f = new File("GovtPassportList.txt");
            if(f.exists()){
                fw = new FileWriter(f, true);
            }
            else{
                fw = new FileWriter(f);
            }

            StringBuilder str = new StringBuilder();
            for(GovtPassport c: GovtPassportList){
                str.append(c.toString()).append("\n");
            }
            fw.write(str.toString());
            fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    public void saveGOVTPassportListToBINOnAction(ActionEvent actionEvent) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("GovtPassport.bin");
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
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @javafx.fxml.FXML
    public void addApplicantPassportToListOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveApplicantPassportListToTXTOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void saveApplicantPassportListtToBINOnAction(ActionEvent actionEvent) {
    }





    @javafx.fxml.FXML
    public void addVerifiedApplicationToListOnAction(ActionEvent actionEvent) {
//        ApplicationG c1 = new Course(courseIDTextfield.getText(), courseTitleTextfield.getText(),
//                courseTypeComboBox.getValue(), noOfCreditsComboBox.getValue());
//        courseList.add(c1);
    }

    @javafx.fxml.FXML
    public void saveVerifiedApplicationListToTXTOnAction(ActionEvent actionEvent) {
    }
    @javafx.fxml.FXML
    public void saveVerifiedApplicationListToBINOnAction(ActionEvent actionEvent) {
    }





    @javafx.fxml.FXML
    public void addPendingApplicationToListOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void savePendingApplicationListToTXTOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void savePendingApplicationListToBINOnAction(ActionEvent actionEvent) {
    }




    @javafx.fxml.FXML
    public void addRejectedApplicationToListOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveRejectedListToTXTOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveRejectedListToBINOnAction(ActionEvent actionEvent) {
    }




    @javafx.fxml.FXML
    public void addApplicationToListOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveApplicationGListToTXTOnAction(ActionEvent actionEvent) {
    }
    @javafx.fxml.FXML
    public void saveApplicationGListToBINOnAction(ActionEvent actionEvent) {
    }
}