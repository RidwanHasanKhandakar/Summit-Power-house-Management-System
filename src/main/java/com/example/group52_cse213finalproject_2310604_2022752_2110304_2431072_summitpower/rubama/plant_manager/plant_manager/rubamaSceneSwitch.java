package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.plant_manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class rubamaSceneSwitch {
    public static void rubamaSceneSwitch(Node sourceNode, String branchPath, String fxmlFileName, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.SamiaSceneSwitch.class.getResource("/com/example/group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower/samia/" + branchPath + "/" + fxmlFileName));
        Parent root = loader.load();

        Stage stage = (Stage) sourceNode.getScene() .getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
