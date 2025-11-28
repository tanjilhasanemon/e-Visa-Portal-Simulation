package com.project.visa_management_portal.rifat.operationManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Decisions_ApprovedDeniedFlaggedController
{
    @javafx.fxml.FXML
    private TableColumn colDecisionDate;
    @javafx.fxml.FXML
    private TableColumn colType;
    @javafx.fxml.FXML
    private ComboBox cmbStatusFilter;
    @javafx.fxml.FXML
    private TableColumn colAppID;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private TableColumn colOfficer;
    @javafx.fxml.FXML
    private TableView tblDecisions;
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
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void initialize() {
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
    }

    @javafx.fxml.FXML
    public void filterApproveDeniedFlaggedOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openFlaggedDetails(ActionEvent actionEvent) {
    }
}