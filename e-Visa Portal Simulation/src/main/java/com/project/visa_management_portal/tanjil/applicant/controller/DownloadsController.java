package com.project.visa_management_portal.tanjil.applicant.controller;

import com.project.visa_management_portal.tanjil.DownloadReceipt;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class DownloadsController
{

    @javafx.fxml.FXML
    private TableColumn <DownloadReceipt, String> fileNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn <DownloadReceipt, String> typeTableColumn;
    @javafx.fxml.FXML
    private TableView <DownloadReceipt>  filesTableView;
    @javafx.fxml.FXML
    private TextField applicantIDTextField;
    @javafx.fxml.FXML
    private Label statusLabel;


    @javafx.fxml.FXML
    public void initialize() {

        fileNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<>("fileType"));



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
    public void fileDownloadOnAction(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        String applicantId = (applicantIDTextField.getText());

        if (applicantId.isEmpty()) {
            statusLabel.setText( "Input required, Please enter your Applicant ID to load receipts.");
        }

    }
}