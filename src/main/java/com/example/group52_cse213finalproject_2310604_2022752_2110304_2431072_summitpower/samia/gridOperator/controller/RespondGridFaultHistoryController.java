package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.RespondToGridFaultFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.RespondToGridFault;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class RespondGridFaultHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<RespondToGridFault,String> faultStatusTabCol;
    @javafx.fxml.FXML
    private TableColumn<RespondToGridFault,String> faultTypeTabCol;
    @javafx.fxml.FXML
    private TableColumn<RespondToGridFault,LocalDate> faultDateTabCol;
    @javafx.fxml.FXML
    private TableView<RespondToGridFault> tableview;
    @javafx.fxml.FXML
    private TableColumn<RespondToGridFault,String> gridSectionTabCol;
    @javafx.fxml.FXML
    private TableColumn<RespondToGridFault,String> responseActionTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        gridSectionTabCol.setCellValueFactory(new PropertyValueFactory<>("gridSection"));
        faultTypeTabCol.setCellValueFactory(new PropertyValueFactory<>("faultType"));
        faultDateTabCol.setCellValueFactory(new PropertyValueFactory<>("faultDate"));
        responseActionTabCol.setCellValueFactory(new PropertyValueFactory<>("responseAction"));
        faultStatusTabCol.setCellValueFactory(new PropertyValueFactory<>("faultStatus"));
        tableview.setItems(RespondToGridFaultFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "samia", "gridOperator", "respond-to-grid-fault-view.fxml","Respond To Grid Fault");
    }
}