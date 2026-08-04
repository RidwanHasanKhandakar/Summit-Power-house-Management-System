module com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower;

    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.commonFiles to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller to javafx.fxml;

    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model to javafx.base;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model to javafx.base;


}