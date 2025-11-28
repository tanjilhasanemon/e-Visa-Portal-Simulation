package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AddTravelController
{
    @javafx.fxml.FXML
    private TextField countryTextField;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TextField applicationIdTextField;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private Label statusLabel;

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
    public void initialize() {
        if (statusLabel != null) statusLabel.setText("Add travel for client/application.");

        toDatePicker.setValue(LocalDate.of(2000, 1,1));
        toDatePicker.setValue(LocalDate.of(2000, 1,1));

    }

    @javafx.fxml.FXML
    public void validateOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {

        String country = (countryTextField.getText());
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();
        String appId = (applicationIdTextField.getText());

        if (country.isEmpty() || from == null || to == null || appId.isEmpty()) {
            statusLabel.setText("Please enter country, from/to dates and application ID.");
            return;
        }

        if (toDatePicker.getValue().isBefore(fromDatePicker.getValue())) {
            statusLabel.setText("To-date must be same or after From-date.");
            return;
        }
        statusLabel.setText("Inputs look valid. Press Save to store.");
    }


}