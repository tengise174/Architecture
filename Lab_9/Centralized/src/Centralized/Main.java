package Centralized;

class Order {
    private OrderLine orderLine;

    public Order(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public double calculatePrice() {
        int quantity = orderLine.getQuantity();
        Product product = orderLine.getProduct();
        double basePrice = calculateBasePrice(quantity, product.getPricingDetails());
        double discounts = calculateDiscounts();
        return basePrice - discounts;
    }

    private double calculateBasePrice(int quantity, double pricePerUnit) {
        return quantity * pricePerUnit;
    }

    private double calculateDiscounts() {
        Customer customer = new Customer();
        return customer.getDiscountInfo();
    }
}

class OrderLine {
    private int quantity;
    private Product product;

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}

class Product {
    private double pricingDetails;

    public Product(double pricingDetails) {
        this.pricingDetails = pricingDetails;
    }

    public double getPricingDetails() {
        return pricingDetails;
    }
}

class  Customer {
    public double getDiscountInfo() {
        return 10.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Product product = new Product(20.0);
        OrderLine orderLine = new OrderLine(5, product);
        Order order = new Order(orderLine);

        double finalPrice = order.calculatePrice();
        System.out.println("Final Price: " + finalPrice);
    }
}