package com.samoilenko.project.controller.imp;

import com.samoilenko.project.controller.Controller;
import com.samoilenko.project.dao.impl.OrderDaoImpl;
import com.samoilenko.project.model.Order;
import com.samoilenko.project.model.Tax;
import com.samoilenko.project.view.impl.OrderView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class OrderController implements Controller {
    private Order order;
    private OrderDaoImpl orderDao;

    public OrderController(Order model, OrderDaoImpl orderDao) {
        this.order = model;
        this.orderDao = orderDao;
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

    @Override
    public void display() {

    }

    public void displayeOrders(){
        LocalDate date = LocalDate.now();
        orderDao.getOrdersByDate(date.toString());
    }

    public void setOrder(Order order) {

    }
}
