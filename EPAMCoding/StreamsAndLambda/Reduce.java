package EPAMCoding.StreamsAndLambda;

import java.util.List;

public class Reduce {
    public static void reduce() {
        List<Integer> nums = List.of(1,2,3,4,5,6);
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
