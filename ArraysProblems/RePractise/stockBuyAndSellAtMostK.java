package ArraysProblems.RePractise;

import java.util.Arrays;

public class stockBuyAndSellAtMostK {

    public static void main(String[] args) {
        int arr[] = { 10,22,5,75,65,80};
        int k = 2;
        System.out.println("Maximum profit is: " + maxProfit(arr, k));
    }


    /* profit vector stores the maximum profit using at most i transactions up to the current day,
       prevDiff vector stores the maximum difference obtained by subtracting the price of the previous day.*/
    static int maxProfit(int[] arr, int k) {
        int[] profit = new int[k + 1];
        int[] prevDiff = new int[k + 1];
        Arrays.fill(prevDiff, Integer.MIN_VALUE);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= k; j++) {
                prevDiff[j] = Math.max(prevDiff[j], profit[j - 1] - arr[i]);
                profit[j] = Math.max(profit[j], arr[i] + prevDiff[j]);
            }
        }
        return profit[k];
    }
}
