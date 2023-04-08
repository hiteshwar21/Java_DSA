package Arrays;

public class majorityElement {

    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int candidate = findCandidate(arr);
        Boolean isMajority = checkMajority(candidate, arr);
        if(isMajority){
            System.out.println("Majority element is: " + candidate);
        }else{
            System.out.println("No majority element");
        }
    }

    static int findCandidate(int[] arr){
        int majIndex = 0, count = 1, size = arr.length;
        for (int i = 1; i < size; i++) {
            if (arr[majIndex] == arr[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majIndex = i;
                count = 1;
            }
        }
        return arr[majIndex];
    }

    static boolean checkMajority(int candidate, int[] arr){
        int i, count = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == candidate)
                count++;
        }
        if (count > arr.length / 2) {
            return true;
        } else {
            return false;
        }
    }
}
