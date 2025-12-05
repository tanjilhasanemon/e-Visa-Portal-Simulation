package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AgentDashboardController
{
    @javafx.fxml.FXML
    private Label statusLabel;


    @javafx.fxml.FXML
    public void initialize() {


    }
    private void showAlert(String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Navigation Error");
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void manageClientPaymentsOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/ClientPayments.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Client Payment");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Unable to open Client Payment Dashboard.");
        }

    }

    @javafx.fxml.FXML
    public void applyVisaForClientOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/Agent_ClientApplication.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Client Visa Apply");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Client Visa Apply Dashboard.");
        }

    }

    @Deprecated
    public void contactSupportOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/DeleteAndUpdateClients.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Client Support");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Client Support Dashboard.");
        }
    }



    @javafx.fxml.FXML
    public void checkAplicationStatusOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/Agent_TrackClientsApplications.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Client Application Status");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Client Application Status Dashboard.");
        }

    }


    @javafx.fxml.FXML
    public void clientTravelHistoryOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/Agent_AddTravelHistory.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Client Travel History");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Client Travel History Dashboard.");
        }

    }


    @javafx.fxml.FXML
    public void createClientProfileOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/Agent_CreateClient.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Create Client");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Create Client Dashboard.");
        }

    }

    @javafx.fxml.FXML
    public void signOutOnAction(ActionEvent actionEvent)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Main Dashboard.");
        }

    }


    @javafx.fxml.FXML
    public void CheckClientListOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/AgentClientList.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Client List");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Client List Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void viewClientApplicationsSummeryOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/ViewClientApplicationSummery.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Client Application Summery");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Client Application Summery Dashboard.");
        }
    }


    public void receiveAgentName(String agentName){
        statusLabel.setText("Welcome " + agentName + " to Registered Agent Dashboard");
    }

    @javafx.fxml.FXML
    public void deleteAndUpdateClientsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/DeleteAndUpdateClients.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Delete And Update Clients");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Unable to open Delete And Update Clients Dashboard.");
        }
    }
}