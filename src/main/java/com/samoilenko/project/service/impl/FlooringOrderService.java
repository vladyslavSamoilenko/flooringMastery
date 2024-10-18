package com.samoilenko.project.service.impl;

import com.samoilenko.project.model.Order;
import com.samoilenko.project.model.Tax;

import java.math.BigDecimal;

public class FlooringOrderService {

    private Order order;
    private Tax tax;

    public FlooringOrderService(Order model, Tax tax) {
        this.order = model;
        this.tax = tax;
    }

    public Tax getTax() {
        return tax;
    }

    public Order getOrder() {
        return order;
    }

    public BigDecimal calculateTotalCost() {
        return getOrder().getMaterialCost().add(getOrder().getLaborCost()).add(getOrder().getTax());
    }

    public BigDecimal materialCost(){
        return getOrder().getArea().multiply(getOrder().getCostPerSquareFoot());
    }

    public BigDecimal laborCost(){
        return getOrder().getArea().multiply(getOrder().getLaborCostPerSquareFoot());
    }

    public BigDecimal tax(Tax tax){
        return (materialCost().add(laborCost())).multiply(tax.getTaxRate().divide(new BigDecimal(100)));
    }
}
