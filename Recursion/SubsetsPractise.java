package Recursion;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/*Given an integer array nums of unique elements, return all possible subsets (the power set).

        The solution set must not contain duplicate subsets. Return the solution in any order.



        Example 1:

        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        Example 2:

        Input: nums = [0]
        Output: [[],[0]]
        https://leetcode.com/problems/subsets/description/*/
public class SubsetsPractise {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Arrays.sort(nums);
        List<List<Integer>> resultSet = new ArrayList<>();
        getAllSubsets(nums, resultSet, new ArrayList<>(), 0);
        System.out.println(resultSet.toString());
    }

    private static void getAllSubsets(int[] nums, List<List<Integer>> resultSet, List<Integer> currentList, int currPos) {
        //Base Condition
        resultSet.add(new ArrayList<>(currentList));

        for(int i=currPos; i<nums.length; i++){
            currentList.add(nums[i]);
            getAllSubsets(nums, resultSet, currentList, i+1);
            currentList.remove(currentList.size()-1);
        }
    }


}
