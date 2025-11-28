package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AgentSupportController
{
    @javafx.fxml.FXML
    private Label lblSupportMsg;
    @javafx.fxml.FXML
    private TextField clientIdTextField;
    @javafx.fxml.FXML
    private TextField subjectTextField;
    @javafx.fxml.FXML
    private TextArea messageTextArea;



    @javafx.fxml.FXML
    public void initialize() {
        if (lblSupportMsg != null) lblSupportMsg.setText("Enter client ID, subject and message.");
    }


    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Registered Agent Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
        String clientId = (clientIdTextField.getText());
        String subject = (subjectTextField.getText());
        String message = (messageTextArea.getText());

        // Basic validation
        if (clientId.isEmpty() || subject.isEmpty() || message.isEmpty()) {
            // show label "Validation error", "All fields are required (Client ID, Subject, Message)
            return;
        }
    }


}