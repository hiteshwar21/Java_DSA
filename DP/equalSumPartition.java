package DP;

public class equalSumPartition {

        public static void main(String[] args) {
            int[] arr = {1, 5, 11, 5};
            int size = arr.length;
            System.out.println(canPartition(arr, size));
        }

        private static boolean canPartition(int[] arr, int n) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }

            boolean[][] t = new boolean[n + 1][sum + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    if (i == 0) {
                        t[i][j] = false;
                    }
                    if (j == 0) {
                        t[i][j] = true;
                    }
                }
            }
            if (sum % 2 != 0) {
                return false;
            }
            return isEqualSubsetSum(arr, sum / 2, n, t);
        }

        private static boolean isEqualSubsetSum(int[] arr, int sum, int n, boolean[][] t) {
            if (n == 0 && sum != 0) {
                return false;
            }

            if (sum == 0) {
                return true;
            }

            if (t[n][sum]) {
                return true;
            }

            if (arr[n - 1] <= sum) {
                return t[n][sum] = isEqualSubsetSum(arr, sum - arr[n - 1], n - 1, t)
                        || isEqualSubsetSum(arr, sum, n - 1, t);
            } else {
                return t[n][sum] = isEqualSubsetSum(arr, sum, n - 1, t);
            }
        }
}
