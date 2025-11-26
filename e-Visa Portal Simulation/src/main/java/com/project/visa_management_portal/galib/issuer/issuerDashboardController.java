package com.project.visa_management_portal.galib.issuer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class issuerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void notifyApplicantOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateEVisaOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewReadyForIssuingOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void markAsIssuedOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportIssuedListOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void revokeVisaOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewIssuedListHistoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void attachVisaIDOnAction(ActionEvent actionEvent) {
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