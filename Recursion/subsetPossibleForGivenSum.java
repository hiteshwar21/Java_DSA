package Recursion;

// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
// Given a set of non-negative integers and a value sum, the task is to check if there is a subset of the given set
// whose sum is equal to the given sum.
public class subsetPossibleForGivenSum {
    public static void main(String[] args) {
        int[] arr = {3,4,12,5,34,2};
        int sum = 12;
        System.out.println(isSubsetSum(arr, sum, arr.length));
    }

    // Time  - O(2^N)
    // Space - O(N)
    private static boolean isSubsetSum(int[] arr, int sum, int currSize){
        //base condition
        if(sum == 0)
            return true;
        if(currSize == 0)
            return false;

        //if last element is greater than sum, then ignore it
        if(arr[currSize-1] > sum)
            return isSubsetSum(arr, sum, currSize-1);

        // Check if sum possible by any of the following condition -
        // 1. including last element
        // 2. excluding last element
        return isSubsetSum(arr, sum-arr[currSize-1], currSize-1) || isSubsetSum(arr,sum, currSize-1);
    }
}
