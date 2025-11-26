package com.project.visa_management_portal.tanjil.applicant.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicantDashboardController
{
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        statusLabel.setText("Welcome to Applicant Dashboard");

    }
    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void uploadDocumentsOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_UploadDocuments.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Upload Document");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Upload Document Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void helpAndFeedbackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Feedback.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Help & Feedback");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            showAlert("Scene error", "Unable to open Help & Feedback Dashboard.");
        }

    }

    @javafx.fxml.FXML
    public void downloadsOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Downloads.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Download Receipts");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Download Receipts Dashboard.");
        }

    }

    @javafx.fxml.FXML
    public void payFeeOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_PayFee.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Payment");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Payment Dashboard.");
        }

    }

    @javafx.fxml.FXML
    public void travelHistoryOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_TravelHistory.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Travel History");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Scene error", "Unable to open Travel History Dashboard.");
        }

    }

    @javafx.fxml.FXML
    public void viewVisaInfoOnAction(ActionEvent actionEvent){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_ViewVisaInfo.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setTitle("Visa Info");
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                showAlert("Scene error", "Unable to open Visa Info Dashboard.");
            }
        }


    @javafx.fxml.FXML
    public void trackApplicationOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_TrackApplication.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Application Track.");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Scene error", "Unable to open Application Track Dashboard.");
        }

    }

    @javafx.fxml.FXML
    public void applyForVIsaOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_ApplyVisa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Apply For Visa");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Scene error", "Unable to open Apply For Visa Dashboard.");
        }

    }

    @javafx.fxml.FXML
    public void signOutOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Scene error", "Unable to open Main Dashboard.");
        }

    }



}