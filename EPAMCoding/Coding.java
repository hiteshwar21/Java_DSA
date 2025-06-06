package EPAMCoding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//List{List{2,4,6,8,10}, List{1,3,5,7,9}}
// task is to flatten the list and you have to use stream operations, print the output list in descending order.
public class Coding {
    public static void main(String[] args) {
        List<List<Integer>> input = List.of(List.of(2,4,6,8,10), List.of(1,3,5,7,9));
        input.stream()
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
