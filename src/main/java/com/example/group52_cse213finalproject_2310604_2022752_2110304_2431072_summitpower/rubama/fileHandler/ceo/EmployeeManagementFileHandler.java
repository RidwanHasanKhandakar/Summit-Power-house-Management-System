package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.ComplaintSummary;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.EmployeeManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class EmployeeManagementFileHandler {
    private static final String FILE_PATH = "data/rubama/ceo/employeeManagement.bin";
    public static void save(EmployeeManagement employeeManagement) {
        ObservableList<EmployeeManagement> list = readAll();
        list.add(employeeManagement);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ObservableList<EmployeeManagement> readAll() {

        File file = new File(FILE_PATH);
        if (!file.exists()||file.length()==0) {
            return FXCollections.observableArrayList();
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<EmployeeManagement> list = (ArrayList<EmployeeManagement>) ois.readObject();
            ois.close();
            return FXCollections.observableArrayList(list);
        }catch (Exception e){
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }

    }
}
