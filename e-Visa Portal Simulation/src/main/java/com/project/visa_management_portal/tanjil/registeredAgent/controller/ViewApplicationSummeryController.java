package com.project.visa_management_portal.tanjil.registeredAgent.controller;
import com.project.visa_management_portal.tanjil.VisaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ViewApplicationSummeryController
{

    @javafx.fxml.FXML
    private PieChart applicationsSummeryPieChart;

    int approvedCount, pendingCount, rejectedCount;
    public void countStatus() throws IOException {
        ArrayList<VisaApplication> visaApplications = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = new File("ClientApplications.bin");
        try{
            if(file.exists()) {
                fis = new FileInputStream(file);
            }
            else{
                showAlert("File Not Found", Alert.AlertType.WARNING, "Client applications file does not exist.");
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true){
                VisaApplication visa = (VisaApplication) ois.readObject();
                visaApplications.add(visa);
            }
        }catch (Exception e){
            try {
                ois.close();
            }catch (Exception _){
                showAlert("File Error", Alert.AlertType.ERROR, "Error closing the file.");
            }

        }

        for (VisaApplication va : visaApplications){
            if (va.getStatus().equals("Approved")) approvedCount++;
            else if (va.getStatus().equals("Pending")) pendingCount++;
            else if (va.getStatus().equals("Rejected")) rejectedCount++;
        }


    }


    @javafx.fxml.FXML
    public void initialize() throws IOException {
        countStatus();
        applicationsSummeryPieChart.getData().add(new PieChart.Data("Approved", approvedCount));
        applicationsSummeryPieChart.getData().add(new PieChart.Data("Pending", pendingCount));
        applicationsSummeryPieChart.getData().add(new PieChart.Data("Rejected", rejectedCount));
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
}