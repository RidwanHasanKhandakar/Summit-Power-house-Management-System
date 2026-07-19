package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimarySceneSwitcher {
    public static void primarySwitchScene(Node sourseNode, String fxmlFileNamem, String title){
        try{
            FXMLLoader loader = new FXMLLoader(PrimarySceneSwitcher.class.getResource("/com/example/group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower/ridwan/commonFiles/"+fxmlFileNamem));

            Parent root = loader.load();

            Stage stage = (Stage) sourseNode.getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
