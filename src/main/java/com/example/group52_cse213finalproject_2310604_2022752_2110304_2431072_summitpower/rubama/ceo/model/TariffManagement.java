package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model;

import java.io.Serializable;
import java.time.LocalDate;

public class TariffManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    private String customerType;
    private Integer setTariffRate;
    private LocalDate setTariffDate;

    public TariffManagement(String customerType, Integer setTariffRate, LocalDate setTariffDate) {
        this.customerType = customerType;
        this.setTariffRate = setTariffRate;
        this.setTariffDate = setTariffDate;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Integer getSetTariffRate() {
        return setTariffRate;
    }

    public void setSetTariffRate(Integer setTariffRate) {
        this.setTariffRate = setTariffRate;
    }

    public LocalDate getSetTariffDate() {
        return setTariffDate;
    }

    public void setSetTariffDate(LocalDate setTariffDate) {
        this.setTariffDate = setTariffDate;
    }

    @Override
    public String toString() {
        return "TariffManagement{" +
                "customerType='" + customerType + '\'' +
                ", setTariffRate=" + setTariffRate +
                ", setTariffDate=" + setTariffDate +
                '}';
    }
}

