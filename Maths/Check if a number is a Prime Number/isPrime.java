import java.util.*;

public class isPrime {
    public static void main(String[] args) {
        int n = 18;
        System.out.println(prime(n));
    }

    public static boolean prime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
