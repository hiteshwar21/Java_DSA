package DP;

public class CountOfSubSetWithGivenSum {
    public static void main(String[] args) {
        int[] set = {1,5,11,5,6};
        int sum = 11;
        System.out.println(getCountOfSubsetWithGivenSum(set, sum));
    }

    static int getCountOfSubsetWithGivenSum(int[] set, int sum){
        int[][] dp = new int[set.length+1][sum+1];
        for(int i=0; i<=set.length; i++){
            for(int j=0; j<=sum; j++){
                if(i==0){
                    dp[i][j] = 0;
                }
                if(j==0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=1; i<=set.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if(set[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-set[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[set.length][sum];
    }

}
