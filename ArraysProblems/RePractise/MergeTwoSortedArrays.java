package ArraysProblems.RePractise;

import java.util.Arrays;

/*We are given two sorted arrays. We need to merge these two arrays such that the initial numbers (after complete sorting)
        are in the first array and the remaining numbers are in the second array
Input: ar1[] = {1, 5, 9, 10, 15, 20}, ar2[] = {2, 3, 8, 13}
        Output: ar1[] = {1, 2, 3, 5, 8, 9}, ar2[] = {10, 13, 15, 20}*/
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};
        getSortedArraysBasic(arr1, arr2);
        getSortedArraysWithInsertionSort(arr1, arr2);
        getSortedArraysEuclidDivisionLemma(arr1, arr2);
    }

    //O(M*(NLogN) Approach
    static void getSortedArraysBasic(int[] arr1, int[] arr2){
        int i=0, temp;
        while (arr1[arr1.length-1]> arr2[0]){
            if(arr1[i]>arr2[0]){
                temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                Arrays.sort(arr2);
            }
            i++;
        }
        System.out.println("Return");
    }

    //O(M*N) Approach
    static void getSortedArraysWithInsertionSort(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int temp;

        while(i< arr1.length && j<arr2.length){
            if(arr1[i]<= arr2[j]){
                i++;
            } else if (arr1[i]> arr2[j]){
                temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i++;

                if(j< arr2.length-1 && arr2[j+1] < arr2[j]){
                    temp = arr2[j];
                    int tempj = j+1;

                    while(tempj< arr2.length && arr2[tempj]< temp){
                        arr2[tempj-1] = arr2[tempj];
                        tempj++;
                    }
                    arr2[tempj-1] = temp;
                }
            }
        }
        System.out.println("Return");
    }

    static void getSortedArraysEuclidDivisionLemma(int[] arr1, int[] arr2){
        int i =0, j=0, k=0;

        int x = 1000000 + 7;

        while (i< arr1.length && (j< arr1.length && k< arr2.length)){
            //Both Modified
            if(arr1[j]>=x && arr2[k]>=x){
                if((arr1[j]%x)<(arr2[k]%x)){
                    arr1[i] += (arr1[j++] %x)*x;
                } else{
                    arr1[i] += (arr2[k++]%x)*x;
                }
            }
            //arr1 entry modified
            else if(arr1[j]>=x){
                if((arr1[j]%x)<arr2[k]){
                    arr1[i] += (arr1[j++] %x)*x;
                } else{
                    arr1[i] += (arr2[k++]%x)*x;
                }
            }
            //arr2 entry modified
            else if(arr2[k] >=x){
                if(arr1[j]< (arr2[k]%x)){
                    arr1[i] += (arr1[j++] %x)*x;
                } else{
                    arr1[i] += (arr2[k++]%x)*x;
                }
            }
            //No element modified yet
            else{
                if(arr1[j]<=arr2[k]){
                    arr1[i] += (arr1[j++]%x)*x;
                } else {
                    arr1[i] += (arr2[k++]%x)*x;
                }
            }
            i++;
        }

        while (j < arr1.length && i < arr1.length) {
            arr1[i++] += (arr1[j++] % x) * x;
        }
        while (k < arr2.length && i < arr1.length) {
            arr1[i++] += (arr2[k++] % x) * x;
        }

        i = 0;

        // arr2 rearrangement
        while (i < arr2.length && (j < arr1.length && k < arr2.length)) {

            // if both arr1 and arr2 elements are modified
            if (arr1[j] >= x && arr2[k] >= x) {
                if (arr1[j] % x <= arr2[k] % x) {
                    arr2[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr2[i] += (arr2[k++] % x) * x;
                }
            }

            // if only arr1 elements are modified
            else if (arr1[j] >= x) {
                if (arr1[j] % x <= arr2[k]) {
                    arr2[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr2[i] += (arr2[k++] % x) * x;
                }
            }

            // if only arr2 elements are modified
            else if (arr2[k] >= x) {
                if (arr1[j] <= arr2[k] % x) {
                    arr2[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr2[i] += (arr2[k++] % x) * x;
                }
            }
            else {

                // if none elements are modified
                if (arr1[j] <= arr2[k]) {
                    arr2[i] += (arr1[j++] % x) * x;
                }
                else {
                    arr2[i] += (arr2[k++] % x) * x;
                }
            }
            i++;
        }

        while (j < arr1.length && i < arr2.length) {
            arr2[i++] += (arr1[j++] % x) * x;
        }
        while (k < arr2.length && i < arr2.length) {
            arr2[i++] += (arr2[k++] % x) * x;
        }

        i = 0;
        //setting to be original Array
        while (i < arr1.length) {
            arr1[i++] /= x;
        }


        i = 0;
        while (i < arr2.length) {
            arr2[i++] /= x;
        }
    }
}
