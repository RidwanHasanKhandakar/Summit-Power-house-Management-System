package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.FinancialSummary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class FinancialSummaryFileHandler {

    private static final String FILE_PATH =
            "data/rubama/ceo/financialSummary.bin";


    public static void save(FinancialSummary financialSummary) {

        if (financialSummary == null) {
            return;
        }

        ObservableList<FinancialSummary> list =
                readAll();

        list.add(financialSummary);

        saveAll(list);
    }


    public static void saveAll(
            ObservableList<FinancialSummary> financialSummaries) {

        if (financialSummaries == null) {
            return;
        }

        File file = new File(FILE_PATH);

        File parentDirectory =
                file.getParentFile();

        if (parentDirectory != null &&
                !parentDirectory.exists()) {

            parentDirectory.mkdirs();
        }


        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(file))) {

            oos.writeObject(
                    new ArrayList<>(financialSummaries)
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    public static ObservableList<FinancialSummary> readAll() {

        File file = new File(FILE_PATH);

        if (!file.exists() ||
                file.length() == 0) {

            return FXCollections.observableArrayList();
        }


        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            ArrayList<FinancialSummary> list =
                    (ArrayList<FinancialSummary>)
                            ois.readObject();

            return FXCollections.observableArrayList(list);

        } catch (IOException |
                 ClassNotFoundException e) {

            e.printStackTrace();

            return FXCollections.observableArrayList();
        }
    }
}