package ArraysProblems.RePractise;

public class findMissingNumber {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 3,5, 7, 8};
        int size = 8;
        System.out.println(getMissingNumber1(arr, size));
        System.out.println(getMissingNumber2(arr, size));
        System.out.println(getMissingNumber3(arr, size));
    }

    static int getMissingNumber1(int[] arr, int size){
        int actualSum = 0;
        for(int i =0;i<arr.length;i++){
            actualSum += arr[i];
        }
        int expectedSum = size*(size+1)/2;
        return expectedSum - actualSum;
    }

    static int getMissingNumber2(int[] arr, int size){
        int result = arr[0]^1;
        for(int i =1;i<arr.length;i++){
            result = result^arr[i]^i+1;
        }
        result = result^size;
        return result;
    }

    static int getMissingNumber3(int[] arr, int size){
        int result = 0;
        int[] freq = new int[size+1];
        for(int i=0;i< arr.length;i++){
            freq[arr[i]]++;
        }
        for (int i =1;i<=size;i++){
            if(freq[i] == 0){
                result = i;
                break;
            }
        }
        return result;
    }
}
