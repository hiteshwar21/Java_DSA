package MockPractise.Arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/*Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

        Note :-  l and r denotes the starting and ending index of the array.

        Example 1:

        Input:
        N = 6
        arr[] = 7 10 4 3 20 15
        K = 3
        Output : 7
        Explanation :
        3rd smallest element in the given
        array is 7.*/
public class KthSmallestElement {
    public static void main(String args[]){
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        System.out.println(getKthSmallest(arr, k));
    }

    static int getKthSmallest(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<arr.length; i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}
