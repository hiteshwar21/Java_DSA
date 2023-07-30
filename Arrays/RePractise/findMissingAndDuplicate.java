package Arrays.RePractise;

public class findMissingAndDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,5};
        int[] arrMultiple = {1,2,3,4,5,6,1,8,2};
        getMissingAndDuplicate(arr);
        getMissingAndDuplicate(arrMultiple);
    }

    static void getMissingAndDuplicate(int[] arr){
        int end = 0;
        int temp;
        while (end< arr.length){
            if(arr[end]!= end+1){
                //SwapLogic
                if(arr[arr[end]-1] == arr[end]){
                    end++;
                } else {
                    temp = arr[end];
                    arr[end] = arr[arr[end] - 1];
                    arr[arr[end] - 1] = temp;
                }
            } else {
                end++;
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
