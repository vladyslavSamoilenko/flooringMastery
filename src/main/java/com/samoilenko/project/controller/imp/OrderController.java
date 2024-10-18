package com.samoilenko.project.controller.imp;

import com.samoilenko.project.dao.impl.OrderDaoImpl;
import com.samoilenko.project.model.Order;
import com.samoilenko.project.view.impl.OrderView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderController{
    private Order order;
    private OrderDaoImpl orderDao;
    private OrderView view;

    public OrderController(Order model, OrderDaoImpl orderDao, OrderView view) {
        this.order = model;
        this.orderDao = orderDao;
        this.view = view;
    }

    public void addOrder(Order order){
        orderDao.addOrder(order);
        System.out.println("Order has been add");
    }

    public void deleteOrderById(int i){
        orderDao.deleteOrder(i);
        System.out.println("Order has been delete");
    }

    public void updateOrderById(int i){
        orderDao.updateOrder(i, order);
        System.out.println("Order has been update");
    }


    public void displayeOrders(){
        LocalDate date = LocalDate.now();
        List<Order> orders = orderDao.getOrdersByDate(date.toString());
        view.displayDetails(orders);
    }

    public void getOrderByCustomerName(String name){
        List<Order> orders = new ArrayList<>();
        orders.add(orderDao.getOrderByCustomerName(name));
        view.displayDetails(orders);

    }

}
