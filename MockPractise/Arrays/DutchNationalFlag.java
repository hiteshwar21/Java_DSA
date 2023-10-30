package MockPractise.Arrays;

/*Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order*/
public class DutchNationalFlag {
    public static void main(String args[]){
        int[] arr = {0,1,0,1,1,1,1,1,1,2,0,1,0};
        arr = sortByDNF(arr);
        System.out.println("ArraySorted");
    }

    static int[] swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return arr;
    }

    static int[] sortByDNF(int[] arr){
        int start = 0, mid = 0, end = arr.length -1;
        while(mid<=end){
            switch(arr[mid]) {
                case 0:
                    arr = swap(arr, start, mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    arr = swap(arr, mid, end);
                    end--;
                    break;
            }
        }
        return arr;
    }
}
