package com.project.visa_management_portal.rifat.modification.ModelClass;

import com.project.visa_management_portal.AppendableObjectOutputStream;
import com.project.visa_management_portal.rifat.operationManager.modelClass.ApplicationsRifat;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;

import static com.project.visa_management_portal.rifat.modification.ModelClass.Account.showAlert;

public class AccountController
{
    @javafx.fxml.FXML
    private TableColumn<Account, String> colAcct;
    @javafx.fxml.FXML
    private TableColumn<Account, String> col_Balance;
    @javafx.fxml.FXML
    private TextField accountTF;
    @javafx.fxml.FXML
    private ComboBox<String> activeStat_CMB;
    @javafx.fxml.FXML
    private TableColumn<Account, String> col_interestRate;
    @javafx.fxml.FXML
    private TableView<Account> tbl_VIew;
    ArrayList<Account> accountArrayList;
    public void initialize() {
        activeStat_CMB.getItems().addAll("Active", "Deactivate");

        colAcct.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        col_Balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        col_interestRate.setCellValueFactory(new PropertyValueFactory<>("interestRate"));

        accountArrayList = new ArrayList<>();
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            File file = new File("AccountList.bin");
            if(file.exists()){
                fos = new FileOutputStream(file , true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            for (Account app: accountArrayList){
                oos.writeObject(app);
            }
            oos.close();
        } catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void showAccountOnActionBtn(ActionEvent actionEvent) {
        tbl_VIew.getItems().clear();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("AccountList.bin");
            if (file.exists()) {
                fis = new FileInputStream(file);
            }
            else{
                showAlert("Error", "File does not exist");
            }
            if(fis!=null)ois = new ObjectInputStream(fis);
            while (true) {
                tbl_VIew.getItems().add((accountArrayListView) ois.readObject());
            }
        } catch (Exception e){
            //
        }
    }
}