# Mission 9232 LTD

## CSE213 Final Project

**Simulating Operations of a Private Power Generation Company such as Summit Power**

Mission 9232 LTD is a Java-based power plant management system developed as a CSE213 final project. The system simulates the major operational, financial, human-resource, inventory, generation, and power-supply activities of a private power generation company.

The application provides role-based modules for different stakeholders involved in power plant operations. Each user can access functions relevant to their responsibilities, while information is maintained through application data files.

---

## Team

### Team Leader

**Ridwan Hasan Khandakar**  
ID: `2310604`

### Team Members

1. **Kazi Fatema Tuj Johra** — `2022752`
2. **Rubama Mehnaj** — `2110304`
3. **Samia Islam** — `2431072`

---

# System Users

The system contains eight primary users:

| User | Role |
|---|---|
| User-1 | Accountant |
| User-2 | BPDB Officer |
| User-3 | HR Manager |
| User-4 | Inventory Manager |
| User-5 | CEO |
| User-6 | Plant Manager |
| User-7 | Engineer |
| User-8 | Grid Operator |

The CRA defines eight goals for each user, resulting in **64 user-specific goals**.

---

# User Goals and Data Workflows

## User-1: Accountant

### Goal 1 — Log Income from Electricity Sales

```text
Sales Information
      │
      ▼
Log Income
      │
      ▼
logIncome.bin
      │
      ▼
Total Sales Income
```

### Goal 2 — Track Fuel and Operational Expenses

```text
Expense Information
      │
      ▼
Track Expenses
      │
      ▼
trackFuel.bin
      │
      ▼
Fuel / Operational Cost
```

### Goal 3 — Manage Salary Payments

```text
Employee Salary Information
      │
      ▼
Salary Payment
      │
      ▼
salaryPayments.bin
      │
      ▼
Total Salary Cost
```

### Goal 4 — Process Purchase Requests

```text
Purchase Request
      │
      ▼
purchaseRequest.bin
      │
      ▼
Approve / Reject Status
      │
      ▼
Other Expenses
```

### Goal 5 — Generate Financial Statements

```text
logIncome.bin
      │
      ▼
Sales Revenue
      │
      ├──────────────────┐
      │                  │
      ▼                  ▼
trackFuel.bin      salaryPayments.bin
      │                  │
      ▼                  ▼
Fuel Cost           Salary Cost
      │                  │
      └────────┬─────────┘
               ▼
        Financial Summary
               │
               ▼
   Financial Statements
```

### Goal 6 — Prepare Profit/Loss Report

```text
logIncome.bin
      │
      ▼
Total Sales Income
      │

trackFuel.bin
      │
      ▼
Fuel Cost
      │

salaryPayments.bin
      │
      ▼
Salary Cost
      │

purchaseRequest.bin
(Approved only)
      │
      ▼
Other Expenses
      │
      ▼
Profit / Loss Report
      │
      ▼
profitLossReport.bin
```

### Goal 7 — Review Financial Records

```text
Financial Records
      │
      ├──────────────┐
      │              │
      ▼              ▼
Income Records   Expense Records
      │              │
      ▼              ▼
logIncome.bin   Expense Data
      │              │
      └───────┬──────┘
              ▼
       Financial Review
```

### Goal 8 — Monitor Financial Performance

```text
Income Data
      │
      ▼
logIncome.bin
      │
      ├──────────────────┐
      │                  │
      ▼                  ▼
Expense Data       Salary Data
      │                  │
      ▼                  ▼
trackFuel.bin    salaryPayments.bin
      │                  │
      └────────┬─────────┘
               ▼
      Financial Performance
               │
               ▼
        Performance Summary
```

The Accountant's CRA responsibilities include recording electricity-sales income and tracking fuel/operational expenses.

---

# User-2: BPDB Officer

### Goal 1 — Monitor Power Generation

```text
Generation Records
      │
      ▼
Power Generation Data
      │
      ▼
Generation Report
```

### Goal 2 — Monitor Power Supply

```text
Daily Supply Records
      │
      ▼
Power Supply Monitoring
      │
      ▼
Filtered Supply Records
      │
      ▼
Total Supplied Power
      │
      ▼
Supply Summary
```

### Goal 3 — Monitor Daily Power Supply

```text
Daily Power Supply
      │
      ▼
Power Supply Records
      │
      ▼
Select Date Range
      │
      ▼
Filtered Records
      │
      ▼
Total Supplied Power
      │
      ▼
Daily Supply Summary
```

### Goal 4 — View Invoices and Payment Records

```text
Invoice Records
      │
      ▼
Invoice & Payments
      │
      ▼
Payment Details
      │
      ▼
Invoice Information
      │
      ▼
Invoice File
```

### Goal 5 — Submit Power Supply Complaint

```text
Complaint Information
      │
      ▼
Submit Complaint
      │
      ▼
Complaint Records
      │
      ▼
Complaint Confirmation
```

### Goal 6 — Request Additional Power Supply

```text
Additional Supply Request
      │
      ▼
Required Capacity
      │
      ▼
Requested Date Range
      │
      ▼
Request Justification
      │
      ▼
Additional Supply Request
      │
      ▼
Plant Manager
```

### Goal 7 — View Generation and Supply Reports

```text
Generation Data
      │
      ├──────────────┐
      │              │
      ▼              ▼
Supply Data      Generation Data
      │              │
      └──────┬───────┘
             ▼
       Select Report Type
             │
             ▼
       Reporting Period
             │
             ▼
       Report Summary
             │
             ▼
        Export Report
```

### Goal 8 — Review Contract Performance

```text
Contract Records
      │
      ▼
Contract Performance
      │
      ▼
Select Contract
      │
      ▼
Fulfillment Statistics
      │
      ▼
Performance Indicators
      │
      ▼
Performance Summary
```

The CRA specifically includes BPDB Officer functions for daily power-supply monitoring, invoices/payment records, complaints, additional supply requests, generation/supply reports, and contract performance.

---

# User-3: HR Manager

### Goal 1 — Add New Employee

```text
Employee Information
      │
      ▼
Add New Employee
      │
      ▼
Employee Records
      │
      ▼
Employee Information File
```

### Goal 2 — Employee Award Management

```text
Employee Information
      │
      ▼
Award Information
      │
      ▼
Award Management
      │
      ▼
Employee Award Records
```

### Goal 3 — Employee Performance Grading

```text
Employee ID
      │
      ├───────────────┐
      │               │
      ▼               ▼
Attendance Score   Teamwork Score
      │               │
      └───────┬───────┘
              ▼
       Efficiency Score
              │
              ▼
       Performance Grading
              │
              ▼
         Final Rating
              │
              ▼
Performance Records
```

### Goal 4 — Employee Medical Clearance

```text
Employee Information
      │
      ▼
Medical Clearance
      │
      ▼
Doctor / Medical Status
      │
      ▼
Checkup Date
      │
      ▼
Medical Clearance Records
```

### Goal 5 — Employee Training Management

```text
Employee Information
      │
      ▼
Training Selection
      │
      ▼
Trainer Information
      │
      ▼
Training Status
      │
      ▼
Training Records
```

### Goal 6 — Create Notice

```text
Notice Information
      │
      ▼
Create Notice
      │
      ▼
Notice Records
      │
      ▼
Published Notice
```

### Goal 7 — View Employee Details

```text
Department
      │
      ▼
Employee Details
      │
      ▼
Employee Records
      │
      ▼
Employee List
      │
      ▼
Table View
```

### Goal 8 — Employee Leave Management

```text
Leave Information
      │
      ▼
Employee Leave
      │
      ▼
Leave Records
      │
      ▼
Employee Leave Information
```

The CRA specifies HR functions covering employee creation, awards, performance grading, medical clearance, training, notices, employee details, and leave management. 
---

# User-4: Inventory Manager

### Goal 1 — Add Equipment

```text
Equipment Information
      │
      ▼
Add Equipment
      │
      ▼
Equipment Records
      │
      ▼
Inventory
```

### Goal 2 — Equipment Maintenance History

```text
Equipment Information
      │
      ▼
Maintenance Information
      │
      ▼
Equipment Maintenance History
      │
      ▼
Maintenance Records
```

### Goal 3 — Parts Issuance

```text
Equipment ID
      │
      ▼
Requester Information
      │
      ▼
Required Quantity
      │
      ▼
Parts Issuance
      │
      ▼
Parts Issuance Records
```

### Goal 4 — Offer Purchase Tender

```text
Tender Information
      │
      ▼
Create Tender
      │
      ▼
Tender Records
      │
      ▼
Purchase Tender
```

### Goal 5 — Vendor Management

```text
Vendor Information
      │
      ▼
Vendor Management
      │
      ▼
Vendor Records
      │
      ▼
Vendor List
```

### Goal 6 — Inventory Report

```text
Inventory Information
      │
      ▼
Report Criteria
      │
      ▼
Inventory Report
      │
      ▼
inventoryReport.bin
```

### Goal 7 — Manage Inventory Records

```text
Inventory Records
      │
      ▼
Inventory Management
      │
      ├──────────────┐
      │              │
      ▼              ▼
Equipment        Parts
      │              │
      └──────┬───────┘
             ▼
       Inventory Status
```

### Goal 8 — View Inventory Report

```text
inventoryReport.bin
      │
      ▼
View Inventory Report
      │
      ▼
Select Report Type
      │
      ▼
Filter Inventory Reports
      │
      ▼
Filtered Inventory Report
```

The CRA identifies Inventory Manager responsibilities including equipment, maintenance history, parts issuance, tenders, vendors, inventory reports, and filtered inventory-report viewing. 
---

# User-5: CEO

### Goal 1 — View Plant Performance Summary

```text
Generation Records
      │
      ▼
Plant Performance
      │
      ▼
Select Date Range
      │
      ▼
Historical Generation Data
      │
      ├───────────────┐
      │               │
      ▼               ▼
Total Generation   Power Loss
      │               │
      └───────┬───────┘
              ▼
      Performance Status
              │
              ▼
      Plant Performance Summary
```

### Goal 2 — Check Financial Summary

```text
logIncome.bin
      │
      ▼
Total Revenue
      │

trackFuel.bin
      │
      ▼
Fuel Cost
      │

Operational Expense Data
      │
      ▼
Operational Cost
      │
      └──────────┬──────────┘
                 ▼
          Financial Summary
                 │
                 ▼
            Profit / Loss
```

### Goal 3 — Set or Change Tariff Rates

```text
Customer Type
      │
      ▼
Tariff Rate
      │
      ▼
Tariff Date
      │
      ▼
Set / Change Tariff
      │
      ▼
Tariff Records
```

### Goal 4 — Approve Fuel Purchase Request

```text
Fuel Request
      │
      ▼
fuelRequest.bin
      │
      ▼
Pending Requests
      │
      ▼
CEO Decision
      │
      ├──────────────┐
      │              │
      ▼              ▼
   Approve         Reject
      │              │
      └──────┬───────┘
             ▼
      Request Status
```

### Goal 5 — Add or Remove an Employee

```text
Employee Information
      │
      ▼
Employee Management
      │
      ├──────────────┐
      │              │
      ▼              ▼
Add Employee    Remove Employee
      │              │
      └──────┬───────┘
             ▼
       Employee Records
```

### Goal 6 — View Total Registered Customers

```text
Customer Records
      │
      ▼
Select Joining Date
      │
      ▼
Registered Customers
      │
      ├──────────────┬──────────────┐
      │              │              │
      ▼              ▼              ▼
Industrial      Commercial     Residential
      │              │              │
      └──────────────┴──────────────┘
                     ▼
          Total Registered Customers
```

### Goal 7 — View Customer Complaint Summary

```text
Customer Records
      │
      ▼
Complaint Records
      │
      ▼
Select Category / Date
      │
      ▼
Complaint Summary
      │
      ├───────────────┐
      │               │
      ▼               ▼
Resolved          Pending
      │               │
      └───────┬───────┘
              ▼
       Complaint Report
```

### Goal 8 — Generate Weekly Report

```text
Plant Performance Data
      │
      ▼
Select Start Date
      │
      ▼
Select End Date
      │
      ▼
Performance Records
      │
      ▼
Weekly Report
      │
      ▼
weeklyReport.bin
```

The CEO goals in the CRA cover plant performance, financial summary, tariff management, fuel-purchase approval, employee management, customer counts, complaint summaries, and weekly reports. 
---

# User-6: Plant Manager

### Goal 1 — Monitor Current Power Generation

```text
Power Generation Records
      │
      ▼
powerGeneration.bin
      │
      ▼
Select Unit Name
      │
      ▼
Select Unit No
      │
      ▼
Select Date
      │
      ▼
View Generation
      │
      ▼
Power Generation History
```

### Goal 2 — Check Fuel Level

```text
Fuel Stock Records
      │
      ▼
fuelStock.bin
      │
      ▼
Select Unit
      │
      ▼
Select Fuel Type
      │
      ▼
Select Date
      │
      ▼
Check Fuel Levels
      │
      ▼
Fuel Stock Status
```

### Goal 3 — Schedule Maintenance for a Unit

```text
Maintenance Schedule
      │
      ▼
maintenanceSchedule.bin
      │
      ▼
Select Unit
      │
      ▼
Select Unit No
      │
      ▼
Select Date
      │
      ▼
View Schedule
      │
      ▼
Maintenance Schedule
```

### Goal 4 — Start or Stop a Generating Unit

```text
Generating Unit
      │
      ▼
Generation Unit Control
      │
      ├──────────────┐
      │              │
      ▼              ▼
     Start          Stop
      │              │
      └──────┬───────┘
             ▼
        Unit Status
```

### Goal 5 — View Maintenance History

```text
Maintenance Records
      │
      ▼
maintenanceHistory.bin
      │
      ▼
Select Unit
      │
      ▼
Select Unit No
      │
      ▼
Select Date
      │
      ▼
Maintenance History
```

### Goal 6 — Generate Daily Shift Report

```text
Generation Data
      │
      ├──────────────┐
      │              │
      ▼              ▼
Maintenance Data   Unit Status
      │              │
      └──────┬───────┘
             ▼
        Shift Report
             │
             ▼
       Daily Report
```

### Goal 7 — Raise Fuel Request to Admin

```text
Fuel Requirement
      │
      ▼
Select Unit
      │
      ▼
Select Fuel Type
      │
      ▼
Select Date
      │
      ▼
Request Fuel
      │
      ▼
fuelRequest.bin
      │
      ▼
Admin / CEO Approval
```

### Goal 8 — Log an Unplanned Breakdown

```text
Generating Unit
      │
      ▼
Breakdown Detected
      │
      ▼
Select Unit
      │
      ▼
Select Unit No
      │
      ▼
Select Date
      │
      ▼
Breakdown Report
      │
      ▼
breakdownReport.bin
```

These flows correspond directly to the Plant Manager goals in the CRA. The implemented project also contains corresponding Plant Manager handlers/models for power generation, fuel stock, fuel requests, maintenance schedules, and breakdown reports. 
---

# User-7: Engineer

### Goal 1 — Monitor Equipment / Unit Condition

```text
Generating Unit Data
      │
      ▼
Unit Condition
      │
      ▼
Equipment Status
      │
      ▼
Engineering Monitoring
```

### Goal 2 — Record Maintenance Activity

```text
Maintenance Activity
      │
      ▼
Equipment / Unit
      │
      ▼
Maintenance Record
      │
      ▼
Maintenance History
```

### Goal 3 — Record Technical Inspection

```text
Technical Inspection
      │
      ▼
Unit / Equipment
      │
      ▼
Inspection Findings
      │
      ▼
Inspection Records
```

### Goal 4 — Report Technical Fault

```text
Technical Fault
      │
      ▼
Fault Information
      │
      ▼
Engineering Report
      │
      ▼
Plant Maintenance / Operations
```

### Goal 5 — Monitor Maintenance Requirements

```text
Maintenance Records
      │
      ▼
Equipment Condition
      │
      ▼
Maintenance Requirement
      │
      ▼
Maintenance Planning
```

### Goal 6 — Monitor Unit Performance

```text
Generation Data
      │
      ▼
Unit Performance
      │
      ├──────────────┐
      │              │
      ▼              ▼
Generation       Unit Status
      │              │
      └──────┬───────┘
             ▼
      Performance Result
```

### Goal 7 — Review Engineering Records

```text
Engineering Records
      │
      ├──────────────┐
      │              │
      ▼              ▼
Maintenance      Inspection
      │              │
      └──────┬───────┘
             ▼
      Engineering History
```

### Goal 8 — Support Plant Operations

```text
Engineering Information
      │
      ▼
Technical Findings
      │
      ▼
Plant Operations
      │
      ▼
Maintenance / Generation
```

---

# User-8: Grid Operator

### Goal 1 — Monitor Grid Status

```text
Grid Data
      │
      ▼
Grid Monitoring
      │
      ▼
Grid Status
```

### Goal 2 — Monitor Power Flow

```text
Generation Data
      │
      ▼
Power Flow
      │
      ▼
Grid Supply
      │
      ▼
Power Flow Status
```

### Goal 3 — Monitor Grid Supply

```text
Power Supply Data
      │
      ▼
Grid Supply Monitoring
      │
      ▼
Supply Records
      │
      ▼
Grid Supply Status
```

### Goal 4 — Monitor Grid Demand

```text
Customer / Grid Demand
      │
      ▼
Demand Data
      │
      ▼
Grid Demand Monitoring
      │
      ▼
Demand Status
```

### Goal 5 — Record Grid Events

```text
Grid Event
      │
      ▼
Event Information
      │
      ▼
Grid Event Records
```

### Goal 6 — Report Grid Problems

```text
Grid Problem
      │
      ▼
Problem Information
      │
      ▼
Grid Problem Report
      │
      ▼
Operations / Engineering
```

### Goal 7 — Review Generation and Supply

```text
Generation Data
      │
      ├──────────────┐
      │              │
      ▼              ▼
Power Generation  Power Supply
      │              │
      └──────┬───────┘
             ▼
      Generation / Supply
             │
             ▼
       Grid Operations
```

### Goal 8 — Generate Grid Operations Report

```text
Grid Records
      │
      ├──────────────┐
      │              │
      ▼              ▼
Generation       Supply
      │              │
      ▼              ▼
Grid Events      Grid Status
      │              │
      └──────┬───────┘
             ▼
      Grid Operations Report
```

---

# Major Cross-Module Data Flows

## Financial Reporting

```text
Log Income
      │
      ▼
logIncome.bin
      │
      ├──────────────┐
      │              │
      ▼              ▼
Financial Statements
      ▲
      │
trackFuel.bin  ◄── Track Fuel
      ▲
      │
salaryPayments.bin ◄── Salary Payments

purchaseRequest.bin
      ▲
      │
Purchase Requests
(Approve / Reject)

fuelInventory.bin
      ▲
      │
Fuel Inventory
(View / Filter)

taxAudit.bin
      ▲
      │
Tax Audit
(View / Search)
```

## Plant Operations

```text
powerGeneration.bin
      │
      ▼
Power Generation History
      │
      ├──────────────────┐
      │                  │
      ▼                  ▼
Plant Performance   Daily Shift Report
      │                  │
      └────────┬─────────┘
               ▼
        Plant Operations
```

## Fuel Management

```text
fuelStock.bin
      │
      ▼
Fuel Stock
      │
      ▼
Fuel Level Monitoring
      │
      ▼
Fuel Requirement
      │
      ▼
fuelRequest.bin
      │
      ▼
Fuel Purchase Request
      │
      ▼
Approval
```

## Maintenance Management

```text
maintenanceSchedule.bin
      │
      ▼
Maintenance Schedule
      │
      ▼
Generating Unit
      │
      ▼
Maintenance Activity
      │
      ▼
maintenanceHistory.bin
      │
      ▼
Maintenance History
```

## Breakdown Management

```text
Generating Unit
      │
      ▼
Unplanned Breakdown
      │
      ▼
Breakdown Report
      │
      ▼
breakdownReport.bin
      │
      ▼
Maintenance / Plant Operations
```

---

# Application Architecture

The project follows a Java-based application structure with separate areas for application logic, resources, models, controllers, file handlers, and user interfaces.

```text
src/
└── main/
    ├── java/
    │   └── com.example.group52_cse213finalproject_...
    │       ├── controllers
    │       ├── models
    │       ├── fileHandler
    │       └── application classes
    │
    └── resources/
        └── com.example.group52_cse213finalproject_...
            └── FXML user interfaces

data/
└── role-specific binary data files
```

The repository currently contains the Java source and resources under `src/main`, together with the Maven project configuration and supporting project documents.

---

# Data Persistence

The application uses binary `.bin` files for persistent storage of application records.

A typical persistence flow is:

```text
User Input
    │
    ▼
Controller
    │
    ▼
Model Object
    │
    ▼
File Handler
    │
    ▼
.bin Data File
```

For reading stored records:

```text
.bin Data File
    │
    ▼
File Handler
    │
    ▼
ObservableList
    │
    ▼
Controller
    │
    ▼
TableView
```

The Plant Manager implementation follows this pattern through dedicated file handlers such as:

```text
BreakdownReportFileHandler
FuelRequestFileHandler
FuelStockFileHandler
MaintenanceScheduleFileHandler
PowerGenerationFileHandler
```

---

# Technology Stack

- Java
- JavaFX
- FXML
- Maven
- Object Serialization
- Binary `.bin` file persistence
- MVC-style separation of Model, View, Controller, and File Handler responsibilities

---

# Project Structure

```text
Summit-Power-house-Management-System/
│
├── .idea/
├── .mvn/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com.example.group52_cse213finalproject_...
│       │
│       └── resources/
│           └── com.example.group52_cse213finalproject_...
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
│
├── CSE213_FinalCRA_Group52_SummitPower.pdf
├── CSE213_FinalClassDiagram_Group52_SummitPower.pdf
├── CSE213_FinalDataFileStructure_Group52_SummitPower.xlsx - Sheet1.pdf
└── README.md
```

---

# Running the Project

## Requirements

- Java Development Kit
- JavaFX
- Maven
- IntelliJ IDEA or another Java IDE

## Using Maven

Clone the repository:

```bash
git clone https://github.com/RidwanHasanKhandakar/Summit-Power-house-Management-System.git
```

Open the project in IntelliJ IDEA and allow Maven to load the project dependencies.

Then run the JavaFX application from the project's main application class.

---

# Repository

The complete project source code is available on GitHub:

[Summit Power House Management System — GitHub Repository](https://github.com/RidwanHasanKhandakar/Summit-Power-house-Management-System?utm_source=chatgpt.com)

---

# Project Documentation

The repository contains the project's CRA report, UML class diagram, data-file documentation, and source code.

---

# Team

**Mission 9232 LTD**

CSE213 Final Project  
Independent University, Bangladesh

### Team Leader

Ridwan Hasan Khandakar — `2310604`

### Team Members

Kazi Fatema Tuj Johra — `2022752`  
Rubama Mehnaj — `2110304`  
Samia Islam — `2431072`
