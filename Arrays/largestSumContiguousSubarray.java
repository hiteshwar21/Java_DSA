package Arrays;

/**
 * Given an array arr[] of size N. The task is to find the sum of the contiguous subarray within a arr[] with the largest sum.
 */
public class largestSumContiguousSubarray {
    public static void main(String[] args)
    {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is "
                + maxSubArraySum(a));
    }

    static int maxSubArraySum(int[] arr)
    {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int j : arr) {
            maxEndingHere = maxEndingHere + j;
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }
}