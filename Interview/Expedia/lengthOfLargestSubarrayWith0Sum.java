package Interview.Expedia;

import java.util.HashMap;

public class lengthOfLargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-3,5,8};
        System.out.println(getCountOfLargestSubArray(arr));
    }

    static int getCountOfLargestSubArray(int[] arr){
        int maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if(sum == 0) {
                maxCount = i+1;
            }
            
        }


        return maxCount;
    }
}
