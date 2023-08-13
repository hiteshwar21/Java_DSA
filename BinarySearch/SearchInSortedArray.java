package BinarySearch;

/*Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
Binary Search: Search a sorted array by repeatedly dividing the search interval in half.
Begin with an interval covering the whole array. If the value of the search key is less than the item in the middle of the interval,
narrow the interval to the lower half. Otherwise narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.*/
public class SearchInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int searchElem = 8;
        System.out.println(getElementIdx(arr, searchElem));
    }

    static int getElementIdx(int[] arr, int elem){
        int start = 0, end = arr.length-1;
        int mid = start + (end - start)/2;
        while (start<=end){
            if(elem == arr[mid]){
                return mid;
            }
            if(elem<arr[mid]){
                end = mid;
            } else {
                start = mid+1;
            }
            mid = start + (end - start)/2;
        }
        return -1;
    }
}
