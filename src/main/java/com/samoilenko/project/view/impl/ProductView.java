package com.samoilenko.project.view.impl;

import com.samoilenko.project.model.Product;

import java.util.List;

public class ProductView{
    void displayProductDetails(Product product){
        System.out.println("Product Details: ");
        System.out.println("Product Type: " + product.getProductType());
        System.out.println("Cost Per Square Foot" + product.getCostPerSquareFoot());
        System.out.println("Labor Cost Per SQuare Foot" + product.getLaborCostPerSquareRoot());

    }

    public void displayListOfProducts(List<Product> productList) {
        System.out.println("All product: ");
        productList.forEach(System.out::println);
    }
}
