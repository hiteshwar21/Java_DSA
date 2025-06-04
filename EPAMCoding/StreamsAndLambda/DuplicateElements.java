package EPAMCoding.StreamsAndLambda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {
    public static void collectDuplicates() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "John", "Alice");

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = names.stream()
                .filter(name -> !seen.add(name))
                .collect(Collectors.toSet());
        System.out.println(duplicates);
    }
}
