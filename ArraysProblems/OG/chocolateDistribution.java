package ArraysProblems.OG;

import java.util.Arrays;

public class chocolateDistribution {

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int numKids =3;
        System.out.println(findMinDifference(arr, numKids));
    }

    static int findMinDifference(int[] arr, int numKids){
        Arrays.sort(arr);

        if(numKids> arr.length){
            return -1;
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i=0;i+numKids-1<arr.length;i++){
            int diff = arr[i+numKids-1]-arr[i];
            if (diff < minDiff){
                minDiff = diff;
            }
        }
        return minDiff;
    }
}
