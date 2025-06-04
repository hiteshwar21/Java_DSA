package ArraysProblems.OG;

public class trappingRainwater {

    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        int areaOfWater = findTrappedWater(arr);
        System.out.println(areaOfWater);
    }

    static int findTrappedWater(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalTrappedWater = 0;
        while (left <= right) {
            if (rightMax <= leftMax) {
                totalTrappedWater = totalTrappedWater + Math.max(0, rightMax - arr[right]);
                rightMax = Math.max(rightMax, arr[right]);
                right--;
            } else {
                totalTrappedWater = totalTrappedWater + Math.max(0, leftMax - arr[left]);
                leftMax = Math.max(leftMax, arr[left]);
                left++;
            }
        }
        return totalTrappedWater;
    }
}
