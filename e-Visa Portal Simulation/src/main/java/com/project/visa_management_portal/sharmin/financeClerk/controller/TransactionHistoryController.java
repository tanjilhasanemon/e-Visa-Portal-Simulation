package com.project.visa_management_portal.sharmin.financeclerk.controller;

import com.project.visa_management_portal.sharmin.financeclerk.modelclass.TransactionHistory;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionHistoryController
{
    @javafx.fxml.FXML
    private ComboBox<String> FilterCombobox;
    @javafx.fxml.FXML
    private TableView<TransactionHistory> TransactionsTableview;
    @javafx.fxml.FXML
    private TableColumn<TransactionHistory,Integer> transactionIdColumn;
    @javafx.fxml.FXML
    private TableColumn<TransactionHistory,String> applicantNameColumn;
    @javafx.fxml.FXML
    private TableColumn<TransactionHistory,String> statusColumn;
    @javafx.fxml.FXML
    private TableColumn<TransactionHistory,Integer> amountColumn;
    @javafx.fxml.FXML
    private TableColumn<TransactionHistory, LocalDate> paymentDateColumn;
    @javafx.fxml.FXML
    private TableColumn<TransactionHistory,String>paymentMethodColumn;

    ArrayList<TransactionHistory>TransactionHistoryList=new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        FilterCombobox.getItems().addAll("All", "Paid", "Pending", "Refunded");
        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        applicantNameColumn.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));

        TransactionsTableview.getItems().addAll(TransactionHistoryList);


        TransactionHistoryList.add(new TransactionHistory(101, "Sharmin", "Paid", 5000, LocalDate.now(), "Nagad"));
        TransactionHistoryList.add(new TransactionHistory(102, "Bithi", "Pending", 7000, LocalDate.now(), "Bkash"));
        TransactionHistoryList.add(new TransactionHistory(103, "Rafi", "Refunded", 3000, LocalDate.now(), "Card"));


    }

    @javafx.fxml.FXML
    public void SearchButtonOnAction(ActionEvent actionEvent) {

        String filter = FilterCombobox.getValue();

        if (filter == null) {
            filter = "All";
        }

        ArrayList<TransactionHistory> filteredList = new ArrayList<>();

        if (filter.equals("All")) {
            filteredList.addAll(TransactionHistoryList);
        } else {
            for (TransactionHistory t : TransactionHistoryList) {
                if (t.getStatus().equals(filter)) {
                    filteredList.add(t);
                }
            }
        }

        TransactionsTableview.getItems().clear();
        TransactionsTableview.getItems().addAll(filteredList);
    }

}