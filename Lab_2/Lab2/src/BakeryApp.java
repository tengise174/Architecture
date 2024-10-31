import java.util.HashMap;
import java.util.Map;

class Bread {
    private String type;
    private double price;
    private int quantity;

    public Bread(String type, double price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }
}

class Bakery {
    private Map<String, Bread> breads;

    public Bakery() {
        breads = new HashMap<>();

        breads.put("Хар талх", new Bread("Хар талх", 3.50, 120));
        breads.put("Овъёостой талх", new Bread("Овъёостой талх", 4.00, 80));
        breads.put("Үзэмтэй талх", new Bread("Үзэмтэй талх", 4.50, 100));
        breads.put("Эрүүл мэндийн талх", new Bread("Эрүүл мэндийн талх", 5.00, 60));
    }

    public void displayBreadProduction() {
        System.out.println("Үйлдвэрлэгдсэн талхны мэдээлэл:");
        double totalCost = 0;

        for (Bread bread : breads.values()) {
            System.out.println(bread.getType() + ": " + bread.getQuantity() + " талх, Нэгж талхны үнэ: " + bread.getPrice());
            totalCost += bread.getTotalCost();
        }

        System.out.println("\nБүх талхны үнэ: " + totalCost);
    }
}

public class BakeryApp {
    public static void main(String[] args) {
        Bakery bakery = new Bakery();
        bakery.displayBreadProduction();
    }
}

