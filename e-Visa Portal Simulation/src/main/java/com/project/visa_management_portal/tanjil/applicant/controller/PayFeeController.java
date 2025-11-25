package com.project.visa_management_portal.tanjil.applicant.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PayFeeController
{
    @javafx.fxml.FXML
    private TextField requiredAmountTextField;
    @javafx.fxml.FXML
    private TextField enterAmountTextField;
    @javafx.fxml.FXML
    private TextField applicationIDTextField;

    @Deprecated
    public void handleBack(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handlePay(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleValidateAmount(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void payAmountOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Applicant Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void validateAmountOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadInfoOnAction(ActionEvent actionEvent) {
    }
}