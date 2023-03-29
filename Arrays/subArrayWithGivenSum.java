package Arrays;

/**
 * Given an array arr[] of non-negative integers and an integer sum, find a subarray that adds to a given sum.
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Output: Sum found between indexes 2 and 4
 */
public class subArrayWithGivenSum {
    public static void main(String[] args){
        subArrayWithGivenSum arraySum = new subArrayWithGivenSum();
        int[] arr = { 1, 4, 20, 3, 10, 5 };
        int sum = 33;
        arraySum.subArraySum(arr, sum);
    }

    void subArraySum(int[] arr, int sum){
        int size = arr.length;
        int start = 0;
        int sum_till_calculation = 0;
        for (int j : arr) {
            while (sum_till_calculation > sum && start<j-1){
                sum_till_calculation = sum_till_calculation -arr[start];
                start++;
            }
            if (sum_till_calculation == sum) {
                System.out.println("Sum found between indexes " + start + " and " + j);
                return;
            }
            sum_till_calculation = sum_till_calculation + j;
        }
        System.out.println("Sum not found");
    }
}
