package BinarySearch;


/*Let's suppose that we have an array sorted in descending order and we want to find index of an element e within this array.
 Binary search in every step picks the middle element (m) of the array and compares it to e. If these elements are equal, than it returns the index of m.
 If e is greater than m, than e must be located in the left subarray. On the contrary, if m greater than e, e must be located in the right subarray.
 At this moment binary search repeats the step on the respective subrarray.

 Because the algoritm splits in every step the array in half (and one half of the array is never processed) the input element must be located
 (or determined missing) in at most \\log_{2}{n} steps.*/
public class BSOnReverseSortedArray {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2};
        int k = 8;
        System.out.println(getIdx(arr,k));
    }

    static int getIdx(int[] arr, int k){
        int start = 0, end = arr.length-1;
        int mid = start + (end-start)/2;
        while (start<=end){
            if(arr[mid] == k){
                return mid;
            }
            if(arr[mid]<k){
                end = mid-1;
            } else{
                start = mid+1;
            }
            mid = start + (end-start)/2;
        }
        return -1;
    }
}
