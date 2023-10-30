package DP;

public class minDiffInPartitions {
    public static void main(String[] args) {
        int[] set = {1,5,11,9};
        System.out.println(getMinDiffBetweenAny2Partition(set));
    }

    static int getMinDiffBetweenAny2Partition(int[] arr){
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        return getMinPartition(arr, sum);
    }

    static int getMinPartition(int[] set, int sum){
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
        for(int i=1; i<=set.length; i++){
            for(int j=1; j<=sum; j++){
                if(set[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-set[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp);
        for(int k=sum/2; k<=sum; k++){
            if(dp[set.length][k] > 0){
                return Math.abs(2*k-sum);
            }
        }
        return -1;
    }
}
