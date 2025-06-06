package EPAMCoding.StreamsAndLambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Find the length of Longest string from an array of strings
public class Demo {
    public static void main(String[] args) {
        List<String> words = List.of("Apple", "Banana", "Banana", "Grapes", "Kiwi", "Apple");
        findMaxLen(words);
        findWordWithMaxLen(words);
    }

    public static void findMaxLen(List<String> words) {
        Integer result = words.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length))
                .values().stream().sorted(Collections.reverseOrder()).findFirst().orElse(-1);
        System.out.println(result);
    }

    public static void findWordWithMaxLen(List<String> words) {
        Map<Integer, List<String>> groupedCount = words.stream()
                .distinct()
                .collect(Collectors.groupingBy(String::length));
        List<String> result = groupedCount.entrySet().stream().min(Comparator.comparingInt(Map.Entry::hashCode)).get().getValue();
        System.out.println(result);
    }
}
