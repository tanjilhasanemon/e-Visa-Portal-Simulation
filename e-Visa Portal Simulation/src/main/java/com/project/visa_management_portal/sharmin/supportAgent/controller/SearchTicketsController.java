package com.project.visa_management_portal.sharmin.supportagent.controller;

import com.project.visa_management_portal.sharmin.supportagent.modelclass.SearchTickets;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class SearchTicketsController
{
    @javafx.fxml.FXML
    private TableView<SearchTickets> ResulttableTableview;
    @javafx.fxml.FXML
    private Label TicketIDTextfield;
    @javafx.fxml.FXML
    private Label NameTextfield;
    @javafx.fxml.FXML
    private ComboBox<String>  statusFilterComboBox;
    @javafx.fxml.FXML
    private TableColumn<SearchTickets,String>  nameColumn;
    @javafx.fxml.FXML
    private TableColumn<SearchTickets,String> statusColumn;
    @javafx.fxml.FXML
    private TextField ticketidTextField;
    @javafx.fxml.FXML
    private TableColumn<SearchTickets,String> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<SearchTickets,String> ticketIDColumn;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextField nameTextfield;
    ArrayList<SearchTickets> searchTicketslist =new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        statusFilterComboBox.getItems().clear();
        statusFilterComboBox.getItems().addAll("All", "Pending", "Approved", "Rejected");
        ticketIDColumn.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        SearchTickets ST =new SearchTickets();

        searchTicketslist.add(ST);
        ResulttableTableview.getItems().addAll(searchTicketslist);

    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        if (statusFilterComboBox.getValue() == null) {
            showAlert("Error", "Please select a status!");
            return;
        }
    }

    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}