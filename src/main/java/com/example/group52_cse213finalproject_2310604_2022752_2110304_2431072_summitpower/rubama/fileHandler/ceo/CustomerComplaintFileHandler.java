package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.CustomerComplaint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class CustomerComplaintFileHandler {
    private static final String FILE_NAME = "data/rubama/ceo/CustomerComplaint.bin";

    public static void save(CustomerComplaint complaint) {

        ObservableList<CustomerComplaint> list = readAll();
        list.add(complaint);

        try(ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<CustomerComplaint> readAll() {

        try(ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ObservableList<CustomerComplaint>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {

            return FXCollections.observableArrayList();
        }
    }
}
