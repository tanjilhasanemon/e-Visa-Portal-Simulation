package com.project.visa_management_portal.sharmin.supportagent.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class RespondTicketController
{
    @javafx.fxml.FXML
    private TextArea ReplyTextarea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void SendResponseButtonOnAction(ActionEvent actionEvent) {
        if(ReplyTextarea.getText().isEmpty()) {
            showAlert("Error", "Please enter a response message!");
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