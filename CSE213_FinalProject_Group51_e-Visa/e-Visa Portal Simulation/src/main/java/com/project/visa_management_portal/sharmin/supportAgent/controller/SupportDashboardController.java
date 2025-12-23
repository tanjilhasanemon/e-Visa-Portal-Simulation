package com.project.visa_management_portal.sharmin.supportagent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class SupportDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }
    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void escalateTicketsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/supportagent/EscalateTicket.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("escalate Tickets");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open escalate Tickets Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void searchTicketsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/supportagent/SearchTickets.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("search Tickets");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open search Tickets Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void viewTicketsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/supportagent/ViewTickets.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("viewTickets");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open  view Tickets Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void respondTicketButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/supportagent/RespondTicket.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("respondTicket");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open  respondTicket Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void signoutButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            showAlert("Scene error", "Unable to open Main Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void generateSupportReportButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/supportagent/GenerateSupportReport.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("generateSupportReport");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open generateSupportReport Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void sendFeedbackButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/supportagent/SendFeedback.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("sendFeedback");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open sendFeedback Dashboard.");
        }
    }

    @javafx.fxml.FXML
    public void closeTicketButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/sharmin/supportagent/CloseTicket.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("closeTicket");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open closeTicket Dashboard.");
        }
    }
}