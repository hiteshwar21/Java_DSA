package Stack;

import java.util.Stack;

public class NearestGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        int[] result = getNearestToLeft(arr, arr.length);
        System.out.println("Return");
    }

    static int[] getNearestToLeft(int[] arr, int size){
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<size;i++){
            while (!stack.isEmpty() && stack.peek()<arr[i]){
                    stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = -1;
            } else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
