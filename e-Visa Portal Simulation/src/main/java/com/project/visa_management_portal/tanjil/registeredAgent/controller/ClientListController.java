package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import com.project.visa_management_portal.tanjil.registeredAgent.modelClass.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ClientListController {
    @javafx.fxml.FXML
    private TableColumn<Client, String> clientNameTableColumn;
    @javafx.fxml.FXML
    private TableView<Client> clientTableView;
    @javafx.fxml.FXML
    private TableColumn<Client, String> passportNoTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Client, String> EmailTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Client, String> clientIDTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        clientIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        clientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        passportNoTableColumn.setCellValueFactory(new PropertyValueFactory<>("passportNo"));
        EmailTableColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));


        ArrayList<Client> clients = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;


        File file = new File("Clients.bin");

        try {

            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showAlert("File Not Found", Alert.AlertType.ERROR, "Client applications file does not exist.");
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                Client client = (Client) ois.readObject();
                clients.add(client);
            }
        } catch (IOException | ClassNotFoundException e) {
            try {
                if(ois!=null) ois.close();
            }catch (Exception _) {
                showAlert("File Error", Alert.AlertType.ERROR, "Error closing the file.");
            }
        }

        if (clients.isEmpty()) {
            showAlert("No Clients Found", Alert.AlertType.WARNING, "No clients found in the system.");
        } else {
            clientTableView.getItems().addAll(clients);
        }
    }



    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Registered Agent Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showAlert("Navigation Error", Alert.AlertType.ERROR, "Could not load dashboard: ");
        }

    }

    private void showAlert(String title, Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void addClientOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/Agent_CreateClient.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Create Client");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Navigation Error", Alert.AlertType.ERROR, "Could not load Create Client page.");
        }

    }
}
