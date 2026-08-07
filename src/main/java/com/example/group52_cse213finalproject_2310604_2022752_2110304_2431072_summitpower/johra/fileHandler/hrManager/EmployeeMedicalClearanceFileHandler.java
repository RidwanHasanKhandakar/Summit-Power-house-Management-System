package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeLeave;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeMedicalClearance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class EmployeeMedicalClearanceFileHandler {

    private static String FILE_PATH = "data/johra/hrManager/employeeMedicalClearance.bin";
    public static void save(EmployeeMedicalClearance employeeMedicalClearance){

        ObservableList<EmployeeMedicalClearance> list = readAll();
        list.add(employeeMedicalClearance);

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<EmployeeMedicalClearance> readAll(){

        File file = new File(FILE_PATH);

        if(!file.exists() || file.length() == 0){
            return FXCollections.observableArrayList();
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<EmployeeMedicalClearance> list = (ArrayList<EmployeeMedicalClearance>) ois.readObject();
            ois.close();
            return FXCollections.observableArrayList(list);
        }
        catch(Exception e){
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }

    }

}
