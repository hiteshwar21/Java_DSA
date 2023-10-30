package MockPractise.Arrays;

import java.util.*;

/*Given a list of non-negative integers, arrange them in such a manner that they form the largest number possible.
  The result is going to be very large, hence return the result in the form of a string.


        Example 1:

        Input:
        N = 5
        Arr[] = {3, 30, 34, 5, 9}
        Output: 9534330
        Explanation: Given numbers are {3, 30, 34,
        5, 9}, the arrangement 9534330 gives the
        largest value.*/
public class LargestNumberFormedByArray {
    public static void main(String args[]){
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(getLargestNumber(arr));
    }

    static String getLargestNumber(int[] num){
        StringBuilder result = new StringBuilder();

        String[] nums = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            nums[i] = Integer.toString(num[i]);
        }
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
        return result.toString();
    }
}
