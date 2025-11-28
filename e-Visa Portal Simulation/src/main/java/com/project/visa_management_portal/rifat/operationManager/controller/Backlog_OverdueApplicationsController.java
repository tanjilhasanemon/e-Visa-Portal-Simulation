package com.project.visa_management_portal.rifat.operationManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class Backlog_OverdueApplicationsController
{
    @javafx.fxml.FXML
    private TableView tblBacklog;
    @javafx.fxml.FXML
    private ComboBox cmbPresets;
    @javafx.fxml.FXML
    private Button btnLoad;
    @javafx.fxml.FXML
    private Button btnExport;
    @javafx.fxml.FXML
    private TableColumn colAppID;
    @javafx.fxml.FXML
    private TableColumn colSubmittedAt;
    @javafx.fxml.FXML
    private TableColumn colDaysWaiting;
    @javafx.fxml.FXML
    private TableColumn colPriority;
    @javafx.fxml.FXML
    private Button btnNotify;
    @javafx.fxml.FXML
    private TableColumn colAssignedOfficer;
    @javafx.fxml.FXML
    private TextField txtThresholdDays;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private Button btnEscalate;
    @javafx.fxml.FXML
    private Button btnReassign;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;

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
}