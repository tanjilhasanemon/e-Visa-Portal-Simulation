package com.project.visa_management_portal.rifat.policyManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class policyManagerDashboardController
{
    @javafx.fxml.FXML
    private Button btnApproveMajorChanges;
    @javafx.fxml.FXML
    private Button btnNotices1;
    @javafx.fxml.FXML
    private Button btnProcessingTimeSetting;
    @javafx.fxml.FXML
    private Button btnSignOut;
    @javafx.fxml.FXML
    private Button btnRequirementChecklist;
    @javafx.fxml.FXML
    private Button btnPublish_InstructionUpdates;
    @javafx.fxml.FXML
    private Button btnVisaRuleEditor;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private Button btnViewPolicyLog;




    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void processingTimeSettingOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/ProcessingTimeSettings.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Processing Time Settings");
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
    public void viewPolicyLogOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/PolicyLog.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Policy Log");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void requirementChecklistOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/RequirementChecklist.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Requirement Checklist");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void noticeOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/ProcessingTimeSettings.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Review Notice");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void approveMajorChangesOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/ApproveMajorChanges.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Review Changes");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void publish_InstructionUpdatesOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/InstructionUpdates.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Instruction Updates");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void visaRuleEditorOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/VisaRuleEditor.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Visa Rule Editor");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

}