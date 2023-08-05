package Stack;

import java.util.Stack;

public class NearestSmallestToLeft {
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        int[] result = getSmallerToLeft(arr, arr.length);
        System.out.println("Return");
    }

    static int[] getSmallerToLeft(int[] arr, int size){
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<size;i++){
            while (!stack.isEmpty() && stack.peek()>arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                result[i] = -1;
            } else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
