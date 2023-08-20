package DP;

/*Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
        Example:

        Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
        Output:  True  //There is a subset (4, 5) with sum 9.*/
public class subsetProblem {

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(getSubset(set, set.length, sum));
    }

    static boolean getSubset(int[] arr, int size, int sum){
        boolean[][] matrix = new boolean[size+1][sum+1];
        for(int i =0;i<=size;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    matrix[i][j] = false;
                }
                if(j==0){
                     matrix[i][j] = true;
                }
            }
        }
        for (int i =1;i<=size;i++){
            for (int j=1;j<=sum;j++){
                if(arr[i-1]<= j){
                    matrix[i][j] = matrix[i-1][j] || matrix[i][j-arr[i-1]];
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        return matrix[size][sum];
    }
}
