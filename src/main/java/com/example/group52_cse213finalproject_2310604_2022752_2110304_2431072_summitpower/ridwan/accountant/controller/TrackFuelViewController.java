package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class TrackFuelViewController
{
    @javafx.fxml.FXML
    private DatePicker expenseDateDatePicker;
    @javafx.fxml.FXML
    private Text totalExpensesText;
    @javafx.fxml.FXML
    private TableColumn amountCol;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private ComboBox <String> expenseCategoryComboBox;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TableView operationalExpensesTableView;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private TableColumn expenseIDCol;
    @javafx.fxml.FXML
    private TableColumn categoryCol;

    @javafx.fxml.FXML
    public void initialize() {

        expenseCategoryComboBox.getItems().addAll(
                "All",
                "Fuel",
                "Maintenance",
                "Utility",
                "Other");

    }

    @javafx.fxml.FXML
    public void handleUpdateButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDeleteBurtton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml", "Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleAddExpenseButton(ActionEvent actionEvent) {
    }
}