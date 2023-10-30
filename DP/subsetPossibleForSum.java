package DP;

public class subsetPossibleForSum {
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(getSubsetIfPossible(set, sum));
    }

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
}
