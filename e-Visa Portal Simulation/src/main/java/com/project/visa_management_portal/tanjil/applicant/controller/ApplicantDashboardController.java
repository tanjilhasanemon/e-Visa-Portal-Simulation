package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class ApplicantDashboardController
{
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void onHelpFeedback(ActionEvent actionEvent) throws IOException {
        SceneSwitch.switchTo("/com/project/visa_management_portal/tanjil/applicant/Applicant_Feedback.fxml",actionEvent);
    }

    @Deprecated
    public void onUploadDocuments(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onDownloads(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onViewVisaInfo(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onTrackApplication(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onApplyForVisa(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onTravelHistory(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onSignOut(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onPayFee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void uploadDocumentsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void helpAndFeedbackOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void downloadsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void payFeeOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void travelHistoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewVisaInfoOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void trackApplicationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void applyForVIsaOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutOnAction(ActionEvent actionEvent) {
    }
}