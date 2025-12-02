package com.project.visa_management_portal.galib.visaOfficer;

import com.project.visa_management_portal.galib.model.ApplicantPassport;
import com.project.visa_management_portal.galib.model.ApplicationG;
import com.project.visa_management_portal.galib.model.GovtPassport;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class documentVerificationController
{
    @javafx.fxml.FXML
    private TextField inputAppIdForVerifyTextField;
    @javafx.fxml.FXML
    private TextArea txtNote;
    @javafx.fxml.FXML
    private TableColumn<GovtPassport, String> dummyPassportNoCol;
    @javafx.fxml.FXML
    private TableColumn<GovtPassport, String> dummyExpireDateCol;
    @javafx.fxml.FXML
    private TableView <GovtPassport>dummyPassportTableView;
    @javafx.fxml.FXML
    private TableColumn <ApplicationG, String>verifiedPassportNoCol;
    @javafx.fxml.FXML
    private TableColumn <GovtPassport, String>dummyFirstNameCol;
    @javafx.fxml.FXML
    private TableColumn <ApplicantPassport, String>applicationDobCol;
    @javafx.fxml.FXML
    private TableColumn <ApplicationG, String>verifiedPassportVerifiedCol;
    @javafx.fxml.FXML
    private TableColumn <GovtPassport, String>dummyIssuingCountryCol;
    @javafx.fxml.FXML
    private TableColumn <ApplicantPassport, String>applicationExpireDateCol;
    @javafx.fxml.FXML
    private TableColumn <ApplicantPassport, String>applicaationGenderCol;
    @javafx.fxml.FXML
    private TableColumn <GovtPassport, String>dummyGenderCol;
    @javafx.fxml.FXML
    private TableColumn <ApplicantPassport, String>applicationIssuingCountryCOl;
    @javafx.fxml.FXML
    private TableView <String>verifiedDocumentTableView;
    @javafx.fxml.FXML
    private TableColumn  <ApplicationG, String>verifiedPassportNoteCol;
    @javafx.fxml.FXML
    private TableColumn  <ApplicantPassport, String>applicationFirstNameCol;
    @javafx.fxml.FXML
    private TableColumn <ApplicantPassport, String>applicationPassportNoCol;
    @javafx.fxml.FXML
    private TableColumn  <ApplicationG, String>verifiedAppplicationNameCol;
    @javafx.fxml.FXML
    private TableColumn  <ApplicationG, String>verifiedAppIdCol;
    @javafx.fxml.FXML
    private TableColumn <GovtPassport, String>dummyDobCol;
    @javafx.fxml.FXML
    private TableView<String> applicationPassportTableView;


    @javafx.fxml.FXML
    public void initialize() {

        dummyPassportNoCol.setCellValueFactory(new PropertyValueFactory<GovtPassport,String>("passportNo"));
        dummyIssuingCountryCol.setCellValueFactory(new PropertyValueFactory<GovtPassport, String>("issuingCountry"));
        dummyFirstNameCol.setCellValueFactory(new PropertyValueFactory<GovtPassport, String>("firstName"));
        dummyDobCol.setCellValueFactory(new PropertyValueFactory<GovtPassport, String>("dateOfBirth"));
        dummyGenderCol.setCellValueFactory(new PropertyValueFactory<GovtPassport,String>("gender"));
        dummyExpireDateCol.setCellValueFactory(new PropertyValueFactory<GovtPassport, String>("expireDate"));

        //dummyPassportTableView.getItems().addAll();

    }


    @javafx.fxml.FXML
    public void verifySelectedPassportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshListOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToMainDashboardOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/project/visa_management_portal/galib/visaOfficer/VisaOfficerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Visa Officer Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void loadApplicantPassportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadGovtPassportOnAction(ActionEvent actionEvent) {
        try {
            File file = new File("GovtPassport.bin");
            if (!file.exists()) {
                showAlert(Alert.AlertType.ERROR, "File Error", "GovtPassport.bin file not found at: " + file.getAbsolutePath());
                return;
            }

            dummyPassportTableView.getItems().clear(); // Clear previous data

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (true) {
                    try {
                        GovtPassport passport = (GovtPassport) ois.readObject();
                        dummyPassportTableView.getItems().add(passport);
                    } catch (java.io.EOFException e) {
                        break; // End of file reached
                    }
                }
            }

            System.out.println("Loaded " + dummyPassportTableView.getItems().size() + " passports"); // Debug output

        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load passports: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

//    @javafx.fxml.FXML
//    public void loadGovtPassportFromTXTOnAction(ActionEvent actionEvent) {
//        // Try multiple possible locations
//        File file = new File("GovtPassportList.txt");
//        if (!file.exists()) {
//            file = new File("src/main/resources/GovtPassportList.txt");
//        }
//        if (!file.exists()) {
//            file = new File(System.getProperty("user.dir") + File.separator + "GovtPassportList.txt");
//        }
//
//        if (!file.exists()) {
//            showAlert(Alert.AlertType.ERROR, "File Error", "GovtPassportList.txt file not found. Searched at: " + file.getAbsolutePath());
//            return;
//        }
//
//        dummyPassportTableView.getItems().clear();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) continue; // Skip empty lines
//
//                String[] parts = line.split(",");
//                if (parts.length == 6) {
//                    GovtPassport passport = new GovtPassport(
//                            parts[0].trim(),
//                            parts[1].trim(),
//                            parts[2].trim(),
//                            LocalDate.parse(parts[3].trim()),
//                            parts[4].trim(),
//                            LocalDate.parse(parts[5].trim())
//                    );
//                    dummyPassportTableView.getItems().add(passport);
//                }
//            }
//            System.out.println("Loaded " + dummyPassportTableView.getItems().size() + " passports from TXT");
//        } catch (Exception ex) {
//            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load passports from TXT: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }


    @javafx.fxml.FXML
    public void loadGovtPassportFromTXTOnAction(ActionEvent actionEvent) {
        // File search logic remains the same
        File file = new File("GovtPassportList.txt");
        if (!file.exists()) file = new File("src/main/resources/GovtPassportList.txt");
        if (!file.exists()) file = new File(System.getProperty("user.dir") + File.separator + "GovtPassportList.txt");

        if (!file.exists()) {
            showAlert(Alert.AlertType.ERROR, "File Error", "GovtPassportList.txt file not found.");
            return;
        }

        dummyPassportTableView.getItems().clear();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                // FIX: Remove the "GovtPassport{" prefix and "}" suffix
                String cleanLine = line.replace("GovtPassport{", "").replace("}", "");

                String[] parts = cleanLine.split(",");

                if (parts.length == 6) {
                    // FIX: Extract the value after the '=' sign and remove single quotes
                    GovtPassport passport = getGovtPassport(parts);
                    dummyPassportTableView.getItems().add(passport);
                }
            }
            System.out.println("Loaded " + dummyPassportTableView.getItems().size() + " passports from TXT");
        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load passports from TXT: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static @NotNull GovtPassport getGovtPassport(String[] parts) {
        String passportNo = parts[0].split("=")[1].replace("'", "").trim();
        String country = parts[1].split("=")[1].replace("'", "").trim();
        String firstName = parts[2].split("=")[1].replace("'", "").trim();

        // Date parts do not have single quotes in your text file
        String dobString = parts[3].split("=")[1].trim();

        String gender = parts[4].split("=")[1].replace("'", "").trim();
        String expireString = parts[5].split("=")[1].trim();

        GovtPassport passport = new GovtPassport(
                passportNo,
                country,
                firstName,
                LocalDate.parse(dobString), // Now this string is pure "1995-06-19"
                gender,
                LocalDate.parse(expireString)
        );
        return passport;
    }
}