package com.project.visa_management_portal.tanjil.registeredAgent.controller;
import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.tanjil.registeredAgent.modelClass.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class DeleteAndUpdateClientsController
{

    @javafx.fxml.FXML
    private Label oldEmailLabel;
    @javafx.fxml.FXML
    private TextField newNameTextField;
    @javafx.fxml.FXML
    private Label oldCLientNameLabel;
    @javafx.fxml.FXML
    private Label oldPassportNoLabel;
    @javafx.fxml.FXML
    private TextField newEmailTextField;
    @javafx.fxml.FXML
    private TextField newPassportNoTextField;
    @javafx.fxml.FXML
    private TextField clientIdTextField;

    ArrayList<Client> clients;

    @javafx.fxml.FXML
    public void initialize() {
        clients = new ArrayList<>();

        File file = new File("Clients.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showAlert("File Not Found", Alert.AlertType.WARNING, "Client file does not exist.");
            }

            if (fis != null) ois = new ObjectInputStream(fis);

            while (true) {
                Client client = (Client) ois.readObject();
                clients.add(client);
            }
        } catch (Exception e) {
            try {
                if (ois != null) ois.close();
            } catch (IOException _) {
                showAlert("File Error", Alert.AlertType.ERROR, "Error closing the file.");
            }
        }
    }

    @javafx.fxml.FXML
    public void searchClientOnAction(ActionEvent actionEvent) {
        if (clientIdTextField.getText().isEmpty()) {
            showAlert("Input Error", Alert.AlertType.WARNING, "Please enter Client ID.");
            return;
        }

        String clientId = clientIdTextField.getText().trim();
        boolean found = false;

        for (Client client : clients) {
            if (Objects.equals(client.getClientId(), clientId)) {
                oldCLientNameLabel.setText(client.getName());
                oldEmailLabel.setText(client.getContact());
                oldPassportNoLabel.setText(client.getPassportNo());
                found = true;
            }
        }

        if (!found) {
            showAlert("No Client Found", Alert.AlertType.WARNING, "No client found with the provided Client ID.");
        }
    }

    @javafx.fxml.FXML
    public void updateClientInfoOnAction(ActionEvent actionEvent) {
        if (newNameTextField.getText().isEmpty() && newEmailTextField.getText().isEmpty() && newPassportNoTextField.getText().isEmpty()) {
            showAlert("Input Error", Alert.AlertType.WARNING, "Please enter at least one field to update.");
            return;
        }

        String clientId = clientIdTextField.getText().trim();
        boolean updated = false;

        for (Client client : clients) {
            if (Objects.equals(client.getClientId(), clientId)) {
                if (!newNameTextField.getText().isEmpty()) {
                    client.setName(newNameTextField.getText().trim());
                }
                if (!newEmailTextField.getText().isEmpty()) {
                    client.setContact(newEmailTextField.getText().trim());
                }
                if (!newPassportNoTextField.getText().isEmpty()) {
                    client.setPassportNo(newPassportNoTextField.getText().trim());
                }
                updated = true;
            }
        }

        if (updated) {
            showAlert("Update Successful", Alert.AlertType.INFORMATION, "Client details updated successfully.");

            File f = new File("Clients.bin");
            if (f.exists()) {
                f.delete();
            }
            File file = new File("Clients.bin");

            FileOutputStream fos = null;
            ObjectOutputStream oos = null;


            try {
                if (file.exists()) {
                    fos = new FileOutputStream(file, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                }

                for (Client client : clients) {
                    oos.writeObject(client);
                }

                oos.close();
                showAlert("File Saved", Alert.AlertType.INFORMATION, "Updated clients saved to file.");
            } catch (Exception e) {
                showAlert("File Error", Alert.AlertType.ERROR, "Error saving updated clients to file.");
            }
        } else {
            showAlert("Update Failed", Alert.AlertType.ERROR, "Failed to update client details.");
        }

        clear();
    }

    @javafx.fxml.FXML
    public void deleteClientOnAction(ActionEvent actionEvent) {
        //Validation
        if (clientIdTextField.getText().isEmpty()) {
            showAlert("Input Error", Alert.AlertType.WARNING, "Please enter Client ID to delete.");
            return;
        }


        String clientId = clientIdTextField.getText().trim();

        boolean removed = false;

        Client targetClient = null;

        for (Client c : clients) {
            if (clientId.equals(c.getClientId())) {
                targetClient = c;
            }
        }

        if (targetClient != null) {
            clients.remove(targetClient);
            removed = true;
        }

        if (!removed) {
            showAlert("Delete Failed", Alert.AlertType.WARNING, "No client found with the provided Client ID.");
            return;
        }

        ArrayList<Client> updatedClients;
        updatedClients = clients;


        File f = new File("Clients.bin");
        if (f.exists()) {
            f.delete();
        }
        File file = new File("Clients.bin");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            for (Client client : updatedClients) {
                oos.writeObject(client);
            }

            oos.close();

            showAlert("Delete Successful", Alert.AlertType.INFORMATION, "Client deleted successfully.");

        } catch (Exception e) {
            showAlert("File Error", Alert.AlertType.ERROR, "Error saving updated clients to file.");
        }

        clear();

    }

    private void showAlert(String title, Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
        } catch (IOException e) {
            showAlert("Navigation Error", Alert.AlertType.ERROR, "Unable to return to dashboard.");
        }
    }

    public void clear() {
        oldEmailLabel.setText("");
        oldCLientNameLabel.setText("");
        oldPassportNoLabel.setText("");
        newNameTextField.clear();
        newEmailTextField.clear();
        newPassportNoTextField.clear();
        clientIdTextField.clear();
    }
}


