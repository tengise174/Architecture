import java.util.ArrayList;
import java.util.List;

public class SalaryCalc {
    public static class Employee1 {
        private String id;
        private String name;
        private Main.JobDescription jobDescription;
        private Main.Salary salary; // Composition
        private Main.PaymentMethod paymentMethod;
        private List<Main.Timesheet> timesheets = new ArrayList<>(); // Aggregation

        public Employee1(String id, String name, Main.JobDescription jobDescription, Main.Salary salary, Main.PaymentMethod paymentMethod) {
            this.id = id;
            this.name = name;
            this.jobDescription = jobDescription;
            this.salary = salary;
            this.paymentMethod = paymentMethod;
        }

        public void logTimesheet(Main.Timesheet timesheet) {
            timesheets.add(timesheet);
        }

        public double calculateSalary() {
            int totalHoursWorked = timesheets.stream().mapToInt(Main.Timesheet::getEffectiveHours).sum();
            return salary.calculateTotalSalary(totalHoursWorked);
        }

        public void processPayment() {
            System.out.println("Төлбөр илгээсэн арга: " + paymentMethod.getMethod());
            System.out.println("Төлбөрийн мэдээлэл: " + paymentMethod.getDetails());
            System.out.println("Цалин: ₮" + calculateSalary());
        }
    }
}
