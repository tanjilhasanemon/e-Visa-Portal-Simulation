package com.project.visa_management_portal.rifat.policyManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class VisaRuleEditorController
{
    @javafx.fxml.FXML
    private TableColumn colName;
    @javafx.fxml.FXML
    private Button btnNewRule;
    @javafx.fxml.FXML
    private TableView tblRules;
    @javafx.fxml.FXML
    private TextArea txtRuleBody;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private TableColumn colRuleID;
    @javafx.fxml.FXML
    private Label lblRuleName;
    @javafx.fxml.FXML
    private TextField txtRuleName;
    @javafx.fxml.FXML
    private Button btnSaveRule;
    @javafx.fxml.FXML
    private TableColumn colStatus;
    @javafx.fxml.FXML
    private Label lblRuleBody;
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