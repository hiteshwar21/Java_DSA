package ArraysProblems.OG;

public class reverseInGroupIntervals extends util {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int interval = 3;
        reverseArrayWithIntervals(arr, interval);
        printArray(arr);
    }

    static void reverseArrayWithIntervals(int[] arr, int interval) {
        for (int i = 0; i < arr.length; )
            while (i < arr.length) {
                {
                    int left = i;
                    int right = Math.min(i + interval - 1, arr.length - 1);
                    int temp;
                    while (left < right) {
                        temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;
                        left += 1;
                        right -= 1;
                    }
                }
                i += i + interval;
            }
    }
}
