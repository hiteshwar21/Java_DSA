package ArraysProblems.OG;

public class minMaxArray extends util {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        printArray(getMinMaxForm(arr));
    }

    static int[] getMinMaxForm(int[] arr){
        int maxIndex = arr.length-1;
        int maxElem = arr[maxIndex] + 1;
        int minIndex =0;
        for(int i=0;i< arr.length;i++){
            //even case
            if(i%2==0){
                arr[i] = arr[i] + (arr[maxIndex]%maxElem)*maxElem;
                maxIndex--;
            } else{
                arr[i]= arr[i] + (arr[minIndex]%maxElem)*maxElem;
                minIndex++;
            }
        }

        for(int i=0;i< arr.length;i++){
            arr[i] = arr[i]/maxElem;
        }
        return arr;
    }
}
