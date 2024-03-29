import java.util.*;

public class printPrime {
    public static void main(String[] args) {
        int n = 24;
        printPrime(n);
    }

    public static void printPrime(int n) {
        if (n <= 1)
            return;

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i + " ");
                n = n / i;
            }
        }

        if (n > 1) {
            System.out.println(n);
        }
    }

}
