package EPAMCoding.StreamsAndLambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmpByDepartment {
    public static class Employee {
        private int id;
        private String name;
        private double salary;
        private String department;
        private String designation;

        public Employee(int id, String name, double salary, String department, String designation) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
            this.designation = designation;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        public String getDesignation() {
            return designation;
        }

        // Setters
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary +
                    ", department='" + department + "', designation='" + designation + "'}";
        }
    }

    public static void groupEmpByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 75000, "Engineering", "Developer"),
                new Employee(2, "Bob", 85000, "Engineering", "Developer"),
                new Employee(3, "Charlie", 95000, "Engineering", "Manager"),
                new Employee(4, "David", 70000, "HR", "Recruiter"),
                new Employee(5, "Eve", 105000, "HR", "Manager"),
                new Employee(6, "Frank", 75000, "HR", "Recruiter")
        );
        Map<String, Map<String, Long>> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getDesignation,
                                Collectors.counting())));
        System.out.println(result);

        Map<String, Map<String, Double>> salarySum = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getDesignation,
                                Collectors.summingDouble(Employee::getSalary))));
        System.out.println(salarySum);
    }
}
