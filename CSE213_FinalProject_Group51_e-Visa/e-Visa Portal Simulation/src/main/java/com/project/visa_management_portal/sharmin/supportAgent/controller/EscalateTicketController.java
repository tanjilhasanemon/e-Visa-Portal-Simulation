package com.project.visa_management_portal.sharmin.supportagent.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EscalateTicketController
{
    @javafx.fxml.FXML
    private ComboBox<String> priorityCombobox;
    @javafx.fxml.FXML
    private TextField ticketidTextfield;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextArea reasonTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> escalatetoCombobox;

    @javafx.fxml.FXML
    public void initialize() {
        priorityCombobox.getItems().addAll("High", "Medium", "Low");
        escalatetoCombobox.getItems().addAll( "Operation Manager", "Policy Manager", "Visa Officer");
    }

    @javafx.fxml.FXML
    public void escalateButtonOnAction(ActionEvent actionEvent) {
        if (ticketidTextfield.getText().isEmpty()) {
            statusLabel.setText("Please fill properly!");
        }
    }
    @javafx.fxml.FXML
    public void cancelButtonOnAction(ActionEvent actionEvent) {
        ticketidTextfield.clear();
        reasonTextArea.clear();
        priorityCombobox.setValue(null);
        statusLabel.setText("");
    }
}