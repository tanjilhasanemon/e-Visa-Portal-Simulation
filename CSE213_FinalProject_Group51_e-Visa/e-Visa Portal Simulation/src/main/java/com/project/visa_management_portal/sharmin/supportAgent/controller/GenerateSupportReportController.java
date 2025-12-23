package com.project.visa_management_portal.sharmin.supportagent.controller;

import com.project.visa_management_portal.sharmin.supportagent.modelclass.GenerateSupportReport;
import com.project.visa_management_portal.sharmin.supportagent.modelclass.SearchTickets;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateSupportReportController {
    @javafx.fxml.FXML
    private DatePicker EndDateDatepicker;
    @javafx.fxml.FXML
    private DatePicker StartDateDatepicker;
    @javafx.fxml.FXML
    private TableView<GenerateSupportReport> ReportSummaryTableview;
    @javafx.fxml.FXML
    private TableColumn<GenerateSupportReport, String> userNameColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateSupportReport, Integer> ticketIdColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateSupportReport, String> statusColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateSupportReport, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateSupportReport, String> issueTypeColumn;
    @javafx.fxml.FXML
    private ComboBox<String> ReportTypeCombobox;
    ArrayList GenerateSupportReportlist = new ArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        ReportTypeCombobox.getItems().addAll("Daily Report", "Weekly Report", "Monthly Report", "Status-wise Report");
        ticketIdColumn.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        issueTypeColumn.setCellValueFactory(new PropertyValueFactory<>("issueType"));

        GenerateSupportReport GSR = new GenerateSupportReport();
        GenerateSupportReportlist.add(GSR);
        ReportSummaryTableview.getItems().addAll(GenerateSupportReportlist);

    }

    @javafx.fxml.FXML
    public void GenerateButtonOnAction(ActionEvent actionEvent) {
        if (StartDateDatepicker.getValue() == null) {
            showAlert("Error", "Please select a Start Date!");
            return;
        }
        if (EndDateDatepicker.getValue() == null) {
            showAlert("Error", "Please select an End Date!");
            return;
        }
        if (ReportTypeCombobox.getValue() == null) {
            showAlert("Error", "Please select a Report Type!");
            return;
        }
        if (StartDateDatepicker.getValue().isAfter(EndDateDatepicker.getValue())) {
            showAlert("Error", "Start Date cannot be after End Date!");
            return;
        }


    }

    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}