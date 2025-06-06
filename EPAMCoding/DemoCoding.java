package EPAMCoding;

import java.util.Arrays;
import java.util.Stack;

//Input array: {1,3,2,4} Find Nearest Greatest To Left for each index value of given array and return a list. If there is no element greater to left for a particular index return -1.
//        o/p:- {-1,-1,3,-1}
// Input : 40, 30, 10, 50 26
// Output : -1 40 30 -1 50
public class DemoCoding {
    //5 10 30 40
    public static void main(String[] args) {
        int[] arr = {40, 30, 10, 5, 50};
        int[] result = getNearestGreatestToLeft(arr);
        Arrays.stream(result).forEach(System.out::println);
    }

    // O(M*N)
    private static int[] getNearestGreatestToLeft(int[] arr) {
        //40, 30, 10, 50 26
        //-1, 40 30, -1, 50
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=0;i< arr.length;i++){
            while(!stack.empty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if(stack.empty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
