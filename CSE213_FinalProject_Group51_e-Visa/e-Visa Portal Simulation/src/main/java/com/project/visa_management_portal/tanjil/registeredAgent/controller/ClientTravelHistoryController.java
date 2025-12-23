package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.tanjil.TravelHistory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClientTravelHistoryController
{
    @javafx.fxml.FXML
    private TextField countryTextField;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn <TravelHistory,String> countryTableColumn;
    @javafx.fxml.FXML
    private TableView <TravelHistory> travelHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn <TravelHistory,String> fromTableColumn;
    @javafx.fxml.FXML
    private TableColumn <TravelHistory,String> clientIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn <TravelHistory,String> toTableColumn;


    @javafx.fxml.FXML
    private TextField clientIdTextField;

    ArrayList<TravelHistory> clientTravelHistories;

    @javafx.fxml.FXML
    public void initialize() {
        clientTravelHistories = new ArrayList<>();

        toDatePicker.setValue(LocalDate.of(2000, 1,1));
        fromDatePicker.setValue(LocalDate.of(2000, 1,1));

        countryTableColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        fromTableColumn.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        toTableColumn.setCellValueFactory(new PropertyValueFactory<>("toDate"));
        clientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("clientOrApplicantID"));

    }



    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {

        String country = (countryTextField.getText());
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();
        String clientId = (clientIdTextField.getText());
        //Simple Validation
        if (country.isEmpty() || from == null || to == null || clientId.isEmpty()) {
            showAlert("Input Error", Alert.AlertType.WARNING, "Please fill in all fields.");
            return;
        }
        if (toDatePicker.getValue().isBefore(fromDatePicker.getValue())) {
            showAlert("Input Error", Alert.AlertType.WARNING, "'To' date cannot be before 'From' date.");
            return;
        }

        TravelHistory travelHistory = new TravelHistory(clientId, country, from, to);
        clientTravelHistories.add(travelHistory);

        File file = new File("ClientTravelHistories.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            if(file.exists()){
                fos = new java.io.FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new java.io.FileOutputStream(file);
                oos = new java.io.ObjectOutputStream(fos);
            }
            oos.writeObject(travelHistory);
            oos.close();
            showAlert("Success", Alert.AlertType.INFORMATION, "Travel history saved successfully.");

            travelHistoryTableView.getItems().add(travelHistory);

        } catch (Exception e) {
            showAlert("File Error", Alert.AlertType.ERROR, "An error occurred while saving the travel history.");
        }

        clear();
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
        }
        catch (Exception e){
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

    public void clear() {
        countryTextField.clear();
        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
        clientIdTextField.clear();
    }

}