package Interview;

import java.util.*;

public class ms {
    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        //System.out.println("This is a debug message");
        int[] arr = {-1, 2, 1, -4 };
        int target = 1;
        System.out.println(getClosestTripletSumSum(arr, target));
    }

    static int getClosestTripletSumSum(int[] arr, int target) {
        Arrays.sort(arr);

        int closestSum = Integer.MAX_VALUE;

        for(int i=0; i< arr.length; i++){
            int ptr1 = i + 1, ptr2 = arr.length - 1;
            while (ptr1 < ptr2){
                int sum = arr[i] + arr[ptr1] + arr[ptr2];
                //Check if Sum is closer than current closest
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                //If sum is greater, move second pointer to a smaller number. If sum is smaller, move first pointer to a bigger number
                if (sum > target) {
                    ptr2--;
                } else {
                    ptr1++;
                }
            }
        }

        return closestSum;
    }

    /*public float WithdrawMoney(int accountNumber, float amountToWithdraw){

        RandomInt var = Math.random();
        //Get account

        //Check balance

        //Deduct amount

        //return balance

        What logging principle will you follow?
    }*/

}
