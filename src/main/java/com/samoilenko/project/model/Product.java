package com.samoilenko.project.model;

import java.math.BigDecimal;

public class Product {
    private String productType;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSquareRoot;

    public Product(String productType, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareRoot) {
        this.productType = productType;
        this.costPerSquareFoot = costPerSquareFoot;
        this.laborCostPerSquareRoot = laborCostPerSquareRoot;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareRoot() {
        return laborCostPerSquareRoot;
    }

    public void setLaborCostPerSquareRoot(BigDecimal laborCostPerSquareRoot) {
        this.laborCostPerSquareRoot = laborCostPerSquareRoot;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType='" + productType + '\'' +
                ", costPerSquareFoot=" + costPerSquareFoot +
                ", laborCostPerSquareRoot=" + laborCostPerSquareRoot +
                '}';
    }
}
