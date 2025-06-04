package ArraysProblems.RePractise.HashMap;

/*Given an array A[] of N integers. The task is to find the number of triples (i, j, k) , where i, j, k are indices and (1 <= i < j < k <= N), such that in the set { A_i    , A_j    , A_k    } at least one of the numbers can be written as the sum of the other two.
        Examples:


        Input : A[] = {1, 2, 3, 4, 5}
        Output : 4
        The valid triplets are:
        (1, 2, 3), (1, 3, 4), (1, 4, 5), (2, 3, 5)*/
public class CountTriplets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        getValidTriplets(arr);
    }

    static void getValidTriplets(int [] arr){
        int maxValue = 0;
        int result = 0;
        for(int i: arr){
            if(maxValue<arr[i]){
                maxValue = arr[i];
            }
        }
        int[] freq = new int[maxValue +1];
        //Case 1 : 0,0,0
        result += freq[0]*(freq[0]-1)*(freq[0]-2)/6;

        //Case 2 : 0,x,x
        for(int i:arr)
            result += freq[0]*freq[i]*(freq[i]-1);
        //Case 3 : x,x,2x
        for(int i: arr)
            result += freq[i]*(freq[i]-1)*freq[2*i];
        //Case 4 : x,y,x+y
        for(int i: arr){
            for(int j =i+1;j<arr.length;j++){
                result = freq[i]*freq[i]*freq[i+j];
            }
        }
        System.out.println(result);
    }

}
