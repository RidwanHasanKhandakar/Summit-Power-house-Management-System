package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.CustomerComplaint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class CustomerComplaintFileHandler {

    private static final String FILE_NAME =
            "data/rubama/ceo/CustomerComplaint.bin";


    public static void save(CustomerComplaint complaint) {

        if (complaint == null) {
            return;
        }

        ObservableList<CustomerComplaint> list = readAll();

        list.add(complaint);

        File file = new File(FILE_NAME);

        File parentDirectory = file.getParentFile();

        if (parentDirectory != null && !parentDirectory.exists()) {
            parentDirectory.mkdirs();
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(file))) {

            oos.writeObject(new ArrayList<>(list));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    public static ObservableList<CustomerComplaint> readAll() {

        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            return FXCollections.observableArrayList();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            ArrayList<CustomerComplaint> list =
                    (ArrayList<CustomerComplaint>) ois.readObject();

            return FXCollections.observableArrayList(list);

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

            return FXCollections.observableArrayList();
        }
    }
}