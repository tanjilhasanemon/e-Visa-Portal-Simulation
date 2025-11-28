package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import com.project.visa_management_portal.tanjil.registeredAgent.modelClass.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientListController
{
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn <Client, String> clientPassportNoTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Client, String>clientNationalityTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Client, String> clientActionTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Client, String>clientEmailTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Client, String>clientNameTableColumn;
    @javafx.fxml.FXML
    private TableView <Client>clientTableView;

    @javafx.fxml.FXML
    public void initialize() {

        clientPassportNoTableColumn.setCellValueFactory(new PropertyValueFactory<>("passportNO"));
        clientNationalityTableColumn.setCellValueFactory(new PropertyValueFactory<>(""));
        clientActionTableColumn.setCellValueFactory(new PropertyValueFactory<>(""));
        clientEmailTableColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        clientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
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
    public void addClientOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/Agent_CreateClient.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Create Client");
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void signOutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Main Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}