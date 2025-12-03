package com.project.visa_management_portal.initial.externalLogIn;
import com.project.visa_management_portal.ExternalUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;

public class ExternalLoginController {

    @FXML
    private ComboBox <String> userTypeComboBox;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        userTypeComboBox.getItems().clear();
        userTypeComboBox.getItems().addAll("Applicant", "Registered Agent");
    }



    @FXML
    public ExternalUser logInOnAction(ActionEvent actionEvent) {
        String role = userTypeComboBox.getValue();
        String email = (emailTextField.getText());
        String password = passwordField.getText();


        if (role == null || role.isEmpty()) {
            showAlert("Validation", "Please select a user type.");

        }
        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Validation", "Please enter both email and password.");
        }

        //Initial User
        ExternalUser targetUser = null;



        if (Objects.equals(role, "Applicant")){
            ArrayList <ExternalUser> getApplicants = new ArrayList<>();
            
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            File f = new File("Applicants.bin");

            try{
                if(f.exists()){
                    fis = new FileInputStream(f);
                }
                else{
                    showAlert("File Error.", "Error to reading file.");
                }
                if(fis!=null)ois = new ObjectInputStream(fis);

                while (true){
                    getApplicants.add((ExternalUser)ois.readObject());
                }
            } catch (Exception e) {
                try {
                    ois.close();
                } catch (IOException _) {
                }
            }

            boolean userFound = false;
            for(ExternalUser a : getApplicants) {
                String eml = emailTextField.getText();
                String pass = passwordField.getText();

                if (Objects.equals(eml, a.getEmail()) && Objects.equals(pass, a.getPassword())) {
                    targetUser = a;
                    userFound = true;
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/applicant/Applicant_Dashboard.fxml"));
                        Scene scene = new Scene(loader.load());
                        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        stage.setTitle("Applicant Dashboard");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException _) {
                        showAlert("Scene error", "Unable to open Dashboard.");
                    }
                    break;}
                }
            if (!userFound) {
                showAlert("Login Failed", "User not Found");
            }
        }



        else if (Objects.equals(role, "Registered Agent")) {
                ArrayList<ExternalUser> getAgents = new ArrayList<>();

                FileInputStream fis = null;
                ObjectInputStream ois = null;
                File f = new File("Agents.bin");


                try {
                    if (f.exists()) {
                        fis = new FileInputStream(f);
                    } else {
                        showAlert("File Error.", "Error to reading file.");
                        return null;
                    }
                    if (fis != null) ois = new ObjectInputStream(fis);

                    while (true) {
                            getAgents.add((ExternalUser) ois.readObject());
                    }
                } catch (Exception e) {
                    try {
                        assert ois != null;
                        ois.close();
                    } catch (IOException _) {
                        //
                    }
                }


                boolean userFound = false;
                for (ExternalUser r : getAgents) {
                    String eml = emailTextField.getText();
                    String pass = passwordField.getText();

                    if (Objects.equals(eml, r.getEmail()) && Objects.equals(pass, r.getPassword())) {
                        targetUser = r;
                        userFound = true;
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/tanjil/registeredAgent/RegisteredAgentDashboard.fxml"));
                            Scene scene = new Scene(loader.load());
                            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                            stage.setTitle("Registered Agent Dashboard");
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException _) {
                            showAlert("Scene error", "Unable to open Dashboard.");
                        }
                        break;
                    }
                    }
            if(!userFound) {
                showAlert("Login Failed", "User not Found");
                }
            }


        return targetUser;
    }



    @FXML
    public void backOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/initial/mainDashboard/MainDashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Scene error", "Unable to open Main Dashboard.");
        }
    }




    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}

