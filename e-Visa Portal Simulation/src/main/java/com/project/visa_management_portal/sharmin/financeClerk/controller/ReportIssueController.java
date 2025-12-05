package com.project.visa_management_portal.sharmin.financeclerk.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReportIssueController
{
    @javafx.fxml.FXML
    private TextArea MessageTextarea;
    @javafx.fxml.FXML
    private ComboBox<String> issueTypeComboBox;
    @javafx.fxml.FXML
    private TextField ticketSubjectTextfield;

    @javafx.fxml.FXML
    public void initialize() {
        issueTypeComboBox.getItems().addAll("Technical", "Billing", "General");
    }

    @javafx.fxml.FXML
    public void submitButtonOnAction(ActionEvent actionEvent) {
        if(ticketSubjectTextfield.getText().isEmpty()){
            showAlert("Validation Error", "Please fill all fields!");
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