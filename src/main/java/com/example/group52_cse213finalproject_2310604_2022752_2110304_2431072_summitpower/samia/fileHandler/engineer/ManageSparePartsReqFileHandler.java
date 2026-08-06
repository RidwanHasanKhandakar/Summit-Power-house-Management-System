package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.ManageSparePartsReq;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class ManageSparePartsReqFileHandler {
    private static final String FILE_PATH = "data/samia/engineer/ManageSparePartsReq.bin";



    public static void save(ManageSparePartsReq request){

        ObservableList<ManageSparePartsReq> list = readAll();

        list.add(request);


        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));


            oos.writeObject(new ArrayList<>(list));

            oos.close();


        } catch(IOException e){

            e.printStackTrace();

        }

    }



    @SuppressWarnings("unchecked")
    public static ObservableList<ManageSparePartsReq> readAll(){

        File file = new File(FILE_PATH);


        if(!file.exists() || file.length()==0){

            return FXCollections.observableArrayList();

        }


        try{

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));


            ArrayList<ManageSparePartsReq> list =
                    (ArrayList<ManageSparePartsReq>) ois.readObject();


            ois.close();


            return FXCollections.observableArrayList(list);



        }catch(Exception e){

            e.printStackTrace();

            return FXCollections.observableArrayList();

        }

    }
}
