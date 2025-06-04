package ArraysProblems.RePractise;

public class checkPalindrome {
    public static void main(String[] args) {
        int n = 7007;
        if (checkPalindrome(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean checkPalindrome(int num){
        int reverse = 0;
        int temp = num;
        while (temp!= 0){
            reverse = (reverse*10) + temp%10;
            temp = temp/10;
        }
        return (reverse==num);
    }
}
