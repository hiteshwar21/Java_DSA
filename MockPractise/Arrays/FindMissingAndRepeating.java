package MockPractise.Arrays;

/*Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array. Find these two numbers.

        Example 1:

        Input:
        N = 2
        Arr[] = {2, 2}
        Output: 2 1
        Explanation: Repeating number is 2 and
        smallest positive missing number is 1.*/
public class FindMissingAndRepeating {
    public static void main(String args[]){
        int[] arr = {5,2,3,1,5};
        int[] result = findMissingAndRepeating(arr);
    }

    static int[] findMissingAndRepeating(int[] arr){
        int[] result = new int[2];
        for(int i=0; i< arr.length; i++){
            if(arr[i] != i+1 && arr[arr[i]-1] != arr[i]){
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }
        }

        for(int i=0; i< arr.length; i++){
            if(arr[i] != i+1){
                result[0] = arr[i];
                result[1] = i+1;
                return result;
            }
        }
        return result;
    }
}
