package EPAMCoding;

import java.util.PriorityQueue;

public class GoogleInterview {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int result = getKthLargestElement(arr, k);
        System.out.println(result);
    }

    static int getKthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : arr){
            pq.offer(x);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
