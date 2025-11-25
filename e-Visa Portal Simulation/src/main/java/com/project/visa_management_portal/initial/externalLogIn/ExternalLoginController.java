package com.project.visa_management_portal.initial.externalLogIn;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ExternalLoginController {

    @javafx.fxml.FXML
    private TextField userNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private PasswordField internalUserPasswordField;
    @javafx.fxml.FXML
    private Button backBtn;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Applicant", "Registered Agent");
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Main Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void logInOnAction(ActionEvent actionEvent) throws IOException {
//        String comboVal = String.valueOf(userTypeComboBox.getItems());
//        if (Objects.equals(comboVal, "Applicant")) {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            stage.setTitle("Applicant Dashboard");
//            stage.setScene(scene);
//            stage.show();
//        }
//        else {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            stage.setTitle("Registered Agent Dashboard");
//            stage.setScene(scene);
//            stage.show();
//        }

        if (Objects.equals(userTypeComboBox.getValue(), "Applicant")){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Applicant Dashboard");
            stage.setScene(scene);
            stage.show();

        }if (Objects.equals(userTypeComboBox.getValue(), "Registered Agent")){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Registered Agent Dashboard");
            stage.setScene(scene);
            stage.show();
        }
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        stage.setTitle("Applicant Dashboard");
//        stage.setScene(scene);
//        stage.show();

    }
}