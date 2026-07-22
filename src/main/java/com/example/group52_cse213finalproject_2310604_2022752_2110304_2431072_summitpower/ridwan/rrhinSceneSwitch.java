package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class rrhinSceneSwitch {
    public static void rahinSceneSwitcher(Node sourseNode, String fxmlFileName, String title){
        try{
            FXMLLoader loader = new FXMLLoader(rrhinSceneSwitch.class.getResource("/com/example/group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower/ridwan/accountant/"+fxmlFileName));
            Parent root = loader.load();

            Stage stage = (Stage) sourseNode.getScene() .getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
