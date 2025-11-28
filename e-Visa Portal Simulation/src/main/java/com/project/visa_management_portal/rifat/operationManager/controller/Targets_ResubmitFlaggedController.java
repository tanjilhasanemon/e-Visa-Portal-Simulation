package com.project.visa_management_portal.rifat.operationManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Targets_ResubmitFlaggedController
{
    @javafx.fxml.FXML
    private TableView tblFlagged;
    @javafx.fxml.FXML
    private TableColumn colAssignedOfficer;
    @javafx.fxml.FXML
    private TableColumn colAppID;
    @javafx.fxml.FXML
    private TextArea txtManagerNote;
    @javafx.fxml.FXML
    private TextField txtTargetValue;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private TableColumn colFlagReason;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;
    @javafx.fxml.FXML
    private Button btnSearchAdd;
    @javafx.fxml.FXML
    private Button btnConfirmResubmitOfficers;
    @javafx.fxml.FXML
    private Button btnLoadTableFlagged;
    @javafx.fxml.FXML
    private TableColumn colAssignedOfficer1;
    @javafx.fxml.FXML
    private TableColumn colAppID1;
    @javafx.fxml.FXML
    private TableColumn colFlagReason1;
    @javafx.fxml.FXML
    private TextField reSubApplicant_ID;
    @javafx.fxml.FXML
    private Button btnRefreash;
    @javafx.fxml.FXML
    private TableView tb_ResubmissionList;
    @javafx.fxml.FXML
    private Button btnSetTimeLimit;

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
    public void confirmResubmitOfficersOnActionBtn(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void setTimeLimitOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchAdd_OnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void setLoadTableFlaggedOnActionButton(ActionEvent actionEvent) {
    }
}