import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String rank;
    private double salary;

    public Employee(String name, String rank, double salary) {
        this.name = name;
        this.rank = rank;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public double getSalary() {
        return salary;
    }
}

class Organization {
    private List<Employee> employees;

    public Organization() {
        employees = new ArrayList<>();

        employees.add(new Employee("Бат", "New Employee", 30000));
        employees.add(new Employee("Дорж", "Employee", 40000));
        employees.add(new Employee("Цэцэг", "Senior Employee", 50000));
        employees.add(new Employee("Гэрэл", "Management", 70000));
        employees.add(new Employee("Долгор", "Employee", 40000));
        employees.add(new Employee("Дандар", "Senior Employee", 50000));
    }

    public void displayEmployeeDetails() {
        System.out.println("Ажилтнуудын мэдээлэл:");
        for (Employee employee : employees) {
            System.out.println("Нэр: " + employee.getName() + ", Түвшин: " + employee.getRank() + ", Цалин: " + employee.getSalary());
        }
    }

    public void calculateTotalPayroll() {
        double totalPayroll = 0;
        for (Employee employee : employees) {
            totalPayroll += employee.getSalary();
        }
        System.out.println("\nНийт цалин: " + totalPayroll);
    }
}

public class OrganizationApp {
    public static void main(String[] args) {
        Organization organization = new Organization();
        organization.displayEmployeeDetails();
        organization.calculateTotalPayroll();
    }
}
