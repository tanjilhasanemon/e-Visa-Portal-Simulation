package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.tanjil.ApplicationStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackApplicationController
{

    @javafx.fxml.FXML
    private TableColumn <ApplicationStatus, String> statusTableColumn;
    @javafx.fxml.FXML
    private TableColumn <ApplicationStatus, String> actionTableColumn;
    @javafx.fxml.FXML
    private TableColumn <ApplicationStatus, String> applicationIdTableColumn;
    @javafx.fxml.FXML
    private TableView <ApplicationStatus> trackApplicationsTableView;
    @javafx.fxml.FXML
    private TextField applicantIDTextFIeld;
    @javafx.fxml.FXML
    private Label statusLabel;


    //private list


    @javafx.fxml.FXML
    public void initialize() {
        if (statusLabel != null) statusLabel.setText("Enter application ID.");
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        actionTableColumn.setCellValueFactory(new PropertyValueFactory<>("remark"));
        applicationIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("applicationId"));



    }


    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Applicant Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void viewDetailsOnAction(ActionEvent actionEvent) {
    }



    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {


        String applicantId = (applicantIDTextFIeld.getText());
        if (applicantId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input required", "Please enter Applicant ID to load applications.");
            return;
        }

    }

    private void showAlert(Alert.AlertType t, String title, String msg) {
        Alert a = new Alert(t);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.getDialogPane().setPrefWidth(480);
        a.showAndWait();
    }
}