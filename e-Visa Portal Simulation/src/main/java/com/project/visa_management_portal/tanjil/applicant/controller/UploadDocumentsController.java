package com.project.visa_management_portal.tanjil.applicant.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UploadDocumentsController
{
    @javafx.fxml.FXML
    private CheckBox confirmCheckBox;
    @javafx.fxml.FXML
    private TextField passportPathTextField;
    @javafx.fxml.FXML
    private TextField photoPathTextField;

    @javafx.fxml.FXML
    public void choosePassportPathOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void choosePhotoPathOnAction(ActionEvent actionEvent) {
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
    public void attachOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void validateOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void initialize() {
    }
}