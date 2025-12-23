package com.project.visa_management_portal.rifat.modification.ModelClass;

import javafx.scene.control.Alert;

public class Account {
    public String accountNumber;
    public String balance;
    public double interestRate;
    public String minimumBalance;
    public String status;

    public static void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

}


