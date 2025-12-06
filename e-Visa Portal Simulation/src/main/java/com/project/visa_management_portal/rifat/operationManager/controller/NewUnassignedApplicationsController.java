package com.project.visa_management_portal.rifat.operationManager.controller;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.rifat.operationManager.modelClass.ApplicationsRifat;
import com.sun.net.httpserver.Authenticator;
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


public class NewUnassignedApplicationsController {
    @FXML
    private TableColumn<ApplicationsRifat, String> colAppID;
    @FXML
    private ComboBox<String> cmbVisaType;
    @FXML
    private TableColumn<ApplicationsRifat, String> colSubmittedAt;
    @FXML
    private Button btnApplyFilterVisaType;
    @FXML
    private Button btnRefresh;
    @FXML
    private TableColumn<ApplicationsRifat, String> colType;
    @FXML
    private Button btnAssign;
    @FXML
    private Button btnBackToDashBoard;
    @FXML
    private ComboBox<String> cmbOfficer;
    @FXML
    private Label lblTitle;
    @FXML
    private TableView<ApplicationsRifat> tblNewUnassigned;
    @FXML
    private TableColumn<ApplicationsRifat, String> colStatus;

    ArrayList<ApplicationsRifat> applicationList;
    @FXML
    private Button btnLoad;

    @FXML
    public void initialize() {
        cmbVisaType.getItems().addAll("Tourist Visa", "Student Visa", "Work Visa", "Business Visa", "Transit Visa");
        cmbOfficer.getItems().addAll("Student Visa Officer", "Work Visa Officer", "Business Visa Officer", "Tourist Visa Officer", "Transit Visa Officer");

        applicationList = new ArrayList<ApplicationsRifat>();

        colAppID.setCellValueFactory(new PropertyValueFactory<ApplicationsRifat, String>("appId"));   // set up the cell value factories for the table columns
        colType.setCellValueFactory(new PropertyValueFactory<ApplicationsRifat, String>("visaType"));
        colSubmittedAt.setCellValueFactory(new PropertyValueFactory<ApplicationsRifat, String>("submittedAt"));
        colStatus.setCellValueFactory(new PropertyValueFactory<ApplicationsRifat, String>("status"));

//        ApplicationsRifat a1 = new ApplicationsRifat("2367", "Tourist Visa", LocalDate.of(2024, 6, 1), "Unassigned");
//        ApplicationsRifat a2 = new ApplicationsRifat("2368", "Student Visa", LocalDate.of(2024, 6, 2), "Unassigned");
//        ApplicationsRifat a3 = new ApplicationsRifat("2369", "Work Visa", LocalDate.of(2024, 6, 3), "Unassigned");
//        ApplicationsRifat a4 = new ApplicationsRifat("2370", "Business Visa", LocalDate.of(2024, 6, 4), "Unassigned");
//        ApplicationsRifat a5 = new ApplicationsRifat("2371", "Transit Visa", LocalDate.of(2024, 6, 5), "Unassigned");
//        ApplicationsRifat a6 = new ApplicationsRifat("2372", "Tourist Visa", LocalDate.of(2024, 6, 6), "Unassigned");
//        ApplicationsRifat a7 = new ApplicationsRifat("2373", "Student Visa", LocalDate.of(2024, 6, 7), "Unassigned");
//        ApplicationsRifat a8 = new ApplicationsRifat("2374", "Work Visa", LocalDate.of(2024, 6, 8), "Unassigned");
//        ApplicationsRifat a9 = new ApplicationsRifat("2375", "Business Visa", LocalDate.of(2024, 6, 9), "Unassigned");
//        ApplicationsRifat a10 = new ApplicationsRifat("2376", "Transit Visa", LocalDate.of(2024, 6, 10), "Unassigned");
//        ApplicationsRifat a11 = new ApplicationsRifat("2377", "Tourist Visa", LocalDate.of(2024, 6, 11), "Unassigned");
//        ApplicationsRifat a12 = new ApplicationsRifat("2378", "Student Visa", LocalDate.of(2024, 6, 12), "Unassigned");
//        ApplicationsRifat a13 = new ApplicationsRifat("2379", "Work Visa", LocalDate.of(2024, 6, 13), "Unassigned");
//        ApplicationsRifat a14 = new ApplicationsRifat("2380", "Business Visa", LocalDate.of(2024, 6, 14), "Unassigned");
//        ApplicationsRifat a15 = new ApplicationsRifat("2381", "Transit Visa", LocalDate.of(2024, 6, 15), "Unassigned");
//        ApplicationsRifat a16 = new ApplicationsRifat("2382", "Tourist Visa", LocalDate.of(2024, 6, 16), "Unassigned");
//        ApplicationsRifat a17 = new ApplicationsRifat("2383", "Student Visa", LocalDate.of(2024, 6, 17), "Unassigned");
//        ApplicationsRifat a18 = new ApplicationsRifat("2384", "Work Visa", LocalDate.of(2024, 6, 18), "Unassigned");
//        ApplicationsRifat a19 = new ApplicationsRifat("2385", "Business Visa", LocalDate.of(2024, 6, 19), "Unassigned");
//        ApplicationsRifat a20 = new ApplicationsRifat("2386", "Transit Visa", LocalDate.of(2024, 6, 20), "Unassigned");
//
//
//        applicationList.add(a1);
//        applicationList.add(a2);
//        applicationList.add(a3);
//        applicationList.add(a4);
//        applicationList.add(a5);
//        applicationList.add(a6);
//        applicationList.add(a7);
//        applicationList.add(a8);
//        applicationList.add(a9);
//        applicationList.add(a10);
//        applicationList.add(a11);
//        applicationList.add(a12);
//        applicationList.add(a13);
//        applicationList.add(a14);
//        applicationList.add(a15);
//        applicationList.add(a16);
//        applicationList.add(a17);
//        applicationList.add(a18);
//        applicationList.add(a19);
//        applicationList.add(a20);

        FileOutputStream fos = null;   // file output stream to write bytes to a file
        ObjectOutputStream oos = null; // object output stream to write objects to the file
        try {
            File file = new File("UnassignedApplications.bin"); // create a file object representing the file "UnassignedApplications.bin"
            if(file.exists()){
                fos = new FileOutputStream(file , true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            for (ApplicationsRifat app: applicationList){
                oos.writeObject(app);  // write each application object to the file
            }
            oos.close();
        } catch (Exception e){
            //
        }
    }
    @FXML
    public void load_OnActionButton(ActionEvent actionEvent) { // load applications from binary file
        tblNewUnassigned.getItems().clear();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("UnassignedApplications.bin"); // create a file object representing the file "UnassignedApplications.bin"
            if (file.exists()) {
                fis = new FileInputStream(file); // initialize file input stream
            }
            else{
                showAlert("Error", "File does not exist");
            }
            if(fis!=null)ois = new ObjectInputStream(fis);
            while (true) {
                tblNewUnassigned.getItems().add((ApplicationsRifat) ois.readObject()); // read objects from the file and add to the TableView
            }
        } catch (Exception e){
            //
        }
    }

    @FXML
    public void applyFilterVisaTypeOnActionButton(ActionEvent actionEvent) {
        String selectedVisaType = cmbVisaType.getValue();
        if (selectedVisaType == null) {
            showAlert("Error", "Please select a visa type");
            return;
        }

        tblNewUnassigned.getItems().clear();
        ArrayList<ApplicationsRifat> filteredList = new ArrayList<>();

        FileInputStream fis = null;    // step 1: file input stream
        ObjectInputStream ois = null;  // step 2: object input stream
        try {
            File file = new File("UnassignedApplications.bin");
            if (file.exists()) {
                fis = new FileInputStream(file);  // step 4: initialize file input stream
                ois = new ObjectInputStream(fis);  // step 5: initialize object input stream
                while (true) {                     // step 6: read objects from the file
                    ApplicationsRifat app = (ApplicationsRifat) ois.readObject();
                    if (app.getVisaType().equals(selectedVisaType)) {
                        filteredList.add(app);
                    }
                }
            } else {
                showAlert("Error", "File does not exist");
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (Exception e) {
            showAlert("Error", "Error reading file: " + e.getMessage());
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                // ignore
            }
        }

        tblNewUnassigned.getItems().addAll(filteredList);
    }
    @FXML
    public void assignAppToVIsaOfficer_BinFile_VisaTypeOnActBtn(ActionEvent actionEvent) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            String selectedVisaType = cmbVisaType.getValue();
            String selectedOfficer = cmbOfficer.getValue();
            if (selectedOfficer != null) {
                if (selectedOfficer.equals("Student Visa Officer") && selectedVisaType.equals("Student Visa")){                   // check which officer is selected
                    File file = new File("StudentVisaOfficerApplications.bin"); //
                    if (file.exists()) {
                        fos = new FileOutputStream(file, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(file);
                        oos = new ObjectOutputStream(fos);
                    }
                    for (ApplicationsRifat app : applicationList) {  //
                        if (app.getVisaType().equals("Student Visa")) { // only write applications of type "Student Visa"
                            oos.writeObject(app); // write each application object to the file
                        }
                    }
                    oos.close();
                    showSuccess("Success", "Applications assigned to Student Visa Officer successfully");

                }
                else if (selectedOfficer.equals("Work Visa Officer") && selectedVisaType.equals("Work Visa")){
                    File file = new File("WorkVisaOfficerApplications.bin");
                    if (file.exists()) {
                        fos = new FileOutputStream(file, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(file);
                        oos = new ObjectOutputStream(fos);
                    }
                    for (ApplicationsRifat app : applicationList) {
                        if (app.getVisaType().equals("Work Visa")) {
                            oos.writeObject(app);
                        }
                    }
                    oos.close();
                    showSuccess("Success", "Applications assigned to Work Visa Officer successfully");
                }
                else if (selectedOfficer.equals("Business Visa Officer") && selectedVisaType.equals("Business Visa")){
                    File file = new File("BusinessVisaOfficerApplications.bin");
                    if (file.exists()) {
                        fos = new FileOutputStream(file, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(file);
                        oos = new ObjectOutputStream(fos);
                    }
                    for (ApplicationsRifat app : applicationList) {
                        if (app.getVisaType().equals("Business Visa")) {
                            oos.writeObject(app);
                        }
                    }
                    oos.close();
                    showSuccess("Success", "Applications assigned to Business Visa Officer successfully");
                }
                else if (selectedOfficer.equals("Tourist Visa Officer") && selectedVisaType.equals("Tourist Visa")){
                    File file = new File("TouristVisaOfficerApplications.bin");
                    if (file.exists()) {
                        fos = new FileOutputStream(file, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(file);
                        oos = new ObjectOutputStream(fos);
                    }
                    for (ApplicationsRifat app : applicationList) {
                        if (app.getVisaType().equals("Tourist Visa")) {
                            oos.writeObject(app);
                        }
                    }
                    oos.close();
                    showSuccess("Success", "Applications assigned to Tourist Visa Officer successfully");
                }
                else if (selectedOfficer.equals("Transit Visa Officer") && selectedVisaType.equals("Transit Visa")){
                    File file = new File("TransitVisaOfficerApplications.bin");
                    if (file.exists()) {
                        fos = new FileOutputStream(file, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(file);
                        oos = new ObjectOutputStream(fos);
                    }
                    for (ApplicationsRifat app : applicationList) {
                        if (app.getVisaType().equals("Transit Visa")) {
                            oos.writeObject(app);
                        }
                    }
                    oos.close();
                    showSuccess("Success", "Applications assigned to Transit Visa Officer successfully");
                }
                else{
                    showAlert("Error", "Selected officer does not match selected visa type");
                }
            }
            else{
                showAlert("Error", "Please select an officer");
            }

        } catch (Exception e) {
            //
        }
    }

    @FXML
    public void backToDashboardOnActionButton(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/OperationManager_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Operation Manager Dashboard");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            //
        }
    }





    @FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        tblNewUnassigned.getItems().clear();
    }


    public static void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
    public static void showSuccess(String title, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }


}