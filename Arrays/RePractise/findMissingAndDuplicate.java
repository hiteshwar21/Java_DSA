package Arrays.RePractise;

public class findMissingAndDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,5};
        int[] arrMultiple = {1,2,3,4,5,6,1,8,2};
        getMissingAndDuplicate(arr);
        getMissingAndDuplicate(arrMultiple);
    }

    static void getMissingAndDuplicate(int[] arr){
        int index = 0;
        int temp;
        while (index< arr.length){
            if(arr[index]!= index+1){
                //If Duplicate value, we can move on
                if(arr[arr[index]-1] == arr[index]){
                    index++;
                } else {
                    //SwapLogic - We are doing Swap Sort. We are just putting the wrong value present at an index to its ideal index position
                    temp = arr[index];
                    arr[index] = arr[arr[index] - 1];
                    arr[arr[index] - 1] = temp;
                }
            } else {
                index++;
            }
        }

        for(int i=0;i< arr.length;i++){
            if(i+1!=arr[i]){
                System.out.println("Missing Element : " + (i+1));
                System.out.println("Duplicate Element : " + arr[i]);
            }
        }
    }
}
