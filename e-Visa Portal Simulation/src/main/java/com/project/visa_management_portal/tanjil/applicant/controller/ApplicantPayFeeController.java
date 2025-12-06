package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ApplicantPayFeeController
{
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TextArea receiptTextArea;
    @javafx.fxml.FXML
    private Label payableAmountLabel;

    @javafx.fxml.FXML
    private TextField SearchTextField;

    ArrayList <VisaApplication> visaApplications;


    @javafx.fxml.FXML
    public void initialize() {
        visaApplications = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("ApplicantVisaApplications.bin");
            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showAlert( Alert.AlertType.ERROR, "File Not Found","Client applications file does not exist.");
            }
            if (fis != null) ois = new ObjectInputStream(fis);
            while (true) {
                VisaApplication visa = (VisaApplication) ois.readObject();
                visaApplications.add(visa);

            }
        } catch (IOException | ClassNotFoundException e) {
            try {
                if (ois != null) ois.close();
            } catch (Exception ex) {
                showAlert( Alert.AlertType.ERROR, "File Error","Error closing the file.");
            }
        }
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {

        if (SearchTextField.getText().isEmpty()){
            showAlert( Alert.AlertType.ERROR, "Input Error","Please enter your application id to search.");
            return;
        }

        ArrayList <VisaApplication> matchedApplications = new ArrayList<>();

        String visaFee = "";

        for (VisaApplication targetApplication: visaApplications) {
            if (targetApplication.getApplicationId().equals(SearchTextField.getText())) {
                matchedApplications.add(targetApplication);
                visaFee = Integer.toString(targetApplication.getFeeForVisaType(targetApplication.getVisaType()));
            }
        }
        if (matchedApplications.isEmpty()) {
            showAlert( Alert.AlertType.WARNING, "No Matches","No visa applications found for the given client ID.");
        }

        payableAmountLabel.setText(visaFee);
    }

    @javafx.fxml.FXML
    public void payOnAction(ActionEvent actionEvent) {

        if(amountTextField.getText().isEmpty()){
            showAlert( Alert.AlertType.ERROR, "Input Error","Please enter an amount to pay.");
            return;
        }
        int enterAmount = Integer.parseInt(amountTextField.getText().trim());
        int payableAmount = Integer.parseInt(payableAmountLabel.getText().trim());

        if (enterAmount != payableAmount){
            showAlert( Alert.AlertType.ERROR,"Payment Error", "The entered amount does not match the payable amount.");
            return;
        }


        String transitionId  = "TXN" + System.currentTimeMillis() + (int)(Math.random() * 10000);

        String receipt = "═══════════════════════════════════\n"
                + "          PAYMENT RECEIPT\n"
                + "═══════════════════════════════════\n"
                + "Transaction ID: " + transitionId + "\n"
                + "Application ID: " + SearchTextField.getText() + "\n"
                + "Amount Paid: $" + amountTextField.getText() + "\n"
                + "Payment Date: " + java.time.LocalDate.now() + "\n"
                + "Status: SUCCESS\n"
                + "═══════════════════════════════════\n"
                + "Thank you for your payment!\n"
                + "═══════════════════════════════════";

        receiptTextArea.setText(receipt);
        showAlert( Alert.AlertType.INFORMATION, "Payment Successful","Payment processed successfully. Receipt generated");

    }

    @javafx.fxml.FXML
    public void backToDashBoardOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Applicant Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Unable to load the dashboard.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

}