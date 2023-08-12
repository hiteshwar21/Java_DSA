package Heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {1,2,5,3,6,4};
        int k = 3;
        System.out.println(getKthLargestElement(arr, k));
    }

    static int getKthLargestElement(int[] arr, int k){
        if (arr.length == 0){
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            priorityQueue.add(arr[i]);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
