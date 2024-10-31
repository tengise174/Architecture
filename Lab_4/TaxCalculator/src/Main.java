import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("2023 эсвэл 2024: ");
        int year = scanner.nextInt();

        System.out.print("Нийт орлого оруул: ");
        double income = scanner.nextDouble();

        System.out.print("Ажилласан өдөр: ");
        int daysWorked = scanner.nextInt();

        TaxCalculator calculator;
        if (year == 2023) {
            calculator = new Year2023Calculator();
        } else if (year == 2024) {
            calculator = new Year2024Calculator();
        } else {
            System.out.println("Буруу жил оруулсан байна.");
            return;
        }

        double tax = calculator.calculateTax(income, daysWorked);
        System.out.println(year + " онд таны татвар: " + tax);

        scanner.close();
    }
}
