package Interview.Expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Using streams, we are expected to find the distinct value from a list of numbers
//arr: {1,2,2,3,4,4,5}
//result: {1,2,3,4,5}
public class streams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,3,4,4,5);

        List<Integer> distinctList = list.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctList);

        List<List<Integer>> levels = new ArrayList<>();

        String flat = levels.stream()
                .flatMap(List::stream)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("Flat Level Order: " + flat);
    }
}
