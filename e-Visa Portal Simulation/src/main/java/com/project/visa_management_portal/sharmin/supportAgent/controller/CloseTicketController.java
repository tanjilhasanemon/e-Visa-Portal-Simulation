package com.project.visa_management_portal.sharmin.supportagent.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CloseTicketController
{
    @javafx.fxml.FXML
    private TextField ticketIdTextField;
    @javafx.fxml.FXML
    private TextArea closeTicketTextarea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CloseButtonOnAction(ActionEvent actionEvent) {
        if (ticketIdTextField.getText().isEmpty()) {
            showAlert("Error", "Please enter Ticket ID!");
            return;
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