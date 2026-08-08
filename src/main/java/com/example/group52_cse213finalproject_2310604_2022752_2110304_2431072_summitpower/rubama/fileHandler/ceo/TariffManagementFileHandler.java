package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.TariffManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class TariffManagementFileHandler {

    private static final String FILE_PATH =
            "data/rubama/ceo/tariffManagement.bin";

    public static void save(TariffManagement tariffManagement) {

        ObservableList<TariffManagement> list = readAll();
        list.add(tariffManagement);

        File file = new File(FILE_PATH);
        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(new ArrayList<>(list));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<TariffManagement> readAll() {

        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            return FXCollections.observableArrayList();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            ArrayList<TariffManagement> list =
                    (ArrayList<TariffManagement>) ois.readObject();

            return FXCollections.observableArrayList(list);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }
}