package EPAMCoding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Using Stream API - Get any 15 authors with unique surname in uppercase and age above 50(Provided Author class with some fields)
public class UniqueSurname {

    private static final List<Author> authors = Arrays.asList(
            new Author("John", "Smith", 55, "USA"),
            new Author("Emma", "Johnson", 60, "UK"),
            new Author("Liam", "Brown", 70, "Canada"),
            new Author("Olivia", "Smith", 65, "USA"),   // Duplicate surname
            new Author("Noah", "Jones", 80, "USA"),
            new Author("Ava", "Garcia", 58, "Spain"),
            new Author("William", "Miller", 66, "Germany"),
            new Author("Sophia", "Davis", 75, "France"),
            new Author("James", "Rodriguez", 68, "Mexico"),
            new Author("Isabella", "Martinez", 54, "Brazil"),
            new Author("Benjamin", "Hernandez", 73, "Argentina"),
            new Author("Mia", "Lopez", 59, "Peru"),
            new Author("Lucas", "Gonzalez", 77, "Chile"),
            new Author("Charlotte", "Wilson", 53, "Australia"),
            new Author("Henry", "Anderson", 81, "New Zealand"),
            new Author("Amelia", "Thomas", 49, "UK"),    // Below 50
            new Author("Alexander", "Taylor", 61, "Canada"),
            new Author("Harper", "Moore", 52, "Ireland"),
            new Author("Ethan", "Jackson", 45, "USA"),   // Below 50
            new Author("Evelyn", "Martin", 60, "Italy")
    );

    public static class Author {
        private String firstName;
        private String lastName;
        private int age;
        private String country;

        public Author(String firstName, String lastName, int age, String country) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.country = country;
        }

        public String getLastName() { return lastName; }

        @Override
        public String toString() {
            return firstName + " " + lastName.toUpperCase() + ", Age: " + age + ", Country: " + country;
        }
    }


    public static void main(String args[]){
        //Surname
        List<String> authorSurname = getUniqueSurname(authors);
        authorSurname.forEach(System.out::println);

        //Author
        List<Author> authorsWithUniqueSurname = getAuthorsUniqueSurname(authors);
        authorsWithUniqueSurname.forEach(System.out::println);
    }

    private static List<String> getUniqueSurname(List<Author> authors) {
        return authors.stream()
                .filter(a -> a.age > 50)
                .map(a -> a.getLastName().toUpperCase())
                .distinct()
                .limit(15)
                .toList();
    }

    private static List<Author> getAuthorsUniqueSurname(List<Author> authors) {
        return authors.stream()
                .filter(author -> author.age > 50)
                .collect(Collectors.toMap(
                        a -> a.getLastName().toUpperCase(), // key by uppercase surname
                        a -> a,                            // keep the Author
                        (a1, a2) -> a1                     // if duplicate, keep first
                ))
                .values().stream()
                .limit(15) // get any 15
                .toList();
    }
}
