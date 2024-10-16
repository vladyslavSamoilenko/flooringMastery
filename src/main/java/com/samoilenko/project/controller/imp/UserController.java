package com.samoilenko.project.controller.imp;

import com.samoilenko.project.controller.Controller;
import com.samoilenko.project.model.Customer;
import com.samoilenko.project.view.impl.UserView;

public class UserController implements Controller {
    private Customer model;
    private UserView view;

    public UserController(Customer user, UserView userView) {
        this.model = user;
        this.view = userView;
    }

    public Customer getModel() {
        return model;
    }

    public void setModel(Customer model) {
        this.model = model;
    }

    public UserView getView() {
        return view;
    }

    public void setView(UserView view) {
        this.view = view;
    }

    @Override
    public void updateView() {
        view.displayDetails();
    }
}