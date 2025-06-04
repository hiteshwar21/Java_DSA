package EPAMCoding.StreamsAndLambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static void listToMap(){
        List<String> words = List.of("Hi","My","name","is","Hiteshwar");
        Map<String, Integer> wordWithLengthMap = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.length()
                ));
        words.forEach(System.out::println);
        wordWithLengthMap.entrySet().forEach(System.out::println);

    }
}
