package com.project.visa_management_portal.initial.mainDashboard;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController
{

    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

            statusLabel.setText("Welcome to the Main Dashboard.");
    }



    @javafx.fxml.FXML
    public void signUpOnAction(ActionEvent actionEvent)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/signUp/ExternalSignUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Sign UP");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e){
            statusLabel.setText("Unable to open sign up scene.");
        }

    }

    @javafx.fxml.FXML
    public void forgotPasswordOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/forgotPassword/ForgetPassword.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Forgot Password");
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            statusLabel.setText("Unable to open forgot password Scene.");
        }


    }

    @javafx.fxml.FXML
    public void internalUserLoginOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/internalLogin/InternalLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Internal User Login");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            statusLabel.setText("Unable to open internal user login scene.");
        }

    }

    @javafx.fxml.FXML
    public void externalUserLoginOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/externalLogin/ExternalLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("External User Login");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            statusLabel.setText("Unable to open external user login.");
        }

    }

}


