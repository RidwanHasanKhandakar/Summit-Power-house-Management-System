package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.bpdbOfficer;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.SupplyAgreement;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.SupplyReport;

import java.io.*;
import java.util.ArrayList;

public class SupplyReportFileHandler {

    private static final String FILE_PATH = "data/ridwan/bpdbOfficer/supplyReports.bin";

    public static void save(SupplyReport report){

        ArrayList<SupplyReport> list = readAll();
        list.add(report);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream((FILE_PATH)));
            oos.writeObject(list);;
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static ArrayList<SupplyReport> readAll(){

        File file = new File(FILE_PATH);

        if (!file.exists()||file.length()==0){
            return new ArrayList<>();
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<SupplyReport> list = (ArrayList<SupplyReport>) ois.readObject();
            ois.close();
            return list;
        }catch (Exception e){
            return new ArrayList<>();
        }

    }

}
