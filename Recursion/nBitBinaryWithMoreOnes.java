package Recursion;

import java.util.Vector;

/*Print N-bit binary numbers having more 1s than 0s | Java | Recursion*/
public class nBitBinaryWithMoreOnes {
    static Vector<String> result = new Vector<>();

    public static void main(String[] args) {
        int binaryBitSize = 4;
        solveCombinationOfBinaryBit(0, 0, binaryBitSize, new StringBuilder());
        System.out.println(result);
    }

    static void solveCombinationOfBinaryBit(int count1, int count0, int size, StringBuilder output){
        //Base Condition
        if(size == 0) {
            result.add(output.toString());
            return;
        }
        output.append(1);
        solveCombinationOfBinaryBit(count1+1, count0, size-1, output);
        output.deleteCharAt(output.length()-1);

        if(count1 > count0+1) {
            output.append(0);
            solveCombinationOfBinaryBit(count1, count0+1, size-1, output);
            output.deleteCharAt(output.length()-1);
        }
    }
}
