package Strings;

import java.util.Stack;

public class reverseWordsInGivenString {
    public static void main(String[] args) {
        String original = "I love you";
        String reverse = reverseWordsStack(original);
        System.out.println(reverse);
    }

    static String reverseWordsStack(String original){
        String[] components = original.split(" ");
        Stack stack = new Stack();
        for (int i =0;i< components.length;i++){
            stack.push(components[i]);
        }
        String result = "";
        while (!stack.isEmpty()) {
            if (result.length() == 0) {
                result = result + stack.pop();
            } else {
                result = result + " " + stack.pop();
            }
        }
        return result;
    }

    static String reverseWords(String original){
        int left, i=0, size = original.length();
        //remove extra space at the very start
        while(original.charAt(i) == ' '){
            i++;
        }
        left = i;
        while (i<size){
            if(i+1 == size || original.charAt(i) == ' '){
                int j=i-1;
                if(i+1 == size){
                    j++;
                }
                while (left < j){
                    original = swap(original, left++,j);
                }
                left = i+1;
            }
            if (i>left && original.charAt(left) == ' '){
                left = i;
            }
            i++;
        }

        original = new StringBuilder(original).reverse().toString();
        return original;
    }

    static String swap(String original, int i, int j){
        char[] swappedChar = original.toCharArray();
        char temp = swappedChar[i];
        swappedChar[i] = swappedChar[j];
        swappedChar[j] = temp;
        return new String(swappedChar);
    }
}
