package MockPractise.Arrays;

public class GlobalAndLocalInversion {
    public static void main(String args[]){
        int[] arr = {1,2,0};
        System.out.println(getInversionPossibility(arr));
    }

    static boolean getInversionPossibility(int[] arr){
        for(int i =0; i<arr.length; i++){
            if(Math.abs(arr[i]-i)>1){
                return false;
            }
        }
        return true;
    }
}
