package Arrays.RePractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//First Negative Number in every Window of Size K | Sliding Window
public class FirstNegativeInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 36};
        int windowSize = 3;
        Vector<Integer> result = getFirstNegativeInWindow(arr, arr.length, windowSize);
        assert result != null;
        System.out.println(result);
    }

    static Vector<Integer> getFirstNegativeInWindow(int[] arr, int arrSize,int windowSize){
        Vector<Integer> vector = new Vector<>();
        List<Integer> negativeIntegers = new ArrayList<>();
        int start = 0,end = 0;
        if(windowSize > arrSize){
            return null;
        }
        while(end < arrSize){
            if(end-start+1 < windowSize){
                if(arr[end]<0){
                    negativeIntegers.add(arr[end]);
                }
            } else {
                if(negativeIntegers.isEmpty()){
                    vector.add(0);
                } else {
                    vector.add(negativeIntegers.get(0));
                }
                if(arr[start]<0){
                    negativeIntegers.remove(0);
                }
                if(arr[end]<0){
                    negativeIntegers.add(arr[end]);
                }
                start++;
            }
            end++;
        }
        return vector;
    }
}
