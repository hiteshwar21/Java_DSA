package MockPractise.Arrays;

import java.util.Arrays;

/*Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
        Each packet can have a variable number of chocolates. There are M students,
        the task is to distribute chocolate packets among M students such that :
        1. Each student gets exactly one packet.
        2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

        Example 1:

        Input:
        N = 8, M = 5
        A = {3, 4, 1, 9, 56, 7, 9, 12}
        Output: 6
        Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6
        by choosing following M packets :{3, 4, 9, 7, 9}.*/
public class ChocolateDistribution {
    public static void main(String args[]){
        int[] chocoArray = {3, 4, 1, 9, 56, 7, 9, 12};
        int kidCount = 5;
        System.out.println(getMinDiff(chocoArray, kidCount));
    }

    static int getMinDiff(int[] arr, int kidCount){
        int minDiff = Integer.MAX_VALUE;
        if(kidCount > arr.length){
            return -1;
        }
        Arrays.sort(arr);
        int start = 0, end=0;
        while (end<arr.length){
            if(end-start+1 == kidCount) {
                minDiff = Math.min(minDiff, arr[end]-arr[start]);
                start++;
            }
            end++;
        }
        return minDiff;
    }
}
