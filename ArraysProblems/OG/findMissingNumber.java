package ArraysProblems.OG;

/**
 * Given an array arr[] of size N-1 with integers in the range of [1, N], the task is to find the missing number from the first N integers.
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}, N = 8
 * Output: 5
 */
public class findMissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        System.out.println(getMissingNumber(arr));
    }

    static int getMissingNumber(int[] arr){
        int actual = arr[0];
        int expected = 1;

        // For xor of all the elements in array
        for (int i = 1; i < arr.length; i++)
            actual = actual ^ arr[i];

        // For xor of all the elements from 1 to n+1
        for (int i = 2; i <= arr.length + 1; i++)
            expected = expected ^ i;

        return (actual ^ expected);
    }
}
