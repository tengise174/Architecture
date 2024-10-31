package Distributed;

class Order {
    private OrderLine orderLine;
    private Customer customer;

    public Order(OrderLine orderLine, Customer customer) {
        this.orderLine = orderLine;
        this.customer = customer;
    }

    public double calculatePrice() {
        double baseValue = orderLine.calculatePrice();
        return customer.getDiscountedValue(this, baseValue);
    }
}

class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double calculatePrice() {
        return product.getPrice(quantity);
    }
}

class Product {
    private double unitPrice;

    public Product(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getPrice(int quantity) {
        return unitPrice * quantity;
    }
}

class Customer {
    private double discountRate;

    public Customer(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountedValue(Order order, double baseValue) {
        return baseValue * (1 - discountRate);
    }
}

public class Main {
    public static void main(String[] args) {
        Product product = new Product(10.0);
        OrderLine orderLine = new OrderLine(product, 5);
        Customer customer = new Customer(0.1);
        Order order = new Order(orderLine, customer);

        double finalPrice = order.calculatePrice();
        System.out.println("Final Price: " + finalPrice);
    }
}

