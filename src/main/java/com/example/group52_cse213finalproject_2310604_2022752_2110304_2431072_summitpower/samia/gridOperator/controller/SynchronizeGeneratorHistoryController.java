package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.SynchronizeGenWNationalGridFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.SynchronizeGenWNationalGrid;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class SynchronizeGeneratorHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<SynchronizeGenWNationalGrid,String> idTabCol;
    @javafx.fxml.FXML
    private TableColumn<SynchronizeGenWNationalGrid,Double> genVoltTabCol;
    @javafx.fxml.FXML
    private TableColumn<SynchronizeGenWNationalGrid,LocalDate> synchroDateTabCol;
    @javafx.fxml.FXML
    private TableView<SynchronizeGenWNationalGrid> tableview;
    @javafx.fxml.FXML
    private TableColumn<SynchronizeGenWNationalGrid,String> synchroStatusTabCol;
    @javafx.fxml.FXML
    private TableColumn<SynchronizeGenWNationalGrid,String> synchroIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<SynchronizeGenWNationalGrid,Double> gridVoltTabCol;
    @javafx.fxml.FXML
    private TableColumn<SynchronizeGenWNationalGrid,String> gridSectionTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        synchroIdTabCol.setCellValueFactory(new PropertyValueFactory<>("synchronizationId"));
        idTabCol.setCellValueFactory(new PropertyValueFactory<>("generatorId"));
        genVoltTabCol.setCellValueFactory(new PropertyValueFactory<>("generatorVoltage"));
        gridVoltTabCol.setCellValueFactory(new PropertyValueFactory<>("gridVoltage"));
        synchroStatusTabCol.setCellValueFactory(new PropertyValueFactory<>("synchronizationStatus"));
        synchroDateTabCol.setCellValueFactory(new PropertyValueFactory<>("synchronizationDate"));
        gridSectionTabCol.setCellValueFactory(new PropertyValueFactory<>("gridSection"));
        tableview.setItems(SynchronizeGenWNationalGridFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "samia", "gridOperator", "synchronize-gen-w-national-grid-view.fxml", "Synchronize Generator"
    );
    }
}