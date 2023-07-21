package Arrays.OG;

/**
 * Given an array A[] of N integers.
 * The task is to find the number of triples (i, j, k) , where i, j, k are indices and (1 <= i < j < k <= N),
 * such that in the set { A_i   , A_j   , A_k   } at least one of the numbers can be written as the sum of the other two.
 * Input : A[] = {1, 2, 3, 4, 5}
 * Output : 4
 */
public class countTriplets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(countTheTriplets(arr));
    }

    static int countTheTriplets(int[] arr){
        int result = 0;
        int maxVal = 0;
        for (int k : arr) maxVal = Math.max(maxVal, k);
        int[] freq = new int[maxVal + 1];
        for (int k : arr) freq[k]++;

        // Case 1: 0, 0, 0
        result += freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6;

        // Case 2: 0, x, x
        for (int i = 1; i <= maxVal; i++)
            result += freq[0] * freq[i] * (freq[i] - 1) / 2;

        // Case 3: x, x, 2*x
        for (int i = 1; 2 * i <= maxVal; i++)
            result += freq[i] * (freq[i] - 1) / 2 * freq[2 * i];

        // Case 4: x, y, x + y
        // iterate through all pairs (x, y)
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i + 1; i + j <= maxVal; j++)
                result += freq[i] * freq[j] * freq[i + j];
        }

        return result;
    }
}
