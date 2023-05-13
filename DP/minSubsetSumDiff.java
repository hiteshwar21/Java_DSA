package DP;

public class minSubsetSumDiff {

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int size = arr.length;
        System.out.println(minDifference(arr, size));

    }

    static int minDifference(int[] arr, int size) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        int target = sum / 2;

        Integer[][] dp = new Integer[size + 1][target + 1];
        for (int i = 0; i <= size; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= target; i++) {
            dp[0][i] = 0;
        }

        int partitonOneSum = helper(arr, size, target, dp);

        return sum - (2 * partitonOneSum);
    }

    static int helper(int[] arr, int n, int target, Integer[][] dp) {
        if (dp[n][target] != null)
            return dp[n][target];

        if (arr[n - 1] <= target) {
            dp[n][target] = Math.max(
                    arr[n - 1] + helper(arr, n - 1, target - arr[n - 1], dp),
                    helper(arr, n - 1, target, dp)
            );
        } else {
            dp[n][target] = helper(arr, n - 1, target, dp);
        }

        return dp[n][target];
    }
}