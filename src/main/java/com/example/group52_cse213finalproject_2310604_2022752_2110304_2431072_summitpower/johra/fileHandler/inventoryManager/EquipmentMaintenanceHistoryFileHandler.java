package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.EquipmentMaintenanceHistory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class EquipmentMaintenanceHistoryFileHandler {

    private static final String FILE_PATH = "data/johra/inventoryManager/equipmentMaintenanceHistoryFileHandler.bin";
    public static void save(EquipmentMaintenanceHistory equipmentMaintenanceHistory) {
        ObservableList<EquipmentMaintenanceHistory> list = readAll();
        list.add(equipmentMaintenanceHistory);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<EquipmentMaintenanceHistory> readAll() {

        File file = new File(FILE_PATH);
        if (!file.exists()||file.length()==0) {
            return FXCollections.observableArrayList();
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<EquipmentMaintenanceHistory> list = (ArrayList<EquipmentMaintenanceHistory>) ois.readObject();
            ois.close();
            return FXCollections.observableArrayList(list);
        }catch (Exception e){
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }

    }
}
