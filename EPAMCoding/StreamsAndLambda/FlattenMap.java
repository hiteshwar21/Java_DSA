package EPAMCoding.StreamsAndLambda;

import java.util.Arrays;
import java.util.List;

public class FlattenMap {
    public static void flattenMap() {
        List<String> words = List.of("Hi","My","name","is","Hiteshwar");
        System.out.println(words);

        words.stream().map(s->s.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
    }
}
