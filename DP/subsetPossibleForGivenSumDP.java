package DP;

/* https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
Given a set of non-negative integers and a value sum, the task is to check if there is a subset of the given set
whose sum is equal to the given sum. */

public class subsetPossibleForGivenSumDP {
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(getSubsetIfPossible(set, sum));
        System.out.println(getSubsetIfPossibleLinearStorage(set, set.length, sum));
    }

    //Time : O(sum*n)
    //Space: O(sum*n)
    static Boolean getSubsetIfPossible(int[] arr, int sum){
        Boolean[][] dp = new Boolean[arr.length+1][sum+1];
        for(int i=0; i<=arr.length; i++){
            for(int j=0; j<=sum;j++){
                if(i==0){
                    dp[i][j] = false;
                }
                if(j==0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i=1; i<=arr.length; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length][sum];
    }

    //Time : O(sum*n)
    //Space: O(sum)
    static boolean getSubsetIfPossibleLinearStorage(int[] arr, int size, int sum) {
        boolean[] prev = new boolean[sum+1];
        boolean[] curr = new boolean[sum+1];

        //prev[0] is always true as sum for it is 0.
        prev[0] = true;

        for(int i=1; i<=size; i++){
            for(int j=0; j<=sum; j++) {
                if(j < arr[i-1]) {
                    curr[j] = prev [j];
                } else {
                    curr[j] = (prev[j] || prev[j- arr[i-1]]);
                }
            }
            prev = curr.clone();
        }
        return prev[sum];
    }
}
