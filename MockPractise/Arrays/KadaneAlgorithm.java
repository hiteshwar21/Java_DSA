package MockPractise.Arrays;

/*Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.


        Example 1:

        Input:
        N = 5
        Arr[] = {1,2,3,-2,5}
        Output:
        9
        Explanation:
        Max subarray sum is 9
        of elements (1, 2, 3, -2, 5) which
        is a contiguous subarray.*/
public class KadaneAlgorithm {
    public static void main(String args[]){
        int[] arr = {1,2,3,-2,5};
        System.out.println(getMaxSum(arr));
    }

    static int getMaxSum(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int maxSumTillHere = 0;
        for(int i: arr){
            maxSumTillHere += i;
            maxSum = Math.max(maxSum, maxSumTillHere);

            if(maxSumTillHere < 0){
                maxSumTillHere = 0;
            }
        }
        return maxSum;
    }
}
