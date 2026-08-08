package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.bpdbOfficer;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.PowerDemandRequest;

import java.io.*;
import java.util.ArrayList;

public class PowerDemandRequestFileHandler {

    private static final String FILE_NAME =
            "data/ridwan/bpdbOfficer/powerDemandRequest.bin";


    public static void save(PowerDemandRequest request) {

        ArrayList<PowerDemandRequest> list = readAll();

        list.add(request);

        File file = new File(FILE_NAME);

        // Create parent directories if they don't exist
        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(file))) {

            oos.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<PowerDemandRequest> readAll() {

        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            return (ArrayList<PowerDemandRequest>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }


    public static String generateNextRequestId() {

        ArrayList<PowerDemandRequest> requests = readAll();

        if (requests.isEmpty()) {
            return "REQ-1001";
        }

        int maxId = 1000;

        for (PowerDemandRequest request : requests) {

            try {

                String id = request.getRequestId()
                        .replace("REQ-", "")
                        .trim();

                int number = Integer.parseInt(id);

                if (number > maxId) {
                    maxId = number;
                }

            } catch (NumberFormatException e) {

                // Ignore invalid request IDs
            }
        }

        return "REQ-" + (maxId + 1);
    }
}