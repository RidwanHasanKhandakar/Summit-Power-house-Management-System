package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.PowerSupplyRecord;

import java.io.*;
import java.util.ArrayList;

public class PowerSupplyRecordFileHandler {

    private static final String FILE_NAME = "data/ridwan/powerSupplyRecords.bin";

    public static void save(PowerSupplyRecord record){
        ArrayList<PowerSupplyRecord> list = readAll();
        list.add(record);
        try(ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream(FILE_NAME)))){
            oos.writeObject(list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //@SuppressWarnings("unchecked")
    public static ArrayList<PowerSupplyRecord>readAll(){
        File file = new  File(FILE_NAME);
        if(!file.exists()||file.length()==0){
            return new ArrayList<>();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            return (ArrayList<PowerSupplyRecord>) ois.readObject();
        }catch (Exception e){
            return new ArrayList<>();
        }

    }

}
