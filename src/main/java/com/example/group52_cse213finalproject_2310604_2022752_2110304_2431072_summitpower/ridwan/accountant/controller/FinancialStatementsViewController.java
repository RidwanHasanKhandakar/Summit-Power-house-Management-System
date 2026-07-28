package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.FinancialStatement;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class FinancialStatementsViewController
{
    @javafx.fxml.FXML
    private TableView <FinancialStatement> finalcialStatementTableView;
    @javafx.fxml.FXML
    private Label totalRevLabel;
    @javafx.fxml.FXML
    private DatePicker fromDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <FinancialStatement,Double> amountCol;
    @javafx.fxml.FXML
    private ComboBox <String> statementTypeComboBox;
    @javafx.fxml.FXML
    private Label netProfitLabel;
    @javafx.fxml.FXML
    private TableColumn <FinancialStatement,String> categoryCol;
    @javafx.fxml.FXML
    private TextArea statementPreviewTextArea;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <FinancialStatement,String> accountCol;
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

        //accountCol.setCellValueFactory(new PropertyValueFactory<>(""));
        accountCol.setCellValueFactory(new PropertyValueFactory<>("statementId"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant","accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleGenStatement(ActionEvent actionEvent) {
    }
}