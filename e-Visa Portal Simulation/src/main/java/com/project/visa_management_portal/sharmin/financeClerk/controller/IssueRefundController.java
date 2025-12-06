package com.project.visa_management_portal.sharmin.financeclerk.controller;

import com.project.visa_management_portal.sharmin.financeclerk.modelclass.IssueRefund;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class IssueRefundController
{
    @javafx.fxml.FXML
    private Label ApplicationIDTextfield;
    @javafx.fxml.FXML
    private TextArea reasonTextarea;
    @javafx.fxml.FXML
    private Label RefundAmountTextfield;
    @javafx.fxml.FXML
    private TableColumn<IssueRefund,String> applicantNameColumn;
    @javafx.fxml.FXML
    private TableColumn<IssueRefund,String> statusColumn;
    @javafx.fxml.FXML
    private TableView<IssueRefund> RefundsTableView;
    @javafx.fxml.FXML
    private TableColumn<IssueRefund,Integer> amountColumn;
    @javafx.fxml.FXML
    private TableColumn<IssueRefund, LocalDate> paymentDateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> filterComboBox;
    @javafx.fxml.FXML
    private TextField searchTextField;
    @javafx.fxml.FXML
    private TableColumn<IssueRefund,String> paymentMethodColumn;
    @javafx.fxml.FXML
    private Label messageLabel;
    ArrayList<IssueRefund> refundList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        filterComboBox.getItems().addAll("All", "Paid", "Pending", "Refunded");
        applicantNameColumn.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));


//        refundList.add(new IssueRefund(101, "Sharmin", "Paid", 5000, "Nagad", LocalDate.now()));
//        refundList.add(new IssueRefund(102, "Bithi", "Paid", 7000, "Bkash", LocalDate.now()));
//        refundList.add(new IssueRefund(103, "Rafi", "Refunded", 3000, "Card", LocalDate.now()));

        RefundsTableView.getItems().addAll(refundList);
    }

    @javafx.fxml.FXML
    public void issueRefundButtonOnAction(ActionEvent actionEvent) {
        IssueRefund selected = RefundsTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            messageLabel.setText("Please select a transaction to refund.");
            return;
        }

        if (selected.getStatus().equals("Refunded")) {
            messageLabel.setText("This transaction is already refunded.");
            return;
        }
        selected.setStatus("Refunded");
        RefundsTableView.refresh();
        messageLabel.setText("Refund issued successfully.");


    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {

            String search = searchTextField.getText();

            RefundsTableView.getItems().clear();

            for (IssueRefund r : refundList) {
                if (r.getApplicantName().toLowerCase().contains(search.toLowerCase())) {
                    RefundsTableView.getItems().add(r);
                }
            }
        }


}