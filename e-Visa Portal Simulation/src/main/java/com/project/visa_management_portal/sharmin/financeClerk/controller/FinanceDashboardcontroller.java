package com.project.visa_management_portal.sharmin.financeclerk.controller;

import com.project.visa_management_portal.sharmin.financeclerk.modelclass.FinanceDashboard;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class FinanceDashboardcontroller
{
    @javafx.fxml.FXML
    private Label pendingVerificationsLabel;
    @javafx.fxml.FXML
    private Label refundsProcessedLabel;
    @javafx.fxml.FXML
    private Label totalPaymentsLabel;

    @javafx.fxml.FXML
    public void initialize() {
        FinanceDashboard model  = new FinanceDashboard();

    }

    @javafx.fxml.FXML
    public void issuerefundButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void verifypaymentButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportdataButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signoutButtonOnAction(ActionEvent actionEvent) {
    }
}