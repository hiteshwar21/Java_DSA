package Arrays.OG;

public class LeftSmallerRightGreater {

    public static void main(String[] args) {
        int[] arr = {4,2,5,7};
        System.out.println(findTriangle(arr));
    }

    static int findTriangle(int[] arr){
        int size = arr.length;
        int[] rightMin = new int[size];
        int rightMinima = arr[0];
        int leftMaxima = arr[size-1];
        int[] leftMax = new int[size];
        for (int i=0; i<size;i++){
            if(arr[i]>leftMaxima){
                leftMaxima = arr[i];
            }
            leftMax[i] = leftMaxima;
            if (arr[size - i -1] < rightMinima) {
                rightMinima = arr[i];
            }
            rightMin[i] = rightMinima;
        }
        for (int i=0;i<size;i++){
            if (leftMax[i] == arr[i] && rightMin[i] == arr[i]){
                return arr[i];
            }
        }
        return -1;
    }
}
