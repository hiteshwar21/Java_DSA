package Arrays.RePractise.SlidingWindow;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/*Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

        Example:

        Input 1:
        A = [1, 3, -1, -3, 5, 3, 6, 7]
        B = 3
        Output 1:
        C = [3, 3, 5, 5, 6, 7] .*/
public class MaximumOfAllSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        int[] result = getMaxAllSubArray(arr, arr.length, windowSize);
    }

    static int[] getMaxAllSubArray(int[] arr, int size, int windowSize){
        int[] result = new int[size-windowSize+1];
        int start = 0, end = 0;
        int max = arr[0];
        int secondMax = arr[0];
        while(end<size) {
            if(end-start< windowSize){
                if(arr[end]>max){
                    secondMax = max;
                    max = arr[end];
                }
            } else {
                result[start] = max;
                if(arr[start] == max){
                    max = secondMax;
                }
                if(arr[end]>max) {
                    secondMax = max;
                    max = arr[end];
                }
                start++;
            }
            end++;
        }
        result[start] = max;
        return result;
    }
}
