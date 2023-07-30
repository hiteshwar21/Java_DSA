package Arrays.RePractise;

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
        getSortedArraysEuclidDivisionLemma(arr1, arr2);
    }

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

    static void getSortedArraysEuclidDivisionLemma(int[] arr1, int[] arr2){

    }
}
