package EPAMCoding;

import java.util.*;
import java.util.stream.Collectors;

//Create a collection of names, e.g.  "Dave", "Joe", "Ryan", "Iyan", "Ray", and print person’s name capitalized.
public class CreateCollectionAndPrintNames {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        System.out.println(list.stream().mapToInt(a -> a*a).sum());

        String text = "Welcome to my house My house you are welcome";
        Map<String, Long> count = Arrays.stream(text.split("\\s"))
                .map(word -> word.toLowerCase())
                .collect(Collectors.groupingBy(word->word, Collectors.counting()));
        System.out.println(count);

        HashSet<Integer> set = new HashSet<>();
        List<Integer> arr = Arrays.asList(10,20,31,21,10,21,31);
        Set<Integer> result = arr.stream().filter(x-> !set.add(x)).collect(Collectors.toSet());
        System.out.println(result);
    }
}