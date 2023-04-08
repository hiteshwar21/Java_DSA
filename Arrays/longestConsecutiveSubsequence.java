package Arrays;

import java.util.HashSet;

public class longestConsecutiveSubsequence {

    public static void main(String[] args) {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int length = findLongestSubsequence(arr);
        System.out.println(length);
    }

    static int findLongestSubsequence(int[] arr){
        int lss =0;
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int i = 0; i < arr.length; ++i)
            hashSet.add(arr[i]);

        for (int i = 0; i < arr.length; ++i) {
            if (!hashSet.contains(arr[i] - 1)) {
                int j = arr[i];
                while (hashSet.contains(j)){
                    hashSet.remove(Integer.valueOf(j));
                    j++;
                }
                if (lss < j - arr[i])
                    lss = j - arr[i];
            }
        }
        return lss;
    }
}
