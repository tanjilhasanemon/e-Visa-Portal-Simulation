package com.project.visa_management_portal.initial.internalLogIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InternalLoginController {

    @javafx.fxml.FXML
    private Button backBtn;

    @javafx.fxml.FXML
    private PasswordField internalUserPasswordField;

    @javafx.fxml.FXML
    private TextField internalUserIdTextField;

    @javafx.fxml.FXML
    private ComboBox<String> internalUserTypeComboBox;

    @javafx.fxml.FXML
    private Label loginMessageLabel;

    String[][] internalUserList = {
            {"employeeRole", "employeeID","password" },
            {"Visa Officer", "2500333", "33visa33"},
            {"Issuer", "2500444", "44issuer44"},
            {"Operation Manager", "2500555", "55operation55"},
            {"Policy Manager", "2500666", "66policy66"},
            {"Finance Clerk", "2210233", "bithe2001"},      // normalized role text
            {"Support Agent", "2210233", "bithe2001"}
    };

    @javafx.fxml.FXML
    public void initialize() {
        // populate combo with roles from the array (skip header row)
        for (int i = 1; i < internalUserList.length; i++) {
            internalUserTypeComboBox.getItems().add(internalUserList[i][0]);
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void logInOnAction(ActionEvent actionEvent){
        String selectedRole = internalUserTypeComboBox.getValue();
        String inputUserId = internalUserIdTextField.getText().trim();
        String inputPassword = internalUserPasswordField.getText().trim();

        loginMessageLabel.setText(""); // clear previous message

        if (selectedRole == null || selectedRole.isEmpty()) {
            loginMessageLabel.setText("Please select a user type.");
            return;
        }
        if (inputUserId.isEmpty() || inputPassword.isEmpty()) {
            loginMessageLabel.setText("Enter ID and password.");
            return;
        }

        boolean matched = false;

        // loop through internalUserList starting at row 1 (row 0 is header)
        for (int r = 1; r < internalUserList.length; r++) {
            String role = internalUserList[r][0];
            String id = internalUserList[r][1];
            String pw = internalUserList[r][2];

            if (Objects.equals(role, selectedRole) &&
                    Objects.equals(id, inputUserId) &&
                    Objects.equals(pw, inputPassword)) {

                matched = true;
                // open role-specific dashboard (use switch or map)
                openDashboardForRole(selectedRole, actionEvent);
                break;
            }
        }

        if (!matched) {
            loginMessageLabel.setText("Invalid credentials for selected role.");
        }
    }

    private void openDashboardForRole(String role, ActionEvent actionEvent) {
        String fxmlPath = null;

        // map roles to FXML paths - update these paths to your real files
        switch (role) {
            case "Visa Officer":
                fxmlPath = "/com/project/visa_management_portal/galib/visaOfficer/VisaOfficerDashboard.fxml";
                break;
            case "Issuer":
                fxmlPath = "/com/project/visa_management_portal/galib/issuer/issuer-Dashboard.fxml";
                break;
            case "Operation Manager":
                fxmlPath = "/com/project/visa_management_portal/rifat/operationManager/OperationManager_Dashboard.fxml";
                break;
            case "Policy Manager":
                fxmlPath = "/com/project/visa_management_portal/rifat/policyManager/policyManagerDashboard.fxml";
                break;
            case "Finance Clerk":
                fxmlPath = "/com/project/visa_management_portal/finance/FinanceDashboard.fxml";
                break;
            case "Support Agent":
                fxmlPath = "/com/project/visa_management_portal/support/SupportDashboard.fxml";
                break;
            default:
                showAlert("Config error", "No dashboard configured for role: " + role);
                return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle(role + " Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Scene error", "Unable to open " + role + " Dashboard.");
        }
    }

    public void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}
