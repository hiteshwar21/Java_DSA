package Strings;

public class reverseWordsInGivenString {
    public static void main(String[] args) {
        String original = "I love you";
        String reverse = reverseWords(original);
        System.out.println(reverse);
    }

    static String reverseWords(String original){
        int left, i=0, size = original.length();
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
