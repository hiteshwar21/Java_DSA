package MockPractise.Arrays;

/*Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.
Output your answer modulo 10^9 + 7.

        Example 1:

        Input:
        N = 5
        Output: 5
        Explanation: 5 strings are (000, 001, 010, 100, 101).*/
public class Consecutive1sNotAllowed {
    public static void main(String args[]){
        int binaryStringLength = 7;
        System.out.println(getAllNonConsecutive1CountDP(binaryStringLength));
        System.out.println(getAllNonConsecutive1Count(binaryStringLength));
    }

    static int getAllNonConsecutive1Count(int binaryStringLength){
        int zeroEnding = 1, oneEnding = 1;
        for(int i=1; i<binaryStringLength; i++){
            int temp = zeroEnding + oneEnding;
            oneEnding = zeroEnding;
            zeroEnding = temp;
        }
        return zeroEnding+oneEnding;
    }

    static int getAllNonConsecutive1CountDP(int binaryStringLength){
        int[] zeroEnding = new int[binaryStringLength+1];
        int[] oneEnding = new int[binaryStringLength+1];
        zeroEnding[0] = oneEnding[0] = 0;
        zeroEnding[1] = oneEnding[1] = 1;
        for(int i=2; i<=binaryStringLength; i++){
            zeroEnding[i] = zeroEnding[i-1] + oneEnding[i-1];
            oneEnding[i] = zeroEnding[i-1];
        }
        return zeroEnding[binaryStringLength] + oneEnding[binaryStringLength];
    }
}
