import java.util.*;

public class paldigit {
    public static void main(String[] args) {
        int n = 131;
        System.out.println(isPalindrome(n));
    }

    public static boolean isPalindrome(int n) {
        int rev = 0;
        int temp = n;
        while (temp != 0) {
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }
        return (rev == n);
    }
}
