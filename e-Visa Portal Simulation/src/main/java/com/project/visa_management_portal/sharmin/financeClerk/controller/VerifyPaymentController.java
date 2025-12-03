package com.project.visa_management_portal.sharmin.financeclerk.controller;

import com.project.visa_management_portal.sharmin.financeclerk.modelclass.VerifyPayment;
import com.project.visa_management_portal.tanjil.applicant.modelClass.Applicant;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class VerifyPaymentController
{
    @javafx.fxml.FXML
    private TextField applicantidTextfield;
    @javafx.fxml.FXML
    private TableView <VerifyPayment>paymentTableView;
    @javafx.fxml.FXML
    private TableColumn<VerifyPayment, Integer> AmountTablecolumn;
    @javafx.fxml.FXML
    private TableColumn <VerifyPayment,String>StatusTablecolumn;
    @javafx.fxml.FXML
    private TableColumn <VerifyPayment, Integer>ApplicantIDTablecolumn;
    @javafx.fxml.FXML
    private TableColumn <VerifyPayment, Integer>DateTablecolumn;
    @javafx.fxml.FXML
    private TableColumn <VerifyPayment,String>NameTablecolumn;

    private ArrayList<VerifyPayment> dataList = new ArrayList<>();



    @javafx.fxml.FXML
    public void initialize() {
        ApplicantIDTablecolumn.setCellValueFactory(new PropertyValueFactory<>("applicantID"));
        NameTablecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        AmountTablecolumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        StatusTablecolumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        DateTablecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        VerifyPayment v1 = new VerifyPayment();
        VerifyPayment v2 = new VerifyPayment();
        VerifyPayment v3 = new VerifyPayment();


        dataList.add(v1);
        dataList.add(v2);
        dataList.add(v3);
        paymentTableView.getItems().addAll(dataList);
    }

    @javafx.fxml.FXML
    public void MarkVerifiedButtonOnAction(ActionEvent actionEvent) {
        if(applicantidTextfield.getText().isEmpty()){
            showAlert("Error", "Applicant ID cannot be empty");
        }

        boolean invalidFound = false;
        for (int i = 0; i < applicantidTextfield.getText().length(); i++) {
            if(applicantidTextfield.getText().charAt(i)>='0'&& applicantidTextfield.getText().charAt(i)<='9') invalidFound = true;

            showAlert("Error", "Applicant ID must contain only numbers!");
            }
        boolean sameIdFound = false;
        VerifyPayment foundRecord = null;
        int applicantID=(2210233 );

        for (VerifyPayment vp : dataList) {
            if (vp.getApplicantID() == applicantID) {
                sameIdFound = true;
                foundRecord = vp;
            }
        }

        if (!sameIdFound) {
            showAlert("Not Found", "No record found for Applicant ID: " + applicantID);
            return;
        }
        if (foundRecord.getStatus().equals("Verified")) {
            showAlert("Info", "Payment is already Verified!");
            return;
        }

        foundRecord.setStatus("Verified");
        paymentTableView.refresh();

        showAlert("Success", "Payment marked as Verified!");

    }



    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        if(applicantidTextfield.getText().isEmpty()){
            showAlert("Error", "Applicant ID cannot be empty");
        }

        boolean invalidFound = false;
        for (int i = 0; i < applicantidTextfield.getText().length(); i++) {
            if(applicantidTextfield.getText().charAt(i)>='0'&& applicantidTextfield.getText().charAt(i)<='9') invalidFound = true;

            showAlert("Error", "Applicant ID must contain only numbers!");
        }
        boolean sameIdFound = false;
        VerifyPayment foundRecord = null;
        int applicantID=(2210233 );

        for (VerifyPayment vp : dataList) {
            if (vp.getApplicantID() == applicantID) {
                sameIdFound = true;
                foundRecord = vp;
            }
        }

        if (!sameIdFound) {
            showAlert("Not Found", "No record found for Applicant ID: " + applicantID);
            return;
        }
        if (foundRecord.getStatus().equals("Verified")) {
            showAlert("Info", "Payment is already Verified!");
            return;
        }

        foundRecord.setStatus("Verified");
        paymentTableView.refresh();

        showAlert("Success", "Payment marked as Verified!");


    }

    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}