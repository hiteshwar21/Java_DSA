package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*Given an array of integers arr, length of the array  N, and an integer K, find all the unique combinations in arr where
        the sum of the combination is equal to K. Each number can only be used once in a combination.

        Input:
        N = 5, K = 7
        arr[] = { 1, 2, 3, 3, 5 }

        Output:
        { { 1, 3, 3 }, { 2, 5 } }

        Explanation:
        1 + 3 + 3 = 7
        2 + 5 = 7*/
public class CombinationSum2 {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String args[]){
        int[] arr = {1,2,3,3,5};
        int targetSum = 7;
        getCombinationSum(arr, targetSum, 0, new ArrayList<>());
        System.out.println(result);
    }

    static void getCombinationSum(int[] arr, int targetSum, int currentSum, List<Integer> possibleOutput){
        //Base Condition
        if(currentSum>targetSum){
            return;
        }

        currentSum += possibleOutput.get(possibleOutput.size()-1);
        if(currentSum == targetSum){
            result.add(possibleOutput);
            return;
        }


    }
}
