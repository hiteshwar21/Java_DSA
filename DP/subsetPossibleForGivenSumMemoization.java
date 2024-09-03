package DP;

// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
// Given a set of non-negative integers and a value sum, the task is to check if there is a subset of the given set
// whose sum is equal to the given sum.

public class subsetPossibleForGivenSumMemoization {
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(getSubsetIfPossibleForSum(set, sum, set.length));
    }

    //Time : O(sum*n)
    //Space: O(sum*n)
    static int getSubsetIfPossibleForSum(int[] arr, int sum, int currSize){
        // Storing the value -1 to the matrix
        int[][] tab = new int[currSize+1][sum];
        for(int i=1; i<=currSize; i++) {
            for(int j=1; j<=sum; j++) {
                tab[i][j] = -1;
            }
        }

        // Base Condition
        if (sum == 0)
            return 1;
        if (currSize == 0)
            return 0;

        // if value is not -1, it means already called before
        if (tab[currSize-1][sum] != -1)
            return tab[currSize-1][sum];

        //Ignore if last value greater than the sum
        if (arr[currSize-1] > sum) {
            tab[currSize-1][sum] = getSubsetIfPossibleForSum(arr, sum, currSize-1);
        } else{
            //check if any of the condition before has non-zero value. if yes, then we are setting our current value to 1.
            if (getSubsetIfPossibleForSum(arr, sum, currSize-1) != 0 ||
                    getSubsetIfPossibleForSum(arr, sum-arr[currSize-1], currSize-1) !=0) {
                tab[currSize-1][sum] = 1;
            } else {
                tab[currSize-1][sum] = 0;
            }
        }
        return tab[currSize - 1][sum];
    }
}
