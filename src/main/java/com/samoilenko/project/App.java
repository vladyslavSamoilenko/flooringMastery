package com.samoilenko.project;

import com.samoilenko.project.controller.imp.MainController;
import com.samoilenko.project.controller.imp.OrderController;
import com.samoilenko.project.controller.imp.ProductsController;
import com.samoilenko.project.dao.impl.OrderDaoImpl;
import com.samoilenko.project.model.Order;
import com.samoilenko.project.model.Product;
import com.samoilenko.project.service.impl.FlooringOrderService;
import com.samoilenko.project.service.impl.ProductManagementService;
import com.samoilenko.project.view.impl.OrderView;
import com.samoilenko.project.view.impl.ProductView;

import java.math.BigDecimal;
public class App 
{
    public static void main( String[] args )
    {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        ProductView productView = new ProductView();
        OrderView orderView = new OrderView();

        // Initialize product list
        ProductManagementService.ProductList();

        // Initialize Controllers
        ProductsController productsController = new ProductsController(new ProductManagementService(), productView, null);
        OrderController orderController = new OrderController(null, orderDao, orderView);

        // Create Flooring Order Service (without orders yet)
        FlooringOrderService flooringService = new FlooringOrderService(null, null);

        // Initialize Main Controller
        MainController mainController = new MainController(orderController, productsController, flooringService, orderDao, orderView);

        // Start the application
        mainController.start();
    }
}
