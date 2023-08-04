package Strings;

public class checkPalindrome {

    public static void main(String[] args) {
        String pattern = "7007";
        System.out.println(checkPalindromeSequence(pattern));
    }

    static boolean checkPalindromeSequence(String pattern){
        int size = pattern.length();
        for(int i=0;i<size/2;i++){
            if(pattern.charAt(i) != pattern.charAt(size-i-1)){
                return false;
            }
        }
        return true;
    }
}
