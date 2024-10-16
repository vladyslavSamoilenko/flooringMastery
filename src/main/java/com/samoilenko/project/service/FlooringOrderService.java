package com.samoilenko.project.service;

public interface FlooringOrderService {
    void calculateOrderDetails();
    void validateState();
    void validateProduct();
    void validateOrderDate();
    void placeOrder();
    void editOrder();
    void removeOrder();
}
