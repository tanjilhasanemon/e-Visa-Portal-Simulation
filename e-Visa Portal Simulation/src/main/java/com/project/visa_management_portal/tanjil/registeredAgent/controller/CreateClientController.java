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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CreateClientController {
    @javafx.fxml.FXML
    private Label lblClientMsg;
    @javafx.fxml.FXML
    private TextField clientContactTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField clientPassportNoTextField;

    public ArrayList<Client> clients;


    @javafx.fxml.FXML
    public void initialize() {
        if (lblClientMsg != null) lblClientMsg.setText("Enter client details and press Create.");

        clients = new ArrayList<>();

        // Dummy data
//        clients.add(new Client("John Smith", "P123456789", "john.smith@gmail.com"));
//        clients.add(new Client("Maria Garcia", "P987654321", "maria.garcia@gmail.com"));
//        clients.add(new Client("Ahmed Khan", "P456789123", "ahmed.khan@gmail.com"));
//        clients.add(new Client("Sophie Dupont", "P321654987", "sophie.dupont@gmail.com"));
//        clients.add(new Client("Hiroshi Tanaka", "P654321789", "hiroshi.tanaka@gmail.com"));
//        clients.add(new Client("Emma Wilson", "P789123456", "emma.wilson@gmail.com"));
//        clients.add(new Client("Carlos Rodriguez", "P234567890", "carlos.rodriguez@gmail.com"));
//        clients.add(new Client("Yuki Yamamoto", "P567890123", "yuki.yamamoto@gmail.com"));
//        clients.add(new Client("Pierre Leclerc", "P890123456", "pierre.leclerc@gmail.com"));
//        clients.add(new Client("Anna Mueller", "P345678901", "anna.mueller@gmail.com"));
//        clients.add(new Client("Rajesh Kumar", "P678901234", "rajesh.kumar@gmail.com"));
//        clients.add(new Client("Fatima Hassan", "P012345678", "fatima.hassan@gmail.com"));
//        clients.add(new Client("Bruno Ferrari", "P901234567", "bruno.ferrari@gmail.com"));
//        clients.add(new Client("Elena Rossi", "P234567891", "elena.rossi@gmail.com"));
//        clients.add(new Client("Chen Wei", "P567890124", "chen.wei@gmail.com"));
//        clients.add(new Client("Lisa Anderson", "P890123457", "lisa.anderson@gmail.com"));
//        clients.add(new Client("Marco Rossi", "P345678902", "marco.rossi@gmail.com"));
//        clients.add(new Client("Priya Singh", "P678901235", "priya.singh@gmail.com"));
//        clients.add(new Client("Hassan Ali", "P012345679", "hassan.ali@gmail.com"));
//        clients.add(new Client("Sophia Mueller", "P901234568", "sophia.mueller@gmail.com"));
    }


    @javafx.fxml.FXML
    public void createClientProfileOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String passport = clientPassportNoTextField.getText();
        String contact = clientContactTextField.getText();

        // Basic validation
        if (name.isEmpty() || passport.isEmpty() || contact.isEmpty()) {
            showAlert("Validation Error", "All fields are required.");
            return;
        }

        Client newClient = new Client(name, passport, contact);
        clients.add(newClient);

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

            showAlert("Success", "Client profile created successfully.");
            clearFields();

        } catch (Exception e) {
            showAlert("Error", "An error occurred while creating client profile.");

        }
    }

    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

    private void clearFields() {
        nameTextField.clear();
        clientPassportNoTextField.clear();
        clientContactTextField.clear();
    }


    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Registered Agent Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            showAlert("Scene error", "Unable to open Applicant Dashboard.");
        }
    }

}
