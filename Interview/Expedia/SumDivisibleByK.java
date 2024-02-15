package Interview.Expedia;

public class SumDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 7, 5, 3};
        int k = 4;
        int count = getCountOfDivisiblePair(arr,k);
        System.out.println(count);
    }

    static int getCountOfDivisiblePair(int[] arr, int k){
        int count = 0;
        int[] freq = new int[k];
        for(int i:arr){
            ++freq[i%k];
        }
        //Case 1 : both numbers are divisible by k
        count+= freq[0]*(freq[0]-1)/2;

        for(int i=1; i<=k/2 && i != k-i; i++) {
            count += freq[i] * freq[k - i];
        }
        //if K is even
        if(k%2 == 0){
            count += (freq[k/2]*(freq[k/2]-1)/2);
        }

        return count;
    }
}
