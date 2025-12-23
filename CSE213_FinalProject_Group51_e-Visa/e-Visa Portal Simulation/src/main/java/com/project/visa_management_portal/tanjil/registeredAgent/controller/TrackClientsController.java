package com.project.visa_management_portal.tanjil.registeredAgent.controller;
import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class TrackClientsController {
    @javafx.fxml.FXML
    private TableColumn <VisaApplication, String> statusTableColumn;
    @javafx.fxml.FXML
    private TableView <VisaApplication> clientApplicantionsTableView;
    @javafx.fxml.FXML
    private TableColumn <VisaApplication, String> actionTableColumn;
    @javafx.fxml.FXML
    private TableColumn <VisaApplication, String> applicationIdTableColumn;
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

        if (searchClientId.isEmpty()) {
            showAlert("Input Required", AlertType.WARNING, "Please enter a client ID to search.");
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
            }else {
                showAlert("File Not Found", AlertType.WARNING, "Client applications file does not exist.");
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                clientsApplicationsList.add((VisaApplication) ois.readObject());
            }

        } catch (Exception e) {
            try {
                if(ois!=null)
                    ois.close();
            }catch (IOException _) {
                showAlert("File Error", AlertType.ERROR, "Error closing the file.");
            }
        }



        for (VisaApplication application : clientsApplicationsList) {
            if (searchClientId.equals(application.getClientId())) {
                filteredClientApplication.add(application);

            }
        }
        if (filteredClientApplication.isEmpty()) {
            showAlert("No Matches", AlertType.WARNING, "No applications found for the given client ID.");
            return;
        }



        for (VisaApplication fApplication : filteredClientApplication) {
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

        clientApplicantionsTableView.getItems().setAll(filteredClientApplication);
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
            showAlert("Navigation Error", AlertType.ERROR, "Unable to return to dashboard.");
        }
    }

    private void showAlert(String title, AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
