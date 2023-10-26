package MockPractise.Arrays;

public class CheckPalindrome {
    public static void main(String[] args) {
        int n = 7007;
        if (checkPalindrome(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean checkPalindrome(int n){
        int reverse = 0;
        int temp = n;
        while (temp !=0){
            reverse = reverse*10 + temp%10;
            temp = temp/10;
        }
        return reverse==n;
    }
}
