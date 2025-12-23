package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ClientApplicationController
{
    @javafx.fxml.FXML
    private TextField motherLanguageTextField;
    @javafx.fxml.FXML
    private TextField clientIdTextField;
    @javafx.fxml.FXML
    private TextField passportNoTextField;
    @javafx.fxml.FXML
    private ComboBox <String> visaTypeComboBox;
    @javafx.fxml.FXML
    private TextField nationalityTextField;
    @javafx.fxml.FXML
    private ToggleGroup gender;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TextField agentEmailTextField;
    @javafx.fxml.FXML
    private TextField clientNameTextField;
    @javafx.fxml.FXML
    private TextField clientEmailTextfield;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;


    ArrayList<VisaApplication> clientApplications;

    @javafx.fxml.FXML
    public void initialize() {
        visaTypeComboBox.getItems().addAll("Tourist Visa", "Business Visa", "Student Visa", "Transit Visa", "Work Visa");

        clientApplications = new ArrayList<>();


        //Dummy data
//        clientApplications.add(new VisaApplication("C001", "John Smith", "P123456789", "USA", "English", "Business Visa", "Male", "cr@visathing.com", "john.smith@gmail.com"));
//        clientApplications.add(new VisaApplication("C002", "Maria Garcia", "P987654321", "Spain", "Spanish", "Tourist Visa", "Female", "cr@visathing.com", "maria.garcia@gmail.com"));
//        clientApplications.add(new VisaApplication("C003", "Ahmed Khan", "P456789123", "Pakistan", "Urdu", "Student Visa", "Male", "cr@visathing.com", "ahmed.khan@gmail.com"));
//        clientApplications.add(new VisaApplication("C004", "Sophie Dupont", "P321654987", "France", "French", "Work Visa", "Female", "cr@visathing.com", "sophie.dupont@gmail.com"));
//        clientApplications.add(new VisaApplication("C005", "Hiroshi Tanaka", "P654321789", "Japan", "Japanese", "Transit Visa", "Male", "cr@visathing.com", "hiroshi.tanaka@gmail.com"));
//        clientApplications.add(new VisaApplication("C006", "Emma Wilson", "P789123456", "UK", "English", "Business Visa", "Female", "cr@visathing.com", "emma.wilson@gmail.com"));
//        clientApplications.add(new VisaApplication("C007", "Carlos Rodriguez", "P234567890", "Germany", "German", "Student Visa", "Male", "cr@visathing.com", "carlos.rodriguez@gmail.com"));
//        clientApplications.add(new VisaApplication("C008", "Yuki Yamamoto", "P567890123", "Canada", "English", "Tourist Visa", "Female", "cr@visathing.com", "yuki.yamamoto@gmail.com"));
//        clientApplications.add(new VisaApplication("C009", "Pierre Leclerc", "P890123456", "France", "French", "Work Visa", "Male", "cr@visathing.com", "pierre.leclerc@gmail.com"));
//        clientApplications.add(new VisaApplication("C010", "Anna Mueller", "P345678901", "Germany", "German", "Tourist Visa", "Female", "cr@visathing.com", "anna.mueller@gmail.com"));
//        clientApplications.add(new VisaApplication("C011", "Rajesh Kumar", "P678901234", "India", "Hindi", "Business Visa", "Male", "cr@visathing.com", "rajesh.kumar@gmail.com"));
//        clientApplications.add(new VisaApplication("C012", "Fatima Hassan", "P012345678", "Pakistan", "Urdu", "Student Visa", "Female", "cr@visathing.com", "fatima.hassan@gmail.com"));
//        clientApplications.add(new VisaApplication("C013", "Bruno Ferrari", "P901234567", "Italy", "Italian", "Tourist Visa", "Male", "cr@visathing.com", "bruno.ferrari@gmail.com"));
//        clientApplications.add(new VisaApplication("C014", "Elena Rossi", "P234567891", "Italy", "Italian", "Work Visa", "Female", "cr@visathing.com", "elena.rossi@gmail.com"));
//        clientApplications.add(new VisaApplication("C015", "Chen Wei", "P567890124", "China", "Mandarin", "Business Visa", "Male", "cr@visathing.com", "chen.wei@gmail.com"));
//        clientApplications.add(new VisaApplication("C016", "Lisa Anderson", "P890123457", "USA", "English", "Student Visa", "Female", "cr@visathing.com", "lisa.anderson@gmail.com"));
//        clientApplications.add(new VisaApplication("C017", "Marco Rossi", "P345678902", "Spain", "Spanish", "Tourist Visa", "Male", "cr@visathing.com", "marco.rossi@gmail.com"));
//        clientApplications.add(new VisaApplication("C018", "Priya Singh", "P678901235", "India", "Hindi", "Work Visa", "Female", "cr@visathing.com", "priya.singh@gmail.com"));
//        clientApplications.add(new VisaApplication("C019", "Hassan Ali", "P012345679", "Pakistan", "Urdu", "Transit Visa", "Male", "cr@visathing.com", "hassan.ali@gmail.com"));
//        clientApplications.add(new VisaApplication("C020", "Sophia Mueller", "P901234568", "Germany", "German", "Business Visa", "Female", "cr@visathing.com", "sophia.mueller@gmail.com"));
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {

        // Validate empty fields
        if (clientIdTextField.getText().isEmpty() || clientNameTextField.getText().isEmpty() ||
                passportNoTextField.getText().isEmpty() || nationalityTextField.getText().isEmpty() ||
                motherLanguageTextField.getText().isEmpty() || visaTypeComboBox.getValue() == null ||
                agentEmailTextField.getText().isEmpty() || clientEmailTextfield.getText().isEmpty()) {
            showAlert("Incomplete Form", Alert.AlertType.WARNING, "Please fill all fields");
        }

        RadioButton selectedGender = (RadioButton) gender.getSelectedToggle();
        if (selectedGender == null) {
            showAlert("Gender Not Selected", Alert.AlertType.WARNING, "Please select the gender");
        }

        String clientId = clientIdTextField.getText();
        String clientName = clientNameTextField.getText();
        String passportNo = passportNoTextField.getText();
        String nationality = nationalityTextField.getText();
        String motherLanguage = motherLanguageTextField.getText();
        String visaType = visaTypeComboBox.getValue();
        String selectedGenderText = selectedGender.getText();
        String agentEmail = agentEmailTextField.getText();
        String clientEmail = clientEmailTextfield.getText();

        VisaApplication application = new VisaApplication(
                clientId, clientName, passportNo, nationality,
                motherLanguage, visaType, selectedGenderText,
                agentEmail, clientEmail);

        clientApplications.add(application);

        File file = new File("ClientApplications.bin");
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
            for (VisaApplication app : clientApplications) {
                oos.writeObject(app);
            }
            oos.close();

            showAlert("Success", Alert.AlertType.INFORMATION, "Client application submitted successfully.");

            clearFields();

        } catch (Exception e) {
            showAlert("File Error", Alert.AlertType.ERROR, "An error occurred while submitting the client application.");
        }
    }


    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            showAlert("Navigation Error", Alert.AlertType.ERROR, "Unable to load the dashboard.");
        }
    }



    private void showAlert(String title, Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void clearFields() {
        clientIdTextField.clear();
        clientNameTextField.clear();
        passportNoTextField.clear();
        nationalityTextField.clear();
        motherLanguageTextField.clear();
        agentEmailTextField.clear();
        clientEmailTextfield.clear();
        visaTypeComboBox.setValue(null);
        gender.selectToggle(null);
    }

}