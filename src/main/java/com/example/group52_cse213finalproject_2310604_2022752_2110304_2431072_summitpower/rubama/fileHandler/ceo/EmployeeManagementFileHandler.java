package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.EmployeeManagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class EmployeeManagementFileHandler {

    private static final String FILE_PATH =
            "data/rubama/ceo/employeeManagement.bin";


    public static void save(EmployeeManagement employee) {

        if (employee == null) {
            return;
        }

        ObservableList<EmployeeManagement> list =
                readAll();

        list.add(employee);

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
                    new ArrayList<>(list)
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    public static void saveAll(
            ObservableList<EmployeeManagement> employees) {

        if (employees == null) {
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
                    new ArrayList<>(employees)
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    public static ObservableList<EmployeeManagement> readAll() {

        File file = new File(FILE_PATH);

        if (!file.exists() ||
                file.length() == 0) {

            return FXCollections.observableArrayList();
        }


        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            ArrayList<EmployeeManagement> list =
                    (ArrayList<EmployeeManagement>)
                            ois.readObject();

            return FXCollections.observableArrayList(list);

        } catch (IOException |
                 ClassNotFoundException e) {

            e.printStackTrace();

            return FXCollections.observableArrayList();
        }
    }
}
