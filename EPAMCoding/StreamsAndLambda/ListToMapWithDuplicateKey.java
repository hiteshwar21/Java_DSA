package EPAMCoding.StreamsAndLambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapWithDuplicateKey {
    public static void listToMapWithDuplicates(){
        List<String> words = List.of("Hi", "My", "name", "is", "Hiteshwar", "Hi");
        Map<String, Long> freqMap = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1L,
                        Long::sum
                ));
        freqMap.entrySet().forEach(System.out::println);
    }
}
