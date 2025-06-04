package EPAMCoding.StreamsAndLambda;

import java.util.List;

public class ParallelStream {
    public static void parallelStream(){
        List<Integer> list = List.of(1, 2, 3, 4);
        int sum = list.parallelStream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
