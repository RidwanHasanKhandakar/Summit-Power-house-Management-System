package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.TrackFuel;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.TrackFuelFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import javax.sound.midi.Track;
import java.time.LocalDate;

public class TrackFuelViewController
{
    @javafx.fxml.FXML
    private DatePicker expenseDateDatePicker;
    @javafx.fxml.FXML
    private Text totalExpensesText;
    @javafx.fxml.FXML
    private TableColumn <TrackFuel,Double> amountCol;
    @javafx.fxml.FXML
    private TableColumn <TrackFuel, LocalDate> dateCol;
    @javafx.fxml.FXML
    private ComboBox <String> expenseCategoryComboBox;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TableView <TrackFuel> operationalExpensesTableView;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private TableColumn <TrackFuel,Integer> expenseIDCol;
    @javafx.fxml.FXML
    private TableColumn <TrackFuel,String> categoryCol;

    //private int expenseCounter = 1;

    @javafx.fxml.FXML
    public void initialize() {

        expenseCategoryComboBox.getItems().addAll(
                "All",
                "Fuel",
                "Maintenance",
                "Utility",
                "Other");

        expenseIDCol.setCellValueFactory(new PropertyValueFactory<>("expenseId"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("expenseDate"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        ObservableList<TrackFuel> list = TrackFuelFileHandler.readAll();
        operationalExpensesTableView.setItems(list);

        calculateTotalExpenses();

    }

    @javafx.fxml.FXML
    public void handleUpdateButton(ActionEvent actionEvent) {

        TrackFuel selected = operationalExpensesTableView.getSelectionModel().getSelectedItem();
        if (selected==null){
            showErr("Please select an expense to update.");
            return;
        }
        if (expenseCategoryComboBox.getValue()==null||amountTextField.getText().isEmpty()||descriptionTextArea.getText().isEmpty()||expenseDateDatePicker.getValue()==null){
            showErr("Please fill in all fields.");
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(amountTextField.getText().trim());
        } catch (NumberFormatException e) {
            showErr("Please enter a valid number for the amount.");
            return;
        }

        if (amount<=0){
            showErr("Amount must be greater than zero.");
            return;
        }

        selected.setCategory(expenseCategoryComboBox.getValue());
        selected.setDescription(descriptionTextArea.getText().trim());
        selected.setAmount(amount);
        selected.setExpenseDate(expenseDateDatePicker.getValue());

        ObservableList<TrackFuel> allExpenses = operationalExpensesTableView.getItems();
        TrackFuelFileHandler.overwrite(allExpenses);
        operationalExpensesTableView.refresh();
        calculateTotalExpenses();
        showSuc("Expense updated successfully!");

    }

    @javafx.fxml.FXML
    public void handleDeleteBurtton(ActionEvent actionEvent) {

        TrackFuel selected = operationalExpensesTableView.getSelectionModel().getSelectedItem();
        if (selected==null){
            showErr("Please select an expense.");
            return;
        }

        ObservableList<TrackFuel> list = FXCollections.observableArrayList(operationalExpensesTableView.getItems());
        list.remove(selected);
        TrackFuelFileHandler.overwrite(list);
        operationalExpensesTableView.setItems(TrackFuelFileHandler.readAll());
        calculateTotalExpenses();
        showSuc("Expense deleted successfully!");

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        expenseCategoryComboBox.getSelectionModel().clearSelection();
        amountTextField.clear();
        descriptionTextArea.clear();
        expenseDateDatePicker.setValue(null);

        operationalExpensesTableView.getSelectionModel().clearSelection();

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml", "Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleAddExpenseButton(ActionEvent actionEvent) {

        if (expenseCategoryComboBox.getValue() == null || expenseDateDatePicker.getValue() == null || amountTextField.getText().isEmpty()||descriptionTextArea.getText().isEmpty()) {
            showErr("Please fill in all fields.");
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(amountTextField.getText());
        } catch (NumberFormatException e) {
            showErr("Please enter a valid number for the amount.");
            return;
        }

        if (amount<=0){
            showErr("Amount must be greater than zero.");
            return;
        }

        TrackFuel ex = new TrackFuel(
                expenseCategoryComboBox.getValue(),
                descriptionTextArea.getText().trim(),
                amount,
                expenseDateDatePicker.getValue()
        );

        TrackFuelFileHandler.save(ex);
        operationalExpensesTableView.setItems(TrackFuelFileHandler.readAll());
        calculateTotalExpenses();
        showSuc("Expenses added successfully!");
        handleClearButton(null);

    }

    public void showErr (String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    public void showSuc (String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    private void calculateTotalExpenses() {
        double total = 0;
        for (TrackFuel ex: operationalExpensesTableView.getItems()) {
            total+=ex.getAmount();
        }
        totalExpensesText.setText(String.format("%.2f",total));
    }

}