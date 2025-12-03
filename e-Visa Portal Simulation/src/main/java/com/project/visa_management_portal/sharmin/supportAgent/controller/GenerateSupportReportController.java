package com.project.visa_management_portal.sharmin.supportagent.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

public class GenerateSupportReportController
{
    @javafx.fxml.FXML
    private DatePicker EndDateDatepicker;
    @javafx.fxml.FXML
    private ComboBox ReportTypeTextfield;
    @javafx.fxml.FXML
    private DatePicker StartDateDatepicker;
    @javafx.fxml.FXML
    private TableView ReportSummaryTableview;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void GenerateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void DownloadButtonOnAction(ActionEvent actionEvent) {
    }
}