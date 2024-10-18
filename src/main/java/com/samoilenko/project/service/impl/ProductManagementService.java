package com.samoilenko.project.service.impl;

import com.samoilenko.project.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductManagementService {
    private static List<Product> products;

    public static void ProductList(){
        products = new ArrayList<>(Arrays.asList(new Product("Carpet", new BigDecimal(2.25), new BigDecimal(2.10)),
                new Product("Laminate", new BigDecimal(1.75), new BigDecimal(2.10)),
                new Product("Tile", new BigDecimal(3.50), new BigDecimal(4.15)),
                new Product("Wood", new BigDecimal(5.15), new BigDecimal(4.75))));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int index) {
        return products.get(index);
    }
}
