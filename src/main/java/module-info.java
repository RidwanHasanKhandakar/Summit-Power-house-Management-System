module com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower;

    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.commonFiles to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant to javafx.fxml;
    opens com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer to javafx.fxml;
}