package Arrays.OG;

public class dutchNationalFlag extends util {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sortDutchNationalFlag(arr);
        printArray(arr);
    }

    static void sortDutchNationalFlag(int[] arr) {
        int low = 0;
        int hi = arr.length - 1;
        int middle = 0;
        int temp;

        while (middle <= hi) {
            switch (arr[middle]) {
                case 0 -> {
                    temp = arr[low];
                    arr[low] = arr[middle];
                    arr[middle] = temp;
                    middle++;
                    low++;
                }
                case 1 -> middle++;
                case 2 -> {
                    temp = arr[middle];
                    arr[middle] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                }
            }
        }
    }
}
