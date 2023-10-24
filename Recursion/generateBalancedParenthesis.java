package Recursion;

import java.util.Vector;

public class generateBalancedParenthesis {
    public static void main(String[] args) {
        int parenthesisCount = 3;
        Vector<String> balancedParenthesisDFS = solveParenthesisDFS(parenthesisCount, parenthesisCount, "", new Vector<>());
        System.out.println(balancedParenthesisDFS);
    }

    static Vector<String> solveParenthesisDFS(int open, int close, String possibleBalancedParenthesisDFS, Vector<String> result){
        if(open == 0 && close == 0){
            result.add(possibleBalancedParenthesisDFS);
        }

        if(open>close || open<0 || close<0){
            return result;
        }

        possibleBalancedParenthesisDFS += "{";
        solveParenthesisDFS(open-1, close, possibleBalancedParenthesisDFS, result);
        possibleBalancedParenthesisDFS = possibleBalancedParenthesisDFS.substring(0, possibleBalancedParenthesisDFS.length()-1);

        possibleBalancedParenthesisDFS += "}";
        solveParenthesisDFS(open, close-1, possibleBalancedParenthesisDFS, result);
        possibleBalancedParenthesisDFS = possibleBalancedParenthesisDFS.substring(0, possibleBalancedParenthesisDFS.length()-1);

        return result;
    }
}
