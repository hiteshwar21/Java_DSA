package Heap;


import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,5,6,3};
        int k =3;
        System.out.println(getKthSmallestInteger(arr, k));
    }

    static int getKthSmallestInteger(int[] arr, int k){
        if(arr.length==0){
            return -1;
        }
        //max Heap
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i< arr.length;i++){
            pQueue.add(arr[i]);
            if (pQueue.size()>k){
                pQueue.poll();
            }
        }
        return pQueue.peek();
    }
}
