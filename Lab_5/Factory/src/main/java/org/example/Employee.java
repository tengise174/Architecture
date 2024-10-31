package org.example;

// Employee Interface
interface Employee {
    void performWork(int hoursWorked, double hourlyRate);
    double calculatePerformance();
    String getPerformanceReport();
}

// Seamstress Class
class Seamstress implements Employee {
    private int hoursWorked;
    private double hourlyRate;

    @Override
    public void performWork(int hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        System.out.println("Seamstress worked for " + hoursWorked + " hours.");
    }

    @Override
    public double calculatePerformance() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getPerformanceReport() {
        return "Seamstress Performance: " + calculatePerformance();
    }
}

// Knitter Class
class Knitter implements Employee {
    private int hoursWorked;
    private double hourlyRate;

    @Override
    public void performWork(int hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        System.out.println("Knitter worked for " + hoursWorked + " hours.");
    }

    @Override
    public double calculatePerformance() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getPerformanceReport() {
        return "Knitter Performance: " + calculatePerformance();
    }
}

// Quality Inspector Class
class QualityInspector implements Employee {
    private int hoursWorked;
    private double hourlyRate;

    @Override
    public void performWork(int hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        System.out.println("Quality Inspector worked for " + hoursWorked + " hours.");
    }

    @Override
    public double calculatePerformance() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getPerformanceReport() {
        return "Quality Inspector Performance: " + calculatePerformance();
    }
}
