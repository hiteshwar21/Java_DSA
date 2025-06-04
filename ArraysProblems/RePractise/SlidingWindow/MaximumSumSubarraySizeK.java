package ArraysProblems.RePractise.SlidingWindow;

//Maximum Sum Subarray of size K | Sliding Window
public class MaximumSumSubarraySizeK {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int size = arr.length;
        int subArraySize = 3;
        int maxSubArraySum = getMaxSubArraySum(arr, size, subArraySize);
        System.out.println(maxSubArraySum);
    }

    static int getMaxSubArraySum(int[] arr, int size, int subArraySize){
        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0;
        int currSum = 0;
        if(subArraySize> size){
            return -1;
        }
        while(end<size){
            if(end-start<subArraySize){
                currSum = currSum+arr[end];
            } else{
                if(maxSum<currSum){
                    maxSum = currSum;
                }
                currSum = currSum+arr[end]-arr[start];
                start++;
            }
            end++;
        }
        return maxSum;
    }
}
