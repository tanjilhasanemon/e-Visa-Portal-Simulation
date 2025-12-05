package com.project.visa_management_portal.sharmin.financeclerk.controller;

import com.project.visa_management_portal.sharmin.financeclerk.modelclass.PendingPayments;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class PendingPaymentsController
{
    @javafx.fxml.FXML
    private TableView<PendingPayments> PendingpaymentslistTableView;
    @javafx.fxml.FXML
    private TableColumn<PendingPayments,Integer> transactionIdColumn;
    @javafx.fxml.FXML
    private TableColumn<PendingPayments,String>  applicantNameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> FilterCombobox;
    @javafx.fxml.FXML
    private TableColumn<PendingPayments,String> statusColumn;
    @javafx.fxml.FXML
    private TableColumn<PendingPayments,Integer> amountColumn;
    @javafx.fxml.FXML
    private TableColumn<PendingPayments,LocalDate> paymentDateColumn;
    @javafx.fxml.FXML
    private TableColumn<PendingPayments,String> paymentMethodColumn;
    @javafx.fxml.FXML
    private TextField searchTextField;
    ArrayList<PendingPayments> PendingPaymentslist=new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        FilterCombobox.getItems().addAll("All", "Paid", "Pending", "Refunded");
        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        applicantNameColumn.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));

        PendingPaymentslist.add(new PendingPayments(101, "Sharmin", 5000, "Pending", "Nagad", LocalDate.now()));
        PendingPaymentslist.add(new PendingPayments(102, "Bithi", 7000, "Paid", "Bkash", LocalDate.now()));
        PendingPaymentslist.add(new PendingPayments(103, "Rafi", 3000, "Refunded", "Card", LocalDate.now()));

        PendingpaymentslistTableView.getItems().addAll(PendingPaymentslist);
    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        PendingpaymentslistTableView.getItems().clear();
        String searchText = searchTextField.getText();

        for (PendingPayments payment : PendingPaymentslist) {
            if (payment.getApplicantName().equals(searchText)) {
                PendingpaymentslistTableView.getItems().add(payment);
            }
        }
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {
        PendingpaymentslistTableView.getItems().clear();
        PendingpaymentslistTableView.getItems().addAll(PendingPaymentslist);
    }
}