package EPAMCoding;

import java.util.*;

public class MS {

    static final int MOD = 1_000_000_007;
    static final int MAX_NUM = 5000;
    static Map<Integer, List<Integer>> digitSumMap = new HashMap<>();

    /**
     * Main method to count all valid result arrays
     */
    public static int countArrays(List<Integer> required_sums) {
        int n = required_sums.size();
        if (n == 0) return 0;

        precomputeDigitSums();

// dp[i]: Map of {endingNumber -> ways to build sequence of length i+1 ending with that number}
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();

// Initialize DP[0] for first digit sum
        for (int num : digitSumMap.getOrDefault(required_sums.get(0), Collections.emptyList())) {
            dp[0].put(num, 1); // One way to form a sequence of length 1 ending with num
        }

        for (int i = 1; i < n; i++) {
            List<Integer> currList = digitSumMap.getOrDefault(required_sums.get(i), Collections.emptyList());
            List<Integer> prevList = new ArrayList<>(dp[i - 1].keySet());
            Collections.sort(prevList);

// Prefix sum for previous DP map to allow fast sum query
            long[] prefix = new long[prevList.size() + 1];
            for (int j = 0; j < prevList.size(); j++) {
                int val = dp[i - 1].getOrDefault(prevList.get(j), 0);
                prefix[j + 1] = (prefix[j] + val) % MOD;
            }

// For each curr, find number of prev ≤ curr
            for (int curr : currList) {
                int idx = upperBound(prevList, curr); // count of prev ≤ curr
                if (idx > 0) {
                    int ways = (int) prefix[idx]; // sum of all valid transitions
                    dp[i].put(curr, ways);
                }
            }
        }

// Sum all valid arrays ending at position n-1
        int result = 0;
        for (int val : dp[n - 1].values()) {
            result = (result + val) % MOD;
        }

        return result;
    }

    /**
     * Precomputes all numbers < 5000 grouped by digit sum
     */
    private static void precomputeDigitSums() {
        digitSumMap.clear();
        for (int i = 0; i < MAX_NUM; i++) {
            int sum = digitSum(i);
            digitSumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    /**
     * Calculates the digit sum of a number
     */
    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /**
     * Custom upper bound implementation: returns index of first element > target
     * i.e., how many elements in list ≤ target
     */
    private static int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * Main method to run tests
     */
    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1, 31);
        System.out.println("Output 1: " + countArrays(test1)); // Expected: 4

        List<Integer> test2 = Arrays.asList(31, 7, 23, 17, 1);
        System.out.println("Output 2: " + countArrays(test2)); // Expected: 0

        List<Integer> test3 = Arrays.asList(30, 31, 31);
        System.out.println("Output 3: " + countArrays(test3)); // Expected: 4 (from example)
    }
}