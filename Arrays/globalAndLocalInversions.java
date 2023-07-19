package Arrays;

/*You are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].
        1. The number of global inversions is the number of the different pairs (i, j) where:
        0 <= i < j < n
        nums[i] > nums[j]

        2. The number of local inversions is the number of indices i where:
        0 <= i < n - 1
        nums[i] > nums[i + 1]
Return true if the number of global inversions is equal to the number of local inversions.*/
public class globalAndLocalInversions {

    public static void main(String[] args) {
        int[] nums = {1,0,2};
        System.out.println(isIdealPermutation(nums));
    }

    public static boolean isIdealPermutation(int[] nums) {
        for(int i=0;i< nums.length;i++){
            if(i-nums[i]>1 || i-nums[i]<-1){
                return false;
            }
        }
        return true;
    }
}
