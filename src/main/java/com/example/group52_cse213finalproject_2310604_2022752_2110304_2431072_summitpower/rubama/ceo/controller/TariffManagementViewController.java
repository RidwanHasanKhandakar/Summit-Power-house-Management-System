package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.TariffManagement;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.TariffManagementFileHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class TariffManagementViewController {

    @javafx.fxml.FXML
    private TableColumn<TariffManagement, LocalDate> dateCol;

    @javafx.fxml.FXML
    private ComboBox<String> customerTypeComboBox;

    @javafx.fxml.FXML
    private TableColumn<TariffManagement, String> customerTypeCol;

    @javafx.fxml.FXML
    private TableView<TariffManagement> tarrifTableView;

    @javafx.fxml.FXML
    private DatePicker setTariffDatePicker;

    @javafx.fxml.FXML
    private TableColumn<TariffManagement, Integer> tariffRateCol;

    @javafx.fxml.FXML
    private TextField setTariffRateTextField;


    @javafx.fxml.FXML
    public void initialize() {

        customerTypeComboBox.getItems().addAll(
                "Industrial Customer",
                "Residential Customer",
                "Commercial Customer"
        );

        customerTypeCol.setCellValueFactory(
                new PropertyValueFactory<>("customerType")
        );

        tariffRateCol.setCellValueFactory(
                new PropertyValueFactory<>("setTariffRate")
        );

        dateCol.setCellValueFactory(
                new PropertyValueFactory<>("setTariffDate")
        );

        loadTable();
    }


    private void loadTable() {

        tarrifTableView.setItems(
                TariffManagementFileHandler.readAll()
        );

        tarrifTableView.refresh();
    }


    @javafx.fxml.FXML
    public void handleSetTarrif(ActionEvent actionEvent) {

        String type = customerTypeComboBox.getValue();
        String rateText = setTariffRateTextField.getText().trim();
        LocalDate date = setTariffDatePicker.getValue();


        // Validation
        if (type == null || rateText.isEmpty() || date == null) {
            showError("Please fill in all fields.");
            return;
        }


        int rate;

        try {

            rate = Integer.parseInt(rateText);

        } catch (NumberFormatException e) {

            showError("Tariff rate must be a valid number.");
            return;
        }


        if (rate < 0) {

            showError("Tariff rate cannot be negative.");
            return;
        }


        TariffManagement tariff =
                new TariffManagement(type, rate, date);


        // Save permanently
        TariffManagementFileHandler.save(tariff);


        // Reload table
        loadTable();


        // Clear fields
        customerTypeComboBox.getSelectionModel().clearSelection();
        setTariffRateTextField.clear();
        setTariffDatePicker.setValue(null);


        showSuccess("Tariff set successfully.");
    }


    private void showError(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }


    private void showSuccess(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }


    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "rubama",
                "ceo",
                "ceo-dashboard-view.fxml",
                "CEO Dashboard"
        );
    }
}
