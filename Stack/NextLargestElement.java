package Stack;

import java.util.Stack;

/*Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array.
        Elements for which no greater element exist, consider next greater element as -1.*/
public class NextLargestElement {
    public static void main(String[] args) {
        int[] arr = {1,3,0,0,1,2,4};
        int[] result = getGreaterToRight(arr);
        System.out.println("Return");
    }

    static int[] getGreaterToRight(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int size = arr.length;
        int[] result = new int[size];
        for(int i = size-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
