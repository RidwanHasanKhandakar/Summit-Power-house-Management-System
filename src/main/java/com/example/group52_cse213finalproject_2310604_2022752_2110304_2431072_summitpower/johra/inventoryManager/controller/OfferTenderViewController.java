package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Tender;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;

public class OfferTenderViewController
{
    @javafx.fxml.FXML
    private TextField equipmentNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Tender, String> equipmentCol;
    @javafx.fxml.FXML
    private TableColumn<Tender, LocalDate> closingDateCol;
    @javafx.fxml.FXML
    private TextField tenderIdTextField;
    @javafx.fxml.FXML
    private DatePicker closingDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Tender, String> tenderIdCol;
    @javafx.fxml.FXML
    private TextField tenderTitleTextField;
    @javafx.fxml.FXML
    private TableView<Tender> showTenderTableView;
    @javafx.fxml.FXML
    private TableColumn<Tender, String> tenderTitleCol;

    @javafx.fxml.FXML
    public void initialize() {

        if(tenderIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(tenderTitleTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(equipmentNameTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(closingDateDatePicker == null){
            showError("Field cannot be empty");
        }

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboardView.fxml", "Inventory Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void createTenderButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTableView(ActionEvent actionEvent) {
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

        tenderIdTextField.clear();
        tenderTitleTextField.clear();
        equipmentNameTextField.clear();
        closingDateDatePicker.setValue(null);

    }
}