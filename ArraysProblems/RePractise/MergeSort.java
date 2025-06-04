package ArraysProblems.RePractise;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,6,5,7,9};
        int[] sortedArray = sortArray(arr, 0, arr.length-1);
    }

    static int[] sortArray(int[] arr, int left, int right){
        if(left<right){
            int middle = left + (right-left)/2;

            //Divide
            sortArray(arr, left, middle);
            sortArray(arr, middle+1, right);

            //Conquer
            mergeSortedArrays(arr, left, middle, right);
        }
        return arr;
    }

    static int[] mergeSortedArrays(int[] arr, int left, int middle, int right){
        int[] merged = new int[right-left+1];

        int idx1 = left;
        int idx2 = middle+1;
        int x = 0;

        while(idx1<=middle && idx2<=right){
            if(arr[idx1]<arr[idx2]){
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2]++;
            }
        }

        while (idx1<=middle){
            merged[x++] = arr[idx1++];
        }

        while (idx2<=right){
            merged[x++] = arr[idx2++];
        }

        for(int i=0, j=left; i<merged.length; i++,j++){
            arr[j] = merged[i];
        }

        return arr;
    }
}
