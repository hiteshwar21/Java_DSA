package Heap;

import java.util.*;

/*Print the elements of an array in the increasing frequency if 2 numbers have same frequency then print the one which came first.

        Example:
        Input : arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
        Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6} .*/
public class FrequencySort {

    static class Pair implements Comparable<Pair>{
        int freq;
        int data;

        public Pair(int freq, int data){
            this.freq = freq;
            this.data = data;
        }

        @Override
        public int compareTo(Pair o) {
            return this.freq - o.freq;
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
        sortByFrequency(arr);
        findLeastNumOfUniqueInts(arr, 2);
    }

    static void sortByFrequency(int[] arr){
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i: arr){
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer, Integer> map : hashMap.entrySet()){
            maxHeap.add(new Pair(map.getValue(), map.getKey()));
        }

        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll().data + " ");
        }
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        if(k >= arr.length){
            return 0;
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i: arr){
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer, Integer> map : hashMap.entrySet()){
            minHeap.add(new Pair(map.getValue(), map.getKey()));
        }
        for(int i=k;i>0;i--){
            int freq = minHeap.peek().freq;
            if(freq == 0){
                minHeap.poll();
                freq = minHeap.peek().freq;
            }
            freq--;
        }
        return minHeap.size();
    }

    public int heightChecker(int[] heights) {
        int count =0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<heights.length;i++){
            minHeap.add(heights[i]);
        }
        for(int i=0;i<heights.length;i++){
            if(heights[i]!= minHeap.poll()){
                count++;
            }
        }
        return count;
    }
}
