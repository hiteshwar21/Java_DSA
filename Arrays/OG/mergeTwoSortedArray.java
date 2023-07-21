package Arrays.OG;

//Merge two sorted arrays with O(1) extra space
public class mergeTwoSortedArray extends util {

    public static void main(String[] args) {
        int[] arr1 = {1,5,9,10,15,20};
        int[] arr2 = {2,3,8,13};
        mergeSortedArrays(arr1, arr2);
    }

    static void mergeSortedArrays(int[] arr1, int[] arr2){
        int i=0,j=0,k=0;
        int x=10000000+7;
        //while




        printArray(arr1);
        printArray(arr2);
    }
}
