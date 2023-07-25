package Arrays.RePractise.SlidingWindow;

/*Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.

        For Input:
        1
        7 5
        4 1 1 1 2 3 5
        your output is:
        4 .*/
public class LargestSubArrayOfSumK {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int requiredSum = 5;
        System.out.println(getLargestSubArrayForGivenSum(arr, arr.length, requiredSum));
    }

    //This will only work for Non-Negative Integers
    static int getLargestSubArrayForGivenSum(int[] arr, int size, int requiredSum){
        int start = 0, end = 0;
        int max = -1;
        int sum = 0;
        while (end<size){
            sum = sum + arr[end];
            if (sum > requiredSum){
                while (sum>requiredSum){
                    sum = sum - arr[start];
                    start++;
                }
            }
            if (sum == requiredSum){
                if(max<end-start+1){
                    max = end-start+1;
                }
            }
            end++;
        }
        return max;
    }
}
