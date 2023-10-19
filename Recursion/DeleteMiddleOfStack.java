package Recursion;

import java.util.Stack;

public class DeleteMiddleOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Stack<Integer> result = getMidDeletedStack(stack);
        System.out.println(result);
    }

    static Stack<Integer> getMidDeletedStack(Stack<Integer> stack){
        if(stack == null || stack.isEmpty()){
            return stack;
        }
        int mid = stack.size()/2;
        if(stack.size()%2 != 0){
            mid++;
        }
        return getResultStack(stack, mid);
    }

    static Stack<Integer> getResultStack(Stack<Integer> stack, int mid){
        if(mid == 1){
            stack.pop();
            return stack;
        }
        int surfaceElem = stack.pop();
        mid--;
        getResultStack(stack, mid);
        stack.push(surfaceElem);
        return stack;
    }
}
