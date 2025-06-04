package MockPractise.Arrays;

import java.util.PriorityQueue;

/*Given an array of integers. Find the Inversion Count in the array.

        Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
        If the array is already sorted then the inversion count is 0.
        If an array is sorted in the reverse order then the inversion count is the maximum.
        Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.


        Example 1:

        Input: N = 5, arr[] = {2, 4, 1, 3, 5}
        Output: 3
        Explanation: The sequence 2, 4, 1, 3, 5
        has three inversions (2, 1), (4, 1), (4, 3).*/
public class InversionOfArray {
    public static void main(String args[]){
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(getInversionCount(arr));
    }

    static class Pair implements Comparable<Pair>{
        int index;
        int data;

        public Pair(int index, int data){
            this.index = index;
            this.data = data;
        }

        @Override
        public int compareTo(Pair o) {
            return this.data - o.data;
        }
    }

    static int getInversionCount(int[] arr){
        int count = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            minHeap.add(new Pair(i, arr[i]));
        }
        int iterator = 1;
        return count;
    }
}
