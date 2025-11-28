package com.project.visa_management_portal.tanjil.applicant.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;

import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
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


    private final FileChooser fileChooser = new FileChooser();
    @javafx.fxml.FXML
    private TextField applicantIDTextField;


    @javafx.fxml.FXML
    public void initialize() {
    }

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

        String passportPath = (passportPathTextField.getText());
        String photoPath = (photoPathTextField.getText());


        if (passportPath.isEmpty() || photoPath.isEmpty()) {
            showAlert("Please choose both passport and photo files.");
            return;
        }

        if (!confirmCheckBox.isSelected()) {
            showAlert("Please confirm that files are correct by ticking the checkbox.");
            return;
        }
    }



    private void showAlert(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Validation");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }


}