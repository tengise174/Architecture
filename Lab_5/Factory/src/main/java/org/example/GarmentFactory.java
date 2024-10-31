package org.example;

// FactoryReport Class
class FactoryReport {
    public static void generateProductionReport(Garment garment) {
        System.out.println(garment.getReport());
    }

    public static void generateEmployeePerformanceReport(Employee employee) {
        System.out.println(employee.getPerformanceReport());
    }
}

// Main Program
public class GarmentFactory {
    public static void main(String[] args) {
        // Garment Production
        Garment hat = new Hat();
        Garment shirt = new Shirt();

        hat.sew();
        hat.iron();
        hat.addEmbellishments();

        shirt.sew();
        shirt.iron();
        shirt.addEmbellishments();

        // Generate Reports for Garments
        FactoryReport.generateProductionReport(hat);
        FactoryReport.generateProductionReport(shirt);

        // Employee Performance
        Employee seamstress = new Seamstress();
        Employee knitter = new Knitter();
        Employee inspector = new QualityInspector();

        seamstress.performWork(8, 15.0);
        knitter.performWork(6, 18.0);
        inspector.performWork(5, 20.0);

        // Generate Employee Performance Reports
        FactoryReport.generateEmployeePerformanceReport(seamstress);
        FactoryReport.generateEmployeePerformanceReport(knitter);
        FactoryReport.generateEmployeePerformanceReport(inspector);
    }
}
