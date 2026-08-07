package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeLeave;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeTraining;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class EmployeeLeaveFileHandler {

    private static String FILE_PATH = "data/johra/hrManager/employeeLeave.bin";
    public static void save(EmployeeLeave employeeLeave){

        ObservableList<EmployeeLeave> list = readAll();
        list.add(employeeLeave);

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<EmployeeLeave> readAll(){

        File file = new File(FILE_PATH);

        if(!file.exists() || file.length() == 0){
            return FXCollections.observableArrayList();
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<EmployeeLeave> list = (ArrayList<EmployeeLeave>) ois.readObject();
            ois.close();
            return FXCollections.observableArrayList(list);
        }
        catch(Exception e){
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }

    }
}
