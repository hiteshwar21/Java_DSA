package Heap;

import java.util.PriorityQueue;

/*Given an array of integers and two numbers k1 and k2. Find the sum of all elements between given two k1’th and k2’th smallest elements of the array. It may  be assumed that all elements of array are distinct.

        Example :
        Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6
        Output : 26
        3rd smallest element is 10. 6th smallest element
        is 20. Sum of all element between k1 & k2 is
        12 + 14 = 26 .*/
public class SumBetweenK1SmallestK2Smallest {
    public static void main(String[] args) {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 3;
        int k2 = 6;
        System.out.println(getSumBetweenK1K2(arr, k1, k2));
    }

    static int getSumBetweenK1K2(int[] arr, int k1, int k2){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: arr){
            minHeap.add(i);
        }
        int count =1, sum = 0;
        int small = Math.min(k1,k2);
        int large = Math.max(k1,k2);
        while (!minHeap.isEmpty()){
            if (count > small && count<large){
                sum += minHeap.peek();
            }
            if(count> large){
                break;
            }
            minHeap.poll();
            count++;
        }
        return sum;
    }
}
