import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;
    double salary;
    Employee(String n, String d, double s) { name = n; department = d; salary = s; }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR", 50000),
            new Employee("Bob", "IT", 70000),
            new Employee("Charlie", "HR", 55000),
            new Employee("David", "IT", 80000)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        System.out.println(avgSalaryByDept);
    }
}
