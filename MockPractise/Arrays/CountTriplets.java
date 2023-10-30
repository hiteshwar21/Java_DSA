package MockPractise.Arrays;


import java.util.HashSet;

/**
 * Given an array A[] of N integers.
 * The task is to find the number of triples (i, j, k) , where i, j, k are indices and (1 <= i < j < k <= N),
 * such that in the set { A_i   , A_j   , A_k   } at least one of the numbers can be written as the sum of the other two.
 * Input : A[] = {1, 2, 3, 4, 5}
 * Output : 4
 */
public class CountTriplets {
    public static void main(String args[]){
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(getTripletCount(arr));
    }

    static int getTripletCount(int[] arr){
        int count = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i: arr){
            maxValue = Math.max(maxValue, i);
        }
        int[] freq = new int[maxValue+1];
        for(int i: arr){
            freq[i]++;
        }
        //Case 1: 0,0,0
        count += freq[0]*(freq[0]-1)*(freq[0]-2)/6;
        //Case 2: 0,x,x
        for(int i=1; i<=maxValue;i++){
            count += freq[0]*freq[i]*(freq[i]-1)/2;
        }

        //Case 3: x, x, 2x
        for(int i=1; 2*i<=maxValue;i++){
            count += freq[i]*(freq[i]-1)/2*(freq[2*i]);
        }
        //Case 4: x, y, x+y
        for(int i=1; i<=maxValue; i++){
            for(int j=i+1; i+j<=maxValue; j++){
                count += freq[i]*freq[j]*freq[i+j];
            }
        }
        return count;
    }
}
