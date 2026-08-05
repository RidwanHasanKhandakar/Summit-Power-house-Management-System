package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.UpdateMaintenanceStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class UpdateMaintenanceStatusFileHandler {
    private static final String FILE_PATH = "data/samia/engineer/UpdateMaintenanceStatus.bin";

    public static void save(UpdateMaintenanceStatus maintenance) {

        ObservableList<UpdateMaintenanceStatus> list = readAll();

        list.add(maintenance);

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")
    public static ObservableList<UpdateMaintenanceStatus> readAll() {

        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {

            return FXCollections.observableArrayList();

        }

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<UpdateMaintenanceStatus> list = (ArrayList<UpdateMaintenanceStatus>) ois.readObject();
            ois.close();

            return FXCollections.observableArrayList(list);

        } catch (Exception e) {

            e.printStackTrace();

            return FXCollections.observableArrayList();

        }

    }
}
