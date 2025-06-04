package ArraysProblems.OG;

public class mergeSort extends util {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,6,5,7,9};
        int[] sortedArray = sortArray(arr, 0, arr.length-1);
        printArray(sortedArray);
    }

    static int[] sortArray(int[] arr, int left, int right){
        if (left< right){
            int middle = left + (right-left)/2;

            sortArray(arr, left, middle);
            sortArray(arr, middle+1, right);

            mergeSortedArrays(arr, left, middle, right);
        }
        return arr;
    }

    static int[]mergeSortedArrays(int[] arr, int left, int middle, int right){
        int la = middle-left+1;
        int ra = right-middle;
        int[] leftArray = new int[la];
        int[] rightArray = new int[ra];

        for (int i = 0; i < la; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < ra; j++)
            rightArray[j] = arr[middle + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < la && j < ra) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < la) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < ra) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        return arr;
    }
}
