package com.project.visa_management_portal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("initial/mainDashboard/MainDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("e-Visa management portal");
        stage.setScene(scene);
        stage.show();
    }
}
