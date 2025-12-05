package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.tanjil.VisaApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class TrackApplicationController
{

    @javafx.fxml.FXML
    private TableColumn <VisaApplication, String> statusTableColumn;
    @javafx.fxml.FXML
    private TableColumn <VisaApplication, String> actionTableColumn;
    @javafx.fxml.FXML
    private TableColumn <VisaApplication, String> applicationIdTableColumn;
    @javafx.fxml.FXML
    private TableView <VisaApplication> trackApplicationsTableView;
    @javafx.fxml.FXML
    private TextField applicantIDTextFIeld;

    ArrayList<VisaApplication> visaApplications;

    @javafx.fxml.FXML
    public void initialize() {

        visaApplications = new ArrayList<>();

        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        actionTableColumn.setCellValueFactory(new PropertyValueFactory<>("requiredAction"));
        applicationIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("applicationId"));
    }


    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {

        String applicationId = (applicantIDTextFIeld.getText());
        if (applicationId.isEmpty()) {
            showAlert( "Input required", Alert.AlertType.WARNING,"Please enter Applicant ID to load applications.");
        }

        ArrayList <VisaApplication> filteredApplications = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = new File("ApplicantVisaApplications.bin");

        try {

            if (file.exists()) {
                fis = new FileInputStream(file);
            }else {
                showAlert("File Not Found", Alert.AlertType.WARNING, "Client applications file does not exist.");
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                visaApplications.add((VisaApplication) ois.readObject());
            }

        } catch (Exception e) {
            try {
                if(ois!=null)
                    ois.close();
            }catch (Exception _) {
                showAlert("File Error", Alert.AlertType.ERROR, "Error closing the file.");
            }
        }

        for (VisaApplication application : visaApplications) {
            if (application.getApplicationId().equals(applicationId)) {
                filteredApplications.add(application);
            }
        }

        if (filteredApplications.isEmpty()) {
            showAlert("No Matches", Alert.AlertType.WARNING, "No applications found for the given client ID.");
        }

        for (VisaApplication fApplication : filteredApplications) {
            if (fApplication.getStatus().equals("Pending")) {
                fApplication.setRequiredAction("Submit required documents");
            } else if (fApplication.getStatus().equals("Approved")) {
                fApplication.setRequiredAction("Collect visa");
            } else if (fApplication.getStatus().equals("Rejected")) {
                fApplication.setRequiredAction("Review rejection reason");
            } else {
                fApplication.setRequiredAction("Contact support");
            }
        }

        trackApplicationsTableView.getItems().setAll(filteredApplications);

    }




    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Applicant Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Navigation Error", Alert.AlertType.ERROR, "Unable to load the dashboard.");
        }
    }


    private void showAlert(String title, Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
