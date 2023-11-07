package Arrays;

public class WinningWays {
    public static void main(String args[]){
        int[] arr1 = {1,3,4,4,6};
        int[] arr2 = {2,3,4,4,5};
        System.out.println(getWinningWays(arr1, arr2));
    }

    static int getWinningWays(int[] arr1, int[] arr2){
        int count=0;
        int idxB=0;
        for(int i=0; i<arr1.length; i++){
            while(idxB<arr2.length && arr1[i] > arr2[idxB]){
                count+=idxB;
            }
        }
        return count;
    }
}
