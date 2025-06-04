package EPAMCoding.StreamsAndLambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DifferentCollectorsUsage {
    static List<String> names = List.of("Alice", "Bob");

    public static void groupbyResult(){
        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);
    }
    public static void joiningResult() {
        String joiningResult = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joiningResult);
    }

    public static void partitioningResult(){
        Map<Boolean, List<String>> partitioningResult = names.stream()
                .collect(Collectors.partitioningBy(name -> name.length()>3));
        System.out.println(partitioningResult);
    }
}
