package com.project.visa_management_portal.tanjil.applicant.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ApplyVisaController
{
    @javafx.fxml.FXML
    public ToggleGroup genderGroup;
    @javafx.fxml.FXML
    private TextArea purposeOfVisitTextArea;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TextField fullNameTextField;
    @javafx.fxml.FXML
    private TextField passportNoTextField;
    @javafx.fxml.FXML
    private ComboBox <String> visaTypeComboBox;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private TextField motherLangTextField;
    @javafx.fxml.FXML
    private TextField nationalityTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void handleValidateApplication(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleSubmitApplication(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleBackToDashboard(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void validateApplicationOnAction(ActionEvent actionEvent) {
    }
}