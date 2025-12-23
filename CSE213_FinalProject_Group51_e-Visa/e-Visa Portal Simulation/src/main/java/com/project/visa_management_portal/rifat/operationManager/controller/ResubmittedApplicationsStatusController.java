package com.project.visa_management_portal.rifat.operationManager.controller;

import com.project.visa_management_portal.rifat.operationManager.modelClass.ApplicationsRifat;
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

import static com.project.visa_management_portal.rifat.operationManager.controller.NewUnassignedApplicationsController.showAlert;

public class ResubmittedApplicationsStatusController
{
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colCurrentStatus;
    @javafx.fxml.FXML
    private TableView<ApplicationsRifat> tblResubmitted;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colResubmittedAt;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colAppID;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> col_PendingDays;
    @javafx.fxml.FXML
    private TableColumn<ApplicationsRifat, String> colVisaType;

    @javafx.fxml.FXML
    public void initialize() {
        tblResubmitted.getItems().clear();
        colAppID.setCellValueFactory(new PropertyValueFactory<>("appId"));
        colVisaType.setCellValueFactory(new PropertyValueFactory<>("visaType"));
        colResubmittedAt.setCellValueFactory(new PropertyValueFactory<>("resubmittedAt"));
        col_PendingDays.setCellValueFactory(new PropertyValueFactory<>("pendingResubmittedDays"));
        colCurrentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("ResubmittedApplications.bin");
            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showAlert("File Not Found", "Resubmitted applications file does not exist.");
            }
            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                ApplicationsRifat app = (ApplicationsRifat) ois.readObject();
                tblResubmitted.getItems().add(app);
            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception ignored) {
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
}