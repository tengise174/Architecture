package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Product {
    private String name;
    private double price;
    private Date date;

    public Product(String name, double price, Date date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() { return name;}

    public double getPrice() { return price; }

    double calcDecreasePrice(){
        return this.price *= 0.9;
    }

    public String printInfo() {
        return "Product{name= " + name + ", price=" + price + ", date " + date + "}";
    }
}

class ProductListComposition {
    private List<Product> products;

    public ProductListComposition() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printInfo() {
        for(Product product : products)
            product.printInfo();
    }
}

class ProductListAggregation {
    private List<Product> products;

    public ProductListAggregation(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printInfo() {
        for(Product product : products)
            product.printInfo();
    }
}

class ProductListAssociation {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printInfo() {
        for(Product product : products)
            product.printInfo();
    }
}

