package Arrays.OG;

import java.sql.Array;
import java.util.Arrays;

// int[] arr = {8,4,2,1}
// o/p : 6
public class inversionOfArray {
    public static void main(String[] args) {
        int[] arr = {8,4,2,1};
        System.out.println("Expected : 6    Actual : " + getInversionCount(arr, 0, arr.length-1));
    }

    static int getInversionCount(int[] arr, int startIdx, int endIdx){
        int count =0;
        if(startIdx<endIdx) {
            int mid = startIdx + (endIdx-startIdx)/2;
            count = count + getInversionCount(arr, startIdx, mid);
            count = count + getInversionCount(arr, mid+1, endIdx);
            count = count + conquerCount(arr, startIdx, mid, endIdx);
        }
        return count;
    }

    static int conquerCount(int[] arr, int startIdx, int mid,  int endIdx){
        int[] leftArray = Arrays.copyOfRange(arr, startIdx, mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, endIdx+1);

        int idx1 = 0, idx2 = 0, k = startIdx, swaps = 0;

        while (idx1 < leftArray.length && idx2 < rightArray.length) {
            if (leftArray[idx1] <= rightArray[idx2]) {
                arr[k++] = leftArray[idx1++];
            }  else {
                arr[k++] = rightArray[idx2++];
                swaps  = swaps + mid+1 - startIdx+idx1;
            }
        }
        while (idx1 < leftArray.length) {
            arr[k++] = leftArray[idx1++];
        }
        while (idx2 < rightArray.length) {
            arr[k++] = rightArray[idx2++];
        }
        return swaps;
    }
}