package com.samoilenko.project.view.impl;

import com.samoilenko.project.model.Order;

import java.util.List;

public class OrderView {


    public void displayDetails(List<Order> orders) {
        System.out.printf("%-12s %-20s %-10s %-8s %-15s %-8s %-12s %-15s %-12s %-12s %-10s %-10s %-12s%n",
                "OrderNumber", "CustomerName", "State", "TaxRate", "ProductType", "Area", "Cost/SqFt",
                "LaborCost/SqFt", "MaterialCost", "LaborCost", "Tax", "Total", "OrderDate");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Order order : orders) {
            System.out.printf("%-12d %-20s %-10s %-8.2f %-15s %-8.2f %-12.2f %-15.2f %-12.2f %-12.2f %-10.2f %-10.2f %-12s%n",
                    order.getOrderNumber(),
                    order.getCustomerName(),
                    order.getState(),
                    order.getTaxRate().doubleValue(),
                    order.getProductType(),
                    order.getArea().doubleValue(),
                    order.getCostPerSquareFoot().doubleValue(),
                    order.getLaborCostPerSquareFoot().doubleValue(),
                    order.getMaterialCost().doubleValue(),
                    order.getLaborCost().doubleValue(),
                    order.getTax().doubleValue(),
                    order.getTotal().doubleValue(),
                    order.getOrderDate()
            );
        }

    }
}
