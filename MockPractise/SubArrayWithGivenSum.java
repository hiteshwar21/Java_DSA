package MockPractise;

import java.util.HashMap;

/*Given an unsorted array A of size N that contains only positive integers, find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.

        In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.

        Note:- You have to return an ArrayList consisting of two elements left and right. In case no such subarray exists return an array consisting of element -1.

        Example 1:

        Input:
        N = 5, S = 12
        A[] = {1,2,3,7,5}
        Output: 2 4
        Explanation: The sum of elements
        from 2nd position to 4th position
        is 12.*/
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int sum = 12;
        int size = arr.length;
        //O(N) , O(N)
        printSubarrayIndexUsingHashMap(arr, sum, size);
        //O(N), O(1)
        printSubarrayIndexUsingSlidingWindow(arr, sum, size);
    }

    private static void printSubarrayIndexUsingHashMap(int[] arr, int sum, int size){
        int currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<size;i++){
            currSum = currSum + arr[i];
            map.put(currSum,i);
            if(currSum - sum == 0){
                System.out.println("Starting Index: " + 0 + " Ending index: " + i);
                return;
            }
            if (map.containsKey(currSum-sum)){
                int startingIdx = map.get(currSum-sum) +1;
                System.out.println("Starting Index: " + startingIdx + " Ending Index: " + i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void printSubarrayIndexUsingSlidingWindow(int[] arr, int sum, int size){
        int startIdx = 0, endIdx = 0;
        int currSum = 0;
        while (endIdx< size){
            currSum = currSum + arr[endIdx];
            if(currSum > sum){
                while (currSum>sum){
                    currSum = currSum - arr[startIdx];
                    startIdx++;
                }
            }
            if(currSum==sum){
                System.out.println("Starting Index: "+ startIdx + " Ending Index: " +  endIdx);
                return;
            }
            endIdx++;
        }
        System.out.println(-1);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i =0;i< nums.length;i++){
            map.put(i, nums[i]);
            if(map.containsValue(target-nums[i])){
                result[0] = (map.get(target-nums[i]));
                result[1] = i;
            }
        }
        return result;
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        //Edge Cases
        if(word1.length()==0 || word2.length()==0 || word1.length()!=word2.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i = 0; i<word1.length() ;i++){
            freq[word1.charAt(i)-'a']++;
            freq[word2.charAt(i)-'a']--;
        }

        for(int i =0;i<26;i++){
            if(freq[i]>3){
                return false;
            }
        }
        return true;
    }
}
