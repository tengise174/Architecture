public class Year2023Calculator implements TaxCalculator {

    @Override
    public double calculateTax(double income, int daysWorked) {
        if (daysWorked > 300) {
            return income * 0.20;
        } else {
            return income * 0.10;
        }
    }
}