package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Vendor;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class VendorManagementViewController
{
    @javafx.fxml.FXML
    private TextField vendorIdTextField;
    @javafx.fxml.FXML
    private TableColumn<Vendor, String> vendorNameCol;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TableView<Vendor> showTableView;
    @javafx.fxml.FXML
    private TableColumn<Vendor, String> emailCol;
    @javafx.fxml.FXML
    private TextField vendorNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Vendor, String> suppliedEquipmentCol;
    @javafx.fxml.FXML
    private TableColumn<Vendor, String> vendorIdCol;
    @javafx.fxml.FXML
    private TextField suppliedEquipmentTextField;

    @javafx.fxml.FXML
    public void initialize() {

        vendorIdCol.setCellValueFactory(new PropertyValueFactory<>("vendorId"));
        vendorNameCol.setCellValueFactory(new PropertyValueFactory<>("vendorName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        suppliedEquipmentCol.setCellValueFactory(new PropertyValueFactory<>("suppliedEquipment"));

    }

    ArrayList<Vendor> vendorList  = new ArrayList<>();

    @javafx.fxml.FXML
    public void createVendorButtonOnAction(ActionEvent actionEvent) {

        if(vendorIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(vendorNameTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(emailTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(suppliedEquipmentTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        Vendor vendor = new Vendor(vendorIdTextField.getText(), vendorNameTextField.getText(), emailTextField.getText(), suppliedEquipmentTextField.getText());

        vendorList.add(vendor);

        showInformation("Vendor information recorded successfully !");
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboard-view.fxml", "Inventory Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {

        showTableView.getItems().addAll(vendorList);
    }

    public void showInformation(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Success");
        alert.setContentText(text);
        alert.showAndWait();
    }

    public void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {

        vendorIdTextField.clear();
        vendorNameTextField.clear();
        suppliedEquipmentTextField.clear();
        emailTextField.clear();

    }
}