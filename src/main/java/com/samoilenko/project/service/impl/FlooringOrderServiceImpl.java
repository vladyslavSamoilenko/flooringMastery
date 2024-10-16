package com.samoilenko.project.service.impl;

import com.samoilenko.project.model.Order;
import com.samoilenko.project.model.Tax;
import com.samoilenko.project.service.FlooringOrderService;

import java.math.BigDecimal;

public class FlooringOrderServiceImpl implements FlooringOrderService {

    private Order model;

    public FlooringOrderServiceImpl(Order model) {
        this.model = model;
    }

    @Override
    public void calculateOrderDetails() {

    }

    @Override
    public void validateState() {

    }

    @Override
    public void validateProduct() {

    }

    @Override
    public void validateOrderDate() {

    }

    @Override
    public void placeOrder() {

    }

    @Override
    public void editOrder() {

    }

    @Override
    public void removeOrder() {

    }
    public BigDecimal materialCost(){
        return getModel().getArea().multiply(getModel().getCostPerSquareFoot());
    }

    public BigDecimal laborCost(){
        return getModel().getArea().multiply(getModel().getLaborCostPerSquareFoot());
    }

    public BigDecimal tax(Order model, Tax tax){
        return (materialCost().add(laborCost())).multiply(tax.getTaxRate().divide(new BigDecimal(100)));
    }
}
