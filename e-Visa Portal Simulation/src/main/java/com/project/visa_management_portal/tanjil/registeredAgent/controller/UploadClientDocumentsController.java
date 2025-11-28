package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class UploadClientDocumentsController
{
    @javafx.fxml.FXML
    private TextField applicationIdTextField;
    @javafx.fxml.FXML
    private TextField passportPathTextField;
    @javafx.fxml.FXML
    private TextField photoPathTextField;
    @javafx.fxml.FXML
    private CheckBox filesValidCheckBox;


    private final FileChooser fileChooser = new FileChooser();
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        statusLabel.setText("Upload client documents for an application ID.");

    }

    @javafx.fxml.FXML
    public void choosePassportPathOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void choosePhotoPathOnAction(ActionEvent actionEvent) {
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
    public void attachOnAction(ActionEvent actionEvent) {

        String appId = (applicationIdTextField.getText());
        String passportPath = (passportPathTextField.getText());
        String photoPath = (photoPathTextField.getText());

        if (appId.isEmpty()) {
            statusLabel.setText("Please enter Application ID.");
            return;
        }
        if (passportPath.isEmpty() || photoPath.isEmpty()) {
            statusLabel.setText("Please select passport and photo files.");
            return;
        }
        if (!filesValidCheckBox.isSelected()) {
            statusLabel.setText("Please confirm files are valid by checking the box.");
            return;
        }
    }


}