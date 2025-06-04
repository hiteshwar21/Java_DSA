package EPAMCoding.StreamsAndLambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountFreqOfWords {
    public static void countFreqOfWord() {
        List<String> words = List.of("apple", "banana", "apple");
        Map<String, Long> wordFreq = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
        wordFreq.entrySet().forEach(System.out::println);
    }
}
