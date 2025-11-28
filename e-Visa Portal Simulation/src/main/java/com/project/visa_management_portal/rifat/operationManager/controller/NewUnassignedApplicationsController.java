package com.project.visa_management_portal.rifat.operationManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class NewUnassignedApplicationsController
{
    @javafx.fxml.FXML
    private TableColumn colType;
    @javafx.fxml.FXML
    private Button btnAssign;
    @javafx.fxml.FXML
    private TableColumn colAppID;
    @javafx.fxml.FXML
    private ComboBox cmbOfficer;
    @javafx.fxml.FXML
    private ComboBox cmbVisaType;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private TableColumn colSubmittedAt;
    @javafx.fxml.FXML
    private TableView tblNewUnassigned;
    @javafx.fxml.FXML
    private Button btnConfirmAssign;
    @javafx.fxml.FXML
    private TableColumn colStatus;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;
    @javafx.fxml.FXML
    private Button btnRefresh;
    @javafx.fxml.FXML
    private Button btnApplyFilterVisaType;

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

    @Deprecated
    public void refreshOnAction(ActionEvent actionEvent) {
    }


    @Deprecated
    public void applyFilterOnActionBUtton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void assignApplicationsToVIsaOfficerOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmAssignOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void applyFilterVisaTypeOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }
}