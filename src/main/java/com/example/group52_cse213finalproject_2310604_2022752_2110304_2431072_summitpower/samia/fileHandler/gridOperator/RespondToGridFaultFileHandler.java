package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.RespondToGridFault;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class RespondToGridFaultFileHandler {
    private static final String FILE_PATH =
            "data/samia/gridOperator/RespondToGridFault.bin";

    public static void save(RespondToGridFault respondToGridFault) {

        ObservableList<RespondToGridFault> list = readAll();
        list.add(respondToGridFault);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ObservableList<RespondToGridFault> readAll() {

        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            return FXCollections.observableArrayList();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<RespondToGridFault> list =
                    (ArrayList<RespondToGridFault>) ois.readObject();
            ois.close();

            return FXCollections.observableArrayList(list);

        } catch (Exception e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }
}
