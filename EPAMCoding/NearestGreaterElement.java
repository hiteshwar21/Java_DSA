package EPAMCoding;

import java.util.*;

/*Problem 2: Nearest Greater Element
        Statement:
        Given an array, for each element, find the nearest greater element on either the left or right.
        If both exist, choose the one that is closer. If they are at the same distance, choose the larger value.*/
public class NearestGreaterElement {


    public static void main(String[] args) {
        int[] input = {4,5,2,10,8};
        int[] result = getNearestGreaterElement(input);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] getNearestGreaterElement(int[] input) {
        int size = input.length;
        Map<Integer, Elem> nearestToLeft = getNearestGreatestToLeft(input);
        Map<Integer, Elem> nearestToRight = getNearestGreatestToRight(input);

        int[] result = new int[size];
        for(int i=0;i<size;i++) {
            if(nearestToLeft.get(i).getIndex() == -1  && nearestToRight.get(i).getIndex() == -1){
                result[i] = -1;
            } else if (nearestToLeft.get(i).getIndex() == -1) {
                result[i] = nearestToRight.get(i).value;
            } else if(nearestToRight.get(i).getIndex() == -1) {
                result[i] = nearestToLeft.get(i).value;
            } else {
                result[i] = Math.max(nearestToRight.get(i).value, nearestToLeft.get(i).value);
            }
        }
        return result;
    }

    private static Map<Integer, Elem> getNearestGreatestToLeft(int[] arr) {
        Stack<Elem> stack = new Stack<>();
        Map<Integer, Elem> result = new HashMap<>();
        for(int i=0;i< arr.length;i++){
            stackInsert(arr, stack, result, i);
        }
        return result;
    }

    private static Map<Integer, Elem> getNearestGreatestToRight(int[] arr) {
        Stack<Elem> stack = new Stack<>();
        Map<Integer, Elem> result = new HashMap<>();
        for(int i=arr.length-1;i>=0;i--){
            stackInsert(arr, stack, result, i);
        }
        return result;
    }

    private static void stackInsert(int[] arr, Stack<Elem> stack, Map<Integer, Elem> result, int i) {
        while(!stack.empty() && stack.peek().value <= arr[i]) {
            stack.pop();
        }
        Elem elem = new Elem();
        if(stack.empty()) {
            elem.setIndex(-1);
            elem.setValue(-1);
        } else {
            elem.setIndex(stack.peek().index);
            elem.setValue(stack.peek().value);
        }
        result.put(i, elem);
        stack.push(elem);
    }


}
