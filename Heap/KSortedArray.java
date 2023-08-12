package Heap;

import java.util.PriorityQueue;

/*Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

        Example:
        Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
        k = 3
        Output : arr[] = {2, 3, 5, 6, 8, 9, 10} .*/
public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        int[] arr1 = getKSortedArray(arr, k);
        System.out.println();
    }

    static int[] getKSortedArray(int[] arr, int k){
        if (arr.length == 0 || arr.length<k){
            System.out.println("Wrong Input given");
            return arr;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i =0;i< arr.length;i++){
            priorityQueue.add(arr[i]);
            if(i>=k){
                arr[i-k] = priorityQueue.poll();
            }
        }
        int count = arr.length-k;
        while (!priorityQueue.isEmpty()){
            arr[count] = priorityQueue.poll();
            count++;
        }
        return arr;
    }
}
