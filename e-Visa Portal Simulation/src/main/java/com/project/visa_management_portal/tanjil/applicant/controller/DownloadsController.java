package com.project.visa_management_portal.tanjil.applicant.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DownloadsController
{

    @javafx.fxml.FXML
    private TableColumn fileNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn typeTableColumn;
    @javafx.fxml.FXML
    private TableView filesTableView;
    @javafx.fxml.FXML
    private TextField applicantIDTextField;

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
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
    }
}