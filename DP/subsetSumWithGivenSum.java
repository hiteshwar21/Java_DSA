package DP;

public class subsetSumWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int sum = 6;
        int count = perfectSum(arr, sum);
    }


    static int perfectSum(int[] arr, int sum) {
        int size = arr.length;
        double mod = 1e9 + 7;
        double[][] t = new double[size + 1][sum + 1];

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = (t[i - 1][j - arr[i - 1]] + t[i - 1][j]) % mod;
                } else {
                    t[i][j] = t[i - 1][j] % mod;
                }
            }
        }

        return (int) (t[size][sum] % mod);
    }
}