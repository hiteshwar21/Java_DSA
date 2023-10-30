package MockPractise.Arrays;

/*Given an array A of n positive numbers. The task is to find the first equilibrium point in an array. Equilibrium point in an array is an index (or position) such that the sum of all elements before that index is same as sum of elements after it.

        Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists.

        Example 1:

        Input:
        n = 5
        A[] = {1,3,5,2,2}
        Output:
        3
        Explanation:
        equilibrium point is at position 3 as sum of elements before it (1+3) = sum of elements after it (2+2).*/
public class EquilibriumPoint {
    public static void main(String args[]){
        int[] arr = {1,2};
        System.out.println(findEquilibrium(arr));
    }

    static int findEquilibrium(int[] arr){
        int start = 0, end = arr.length-1;
        int leftSum = arr[start], rightSum = arr[end];
        while(start<end-2){
            if(leftSum < rightSum){
                start++;
                leftSum += arr[start];
            } else {
                end--;
                rightSum += arr[end];
            }
        }
        if(rightSum == leftSum){
            return start+1;
        } else {
            return -1;
        }
    }
}
