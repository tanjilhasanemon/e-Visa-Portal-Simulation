package com.project.visa_management_portal;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitch {

    public static void SceneSwitcher(Node sourceNode,String userName, String fxmlFileName, String title) throws IOException {
            FXMLLoader loader = new FXMLLoader(com.project.visa_management_portal.SceneSwitch.class.getResource("/dsit/pmfinal/meddy/"+ userName +"/"+ fxmlFileName));
            Parent root = loader.load();

            Stage stage = (Stage) sourceNode.getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

