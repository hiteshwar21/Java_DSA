package Interview;

public class SapientEval {

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,1,1,1,1};
        countElement(arr);
    }

    static void countElement(int[] arr) {
        int count0 =0, count1 = 0;
        if(arr.length == 0) {
            System.out.println("Count of both is zero");
            return;
        }
        for(int i: arr){
            count1 += i;
        }
        count0 = arr.length - count1;
        System.out.println("Count of 1: " + count1 + " Count of 0: " + count0);
    }
}