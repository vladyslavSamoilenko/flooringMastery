package com.samoilenko.project.dao;

import com.samoilenko.project.model.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderDao {
    void addOrder(Order order);
    void deleteOrder(int i);
    void updateOrder(int i, Order order);
    List<Order> getOrdersByDate(String date);
    List<Order> getAllOrders();
}
