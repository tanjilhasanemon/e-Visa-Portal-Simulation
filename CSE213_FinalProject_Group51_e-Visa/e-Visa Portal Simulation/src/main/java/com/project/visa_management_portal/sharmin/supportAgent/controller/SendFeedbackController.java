package com.project.visa_management_portal.sharmin.supportagent.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendFeedbackController
{
    @javafx.fxml.FXML
    private TextArea messageTextarea;
    @javafx.fxml.FXML
    private ComboBox<String> feedbackTypeComboBox;
    @javafx.fxml.FXML
    private TextField usernameTextfield;

    @javafx.fxml.FXML
    public void initialize() {
        feedbackTypeComboBox.getItems().addAll("Complaint","Suggestion","Appreciation");
    }

    @javafx.fxml.FXML
    public void sendButtonOnAction(ActionEvent actionEvent) {
        if (usernameTextfield.getText().isEmpty()) {
            showAlert("Error", "Please enter your name!");
            return;
        }
        if (feedbackTypeComboBox.getValue() == null) {
            showAlert("Error", "Please select feedback type!");
            return;
        }
        showAlert("Success", "Feedback sent successfully!");
    }
    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

}

