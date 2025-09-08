package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Given an integer array nums of unique elements, return all possible
        subsets
        (the power set).

        The solution set must not contain duplicate subsets. Return the solution in any order.



        Example 1:

        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        Example 2:

        Input: nums = [0]
        Output: [[],[0]]
        https://leetcode.com/problems/subsets/description/*/
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        storeSubsetByBackTrack(new ArrayList<>(), nums, 0, resultList);
        return resultList;
    }

    private static void storeSubsetByBackTrack(List<Integer> currentList, int[] nums, int start, List<List<Integer>> resultList) {
        resultList.add(new ArrayList<>(currentList));
        for(int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);
            storeSubsetByBackTrack(currentList, nums, i + 1, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
