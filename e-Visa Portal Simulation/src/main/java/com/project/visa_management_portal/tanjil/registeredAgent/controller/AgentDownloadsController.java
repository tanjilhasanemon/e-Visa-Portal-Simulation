package com.project.visa_management_portal.tanjil.registeredAgent.controller;

import com.project.visa_management_portal.tanjil.DownloadReceipt;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AgentDownloadsController
{

    @javafx.fxml.FXML
    private TableView <DownloadReceipt> agentDownloadsTableView;
    @javafx.fxml.FXML
    private TableColumn <DownloadReceipt , String> documentIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn <DownloadReceipt , String>nameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DownloadReceipt , String> typeTableColumn;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextField applicationIdTextField;


    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void downloadOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Registered Agent Dashboard");
        stage.setScene(scene);
        stage.show();
    }



    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        String applicantId = (applicationIdTextField.getText());

        if (applicantId.isEmpty()) {
            statusLabel.setText( "Input required, Please enter your Applicant ID to load receipts.");
        }
    }
}