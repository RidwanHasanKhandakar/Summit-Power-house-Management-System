package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model;

import java.time.LocalDate;

public class CustomerSummary {
    private String industrialCustomers,commercialCustomers,residentialCustomers;
    private LocalDate customerJoiningDate;

    public CustomerSummary(String industrialCustomers, String commercialCustomers, String residentialCustomers, LocalDate customerJoiningDate) {
        this.industrialCustomers = industrialCustomers;
        this.commercialCustomers = commercialCustomers;
        this.residentialCustomers = residentialCustomers;
        this.customerJoiningDate = customerJoiningDate;
    }

    public String getIndustrialCustomers() {
        return industrialCustomers;
    }

    public void setIndustrialCustomers(String industrialCustomers) {
        this.industrialCustomers = industrialCustomers;
    }

    public String getCommercialCustomers() {
        return commercialCustomers;
    }

    public void setCommercialCustomers(String commercialCustomers) {
        this.commercialCustomers = commercialCustomers;
    }

    public String getResidentialCustomers() {
        return residentialCustomers;
    }

    public void setResidentialCustomers(String residentialCustomers) {
        this.residentialCustomers = residentialCustomers;
    }

    public LocalDate getCustomerJoiningDate() {
        return customerJoiningDate;
    }

    public void setCustomerJoiningDate(LocalDate customerJoiningDate) {
        this.customerJoiningDate = customerJoiningDate;
    }

    @Override
    public String toString() {
        return "CustomerSummary{" +
                "industrialCustomers='" + industrialCustomers + '\'' +
                ", commercialCustomers='" + commercialCustomers + '\'' +
                ", residentialCustomers='" + residentialCustomers + '\'' +
                ", customerJoiningDate=" + customerJoiningDate +
                '}';
    }
}
