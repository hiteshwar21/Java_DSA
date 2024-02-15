package Interview.Expedia;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1,2,1,0,1};
        getSortedArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static int[] getSortedArray(int[] arr) {
        int low=0, middle=0, hi= arr.length-1;
        int temp;
        while(middle<=hi){
            switch (arr[middle]) {
                case 0 -> {
                    temp = arr[low];
                    arr[low] = arr[middle];
                    arr[middle] = temp;
                    middle++;
                    low++;
                }
                case 1 -> middle++;
                case 2 -> {
                    temp = arr[middle];
                    arr[middle] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                }
            }
        }
        return arr;
    }
}
