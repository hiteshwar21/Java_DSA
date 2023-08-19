package DP;

import java.util.Arrays;

/*Given N items where each item has some weight and profit associated with it and also given a bag with capacity W,
  [i.e., the bag can hold at most W weight in it].
  The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible.

  Note: The constraint here is we can either put an item completely into the bag or cannot put it at all.
  [It is not possible to put a part of an item into the bag].

Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0*/
public class ZeroOneKnapsackDP {
    static int[][] matrix = new int[4][5];


    public static void main(String[] args) {
        int size = 3;
        int[] profit = {1,2,3};
        int[] weight = {4,5,1};

        int maxWeight = 4;
        System.out.println(getMaxProfitIterative(profit,weight, size, maxWeight));
    }

    static int getMaxProfitIterative(int[] profits, int[] weight, int size, int maxWeight){
        //Base Condition
        for(int i =0;i<=size;i++){
            for (int j = 0;j<=maxWeight;j++){
                if (i==0 || j==0){
                    matrix[i][j] = 0;
                }
            }
        }

        //Iterate from previous Matrix results
        for (int i=1;i<=size;i++){
            for (int j=1;j<=maxWeight;j++){
                if(weight[i-1]<maxWeight) {
                    matrix[i][j] = Math.max(profits[i-1] + matrix[i-1][j-weight[i-1]],
                            matrix[i-1][j]);
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        return matrix[size][maxWeight];
    }
}
