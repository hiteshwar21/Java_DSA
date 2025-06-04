package EPAMCoding.StreamsAndLambda;

import java.util.*;

public class SecondHighestSalary {

    public record Employee(int id, String name, double salary) {}

    public static void getSecondHighestSalary() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 75000.0),
                new Employee(2, "Bob", 85000.0),
                new Employee(3, "Charlie", 95000.0),
                new Employee(4, "David", 75000.0),
                new Employee(5, "Eve", 105000.0),
                new Employee(6, "Frank", 95000.0)
        );

        Optional<Double> secondHighest = employees.stream()
                .map(Employee::salary) // method from record
                .distinct()// convert DoubleStream → Stream<Double>
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();


        System.out.println(secondHighest);
    }
}
