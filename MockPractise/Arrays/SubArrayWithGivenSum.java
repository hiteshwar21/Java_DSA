package MockPractise.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
    public static void main(String args[]){
        int[] arr = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        int[] result = getSubarraySum(sum, arr);
        Arrays.stream(result).forEach(System.out::println);
    }

    static int[] getSubarraySum(int sum, int[] arr) {
        Map<Integer, Integer> sum_Map = new HashMap<>();
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(arr.length == 0) {
            return result;
        }
        int currSum = 0;
        for (int i = 0; i<arr.length;i++) {
            currSum += arr[i];
            if(currSum-sum == 0) {
                result[0] = 0;
                result[1] = i;
            }
            if(sum_Map.containsKey(currSum-sum)){
                result[0] = sum_Map.get(currSum-sum) + 1;
                result[1] = i;
                return result;
            } else {
                sum_Map.put(currSum, i);
            }
        }
        return result;
    }
}
