package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateClientController
{
    @javafx.fxml.FXML
    private Label lblClientMsg;
    @javafx.fxml.FXML
    private TextField clientContactTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField clientPassportNoTextField;


    @javafx.fxml.FXML
    public void initialize() {
        if (lblClientMsg != null) lblClientMsg.setText("Enter client details and press Create.");
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
    public void createClientProfileOnAction(ActionEvent actionEvent) {

        String name = (nameTextField.getText());
        String passport = (clientPassportNoTextField.getText());
        String contact = (clientContactTextField.getText());

        // basic validation
        if (name.isEmpty() || passport.isEmpty() || contact.isEmpty()) {
            //set text "Validation error", "All fields are required.");
            return;
        }
    }


    @javafx.fxml.FXML
    public void validateClientProfileOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewClientListOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/AgentClientList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Client List");
        stage.setScene(scene);
        stage.show();
    }
}