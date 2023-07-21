package Arrays.OG;

import java.util.HashMap;

/**
 * Given an unsorted array of integers, find a subarray that adds to a given number.
 * If there is more than one subarray with the sum of the given number, print any of them.
 * Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
 * Output: Sum found between indexes 0 to 3
 */
public class subArrayWithGivenSumIntegers {
    public static void main(String[] args){
        subArrayWithGivenSumIntegers subArrayWithGivenSumIntegers = new subArrayWithGivenSumIntegers();
        int[] arr = {10, 2, -2, -20, 10};
        int sum = -10;
        subArrayWithGivenSumIntegers.subArrayWithGivenSum(arr, sum);
    }

    public void subArrayWithGivenSum(int[] arr, int sum)
    {
        int currSum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (currSum - sum == 0) {
                end = i;
                break;
            }
            if (hashMap.containsKey(currSum - sum)) {
                start = hashMap.get(currSum - sum) + 1;
                end = i;
                break;
            }
          hashMap.put(currSum, i);
        }
        if (end == -1) {
            System.out.println(
                    "No subarray with given sum exists");
        }
        else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }
    }
}
