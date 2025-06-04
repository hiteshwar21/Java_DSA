package ArraysProblems.OG;

import java.util.Arrays;
import java.util.HashSet;

public class pythagoreanTriplet {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};
        System.out.println(checkPythagoreanTriplet(arr));
    }

    static boolean checkPythagoreanTriplet(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]*arr[i];
        }

        Arrays.sort(arr);

        for(int i=arr.length-1;i>1;i--){
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j=i-1;j>=0;j--){
                if (hashSet.contains(arr[i]-arr[j])){
                    return true;
                }
                hashSet.add(arr[j]);
            }
        }
        return false;
    }
}
