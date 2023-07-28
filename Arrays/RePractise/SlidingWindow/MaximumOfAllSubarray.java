package Arrays.RePractise.SlidingWindow;

import java.util.*;

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
        //int[] arr1 = {5,4,3,2,1};
        int windowSize = 3;
        int[] result = getMaxAllSubArray(arr, arr.length, windowSize);
    }

    static int[] getMaxAllSubArray(int[] arr, int size, int windowSize){
        int[] result = new int[size-windowSize+1];
        int start = 0, end = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        while(end<size) {
            if(end-start< windowSize){
                minHeap.add(arr[end]);
            } else {
                result[start] = minHeap.peek();
                if(arr[start] == minHeap.peek()){
                    minHeap.poll();
                }
                minHeap.add(arr[end]);
                start++;
            }
            end++;
        }
        result[start] = minHeap.poll();
        return result;
    }
}
