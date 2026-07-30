package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Candidate;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CandidateSelectionViewController
{
    @javafx.fxml.FXML
    private TableColumn<String, Candidate> candidateIdCol;
    @javafx.fxml.FXML
    private TableColumn<String, Candidate> candidateNameCol;
    @javafx.fxml.FXML
    private TableView<Candidate> showCandidateTableView;
    @javafx.fxml.FXML
    private TableColumn<Boolean, Candidate> candidateStatusCol;
    @javafx.fxml.FXML
    private CheckBox candidateNotSelectCheckBox;
    @javafx.fxml.FXML
    private TextField candidateIdTextField;
    @javafx.fxml.FXML
    private CheckBox selectCandidateCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchCandidateButtonOnAction(ActionEvent actionEvent) {
    }
}