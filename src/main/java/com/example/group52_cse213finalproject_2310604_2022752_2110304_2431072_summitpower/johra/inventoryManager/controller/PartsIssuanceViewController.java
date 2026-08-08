package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.OfferTenderFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.PartsIssuanceFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.PartsIssuance;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PartsIssuanceViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> equipmentIdComboBox;
    @javafx.fxml.FXML
    private DatePicker issueDateDatePicker;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private TextField requesterEmployeeIdTextField;
    @javafx.fxml.FXML
    private TableColumn<PartsIssuance, String> requesterEmployeeIdCol;
    @javafx.fxml.FXML
    private TableColumn<PartsIssuance, String> equipmentIdCol;
    @javafx.fxml.FXML
    private TableView<PartsIssuance> showTableView;
    @javafx.fxml.FXML
    private TableColumn<PartsIssuance, String> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<PartsIssuance, String> issueDateCol;

    @javafx.fxml.FXML
    public void initialize() {

        equipmentIdComboBox.getItems().addAll(
                "100",
                "101",
                "102",
                "103",
                "104"
        );

        requesterEmployeeIdCol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        equipmentIdCol.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        issueDateCol.setCellValueFactory(new PropertyValueFactory<>("issueDate"));

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent  actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboard-view.fxml", "Inventory Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void savePartsIssuanceButtonOnAction(ActionEvent actionEvent) {

        if(equipmentIdComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(requesterEmployeeIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(quantityTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(issueDateDatePicker.getValue() == null ){
            showError("Field cannot be empty");
            return;
        }

        if(issueDateDatePicker.getValue().isAfter(LocalDate.now())){
            showError("Issue date cannot be in future !");
            return;
        }

        PartsIssuance partsIssuance = new PartsIssuance(requesterEmployeeIdTextField.getText(), quantityTextField.getText(), equipmentIdComboBox.getValue(), issueDateDatePicker.getValue());

        PartsIssuanceFileHandler.save(partsIssuance);

        showInformation("PartsIssuance created successfully !");

    }

    @javafx.fxml.FXML
    public void loadTableView(ActionEvent actionEvent) {

        showTableView.setItems(PartsIssuanceFileHandler.readAll());

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

        equipmentIdComboBox.setValue(null);
        requesterEmployeeIdTextField.clear();
        quantityTextField.clear();
        issueDateDatePicker.setValue(null);

    }
}