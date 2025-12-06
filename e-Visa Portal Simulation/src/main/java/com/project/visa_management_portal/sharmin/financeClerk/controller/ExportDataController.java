package com.project.visa_management_portal.sharmin.financeclerk.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ExportDataController
{
    @javafx.fxml.FXML
    private RadioButton CSVRadiobutton;
    @javafx.fxml.FXML
    private RadioButton XLSXRadiobutton;
    ToggleGroup tg;

    @javafx.fxml.FXML
    public void initialize() {
        tg = new ToggleGroup();
        CSVRadiobutton.setToggleGroup(tg);
        XLSXRadiobutton.setToggleGroup(tg);
    }

    @javafx.fxml.FXML
    public void ExportButtonOnAction(ActionEvent actionEvent) {
        String format = "";

        if (CSVRadiobutton.isSelected())
            format = "CSV";
        else if (XLSXRadiobutton.isSelected())
            format = "XLSX";

         else {
            showAlert("Error", "Please select a format to export.");
        }
    }
    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}