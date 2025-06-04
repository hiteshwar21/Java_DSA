package ArraysProblems.RePractise.HashMap;

import java.util.HashMap;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/ Handles Negative Integers
/*Given an unsorted array of integers, find a subarray that adds to a given number. If there is more than one subarray with the sum of the given number, print any of them.

        Examples:

        Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
        Output: Sum found between indexes 2 and 4
        Explanation: Sum of elements between indices
        2 and 4 is 20 + 3 + 10 = 33*/
public class FindSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int desiredSum = 33;
        getSubArrayWithGivenSum(arr, desiredSum);
    }

    static void getSubArrayWithGivenSum(int[] arr, int desiredSum){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int currSum = 0;
        int start = 0, end = -1;
        for(int i=0;i<arr.length;i++){
            currSum += arr[i];
            hashMap.put(currSum, i);
            if (currSum-desiredSum == 0){
                end = i;
                System.out.println("Sum found between indices " + start + " and " + end);
                break;
            }
            if(hashMap.containsKey(currSum-desiredSum)){
                start = hashMap.get(currSum-desiredSum) +1;
                end = i;
                System.out.println("Sum found between indices " + start + " and " + end);
                break;
            }
        }
        if(end == -1){
            System.out.println("Nothing found");
        }
    }
}
