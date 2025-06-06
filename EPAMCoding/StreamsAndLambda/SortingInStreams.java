package EPAMCoding.StreamsAndLambda;

import java.util.*;

public class SortingInStreams {
    static List<String> names = List.of("Alice", "Bob");

    public static void basicSort() {
        List<String> sortedNames = names.stream()
                .sorted()
                .toList();
        System.out.println(sortedNames);
    }


    static class People {
        private static String firstName;
        private static String lastName;

        public void setFirstName(String firstName) {
            People.firstName = firstName;
        }

        public void setLastName(String lastName) {
            People.lastName = lastName;
        }

        public void setAge(Integer age) {
            People.age = age;
        }

        private static Integer age;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Integer getAge() {
            return age;
        }
    }

    public static List<People> getPeople() {
        List<People> crowd = new ArrayList<>();

        People people = new People();
        people.setFirstName("EmpF1");
        people.setLastName("EmpL1");
        people.setAge(25);

        crowd.add(people);

        people.setFirstName("EmpF2");
        people.setLastName("EmpL2");
        people.setAge(35);

        crowd.add(people);

        people.setFirstName("EmpF3");
        people.setLastName("EmpL3");
        people.setAge(15);

        return crowd;
    }

    public static void sortUsingComparator() {
        List<People> crowd = getPeople();
        List<People> sortedNames = crowd.stream()
                .sorted(Comparator.comparing(People::getAge))
                .toList();
        sortedNames.stream().map(people -> people.getFirstName()).forEach(System.out::println);
    }

    public static Comparator<People> comparator = Comparator
            .comparing(People::getAge)
            .thenComparing(People::getFirstName)
            .thenComparing(People::getLastName);

    public static void sortUsingMultipleConditions() {
        List<People> crowd = getPeople();
        List<People> sortedNames = crowd.stream()
                .sorted(comparator)
                .toList();
        sortedNames.forEach(System.out::println);
        sortedNames.stream().map(people -> people.getFirstName()).forEach(System.out::println);
    }
}
