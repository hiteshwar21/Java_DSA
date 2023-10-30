package DP;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] set = {1,5,11,5,6};
        System.out.println(getEqualSumPartition(set));
    }

    static boolean getEqualSumPartition(int[] arr){
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        if(sum%2 != 0){
            return false;
        }
        return getPossibleEqualPartition(arr, sum/2);
    }

    static boolean getPossibleEqualPartition(int[] arr, int sum){
        boolean[][] dp = new boolean[arr.length+1][sum+1];
        for(int i=0; i<=arr.length; i++){
            for(int j=0; j<=sum; j++){
                if(i == 0) {
                    dp[i][j] = false;
                }
                if(j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for(int i=1; i<=arr.length; i++) {
            for (int j=1; j <= sum; j++) {
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length][sum];
    }
}
