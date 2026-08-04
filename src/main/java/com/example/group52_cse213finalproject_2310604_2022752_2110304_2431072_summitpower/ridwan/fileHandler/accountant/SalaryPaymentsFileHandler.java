package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.FinancialStatement;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.PurchaseRequest;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.SalaryPayments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class SalaryPaymentsFileHandler {

    private static final String FILE_PATH = "data/ridwan/accountant/salaryPayments.bin";
    public static void save(SalaryPayments salaryPayments) {
        ObservableList<SalaryPayments> list = readAll();
        list.add(salaryPayments);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(new ArrayList<>(list));
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<SalaryPayments> readAll() {

        File file = new File(FILE_PATH);
        if (!file.exists()||file.length()==0) {
            return FXCollections.observableArrayList();
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            ArrayList<SalaryPayments> list = (ArrayList<SalaryPayments>) ois.readObject();
            ois.close();
            return FXCollections.observableArrayList(list);
        }catch (Exception e){
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }

    }

    public static void overwrite(ObservableList<SalaryPayments> list) {

        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE_PATH));

            oos.writeObject(new ArrayList<>(list));

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
