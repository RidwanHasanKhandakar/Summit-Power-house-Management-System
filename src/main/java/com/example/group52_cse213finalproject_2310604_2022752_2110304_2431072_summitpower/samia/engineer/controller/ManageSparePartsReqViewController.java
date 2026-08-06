package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.ManageSparePartsReq;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.ManageSparePartsReqFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ManageSparePartsReqViewController
{
    @javafx.fxml.FXML
    private TextField supplierNameTextField;
    @javafx.fxml.FXML
    private TextField partNameTextField;
    @javafx.fxml.FXML
    private DatePicker requestDatePicker;
    @javafx.fxml.FXML
    private TextField requestIdTextField;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private ComboBox<String> requestStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn<ManageSparePartsReq,String> partNameTabCol;
    @javafx.fxml.FXML
    private TableColumn<ManageSparePartsReq,String> requestIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<ManageSparePartsReq,String> requestStatusTabCol;
    @javafx.fxml.FXML
    private TableColumn<ManageSparePartsReq,String> supplierNameTabCol;
    @javafx.fxml.FXML
    private TableColumn<ManageSparePartsReq,LocalDate> requestDateTabCol;
    @javafx.fxml.FXML
    private TableView<ManageSparePartsReq> tableview;
    @javafx.fxml.FXML
    private TableColumn<ManageSparePartsReq,Integer> quantityTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        requestStatusComboBox.getItems().addAll(
                "Pending",
                "Approved",
                "Rejected"
        );
        requestIdTabCol.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        partNameTabCol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        quantityTabCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        supplierNameTabCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        requestDateTabCol.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        requestStatusTabCol.setCellValueFactory(new PropertyValueFactory<>("requestStatus"));
        tableview.setItems(ManageSparePartsReqFileHandler.readAll());
    }

    public void showSuccess(String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        requestIdTextField.clear();
        partNameTextField.clear();
        quantityTextField.clear();
        requestDatePicker.setValue(null);
        requestStatusComboBox.setValue(null);
        supplierNameTextField.clear();
        tableview.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if(requestIdTextField.getText().trim().isEmpty()){
            showError("Please enter Request ID.");
            return;
        }

        if(partNameTextField.getText().trim().isEmpty()){
            showError("Please enter Part Name.");
            return;
        }

        int quantity;

        try{
            quantity = Integer.parseInt(quantityTextField.getText().trim());

            if(quantity <= 0){
                showError("Quantity must be greater than 0.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter a valid Quantity.");
            return;
        }

        if(supplierNameTextField.getText().trim().isEmpty()){
            showError("Please enter Supplier Name.");
            return;
        }

        if(requestDatePicker.getValue() == null){
            showError("Please select Request Date.");
            return;
        }

        if(requestDatePicker.getValue().isBefore(LocalDate.now())){
            showError("Request Date cannot be in the past.");
            return;
        }

        if(requestStatusComboBox.getValue() == null){
            showError("Please select Request Status.");
            return;
        }
        ManageSparePartsReq request = new ManageSparePartsReq(requestIdTextField.getText().trim(),
                        partNameTextField.getText().trim(),
                        quantity,
                        supplierNameTextField.getText().trim(),
                        requestDatePicker.getValue(),
                        requestStatusComboBox.getValue());
        ManageSparePartsReqFileHandler.save(request);
        tableview.setItems(ManageSparePartsReqFileHandler.readAll());
        refreshButton(null);
        showSuccess("Spare Parts Request saved successfully.");
    }
}