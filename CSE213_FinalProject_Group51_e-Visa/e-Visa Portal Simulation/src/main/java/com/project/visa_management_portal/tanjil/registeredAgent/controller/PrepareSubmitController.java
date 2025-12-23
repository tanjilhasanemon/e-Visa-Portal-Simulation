package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PrepareSubmitController
{
    @javafx.fxml.FXML
    private Label lblPrepareMsg;
    @javafx.fxml.FXML
    private TextField motherLanguageTextField;
    @javafx.fxml.FXML
    private TextField clientIdTextField;
    @javafx.fxml.FXML
    private TextField passportNoTextField;
    @javafx.fxml.FXML
    private ComboBox visaTypeComboBox;
    @javafx.fxml.FXML
    private TextField nationalityTextField;

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
    }

    @javafx.fxml.FXML
    public void validateOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void initialize() {
    }
}