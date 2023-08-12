package Heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Given an unsorted array and two numbers x and k, find k closest values to x.
        Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3 .*/
public class KClosestNumber {
    static class Pair implements Comparable<Pair> {
        int key;
        int data;

        public Pair(int key, int data){
            this.key = key;
            this.data = data;
        }

        @Override
        public int compareTo(Pair o) {
            return this.key - o.key;
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 14, 4, 7, 6};
        int x = 5;
        int k = 3;
        getKClosest(arr, x, k);
    }

    static void getKClosest(int[] arr, int x, int k){
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i< arr.length;i++){
            maxHeap.add(new Pair(Math.abs(arr[i]-x), arr[i]));
            if(i>k){
                maxHeap.poll();
            }
        }
        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll().data);
        }
    }
}
