package BinarySearch;

/*Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.
        Example:
        Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}
        x = 5
        Output : First Occurrence = 2
        Last Occurrence = 5*/
public class CountOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5 ,5, 67, 123, 125};
        int x =5;
        int firstIdx = getFirstOccurrence(arr, x);
        int lastIdx = getLastOccurrence(arr, x);
        System.out.println(lastIdx-firstIdx+1);
    }

    static int getFirstOccurrence(int[] arr, int x){
        int result = -1;
        int start = 0, end = arr.length-1;
        int mid = start + (end - start)/2;
        while (start<=end){
            if(x == arr[mid]){
                result = mid;
                end = mid-1;
            } else if (x>arr[mid]){
                start = mid+1;
            } else {
                end = mid;
            }
            mid = start + (end-start)/2;
        }
        return result;
    }

    static int getLastOccurrence(int[] arr, int x){
        int result = -1;
        int start = 0, end = arr.length-1;
        int mid = start + (end - start)/2;
        while (start<=end){
            if(x == arr[mid]){
                result = mid;
                start = mid+1;
            } else if (x>arr[mid]){
                start = mid+1;
            } else{
                end = mid-1;
            }
            mid = start + (end-start)/2;
        }
        return result;
    }
}
