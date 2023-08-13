package BinarySearch;

/*
Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
*/
public class OrderNotKnownSearch {
    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,2,1};
        int k=6;
        System.out.println(getIdxWhenOrderNotKnown(arr,k));
    }

    static int getIdxWhenOrderNotKnown(int[] arr, int k){
        int start = 0, end = arr.length-1;
        int mid = start+(end-start)/2;
        boolean ascending = arr[0]<arr[1];
        while (start<=end){
            if (arr[mid] == k){
                return mid;
            }
            if(arr[mid]<k){
                if(ascending){
                    start = mid+1;
                } else{
                    end = mid-1;
                }
            } else {
                if(ascending){
                    end = mid;
                } else{
                    start = mid+1;
                }
            }
            mid = start + (end-start)/2;
        }
        return -1;
    }
}
