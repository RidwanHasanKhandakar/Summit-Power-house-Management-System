package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.SynchronizeGenWNationalGrid;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class SynchronizeGenWNationalGridFileHandler {
    private static final String FILE_PATH =
            "data/samia/gridOperator/SynchronizeGenWNationalGrid.bin";

    public static void save(SynchronizeGenWNationalGrid synchronizeGenWNationalGrid) {

        ObservableList<SynchronizeGenWNationalGrid> list = readAll();
        list.add(synchronizeGenWNationalGrid);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ObservableList<SynchronizeGenWNationalGrid> readAll() {

        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            return FXCollections.observableArrayList();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<SynchronizeGenWNationalGrid> list =
                    (ArrayList<SynchronizeGenWNationalGrid>) ois.readObject();
            ois.close();

            return FXCollections.observableArrayList(list);

        } catch (Exception e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }
}
