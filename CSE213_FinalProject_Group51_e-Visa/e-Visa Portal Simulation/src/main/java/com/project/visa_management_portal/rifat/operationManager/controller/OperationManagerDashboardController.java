package com.project.visa_management_portal.rifat.operationManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class OperationManagerDashboardController {

    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private Button btnSignOut;
    @javafx.fxml.FXML
    private Button btnNewUnassigned;
    @javafx.fxml.FXML
    private Button btnReports;
    @javafx.fxml.FXML
    private Button btnNotices;
    @javafx.fxml.FXML
    private Button btnSetTargets;
    @javafx.fxml.FXML
    private Button btnOverDueApplication;
    @javafx.fxml.FXML
    private Button btnFlaggedApplications;
    @javafx.fxml.FXML
    private Button btnResubmittedApplicationStatus;


    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }




    @javafx.fxml.FXML
    public void newUnassignedOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/NewUnassignedApplications.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Unassigned Applications");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }


    @javafx.fxml.FXML
    public void noticeOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/PublishNotices.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Notice");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/DailySummaryReport.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Report");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }


    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) {
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
    public void overdueApplicationsOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/Backlog_OverdueApplications.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Overdue Applications");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void flaggedApplicationOnActionButton(ActionEvent actionEvent) throws IOException {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/Decisions_ApprovedDeniedFlagged.fxml"));
//            Scene scene = new Scene(loader.load());
//            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            stage.setTitle("Applications Status");
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
//        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/Decisions_ApprovedDeniedFlagged.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Decisions - Approved/Denied/Flagged");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SetTargetOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/Targets_ResubmitFlagged.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Assigning Targets");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to Switch.");
        }
    }

    @javafx.fxml.FXML
    public void resubmittedApplicationStatusOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/operationManager/ResubmittedApplicationsStatus.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Resubmitted Applications to Visa Officers");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }
}
