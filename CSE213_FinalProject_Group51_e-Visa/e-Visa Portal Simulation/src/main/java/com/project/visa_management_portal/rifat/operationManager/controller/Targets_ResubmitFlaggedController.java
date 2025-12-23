package com.project.visa_management_portal.rifat.operationManager.controller;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.rifat.operationManager.modelClass.ApplicationsRifat;
import com.sun.net.httpserver.Authenticator;
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
import static com.project.visa_management_portal.rifat.operationManager.controller.NewUnassignedApplicationsController.showSuccess;

public class Targets_ResubmitFlaggedController
{
    @javafx.fxml.FXML
    private TableView<ApplicationsRifat> tblFlagged;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colAssignedOfficer;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colAppID;
    @javafx.fxml.FXML
    private TextArea txtManagerNote;
    @javafx.fxml.FXML
    private TextField txtTargetValue;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private TableColumn<String, String> colFlagReason;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;
    @javafx.fxml.FXML
    private Button btnSearchAdd;
    @javafx.fxml.FXML
    private Button btnConfirmResubmitOfficers;
    @javafx.fxml.FXML
    private Button btnLoadTableFlagged;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colAssignedOfficer1;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colAppID1;
    @javafx.fxml.FXML
    private TextField reSubApplicant_ID;
    @javafx.fxml.FXML
    private Button btnRefresh;
    @javafx.fxml.FXML
    private TableView<ApplicationsRifat> tb_ResubmissionList;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colResubmittedAt;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colFlagReasonSearched;

    ArrayList<ApplicationsRifat> flaggedApplications;
    ArrayList <ApplicationsRifat> confirmation_Resubmit_flaggedList;
    @javafx.fxml.FXML
    public void initialize() {
        flaggedApplications = new ArrayList<ApplicationsRifat>();


        confirmation_Resubmit_flaggedList = new ArrayList<>();

        colAppID.setCellValueFactory(new PropertyValueFactory<>("appId"));
        colAssignedOfficer.setCellValueFactory(new PropertyValueFactory<>("assignedOfficer"));
        colFlagReason.setCellValueFactory(new PropertyValueFactory<>("flagReason")); // Use the actual property name from your model

        colAppID1.setCellValueFactory(new PropertyValueFactory<>("appId"));
        colAssignedOfficer1.setCellValueFactory(new PropertyValueFactory<>("assignedOfficer"));
        colFlagReasonSearched.setCellValueFactory(new PropertyValueFactory<>("flagReason"));
        colResubmittedAt.setCellValueFactory(new PropertyValueFactory<>("resubmissionFlaggedDate"));

        ApplicationsRifat aF1 = new ApplicationsRifat("2367","Tourist Visa Officer","Security Concerns", null, LocalDate.of(2024, 6, 20), null);
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
            File file = new File("ResubmittedApplications.bin"); // create a file object representing the file "UnassignedApplications.bin"
            if(file.exists()){
                fos = new FileOutputStream(file , true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            for (ApplicationsRifat app: flaggedApplications){
                oos.writeObject(app);  // write each application object to the file
            }
            oos.close();
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
    public void confirmResubmitOfficersOnActionBtn(ActionEvent actionEvent) {
        String managerNote = txtManagerNote.getText().trim();
        String targetValueStr = txtTargetValue.getText().trim();

        // Validate inputs
        if (managerNote.isEmpty() || targetValueStr.isEmpty()) {
            showAlert("Input Error", "Please enter both Manager Note and Target Value.");
            return;
        }

        if (confirmation_Resubmit_flaggedList.isEmpty()) {
            showAlert("No Applications", "Please search and add applications first.");
            return;
        }
        int targetValue;
        try {
            targetValue = Integer.parseInt(targetValueStr);

            // Only update the searched applications
            for (ApplicationsRifat app : confirmation_Resubmit_flaggedList) {
                app.setManagerNote(managerNote);
                app.setTargetValue(targetValue);
                app.setResubmissionFlaggedDate(LocalDate.now());
            }

            showSuccess("Success", confirmation_Resubmit_flaggedList.size() +
                    " application(s) updated successfully.");

            // Refresh the table to show updated values
            tb_ResubmissionList.refresh();

        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid integer for the target value.");
        }
    }



    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        tblFlagged.getItems().clear();
    }

    @javafx.fxml.FXML
    public void searchAdd_OnActionButton(ActionEvent actionEvent) {
        String searchAppID = reSubApplicant_ID.getText().trim();
        boolean found = false;

        for (ApplicationsRifat app : flaggedApplications) {
            if (app.getAppId().equals(searchAppID)) {
                tb_ResubmissionList.getItems().add(app);
                confirmation_Resubmit_flaggedList.add(app);
                found = true;
                break;
            }
        }

        if (!found) {
            showAlert("Not Found", "Application ID " + searchAppID + " not found in flagged applications.");
        }
    }

    @javafx.fxml.FXML
    public void setLoadTableFlaggedOnActionButton(ActionEvent actionEvent) {
        tblFlagged.getItems().clear();
        tblFlagged.getItems().addAll(flaggedApplications);

    }
}

