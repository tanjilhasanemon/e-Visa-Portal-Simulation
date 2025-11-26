package com.project.visa_management_portal.rifat.operationManager.controller;

import javafx.scene.control.*;

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
    public void initialize() {
    }}