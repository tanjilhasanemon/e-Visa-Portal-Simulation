package com.project.visa_management_portal.rifat.policyManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PolicyLogController
{
    @javafx.fxml.FXML
    private TableView tblPolicyLog;
    @javafx.fxml.FXML
    private TableColumn colChangeSummary;
    @javafx.fxml.FXML
    private TableColumn colTimestamp;
    @javafx.fxml.FXML
    private TableColumn colUser;
    @javafx.fxml.FXML
    private TextField txtFilter;
    @javafx.fxml.FXML
    private Button btnApplyFilter;
    @javafx.fxml.FXML
    private ComboBox cmbChangeType;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private Button btnBackToDashBoard;
    @javafx.fxml.FXML
    private Button btn_Refresh;

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

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }
}