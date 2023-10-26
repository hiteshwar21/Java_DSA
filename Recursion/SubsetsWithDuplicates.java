package Recursion;

/*
Given an integer array nums that may contain duplicates, return all possible
        subsets
        (the power set).

        The solution set must not contain duplicate subsets. Return the solution in any order.



        Example 1:

        Input: nums = [1,2,2]
        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        Example 2:

        Input: nums = [0]
        Output: [[],[0]]
        https://leetcode.com/problems/subsets-ii/description/
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        subsetsWithDup(nums);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        storeSubsetWithDuplicates(result, new ArrayList<>(), 0, nums);
        return result;
    }

    static void storeSubsetWithDuplicates(List<List<Integer>> result, List<Integer> currentList, int start, int[] nums) {
        result.add(new ArrayList<>(currentList));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            currentList.add(nums[i]);
            storeSubsetWithDuplicates(result, currentList, i + 1, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}
