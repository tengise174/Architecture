import java.util.ArrayList;
import java.util.List;

abstract class Person {
    protected String id;
    protected String name;
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {return id;}

    public String getName() {return name;}

    public abstract String getJobDescription();
}

public class Main {
    public static class Employee {
        private String id;
        private String name;
        private JobDescription jobDescription;
        private Salary salary;
        private PaymentMethod paymentMethod;
        private List<Timesheet> timesheets = new ArrayList<>();

        public Employee(String id, String name, JobDescription jobDescription, Salary salary, PaymentMethod paymentMethod) {
            this.id = id;
            this.name = name;
            this.jobDescription = jobDescription;
            this.salary = salary;
            this.paymentMethod = paymentMethod;
        }

        public void logTimesheet(int hours, Timesheet.WorkType workType) {
            Timesheet timesheet = new Timesheet(this, hours, workType);
            timesheets.add(timesheet);
            System.out.println(name + " logged " + hours + " hours as " + workType);

            if (workType == Timesheet.WorkType.WORKED_HOUR) {
                jobDescription.addWorkedDays(hours);
            } else if (workType == Timesheet.WorkType.BONUS_HOUR) {
                jobDescription.addBonusDays(hours);
            } else if (workType == Timesheet.WorkType.DEDUCTION_HOUR) {
                jobDescription.addDeductionDays(hours);
            }
        }

        public double calculateSalary() {
            int totalEffectiveHours = timesheets.stream().mapToInt(Timesheet::getEffectiveHours).sum();
            return salary.calculateTotalSalary(totalEffectiveHours);
        }

        public void processPayment() {
            System.out.println("Processing payment for " + name + " via: " + paymentMethod.getMethod());
            System.out.println("Total salary: $" + calculateSalary());
            System.out.println("Job Description Overview: \n" + jobDescription);
        }
    }

    public static class JobDescription {
        private String title;
        private int workingDays = 0;
        private int bonusDays = 0;
        private int deductionDays = 0;

        public JobDescription(String title) {this.title = title;}

        public void addWorkedDays(int days) {workingDays += days;}

        public void addBonusDays(int days) {bonusDays += days;}

        public void addDeductionDays(int days) {deductionDays += days;}

        public int getWorkedDays() {return workingDays;}

        public int getBonusDays() {return bonusDays;}

        public int getDeductionDays() {return deductionDays;}

        public int calculateEffectiveDaysWorked() {return workingDays + bonusDays - deductionDays;}

        @Override
        public String toString() {
            return "Job Description: " + title + "\nWorked Days: " + workingDays + "\nBonus Days: " + bonusDays + "\nDeduction Days: " + deductionDays;
        }
    }

    public static class Salary {
        private double hourlyRate;
        private double shiftPay;
        private double award;
        private double deduction;

        public Salary(double hourlyRate, double shiftPay, double award, double deduction) {
            this.hourlyRate = hourlyRate;
            this.shiftPay = shiftPay;
            this.award = award;
            this.deduction = deduction;
        }

        public double calculateTotalSalary(int hoursWorked) {
            double baseSalary = hoursWorked * hourlyRate;
            double totalSalary = baseSalary + shiftPay + award - deduction;
            return totalSalary;
        }

    }

    public static class Timesheet {
        public enum WorkType {
            WORKED_HOUR, BONUS_HOUR, DEDUCTION_HOUR
        }

        private Employee employee;
        private int hours;
        private WorkType workType;

        public Timesheet(Employee employee, int hours, WorkType workType) {
            this.employee = employee;
            this.hours = hours;
            this.workType = workType;
        }

        public int getHours() {return hours;}

        public WorkType getWorkType() {return workType;}

        public int getEffectiveHours() {
            if (workType == WorkType.WORKED_HOUR || workType == WorkType.BONUS_HOUR) {
                return hours;
            } else if (workType == WorkType.DEDUCTION_HOUR) {
                return -hours;
            }
            return 0;
        }
    }

    public static class PaymentMethod {
        private String method;
        private String details;

        public PaymentMethod(String method, String details) {
            this.method = method;
            this.details = details;
        }

        public String getMethod() {return method;}

        public String getDetails() {return details;}
    }


    public static void main(String[] args) {
        JobDescription jobDescription = new JobDescription("Software Engineer");

        Salary salary = new Salary(25, 100, 50, 30);

        PaymentMethod paymentMethod = new PaymentMethod("Bank", "Account: 123456");

        Employee employee = new Employee("E001", "John", jobDescription, salary, paymentMethod);

        employee.logTimesheet(8, Timesheet.WorkType.WORKED_HOUR);
        employee.logTimesheet(2, Timesheet.WorkType.BONUS_HOUR);
        employee.logTimesheet(1, Timesheet.WorkType.DEDUCTION_HOUR);

        employee.processPayment();
    }
}