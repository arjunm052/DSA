import java.util.*;

public class factorial {
    public static void main(String[] args) {
        long n = 6;
        System.out.println(factRec(n));
    }

    public static long factorial(long n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }

        return res;
    }

    public static long factRec(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factRec(n - 1);
    }
}
