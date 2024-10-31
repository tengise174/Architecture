public class Year2024Calculator implements TaxCalculator {

    @Override
    public double calculateTax(double income, int daysWorked) {
        double dailyIncome = income / daysWorked;
        if (dailyIncome > 20000) {
            return (dailyIncome * 0.10) * 365;
        } else {
            return (dailyIncome * 0.05) * 365;
        }
    }
}