package com.samoilenko.project.controller.imp;

import com.samoilenko.project.controller.Controller;
import com.samoilenko.project.model.Order;
import com.samoilenko.project.model.Tax;
import com.samoilenko.project.view.impl.OrderView;

import java.math.BigDecimal;

public class OrderController implements Controller {
    private Order model;
    private OrderView view;

    public OrderController(Order model, OrderView view) {
        this.model = model;
        this.view = view;
    }

    public Order getModel() {
        return model;
    }

    public void setModel(Order model) {
        this.model = model;
    }

    public OrderView getView() {
        return view;
    }

    public void setView(OrderView view) {
        this.view = view;
    }

    @Override
    public void updateView() {
        view.displayDetails();
    }
}
