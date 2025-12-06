package com.project.visa_management_portal.sharmin.financeclerk.controller;

import com.project.visa_management_portal.sharmin.financeclerk.modelclass.GenerateReport;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateReportController
{
    @javafx.fxml.FXML
    private TableView<GenerateReport> ReportsummaryTbleview;
    @javafx.fxml.FXML
    private DatePicker StartDateDatepicker;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport,Integer> transactionIdColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport,String> applicantNameColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport,String> statusColumn;
    @javafx.fxml.FXML
    private DatePicker endDateDatepicker;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport,Integer> amountColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport, LocalDate> paymentDateColumn;
    @javafx.fxml.FXML
    private TableColumn<GenerateReport,String> paymentMethodColumn;
    @javafx.fxml.FXML
    private ComboBox<String> reporttypeCombobox;
    ArrayList<GenerateReport> generateReportslist=new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        StartDateDatepicker.setValue(LocalDate.now());
        endDateDatepicker.setValue(LocalDate.now());
        reporttypeCombobox.getItems().addAll("Daily","Monthly","Payment Summary","Refund Summary");
        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        applicantNameColumn.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));


        //generateReportslist.add(new GenerateReport(101, "John Doe", 5000, "Completed", LocalDate.of(2025,12,1), "Card"));
        //generateReportslist.add(new GenerateReport(102, "Jane Smith", 7500, "Pending", LocalDate.of(2025,12,1), "Cash"));

        ReportsummaryTbleview.getItems().addAll(generateReportslist);
    }

    @javafx.fxml.FXML
    public void generateButtonOnAction(ActionEvent actionEvent) {
        ReportsummaryTbleview.getItems().clear();

        String selectedReportType = reporttypeCombobox.getValue();
        LocalDate startDate = StartDateDatepicker.getValue();
        LocalDate endDate = endDateDatepicker.getValue();


        if (selectedReportType == null) {
            showAlert("Error", "Please select a report type.");
            return;
        }


        if (startDate == null || endDate == null) {
            showAlert("Error", "Please select both start and end dates.");
            return;
        }


        for (GenerateReport report : generateReportslist) {
            LocalDate paymentDate = report.getPaymentDate();

            boolean inRange =
                    (paymentDate.isEqual(startDate) || paymentDate.isAfter(startDate)) &&
                            (paymentDate.isEqual(endDate)   || paymentDate.isBefore(endDate));

            if (inRange) {
                ReportsummaryTbleview.getItems().add(report);
            }
        }


        if (ReportsummaryTbleview.getItems().isEmpty()) {
            showAlert("Info", "No reports found for the selected date range.");
        }
        GenerateReport reportToAdd = new GenerateReport(
        );

        ReportsummaryTbleview.getItems().add(reportToAdd);
        generateReportslist.add(reportToAdd);

    }
    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}