package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class FinancialStatementsViewController
{
    @javafx.fxml.FXML
    private TableView finalcialStatementTableView;
    @javafx.fxml.FXML
    private Label totalRevLabel;
    @javafx.fxml.FXML
    private DatePicker fromDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn amountCol;
    @javafx.fxml.FXML
    private ComboBox <String> statementTypeComboBox;
    @javafx.fxml.FXML
    private Label netProfitLabel;
    @javafx.fxml.FXML
    private TableColumn categoryCol;
    @javafx.fxml.FXML
    private TextArea statementPreviewTextArea;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn accountCol;
    @javafx.fxml.FXML
    private Label totalExpensesLabel;

    @javafx.fxml.FXML
    public void initialize() {

        statementTypeComboBox.getItems().addAll(
                "Income Statement",
                "Trial Balance",
                "Balance Sheet",
                "Cash Flow Statement"
        );

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleGenStatement(ActionEvent actionEvent) {
    }
}