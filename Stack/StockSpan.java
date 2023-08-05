package Stack;

import java.util.Stack;

/*The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate
 span of stock’s price for all n days.

 The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
 for which the price of the stock on the current day is less than or equal to its price on the given day.

 For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}*/
public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int[] result = getStockSpan(arr, arr.length);
        System.out.println("Return");
    }

    //nearestGreaterToLeftCount Approach
    static int[] getStockSpan(int[] arr, int size){
        int[] result = new int[size];
        Stack<Pair> stack = new Stack<Pair>();
        for(int i =0; i<size;i++){
            while (!stack.isEmpty() && stack.peek().element < arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                if(i==0){
                    result[i] = -1;
                } else {
                    result[i] = i;
                }
            } else {
                result[i] = i - stack.peek().index;
            }
            stack.push(new Pair(arr[i],i));
        }
        return result;
    }

    static class Pair{
        int element;
        int index;
        Pair(int element,int index){
            this.element = element;
            this.index = index;
        }
    }
}
