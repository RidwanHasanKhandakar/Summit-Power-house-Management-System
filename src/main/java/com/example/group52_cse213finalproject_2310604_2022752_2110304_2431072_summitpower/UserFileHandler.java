package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.AdditionalPowerRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class UserFileHandler {

    private static final String FILE_PATH = "data/users.bin";
    public static void save(User user) {
        ObservableList<User> list = readAll();
        list.add(user);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<User> readAll() {

        File file = new File(FILE_PATH);
        if (!file.exists()||file.length()==0) {
            return FXCollections.observableArrayList();
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<User> list = (ArrayList<User>) ois.readObject();
            ois.close();
            return FXCollections.observableArrayList(list);
        }catch (Exception e){
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }

    }

}
