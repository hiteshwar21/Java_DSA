package BinarySearch;

public class KokosBanana {
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        int maxHour = 8;
        System.out.println(getMinPerHour(arr, maxHour));
    }

    static int getMinPerHour(int[] arr, int maxHour){
        if(arr == null || arr.length == 0 || maxHour ==0){
            return -1;
        }
        int result = -1;
        int start = 1, end = getLargestInArray(arr);
        while (start<=end){
            int mid = start + (end-start)/2;
            int hours = calculatePie(arr, mid);
            if(hours<maxHour){
                result = hours;
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return result;
    }

    static int getLargestInArray(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr){
            if(max<i){
                max = i;
            }
        }
        return max;
    }

    static int calculatePie(int[] arr, int hours){
        int result = 0;
        for (int i: arr){
            result += Math.ceil((double)i/(double) hours);
        }
        return result;
    }
}
