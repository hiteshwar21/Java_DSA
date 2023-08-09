package Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    int minElem = Integer.MAX_VALUE;

    public void push(int val){
        if (stack.isEmpty()){
            minElem = val;
        } else{
            if (minElem<= val) {
                stack.push(val);
            } else{
                stack.push(2*val - minElem);
                minElem = val;
            }
        }
    }

    public int pop(){
        if (stack.isEmpty()){
            return -1;
        } else {
            if (stack.peek() < minElem) {
                int ans = minElem;
                minElem = 2 * stack.peek() - minElem;
                return ans;
            } else {
                return stack.pop();
            }
        }
    }

    public int peek(){
        if (stack.isEmpty()){
            return -1;
        } else {
            if (stack.peek() < minElem){
                return minElem;
            } else {
                return stack.peek();
            }
        }
    }

    public int getMinElem(){
        if(stack.isEmpty()){
            return -1;
        }
        return minElem;
    }
}
