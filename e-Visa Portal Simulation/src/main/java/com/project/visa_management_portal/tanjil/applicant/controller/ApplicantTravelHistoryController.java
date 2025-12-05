package com.project.visa_management_portal.tanjil.applicant.controller;

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

public class ApplicantTravelHistoryController
{
    @javafx.fxml.FXML
    private TextField countryTextField;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableView <TravelHistory> travelHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn <String, TravelHistory> fromTableColumn;
    @javafx.fxml.FXML
    private TableColumn <String, TravelHistory> toTableColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn <String, TravelHistory> countryTableColumn;
    @javafx.fxml.FXML
    private TextField applicationIdTextField;

    ArrayList<TravelHistory> applicantTravelHistories;
    @javafx.fxml.FXML
    private TableColumn <String, TravelHistory>applicationIdTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        applicantTravelHistories = new ArrayList<>();
        toDatePicker.setValue(LocalDate.of(2000, 1, 1));
        fromDatePicker.setValue(LocalDate.of(2000, 1, 1));
        countryTableColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        fromTableColumn.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        toTableColumn.setCellValueFactory(new PropertyValueFactory<>("toDate"));
        applicationIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("clientOrApplicantID"));
    }

    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Applicant Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Unable to load the dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {
        String country = countryTextField.getText();
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();
        String applicantId = applicationIdTextField.getText();

        // Validation
        if (countryTextField.getText().isEmpty() || fromDatePicker.getValue() == null || toDatePicker.getValue() == null || applicationIdTextField.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Incomplete Form", "Country, from date, to date and applicant ID are required.");
            return;
        }

        if (to.isBefore(from)) {
            showAlert(Alert.AlertType.WARNING, "Invalid Dates", "To-date must be same or after from-date.");
            return;
        }

        TravelHistory travelHistory = new TravelHistory(applicantId, country, from, to);
        applicantTravelHistories.add(travelHistory);

        File file = new File("ApplicantsTravelHistories.bin");
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
            oos.writeObject(travelHistory);
            oos.close();

            showAlert(Alert.AlertType.INFORMATION, "Success", "Travel history saved successfully.");
            travelHistoryTableView.getItems().add(travelHistory);

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "File Error", "An error occurred while saving the travel history.");
        }

        clear();
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    public void clear() {
        countryTextField.clear();
        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
        applicationIdTextField.clear();
    }
}
