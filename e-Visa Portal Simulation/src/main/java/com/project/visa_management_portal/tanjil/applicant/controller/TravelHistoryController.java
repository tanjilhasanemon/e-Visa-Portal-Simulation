package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.tanjil.TravelHistoryEntry;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class TravelHistoryController
{
    @javafx.fxml.FXML
    private TextField countryTextField;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableView <String> travelHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn <String, TravelHistoryEntry> fromTableColumn;
    @javafx.fxml.FXML
    private TableColumn <String, TravelHistoryEntry> toTableColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn <String, TravelHistoryEntry>countryColumnView;
    @javafx.fxml.FXML
    private TextField applicantIDTextFields;
    @javafx.fxml.FXML
    private Label statusLabel;


    @javafx.fxml.FXML
    public void initialize() {
        if (statusLabel != null) statusLabel.setText("Enter application ID.");
        toDatePicker.setValue(LocalDate.of(2000, 1,1));
        toDatePicker.setValue(LocalDate.of(2000, 1,1));
        countryColumnView.setCellValueFactory(new PropertyValueFactory<>("country"));
        fromTableColumn.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        toTableColumn.setCellValueFactory(new PropertyValueFactory<>("toDate"));

    }



    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Applicant Dashboard");
        stage.setScene(scene);
        stage.show();
    }



    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {

        String country = (countryTextField.getText());
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();
        String applicantId = (applicantIDTextFields.getText());


        if (countryTextField.getText().isEmpty() || fromDatePicker == null || toDatePicker == null ||applicantIDTextFields.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation", "Country, from date, to date and applicant ID are required.");
            return;
        }


        if (!fromDatePicker.getValue().isBefore(toDatePicker.getValue())) {
            return;
        }
        showAlert(Alert.AlertType.ERROR, "Validation", "To-date must be same or after From-date.");
        return;
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

}

