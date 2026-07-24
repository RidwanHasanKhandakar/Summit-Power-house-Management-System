package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.Invoice;
//import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.SupplyAgreement;

import java.io.*;
import java.util.ArrayList;

public class InvoicesFileHandler {

        private static final String FILE_PATH = "data/ridwan/invoices.bin";

        public static void save(Invoice invoice){

            ArrayList<Invoice> list = readAll();
            list.add(invoice);
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream((FILE_PATH)));
                oos.writeObject(list);;
                oos.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }

        @SuppressWarnings("unchecked")
        public static ArrayList<Invoice> readAll(){

            File file = new File(FILE_PATH);

            if (!file.exists()||file.length()==0){
                return new ArrayList<>();
            }

            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
                ArrayList<Invoice> list = (ArrayList<Invoice>) ois.readObject();
                ois.close();
                return list;
            }catch (Exception e){
                return new ArrayList<>();
            }

        }

    }
