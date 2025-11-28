package com.project.visa_management_portal.rifat.policyManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RequirementChecklistController
{
    @javafx.fxml.FXML
    private TableColumn colDocumentName;
    @javafx.fxml.FXML
    private Button btnSave;
    @javafx.fxml.FXML
    private TableColumn colRequiredFlag;
    @javafx.fxml.FXML
    private ComboBox cmbVisaType;
    @javafx.fxml.FXML
    private Label lblTitle;
    @javafx.fxml.FXML
    private TableView tblChecklist;
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

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
    }
}