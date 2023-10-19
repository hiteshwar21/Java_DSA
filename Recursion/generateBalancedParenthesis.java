package Recursion;

import java.util.Vector;

public class generateBalancedParenthesis {
    public static void main(String[] args) {
        int parenthesisCount = 3;
        Vector<String> balancedParenthesis = solveParenthesis(parenthesisCount, parenthesisCount, new Vector<>());
        System.out.println(balancedParenthesis);
    }

    static Vector<String> solveParenthesis(int open, int close, Vector<String> result){
        if(open == 0 && close ==0){

        }
        return result;
    }


}
