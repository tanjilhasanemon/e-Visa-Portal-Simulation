package com.project.visa_management_portal.rifat.operationManager.controller;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.rifat.operationManager.modelClass.ApplicationsRifat;
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

import static com.project.visa_management_portal.rifat.operationManager.controller.NewUnassignedApplicationsController.showAlert;

public class Decisions_ApprovedDeniedFlaggedController
{
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colDecisionDate;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colType;
    @javafx.fxml.FXML
    private ComboBox<String> cmbStatusFilter;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colAppID;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colOfficer;
    @javafx.fxml.FXML
    private TableView<ApplicationsRifat> tblDecisions;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;
    @javafx.fxml.FXML
    private TextField txtSearch_ID;
    @javafx.fxml.FXML
    private Button btnOpenFlaggedDetail;
    @javafx.fxml.FXML
    private TextArea txtFieldFlagDetails;
    @javafx.fxml.FXML
    private Button btnApprovedDeniedFlaggedFilter1;
    @javafx.fxml.FXML
    private Button btnSearch_ID;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colStatus;
    @javafx.fxml.FXML
    private Button btnLoad;
    @javafx.fxml.FXML
    private Button brnRefresh;

    ArrayList<ApplicationsRifat> applicationStatusList;
    ArrayList<ApplicationsRifat> flaggedApplications;

    @javafx.fxml.FXML
    public void initialize() {
        cmbStatusFilter.getItems().addAll("Approved", "Rejected", "Flagged");

        applicationStatusList = new ArrayList<ApplicationsRifat>();
        flaggedApplications = new ArrayList<ApplicationsRifat>();


        ApplicationsRifat a1 = new ApplicationsRifat("2367", "Tourist Visa", LocalDate.of(2024, 6, 1),"Tourist Visa Officer", "Flagged");
        ApplicationsRifat a2 = new ApplicationsRifat("2368", "Student Visa", LocalDate.of(2024, 6, 2),"Student Visa Officer", "Approved");
        ApplicationsRifat a3 = new ApplicationsRifat("2369", "Work Visa", LocalDate.of(2024, 6, 3), "Work Visa Officer", "Rejected");
        ApplicationsRifat a4 = new ApplicationsRifat("2370", "Business Visa", LocalDate.of(2024, 6, 4), "Business Visa Officer", "Flagged");
        ApplicationsRifat a5 = new ApplicationsRifat("2371", "Transit Visa", LocalDate.of(2024, 6, 5), "Transit Visa Officer", "Rejected");
        ApplicationsRifat a6 = new ApplicationsRifat("2372", "Tourist Visa", LocalDate.of(2024, 6, 6), "Tourist Visa Officer", "Flagged");
        ApplicationsRifat a7 = new ApplicationsRifat("2373", "Student Visa", LocalDate.of(2024, 6, 7), "Student Visa Officer", "Approved");
        ApplicationsRifat a8 = new ApplicationsRifat("2374", "Work Visa", LocalDate.of(2024, 6, 8), "Work Visa Officer", "Rejected");
        ApplicationsRifat a9 = new ApplicationsRifat("2375", "Business Visa", LocalDate.of(2024, 6, 9), "Business Visa Officer", "Approved");
        ApplicationsRifat a10 = new ApplicationsRifat("2376", "Transit Visa", LocalDate.of(2024, 6, 10), "Transit Visa Officer", "Flagged");
        ApplicationsRifat a11 = new ApplicationsRifat("2377", "Tourist Visa", LocalDate.of(2024, 6, 11), "Tourist Visa Officer", "Rejected");
        ApplicationsRifat a12 = new ApplicationsRifat("2378", "Student Visa", LocalDate.of(2024, 6, 12), "Student Visa Officer", "Flagged");
        ApplicationsRifat a13 = new ApplicationsRifat("2379", "Work Visa", LocalDate.of(2024, 6, 13), "Work Visa Officer", "Rejected");
        ApplicationsRifat a14 = new ApplicationsRifat("2380", "Business Visa", LocalDate.of(2024, 6, 14), "Business Visa Officer", "Approved");
        ApplicationsRifat a15 = new ApplicationsRifat("2381", "Transit Visa", LocalDate.of(2024, 6, 15), "Transit Visa Officer", "Flagged");
        ApplicationsRifat a16 = new ApplicationsRifat("2382", "Tourist Visa", LocalDate.of(2024, 6, 16), "Tourist Visa Officer", "Approved");
        ApplicationsRifat a17 = new ApplicationsRifat("2383", "Student Visa", LocalDate.of(2024, 6, 17), "Student Visa Officer", "Rejected");
        ApplicationsRifat a18 = new ApplicationsRifat("2384", "Work Visa", LocalDate.of(2024, 6, 18), "Work Visa Officer", "Approved");
        ApplicationsRifat a19 = new ApplicationsRifat("2385", "Business Visa", LocalDate.of(2024, 6, 19),"Business Visa Officer", "Flagged");
        ApplicationsRifat a20 = new ApplicationsRifat("2386", "Transit Visa", LocalDate.of(2024, 6, 20), "Transit Visa Officer", "Rejected");
        applicationStatusList.add(a1);
        applicationStatusList.add(a2);
        applicationStatusList.add(a3);
        applicationStatusList.add(a4);
        applicationStatusList.add(a5);
        applicationStatusList.add(a6);
        applicationStatusList.add(a7);
        applicationStatusList.add(a8);
        applicationStatusList.add(a9);
        applicationStatusList.add(a10);
        applicationStatusList.add(a11);
        applicationStatusList.add(a12);
        applicationStatusList.add(a13);
        applicationStatusList.add(a14);
        applicationStatusList.add(a15);
        applicationStatusList.add(a16);
        applicationStatusList.add(a17);
        applicationStatusList.add(a18);
        applicationStatusList.add(a19);
        applicationStatusList.add(a20);

        colAppID.setCellValueFactory(new PropertyValueFactory<>("appId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("visaType"));
        colDecisionDate.setCellValueFactory(new PropertyValueFactory<>("decisionDate"));
        colOfficer.setCellValueFactory(new PropertyValueFactory<>("assignedOfficer"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ApplicationsRifat aF1 = new ApplicationsRifat("2367","Tourist Visa Officer","Security Concerns", null,LocalDate.of(2024, 6, 20), null);
        ApplicationsRifat aF4 = new ApplicationsRifat("2370", "Business Visa Officer","Incomplete Documentation", null, LocalDate.of(2024, 7,11), null);
        ApplicationsRifat aF6 = new ApplicationsRifat("2372", "Tourist Visa Officer","Fraudulent Information", null, LocalDate.of(2024, 7, 3), null);
        ApplicationsRifat aF10 = new ApplicationsRifat("2376", "Transit Visa Officer","Previous Visa Violations", null,LocalDate.of(2024, 7, 12),null);
        ApplicationsRifat aF15 = new ApplicationsRifat("2381", "Transit Visa Officer","Security Concerns", null, LocalDate.of(2024, 7, 15), null);
        ApplicationsRifat aF12 = new ApplicationsRifat("2378", "Student Visa Officer","Insufficient Funds", null, LocalDate.of(2024, 7, 7), null);
        ApplicationsRifat aF19 = new ApplicationsRifat("2385", "Business Visa Officer","Additional Interview Needed", null, LocalDate.of(2024, 7, 12), null);
        flaggedApplications.add(aF1);
        flaggedApplications.add(aF4);
        flaggedApplications.add(aF6);
        flaggedApplications.add(aF10);
        flaggedApplications.add(aF12);
        flaggedApplications.add(aF15);
        flaggedApplications.add(aF19);




        FileOutputStream fos = null;   // file output stream to write bytes to a file
        ObjectOutputStream oos = null; // object output stream to write objects to the file
        try {
            File file = new File("ApplicationsStatus.bin"); // create a file object representing the file "UnassignedApplications.bin"
            if(file.exists()){
                fos = new FileOutputStream(file , true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            for (ApplicationsRifat app: applicationStatusList){
                oos.writeObject(app);  // write each application object to the file
            }
            oos.close();
        } catch (Exception e){
            //
        }

        FileOutputStream fos2 = null;   // file output stream to write bytes to a file
        ObjectOutputStream oos2 = null; // object output stream to write objects to the file
        try {
            File file2 = new File("FlaggedApplicationListReason.bin"); // create a file object representing the file "UnassignedApplications.bin"
            if(file2.exists()){
                fos2 = new FileOutputStream(file2 , true);
                oos2 = new AppendableObjectOutputStream(fos2);
            }
            else{
                fos2 = new FileOutputStream(file2);
                oos2 = new ObjectOutputStream(fos2);
            }
            for (ApplicationsRifat app2: flaggedApplications){
                oos2.writeObject(app2);  // write each application object to the file
            }
            oos2.close();
        } catch (Exception e){
            //
        }
    }
    @javafx.fxml.FXML
    public void loadOnActionButton(ActionEvent actionEvent) {
        tblDecisions.getItems().clear();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("ApplicationsStatus.bin"); // create a file object representing the file "UnassignedApplications.bin"
            if (file.exists()) {
                fis = new FileInputStream(file); // initialize file input stream
            }
            else{
                showAlert("Error", "File does not exist");
            }
            if(fis!=null)ois = new ObjectInputStream(fis);
            while (true) {
                tblDecisions.getItems().add((ApplicationsRifat) ois.readObject()); // read objects from the file and add to the TableView

            }
        } catch (Exception e){
            //
        }
    }
    @javafx.fxml.FXML
    public void backToDashboardOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/OperationManager_Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Operation Manager Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void idSearchOnActionButton(ActionEvent actionEvent) {
        String searchId = txtSearch_ID.getText().trim();

        tblDecisions.getItems().clear();
        for(ApplicationsRifat app: applicationStatusList){
            if(app.getAppId().equals(searchId)){
                tblDecisions.getItems().add(app);
            }
        }
        if (tblDecisions.getItems().isEmpty()) {
            showAlert("Error", "Application ID not found");
        }
    }

    @javafx.fxml.FXML
    public void filterApproveDeniedFlaggedOnActionButton(ActionEvent actionEvent) {
        String selectedStatus = cmbStatusFilter.getValue();
        if (selectedStatus == null) {
            showAlert("Error", "Please select status to filter");
            return;
        }

        tblDecisions.getItems().clear();
        ArrayList<ApplicationsRifat> filteredList = new ArrayList<ApplicationsRifat>();

        FileInputStream fis = null;    // step 1: file input stream
        ObjectInputStream ois = null;  // step 2: object input stream
        try {
            File file = new File("ApplicationsStatus.bin");
            if (file.exists()) {
                fis = new FileInputStream(file);  // step 4: initialize file input stream
                ois = new ObjectInputStream(fis);  // step 5: initialize object input stream
                while (true) {                     // step 6: read objects from the file
                    ApplicationsRifat app = (ApplicationsRifat) ois.readObject();
                    if (app.getStatus().equals(selectedStatus)) {
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
        tblDecisions.getItems().addAll(filteredList);
    }


    @javafx.fxml.FXML
    public void openFlaggedDetails(ActionEvent actionEvent) {
        String searchId = txtSearch_ID.getText().trim();

        for(ApplicationsRifat a : flaggedApplications) {
            if (a.getAppId().equals(searchId)){
                String flagDetails = a.getFlagReason();
                txtFieldFlagDetails.setText(flagDetails);
            }
        }
    }



    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        tblDecisions.getItems().clear();
    }
}