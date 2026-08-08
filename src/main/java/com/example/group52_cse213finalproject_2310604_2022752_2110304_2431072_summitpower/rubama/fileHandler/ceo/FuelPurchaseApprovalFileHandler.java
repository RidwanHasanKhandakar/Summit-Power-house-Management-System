package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.FuelPurchaseApproval;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class FuelPurchaseApprovalFileHandler {

    private static final String FILE_PATH =
            "data/rubama/ceo/fuelPurchaseApproval.bin";

    public static void save(FuelPurchaseApproval fuelPurchaseApproval) {

        ObservableList<FuelPurchaseApproval> list = readAll();
        list.add(fuelPurchaseApproval);

        saveAll(list);
    }

    public static void saveAll(
            ObservableList<FuelPurchaseApproval> fuelPurchaseApprovals) {

        File file = new File(FILE_PATH);
        File parentDirectory = file.getParentFile();

        if (parentDirectory != null && !parentDirectory.exists()) {
            parentDirectory.mkdirs();
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(new ArrayList<>(fuelPurchaseApprovals));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<FuelPurchaseApproval> readAll() {

        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            return FXCollections.observableArrayList();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            ArrayList<FuelPurchaseApproval> list =
                    (ArrayList<FuelPurchaseApproval>) ois.readObject();

            return FXCollections.observableArrayList(list);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }
}