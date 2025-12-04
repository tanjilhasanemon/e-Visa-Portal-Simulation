package com.project.visa_management_portal.sharmin.supportagent.controller;

import com.project.visa_management_portal.sharmin.supportagent.modelclass.ViewTickets;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.View;
import java.time.LocalDate;
import java.util.ArrayList;

public class ViewTicketsController
{
    @javafx.fxml.FXML
    private TableColumn<ViewTickets,String> UserNameTablecolumn;
    @javafx.fxml.FXML
    private TableView<ViewTickets> TicketsTableview;
    @javafx.fxml.FXML
    private TableColumn<ViewTickets,Integer> TicketIDTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<ViewTickets, LocalDate> DateTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<ViewTickets,String> IssueTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<ViewTickets,String> statusTablecolumn;
    @javafx.fxml.FXML
    private ComboBox<String> statusFilterComboBox;
    @javafx.fxml.FXML
    private TextField ticketidTextField;
    @javafx.fxml.FXML
    private Label statusLabel;

    private ArrayList<ViewTickets> viewticketslist=new ArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        statusFilterComboBox.getItems().addAll( "Escalated", "Closed");
        TicketIDTablecolumn.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        UserNameTablecolumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        DateTablecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        IssueTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("issueType"));
        statusTablecolumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        ViewTickets vt=new ViewTickets();

        viewticketslist.add(new ViewTickets(101, "Sharmin","Escalated", "Login Issue",LocalDate.now()));
        viewticketslist.add(new ViewTickets(102, "Bithi", "Refund Query","Closed",LocalDate.now()));

        viewticketslist.add(vt);
        TicketsTableview.getItems().addAll(viewticketslist);

    }

    @javafx.fxml.FXML
    public void closeButtonOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void escalateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void respondButtonOnAcion(ActionEvent actionEvent) {
    }
}