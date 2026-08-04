package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.plant_manager;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.PowerGeneration;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.ShiftReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class ShiftReportFileHandler {
    private static final String FILE_PATH = "data/rubama/plant_manager/shiftReport.bin";
    public static void save(ShiftReport shiftReport) {
        ObservableList<ShiftReport> list = readAll();
        list.add(shiftReport);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<ShiftReport> readAll() {

        File file = new File(FILE_PATH);
        if (!file.exists()||file.length()==0) {
            return FXCollections.observableArrayList();
        }try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<ShiftReport> list = (ArrayList<ShiftReport>) ois.readObject();
            ois.close();
            return FXCollections.observableArrayList(list);
        }catch (Exception e){
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }

    }
}
