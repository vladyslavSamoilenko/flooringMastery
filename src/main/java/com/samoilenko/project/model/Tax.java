package com.samoilenko.project.model;

import java.math.BigDecimal;

public class Tax {
    private String stateAbberaviation;
    private String stateName;
    private BigDecimal taxRate;

    public Tax(String stateAbberaviation, String stateName, BigDecimal taxRate) {
        this.stateAbberaviation = stateAbberaviation;
        this.stateName = stateName;
        this.taxRate = taxRate;
    }

    public String getStateAbberaviation() {
        return stateAbberaviation;
    }

    public void setStateAbberaviation(String stateAbberaviation) {
        this.stateAbberaviation = stateAbberaviation;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
