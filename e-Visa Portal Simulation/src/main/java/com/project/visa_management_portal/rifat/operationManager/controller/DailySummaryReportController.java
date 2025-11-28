package com.project.visa_management_portal.rifat.operationManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class DailySummaryReportController
{
    @javafx.fxml.FXML
    private TextField txtDateTo;
    @javafx.fxml.FXML
    private TableColumn colMetric;
    @javafx.fxml.FXML
    private TextField txtDateFrom;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private Button btnGenerate;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;
    @javafx.fxml.FXML
    private TableColumn colFlaggedCount;
    @javafx.fxml.FXML
    private TableView tblSummaryReport;
    @javafx.fxml.FXML
    private TableColumn colApproveCount;
    @javafx.fxml.FXML
    private TableColumn colRejectCount;

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
    public void tbGenerateOnActionButton(ActionEvent actionEvent) {
    }
}