package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*Given an array of n numbers. Your task is to read numbers from the array and keep at-most K numbers at the top (According to their decreasing frequency) every time a new number is read. We basically need to print top k numbers sorted by frequency when input stream has included k distinct elements, else need to print all distinct elements sorted by frequency.

        Example:
        Input :  arr[] = {5, 2, 1, 3, 2}
        k = 4
        Output : 5 2 5 1 2 5 1 2 3 5 2 1 3 5 .*/
public class TopKFrequentNumber {
    static class Pair implements Comparable<Pair>{
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
        int[] arr = {1,1,1,1,1,2,2,2,2,3,3,3,4,4,5,6,7,8,9};
        int k = 4;
        getTopKFrequentNumber(arr, k);
    }

    static void getTopKFrequentNumber(int[] arr, int k){
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
        }
        for(Map.Entry<Integer,Integer> map : hashMap.entrySet()){
            minHeap.add(new Pair(map.getValue(), map.getKey()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()){
            System.out.print(minHeap.poll().data + ",");
        }
    }
}
