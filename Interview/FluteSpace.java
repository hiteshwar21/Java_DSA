package Interview;

import java.util.Arrays;

public class FluteSpace {
    public static void main(String[] args) {
        int[] nums = {1,5,8,3,2,5,4,2,6};
        //[1,5,8,3,2,5,4,2,6]
        System.out.println(getConsecutiveNumbers(nums));
    }

    public static String getConsecutiveNumbers(int[] nums) throws RuntimeException{
        // [100,4,200,1,3,2]
        int maxConsecutiveNum = 0;
        validateInput(nums);
        if(nums.length == 0) {
            return String.valueOf(maxConsecutiveNum);
        }
        int consecutiveTillHere = 1;
        Arrays.sort(nums);
        //[1,2,3,4,100,200]
        for(int i=1; i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                continue;
            } else if(nums[i] - nums[i-1] == 1){
                consecutiveTillHere++;
            } else{
                consecutiveTillHere = 1;
            }
            maxConsecutiveNum = Math.max(maxConsecutiveNum, consecutiveTillHere);
        }
        return String.valueOf(maxConsecutiveNum);
    }

    private static void validateInput(int[] nums){
        if(nums == null){
            throw new RuntimeException();
        }
    }
}
