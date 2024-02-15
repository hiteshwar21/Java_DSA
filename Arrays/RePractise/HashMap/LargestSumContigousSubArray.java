package Arrays.RePractise.HashMap;

//Given an array arr[] of size N. The task is to find the sum of the contiguous subarray within an arr[] with the largest sum.
// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class LargestSumContigousSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(getLargestSumContigousSubArray(arr));
    }

    static int getLargestSumContigousSubArray(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0;i<arr.length;i++){
            currSum = currSum+ arr[i];
            if(currSum> maxSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}
