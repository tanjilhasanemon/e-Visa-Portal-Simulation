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
    }

    @javafx.fxml.FXML
    public void loadClientsOnAction(ActionEvent actionEvent) {
        ArrayList<Client> clients = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;


        File file = new File("Clients.bin");

        try {
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                while (true) {
                    try {
                        Client client = (Client) ois.readObject();
                        clients.add(client);
                    } catch (java.io.EOFException e) {
                        break;
                    }
                }
                ois.close();
                if (clients.isEmpty()) {
                    showAlert("No Data", "No clients found in the file.");
                } else {
                    clientTableView.getItems().addAll(clients);
                    showAlert("Success", "Loaded " + clients.size() + " clients successfully.");
                }
            } else {
                showAlert("File Error", "Clients.bin file not found.");
            }
        } catch (IOException | ClassNotFoundException e) {
            showAlert("Error", "An error occurred while reading clients: " + e.getMessage());

        }
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
