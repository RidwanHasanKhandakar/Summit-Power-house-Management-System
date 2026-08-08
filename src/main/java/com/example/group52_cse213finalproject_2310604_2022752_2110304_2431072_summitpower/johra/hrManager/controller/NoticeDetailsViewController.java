package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.JohraSceneSwitch;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.CreateNoticeFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Notice;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDate;

public class NoticeDetailsViewController
{
    @javafx.fxml.FXML
    private Label noticeIdLabel;
    @javafx.fxml.FXML
    private Label publishDateLabel;
    @javafx.fxml.FXML
    private Label contentLabel;
    @javafx.fxml.FXML
    private Label subjectLabel;
    @javafx.fxml.FXML
    private Label expiryDateLabel;
    @javafx.fxml.FXML
    private Label createdByLabel;

    @javafx.fxml.FXML
    public void initialize() {

        Notice notice = CreateNoticeFileHandler.readAll().getLast();

        noticeIdLabel.setText(notice.getNoticeId());
        subjectLabel.setText(notice.getSubject());
        publishDateLabel.setText(notice.getPublishDate().toString());
        expiryDateLabel.setText(notice.getExpiryDate().toString());
        createdByLabel.setText(notice.getCreatedBy());
        contentLabel.setText(notice.getContent());

    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        JohraSceneSwitch.johraSceneSwitch((Node) actionEvent.getSource(), "hrManager", "createNotice-view.fxml", "Notice Details");
    }

}