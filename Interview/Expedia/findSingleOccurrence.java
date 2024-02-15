package Interview.Expedia;

public class findSingleOccurrence {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4,5,5};
        System.out.println(getSingleOccurrenceXOR(nums));
        getSingleOccurrenceBS(nums, 0, nums.length);
    }

    static int getSingleOccurrenceXOR(int[] nums){
        int answer = nums[0];
        for(int i=1; i<nums.length; i++){
            answer = answer^nums[i];
        }
        return answer;
    }

    static void getSingleOccurrenceBS(int[] nums, int low, int hi){
        if (low > hi)
            return;
        if (low == hi) {
            System.out.println(nums[low]);
            return;
        }

        int mid = low + (hi - low)/2;

        if(mid%2 == 0){
            if(nums[mid] == nums[mid+1]){
                getSingleOccurrenceBS(nums, mid+2, hi);
            } else {
                getSingleOccurrenceBS(nums,low, mid);
            }
        } else {
            if(nums[mid] == nums[mid-1]){
                getSingleOccurrenceBS(nums, mid+1, hi);
            } else {
                getSingleOccurrenceBS(nums,low , mid-1);
            }
        }

    }
}
