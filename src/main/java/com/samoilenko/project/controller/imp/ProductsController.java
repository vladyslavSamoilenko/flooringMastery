package com.samoilenko.project.controller.imp;

import com.samoilenko.project.model.Product;
import com.samoilenko.project.service.impl.ProductManagementService;
import com.samoilenko.project.view.impl.ProductView;

public class ProductsController{
    private Product model;
    private ProductView view ;
    private ProductManagementService service;

    public ProductsController(ProductManagementService service, ProductView view, Product model) {
        this.service = service;
        this.view = view;
        this.model = model;
    }

    public Product getTheProductById(int id){
        return service.getProductById(id);
    }

    public void displayProducts() {
        view.displayListOfProducts(service.getProducts());
    }
}
