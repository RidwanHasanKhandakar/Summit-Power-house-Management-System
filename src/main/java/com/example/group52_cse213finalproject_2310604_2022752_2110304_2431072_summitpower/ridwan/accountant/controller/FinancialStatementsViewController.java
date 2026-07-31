package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.FinancialStatement;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.FinancialStatementFileHandler;
import javafx.collections.ObservableList;
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
    private ComboBox <String> statementTypeComboBox;
    @javafx.fxml.FXML
    private Label netProfitLabel;
    @javafx.fxml.FXML
    private TextArea statementPreviewTextArea;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;
    @javafx.fxml.FXML
    private Label totalExpensesLabel;
    @javafx.fxml.FXML
    private TableColumn <FinancialStatement,Double> netProfitCol;
    @javafx.fxml.FXML
    private TableColumn <FinancialStatement,Double> ExpensesCol;
    @javafx.fxml.FXML
    private TableColumn <FinancialStatement,String> TypeCol;
    @javafx.fxml.FXML
    private TableColumn <FinancialStatement,Double> RevenueCol;
    @javafx.fxml.FXML
    private TableColumn <FinancialStatement,Integer> satementIDCol;

    private int statementCounter = 1;

    @javafx.fxml.FXML
    public void initialize() {

        statementTypeComboBox.getItems().addAll(
                "Income Statement",
                "Trial Balance",
                "Balance Sheet",
                "Cash Flow Statement"
        );

        //accountCol.setCellValueFactory(new PropertyValueFactory<>(""));
        satementIDCol.setCellValueFactory(new PropertyValueFactory<>("statementId"));
        netProfitCol.setCellValueFactory(new PropertyValueFactory<>("netProfit"));
        RevenueCol.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("statementType"));
        ExpensesCol.setCellValueFactory(new PropertyValueFactory<>("totalExpenses"));

        finalcialStatementTableView.setItems(FinancialStatementFileHandler.readAll());

        ObservableList<FinancialStatement> list = FinancialStatementFileHandler.readAll();

        finalcialStatementTableView.setItems(list);

        if(!list.isEmpty()){
            statementCounter = list.get(list.size()-1).getStatementId()+1;
        }

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        statementTypeComboBox.getSelectionModel().clearSelection();

        fromDateDatePicker.setValue(null);
        toDateDatePicker.setValue(null);

        totalRevLabel.setText("");
        totalExpensesLabel.setText("");
        netProfitLabel.setText("");

        statementPreviewTextArea.clear();

        finalcialStatementTableView.getSelectionModel().clearSelection();

//        if(!FinancialStatementFileHandler.readAll().isEmpty()){
//            statementCounter=FinancialStatementFileHandler.readAll().get(FinancialStatementFileHandler.readAll().size()-1).getStatementId()+1;
//        }

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant","accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        finalcialStatementTableView.setItems(FinancialStatementFileHandler.readAll());
        showInformation("Table Refreshed");

    }

    @javafx.fxml.FXML
    public void handleGenStatement(ActionEvent actionEvent) {

        if (statementTypeComboBox.getValue()==null){
            showError("Please select a statement type.");
            return;
        }

        if(fromDateDatePicker.getValue()==null){
            showError("Please select From date.");
            return;
        }
        if (toDateDatePicker.getValue()==null){
            showError("Please select to Date.");
            return;
        }
        if(fromDateDatePicker.getValue().isAfter(toDateDatePicker.getValue())){
            showError("From date cannot be after to date.");
            return;
        }

//        finalcialStatementTableView.getItems().clear();

        double rev = 250000000;
        double ex = 14200000;
        double profit = rev-ex;

        FinancialStatement statement = new FinancialStatement(statementCounter++,
                statementTypeComboBox.getValue(),
                fromDateDatePicker.getValue(),
                toDateDatePicker.getValue(),
                rev,
                ex,
                profit);

        FinancialStatementFileHandler.save(statement);
        finalcialStatementTableView.setItems(FinancialStatementFileHandler.readAll());

        //finalcialStatementTableView.getItems().clear();

        totalRevLabel.setText(String.format("%.2f",rev));
        totalExpensesLabel.setText(String.format("%.2f",ex));
        netProfitLabel.setText(String.format("%.2f",profit));

        statementPreviewTextArea.setText(
                "========== " + statement.getStatementType() + " ==========\n\n" +

                        "Reporting Period\n" +
                        statement.getFromDate() +
                        " to " +
                        statement.getToDate() +

                        "\n\nTotal Revenue : " +
                        String.format("%.2f", statement.getTotalRevenue()) +

                        "\nTotal Expenses : " +
                        String.format("%.2f", statement.getTotalExpenses()) +

                        "\nNet Profit : " +
                        String.format("%.2f", statement.getNetProfit()) +

                        "\n\nStatus : Generated Successfully"
        );

        showInformation("Financial Statement Generated Successfully!");

    }


    public void showError (String txt){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(txt);
        a.showAndWait();
    }

    public void showInformation(String txt){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information!");
        a.setHeaderText(null);
        a.setContentText(txt);
        a.showAndWait();
    }

}