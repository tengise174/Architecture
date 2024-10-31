package org.example;

// Garment Interface
interface Garment {
    void sew();
    void iron();
    void addEmbellishments();
    String getReport();
}

// Hat Class
class Hat implements Garment {
    @Override
    public void sew() {
        System.out.println("Sewing the hat...");
    }

    @Override
    public void iron() {
        System.out.println("Ironing the hat...");
    }

    @Override
    public void addEmbellishments() {
        System.out.println("Adding embellishments to the hat...");
    }

    @Override
    public String getReport() {
        return "Hat: sewn, ironed, and embellished.";
    }
}

// Shirt Class
class Shirt implements Garment {
    @Override
    public void sew() {
        System.out.println("Sewing the shirt...");
    }

    @Override
    public void iron() {
        System.out.println("Ironing the shirt...");
    }

    @Override
    public void addEmbellishments() {
        System.out.println("Adding embellishments to the shirt...");
    }

    @Override
    public String getReport() {
        return "Shirt: sewn, ironed, and embellished.";
    }
}

