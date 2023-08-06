package Stack;

import java.util.Stack;

/*Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
For simplicity, assume that all bars have same width and the width is 1 unit.*/
public class MaxAreaHistogram {
    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};
        int maxArea = getMaxAreaHistogram(arr, arr.length);
        System.out.println(maxArea);
    }

    static int getMaxAreaHistogram(int[] arr, int size){
        int maxArea = 0;
        int[] nsr = getNearestSmallestToRight(arr, arr.length);
        int[] nsl = getNearestSmallestToLeft(arr, arr.length);
        int currArea = 0;
        for (int i =0;i<size;i++){
            currArea = (nsr[i] - nsl[i] - 1) * arr[i];
            if(currArea> maxArea){
                maxArea = currArea;
            }
        }
        return maxArea;
    }

    static int[] getNearestSmallestToRight(int[] arr, int size){
        Stack<Pair> stack = new Stack<>();
        int[] nsr = new int[size];
        for(int i = size-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek().element>arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                nsr[i] = size;
            } else{
                nsr[i] = stack.peek().index;
            }
            stack.push(new Pair(arr[i], i));
        }
        return nsr;
    }

    static int[] getNearestSmallestToLeft(int[] arr, int size){
        Stack<Pair> stack = new Stack<>();
        int[] nsl = new int[size];
        for (int i = 0; i<size;i++){
            while (!stack.isEmpty() && stack.peek().element>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i] = -1;
            }
            else {
                nsl[i] = stack.peek().index;
            }
            stack.push(new Pair(arr[i], i));
        }
        return nsl;
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
