package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.tanjil.applicant.modelClass.Feedback;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedbackController
{
    @javafx.fxml.FXML
    private TextField subjectTextField;
    @javafx.fxml.FXML
    private TextArea messageTextArea;
    @javafx.fxml.FXML
    private TextField applicantIDTextField;



    @javafx.fxml.FXML
    public void initialize() {


    }


    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Applicant Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
        String applicantId = applicantIDTextField.getText();
        String subject = subjectTextField.getText();
        String message = messageTextArea.getText();

        // Basic validation
        if (applicantId.isBlank() || subject.isBlank() || message.isBlank()) {
            //Statusss label
            return;
        }

        // Create Feedback object
        Feedback feedback = new Feedback(applicantId, subject, message);
        }



}