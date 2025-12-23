package com.project.visa_management_portal.sharmin.financeclerk.controller;

import com.project.visa_management_portal.sharmin.financeclerk.modelclass.FinanceDashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceDashboardcontroller
{

    @javafx.fxml.FXML
    public void initialize() {

    }
    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void issuerefundButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/financeclerk/IssueRefund.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("issue Refund");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open issue Refund Dashboard.");
        }
    }

    @Deprecated
    public void reportsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/financeclerk/ReportIssue.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("report");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open report Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void verifypaymentButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/financeclerk/VerifyPayment.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("verify payment");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open verifypayment Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void exportdataButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/financeclerk/ExportData.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("exportdata");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open exportdata Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void signoutButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Scene error", "Unable to open Main Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void viewreportsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/financeclerk/ReportIssue.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("viewreports");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open viewreports Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void PendingpaymentsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/financeclerk/PendingPayments.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Pendingpayments");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Pendingpayments Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void transactionhistoryButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/financeclerk/TransactionHistory.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("transactionhistory");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open transactionhistory Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void generateReportButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/financeclerk/GenerateReport.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("generateReport");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open generateReport Dashboard.");
        }
    }
}