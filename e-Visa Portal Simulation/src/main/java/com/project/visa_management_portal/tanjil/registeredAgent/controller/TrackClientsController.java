package com.project.visa_management_portal.tanjil.registeredAgent.controller;
import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
public class TrackClientsController {
    @javafx.fxml.FXML
    private TableColumn<VisaApplication, String> statusTableColumn;
    @javafx.fxml.FXML
    private TableView<VisaApplication> clientApplicantionsTableView;
    @javafx.fxml.FXML
    private TableColumn<VisaApplication, String> actionTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VisaApplication, String> applicationIdTableColumn;
    @javafx.fxml.FXML
    private TextField clientIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
        applicationIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        actionTableColumn.setCellValueFactory(new PropertyValueFactory<>("requiredAction"));
    }

    @javafx.fxml.FXML
    public void applyFilterOnAction(ActionEvent actionEvent) {
        String searchClientId = clientIdTextField.getText();

        // Simple Validate input
        if (searchClientId.isEmpty()) {
            showAlert("Input Required", "Please enter a client ID to search.");
            return;
        }

        ArrayList<VisaApplication> clientsApplicationsList = new ArrayList<>();
        ArrayList<VisaApplication> filteredClientApplication = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = new File("ClientApplications.bin");
        try {
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                while (true) {
                    try {
                        VisaApplication clientApplications = (VisaApplication) ois.readObject();
                        clientsApplicationsList.add(clientApplications);
                    } catch (java.io.EOFException e) {
                        break;
                    }
                }
                ois.close();

                for (VisaApplication application : clientsApplicationsList) {
                    if (searchClientId == application.getClientId()) {
                        filteredClientApplication.add(application);
                    }
                    else {
                        showAlert("No Match", "No applications found for the given client ID.");
                    }
                }
                for(VisaApplication application: filteredClientApplication){
                    if (application.getStatus() == "Pending") {
                        application.setRequiredAction("Submit required documents");
                    } else if (application.getStatus() == "Under Review") {
                        application.setRequiredAction("Wait for verification");
                    } else if (application.getStatus() == "Documents Requested") {
                        application.setRequiredAction("Upload additional documents");
                    } else if (application.getStatus() == "Approved") {
                        application.setRequiredAction("Collect visa");
                    } else if (application.getStatus() == "Rejected") {
                        application.setRequiredAction("Review rejection reason");
                    } else if (application.getStatus() == "Interview Scheduled") {
                        application.setRequiredAction("Attend interview");
                    } else if (application.getStatus() == "In Progress") {
                        application.setRequiredAction("No action required");
                    } else if (application.getStatus() == "Visa Issued") {
                        application.setRequiredAction("Download visa");
                    } else {
                        application.setRequiredAction("Contact support");
                    }
                }
                clientApplicantionsTableView.getItems().setAll(filteredClientApplication);


            } else {
                showAlert("File Error", "Clients.bin file not found.");
            }
        } catch (IOException | ClassNotFoundException e) {
            showAlert("Error", "An error occurred while reading clients: " );

        }
    }

    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Registered Agent Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Navigation Error", "Unable to return to dashboard.");
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
