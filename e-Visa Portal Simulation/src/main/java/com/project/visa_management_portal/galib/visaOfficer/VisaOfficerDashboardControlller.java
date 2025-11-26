package com.project.visa_management_portal.galib.visaOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VisaOfficerDashboardControlller
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void applicationReviewOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void travelHistoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void paymentVerificationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void applicationDashboardOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void supportAndReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void documentVerificationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void visaDecisionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void renewalAndCancellationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToMainDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Main Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}