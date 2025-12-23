package com.project.visa_management_portal.rifat.operationManager.controller;


import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.rifat.operationManager.modelClass.ApplicationsRifat;
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


public class Backlog_OverdueApplicationsController
{
    @javafx.fxml.FXML
    private TableView<ApplicationsRifat> tblBacklog;
    @javafx.fxml.FXML
    private ComboBox<String> cmbPresets;
    @javafx.fxml.FXML
    private Button btnLoad;
    @javafx.fxml.FXML
    private Button btnExport;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colAppID;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colSubmittedAt;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colDaysWaiting;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colAssignedOfficer;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;
    @javafx.fxml.FXML
    private Button btnRefresh;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colStatus;

    ArrayList<ApplicationsRifat> overdueApplicationsList;
    @FXML
    private Button btn;

    @javafx.fxml.FXML
    public void initialize() {
        cmbPresets.getItems().addAll("17 Days", "23 Days", "28 Days", "35 Days", "40 Days");
        overdueApplicationsList = new ArrayList<ApplicationsRifat>();

        colAppID.setCellValueFactory(new PropertyValueFactory<>("appId"));
        colSubmittedAt.setCellValueFactory(new PropertyValueFactory<>("submittedAt"));
        colDaysWaiting.setCellValueFactory(new PropertyValueFactory<>("days_pending"));
        colAssignedOfficer.setCellValueFactory(new PropertyValueFactory<>("assignedOfficer"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ApplicationsRifat a1 = new ApplicationsRifat("2367", LocalDate.of(2024, 6, 1), "19", "Tourist Visa Officer", "Pending");
        ApplicationsRifat a4 = new ApplicationsRifat("2370", LocalDate.of(2024, 6, 4), "37", "Business Visa Officer", "Pending");
        ApplicationsRifat a6 = new ApplicationsRifat("2372", LocalDate.of(2024, 6, 6), "27", "Tourist Visa Officer", "Pending");
        ApplicationsRifat a10 = new ApplicationsRifat("2376", LocalDate.of(2024, 6, 10), "32","Transit Visa Officer", "Pending");
        ApplicationsRifat a15 = new ApplicationsRifat("2381", LocalDate.of(2024, 6, 15), "24", "Transit Visa Officer", "Pending");
        ApplicationsRifat a12 = new ApplicationsRifat("2378", LocalDate.of(2024, 6, 12), "25","Student Visa Officer", "Pending");
        ApplicationsRifat a19 = new ApplicationsRifat("2385", LocalDate.of(2024, 6, 19),"23" ,"Business Visa Officer", "Pending");

        overdueApplicationsList.add(a1);
        overdueApplicationsList.add(a4);
        overdueApplicationsList.add(a6);
        overdueApplicationsList.add(a10);
        overdueApplicationsList.add(a15);
        overdueApplicationsList.add(a12);
        overdueApplicationsList.add(a19);

        FileOutputStream fos = null;   // file output stream to write bytes to a file
        ObjectOutputStream oos = null; // object output stream to write objects to the file
        try {
            File file = new File("OverdueApplications.bin"); // create a file object representing the file "UnassignedApplications.bin"
            if(file.exists()){
                fos = new FileOutputStream(file , true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            for (ApplicationsRifat app: overdueApplicationsList){
                oos.writeObject(app);  // write each application object to the file
            }
            oos.close();
        } catch (Exception e){
            //
        }
    }
    @FXML
    public void loadOverdueApplicationsOnActionButton(ActionEvent actionEvent) { // load applications from binary file
        tblBacklog.getItems().clear();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("OverdueApplications.bin"); // create a file object representing the file "UnassignedApplications.bin"
            if (file.exists()) {
                fis = new FileInputStream(file); // initialize file input stream
            }
            else{
                NewUnassignedApplicationsController.showAlert("Error", "File does not exist");
            }
            if(fis!=null)ois = new ObjectInputStream(fis);
            while (true) {
                tblBacklog.getItems().add((ApplicationsRifat) ois.readObject()); // read objects from the file and add to the TableView
            }
        } catch (Exception e){
            //
        }
    }
    @FXML
    public void filter_Waiting_ThresholdOnActionBtn(ActionEvent actionEvent) {
        String selectedThreshold = cmbPresets.getValue();
        if (selectedThreshold == null) {
            NewUnassignedApplicationsController.showAlert("No Selection", "Please select a waiting time threshold.");
            return;
        }

        tblBacklog.getItems().clear();
        for (ApplicationsRifat app : overdueApplicationsList) {
            int daysWaiting = Integer.parseInt(app.getDays_pending());
            int threshold = Integer.parseInt(selectedThreshold.split(" ")[0]);

            if (daysWaiting >= threshold) {
                tblBacklog.getItems().add(app);
            }
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
    public void exportOverdueListOnActionBtn(ActionEvent actionEvent) {
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Export Overdue Applications");
        fileChooser.setInitialFileName("OverdueApplications_Export.bin");
        fileChooser.getExtensionFilters().add(new javafx.stage.FileChooser.ExtensionFilter("Binary Files", "*.bin"));

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        File destinationFile = fileChooser.showSaveDialog(stage);

        if (destinationFile != null) {
            try (FileInputStream fis = new FileInputStream("OverdueApplications.bin");
                 FileOutputStream fos = new FileOutputStream(destinationFile)) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }

                NewUnassignedApplicationsController.showAlert("Success", "File exported successfully!");
            } catch (IOException e) {
                NewUnassignedApplicationsController.showAlert("Error", "Failed to export file: " + e.getMessage());
            }
        }
    }



    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        tblBacklog.getItems().clear();
    }


}