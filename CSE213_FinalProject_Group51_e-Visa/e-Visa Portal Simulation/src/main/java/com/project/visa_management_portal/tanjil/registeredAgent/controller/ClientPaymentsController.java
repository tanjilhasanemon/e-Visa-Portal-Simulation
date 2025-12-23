package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ClientPaymentsController
{
    @FXML
    private TextField amountTextField;
    @FXML
    private TextField clientSearchTextField;
    @FXML
    private TextArea receiptTextArea;
    @FXML
    private Label payableAmountLabel;

    ArrayList <VisaApplication> visaApplications;


    @FXML
    public void initialize() {
        visaApplications = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("ClientApplications.bin");
            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showAlert("File Not Found", Alert.AlertType.ERROR, "Client applications file does not exist.");
            }
            if (fis != null) ois = new ObjectInputStream(fis);
            while (true) {
                VisaApplication visa = (VisaApplication) ois.readObject();
                visaApplications.add(visa);

            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (IOException ex) {
                showAlert("File Error", Alert.AlertType.ERROR, "Error closing the file.");
            }
        }



    }

    @FXML
    public void searchOnAction(ActionEvent actionEvent) {
        if (clientSearchTextField.getText().isEmpty()){
            showAlert("Input Error", Alert.AlertType.WARNING, "Please enter a client ID to search.");
        }

        ArrayList <VisaApplication> matchedApplications = new ArrayList<>();
        String visaFee = "";

        for (VisaApplication targetApplication: visaApplications) {
            if (targetApplication.getClientId().equals(clientSearchTextField.getText())) {
                matchedApplications.add(targetApplication);
                visaFee = Integer.toString(targetApplication.getFeeForVisaType(targetApplication.getVisaType()));
            }
        }
        if (matchedApplications.isEmpty()) {
            showAlert("No Matches", Alert.AlertType.WARNING, "No visa applications found for the given client ID.");
        }

        payableAmountLabel.setText(visaFee);


    }

    @FXML
    public void payOnAction(ActionEvent actionEvent) {

        if(amountTextField.getText().isEmpty()){
            showAlert("Input Error", Alert.AlertType.WARNING, "Please enter an amount to pay.");
            return;
        }
        int enterAmount = Integer.parseInt(amountTextField.getText().trim());
        int payableAmount = Integer.parseInt(payableAmountLabel.getText().trim());

        if (enterAmount != payableAmount){
            showAlert("Payment Error", Alert.AlertType.WARNING, "The entered amount does not match the payable amount.");
            return;
        }


        String transitionId  = "TXN" + System.currentTimeMillis() + (int)(Math.random() * 10000);

        String receipt = "═══════════════════════════════════\n"
                + "          PAYMENT RECEIPT\n"
                + "═══════════════════════════════════\n"
                + "Transaction ID: " + transitionId + "\n"
                + "Client ID: " + clientSearchTextField.getText() + "\n"
                + "Amount Paid: $" + amountTextField.getText() + "\n"
                + "Payment Date: " + java.time.LocalDate.now() + "\n"
                + "Status: SUCCESS\n"
                + "═══════════════════════════════════\n"
                + "Thank you for your payment!\n"
                + "═══════════════════════════════════";

        receiptTextArea.setText(receipt);
        showAlert("Payment Successful", Alert.AlertType.INFORMATION, "Payment processed successfully. Receipt generated");
        clearFields();


    }

    @FXML
    public void backToDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Registered Agent Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e) {
            showAlert("Navigation Error", Alert.AlertType.ERROR, "Unable to load the dashboard.");
        }

    }

    private void showAlert(String title,Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        amountTextField.clear();
        clientSearchTextField.clear();
        payableAmountLabel.setText("0.00");
    }
}