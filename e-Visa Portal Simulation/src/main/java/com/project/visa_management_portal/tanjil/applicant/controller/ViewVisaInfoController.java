package com.project.visa_management_portal.tanjil.applicant.controller;
import com.project.visa_management_portal.tanjil.applicant.modelClass.VisaInfoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewVisaInfoController {

    @FXML
    private TextArea visaInformationTextArea;
    @FXML
    private ComboBox<String> visaTypeComboBox;

    private final VisaInfoModel model = new VisaInfoModel();

    @FXML
    public void initialize() {
        visaTypeComboBox.getItems().clear();
        visaTypeComboBox.getItems().addAll(model.getAvailableVisaTypes());
    }

    @FXML
    public void loadOnAction(ActionEvent actionEvent) {
        String selected = visaTypeComboBox.getValue();
        if (selected == null || selected.isBlank()) {
            showAlert("Please select a visa type to view information.");
            return;
        }
        visaInformationTextArea.setText(model.viewVisaInfo(selected));
    }

    @FXML
    public void backToMainOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Applicant Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Applicant Dashboard.");
        }

    }

    private void showAlert(String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }


}
