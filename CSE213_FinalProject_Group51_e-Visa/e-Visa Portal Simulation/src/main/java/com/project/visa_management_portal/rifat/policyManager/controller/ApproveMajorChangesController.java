package com.project.visa_management_portal.rifat.policyManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ApproveMajorChangesController
{
    @javafx.fxml.FXML
    private TableColumn colSubmittedBy;
    @javafx.fxml.FXML
    private Button btnSaveDecision;
    @javafx.fxml.FXML
    private TableView tblRequests;
    @javafx.fxml.FXML
    private TableColumn colSummary;
    @javafx.fxml.FXML
    private TextArea txtDecisionComment;
    @javafx.fxml.FXML
    private RadioButton rbReject;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private TableColumn colRequestID;
    @javafx.fxml.FXML
    private RadioButton rbApprove;
    @javafx.fxml.FXML
    private Button btnOpenDetail;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/rifat/policyManager/policyManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Policy Manager Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}