package Arrays.MockInterview;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,0};
        printDutchFlag(arr);
    }

    static int[] printDutchFlag(int[] arr){
        int count1 = 0;
        int count2 = 0;
        int count0 = 0;

        for(int i:arr){
            if(i == 0){
                count0++;
            } else if( i== 1){
                count1++;
            } else {
                count2++;
            }
        }
        int j=0;
        while (count0>0){
            //System.out.println(0);
            arr[j] = 0;
            j++;
            count0--;
        }
        while (count1>0){
            //System.out.println(1);
            arr[j] = 0;
            j++;
            count1--;
        }
        while (count2>0){
            //System.out.println(2);
            arr[j] = 0;
            j++;
            count2--;
        }
        return arr;
    }
}
