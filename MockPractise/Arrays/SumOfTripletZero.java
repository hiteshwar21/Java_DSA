package MockPractise.Arrays;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, \
and j != k, and nums[i] + nums[j] + nums[k] == 0.

        Notice that the solution set must not contain duplicate triplets.



        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.
*/
public class SumOfTripletZero {
    public static void main(String args[]){
        int[] arr = {-1,0,1,2,-1,-4};
        List<Integer> triplets = getTripletsWithZeroSum(arr);
        triplets.forEach(s-> System.out.println(s));
    }

    static List<Integer> getTripletsWithZeroSum(int[] arr){
        List<Integer> triplets = new ArrayList<>();
        if(arr.length < 3){
            return triplets;
        }
        Arrays.sort(arr);
        if(arr[0] > 0){
            return triplets;
        }
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i< arr.length; i++) {
            //freqMap.put(arr[i], freqMap.getOrDefault)
        }


        return triplets;
    }
}
