package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();

//        Composition
        ProductListComposition productListComposition = new ProductListComposition();
        productListComposition.addProduct(new Product("car", 999, date));
        productListComposition.addProduct(new Product("ship", 1000, date));

//        Aggregation
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("book", 1001, date);
        Product product2 = new Product("note", 1002, date);
        products.add(product1);
        products.add(product2);

        ProductListAggregation productListAggregation = new ProductListAggregation(products);

//        vdv

    }
}